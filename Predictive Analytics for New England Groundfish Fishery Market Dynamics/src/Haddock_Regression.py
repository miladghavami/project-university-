import numpy as np
import pandas as pd
import seaborn as sns
from sklearn.model_selection import train_test_split, cross_val_score, KFold
from sklearn.linear_model import RidgeCV, LinearRegression
from sklearn.metrics import mean_squared_error, mean_absolute_error, r2_score
from sklearn.preprocessing import StandardScaler
from sklearn.feature_selection import SequentialFeatureSelector
import matplotlib.pyplot as plt
from scipy.stats import shapiro
import scipy.stats as stats


# Load the dataset
data = pd.read_csv('data/Regression.csv')
data = data.drop(columns=['Year'])

# Create a correlation matrix
corr_matrix = data.corr()
plt.figure(figsize=(15, 10))
sns.heatmap(corr_matrix, annot=True, cmap='coolwarm', square=True, cbar_kws={'label': 'Correlation'}, 
            mask=np.triu(np.ones_like(corr_matrix, dtype=bool)), linewidths=0.5, fmt='.2f', 
            annot_kws={'size': 6}, vmin=-1, vmax=1)
plt.xticks(rotation=90, ha='right', fontsize=8)
plt.yticks(fontsize=8)
plt.title('Correlation Heatmap', fontsize=14)
plt.tight_layout()
plt.show()

# Select features based on correlation
features = [ 'Haddock_Import_Vol', 'Haddock_Import_Val', 'Haddock_Export_Vol', 'Haddock_Export_Val',
             'consumption', 'Inflation Rate', 'Maine Temp', 'Mass Temp', 'Maine Unemployment', 'MASS Unemployment',
                       'ME Pop', 'MA Pop', 'Mass PI', 'Maine PI','Haddock_Auction']

# Prepare the data
X = data[features]
y = data['Haddock_avg']


# Define and fit the selector
selector = SequentialFeatureSelector(LinearRegression(), n_features_to_select=8, direction='forward', cv=5)
selector.fit(X, y)

# Get the mask of selected features
selected_features = X.columns[selector.get_support()]

# Initialize a Linear Regression model
model = LinearRegression()

# Calculate R-squared for each selected feature
r2_scores = []
for feature in selected_features:
    model.fit(X[[feature]], y)  # Fit model on each individual feature
    predictions = model.predict(X[[feature]])
    r2_scores.append(r2_score(y, predictions))

# Sort the selected features based on R-squared scores in descending order
sorted_indices = np.argsort(r2_scores)[::-1]
sorted_feature_names = selected_features[sorted_indices]
sorted_r2_scores = np.array(r2_scores)[sorted_indices]

# Visualize features ranked by R-squared scores
plt.figure(figsize=(10, 6))
plt.barh(sorted_feature_names, sorted_r2_scores, color='skyblue')
plt.xlabel('R-squared Score')
plt.title('Feature R-squared Scores Ordered by Sequential Feature Selection')
plt.gca().invert_yaxis()  # Invert y-axis to show the highest scores at the top
plt.tight_layout()
plt.show()


# Scale the selected features
scaler = StandardScaler()
X_scaled = scaler.fit_transform(X[selected_features])

# Split the data
X_train, X_test, y_train, y_test = train_test_split(X_scaled, y, test_size=0.2, shuffle=True, random_state=42)

# Ridge Regression with Cross-Validation
alphas = np.logspace(-3, 3, 100)
ridge_model = RidgeCV(alphas=alphas, cv=5)
ridge_model.fit(X_train, y_train)

# Model Evaluation
y_pred_train = ridge_model.predict(X_train)
y_pred_test = ridge_model.predict(X_test)

r2_train = r2_score(y_train, y_pred_train)
mse_train = mean_squared_error(y_train, y_pred_train)
mae_train = mean_absolute_error(y_train, y_pred_train)

r2_test = r2_score(y_test, y_pred_test)
mse_test = mean_squared_error(y_test, y_pred_test)
mae_test = mean_absolute_error(y_test, y_pred_test)

# Print training and test metrics
print("Training Set Metrics:")
print(f"R-squared: {r2_train:.3f}, MSE: {mse_train:.3f}, MAE: {mae_train:.3f}")
print("===================================================")
print("Test Set Metrics:")
print(f"R-squared: {r2_test:.3f}, MSE: {mse_test:.3f}, MAE: {mae_test:.3f}")

# Regression Function
coefficients = ridge_model.coef_
intercept = ridge_model.intercept_
terms = [f"{coeff:.3f}*{name}" for coeff, name in zip(coefficients, selected_features)]
regression_function = f"{intercept:.3f} + " + " + ".join(terms)
print("===================================================")
print('Regression Function:', regression_function)


# Perform the Shapiro-Wilk test
residuals = y_test - y_pred_test
stat, p_value = shapiro(residuals)
print("===================================================")
print(f'Shapiro-Wilk Test statistic: {stat:.3f}, p-value: {p_value:.3f}')

# Interpretation
alpha = 0.05
if p_value > alpha:
    print('Fail to reject the null hypothesis - the data is normally distributed')
else:
    print('Reject the null hypothesis - the data is not normally distributed')

# Plotting the residuals
plt.figure(figsize=(10, 6))
plt.scatter(y_pred_test, residuals, color='blue', edgecolor='k')
plt.axhline(0, color='red', linestyle='--')
plt.xlabel('Predicted Values')
plt.ylabel('Residuals')
plt.title('Residuals vs. Predicted Values')
plt.grid(True)
plt.show()

# Histogram of residuals
plt.figure(figsize=(10, 6))
sns.histplot(residuals, kde=True)
plt.title('Histogram of Residuals')
plt.xlabel('Residuals')
plt.ylabel('Frequency')
plt.show()

# Q-Q plot of residuals
plt.figure(figsize=(10, 6))
stats.probplot(residuals, dist="norm", plot=plt)
plt.title('Q-Q Plot of Residuals')
plt.show()
