from DRY import Auction
import pandas as pd 
import matplotlib.pyplot as plt
import seaborn as sns

cleaneded_data = Auction('data/pfex_report.csv')

# Separate the data for Cod and Haddock
cod_data = cleaneded_data[cleaneded_data['FishDesc'].str.contains('Cod', case=False)]
haddock_data = cleaneded_data[cleaneded_data['FishDesc'].str.contains('Haddock', case=False)]

# Aggregate average price by year for each species
cod_yearly_avg = cod_data.groupby('YearNum')['AvgPrice'].mean().reset_index()
haddock_yearly_avg = haddock_data.groupby('YearNum')['AvgPrice'].mean().reset_index()

# Merging the datasets for plotting
yearly_avg_prices_combined = pd.merge(cod_yearly_avg, haddock_yearly_avg, on='YearNum', suffixes=('_Cod', '_Haddock'))

# Creating the line plot
plt.figure(figsize=(12, 6))
sns.lineplot(x='YearNum', y='AvgPrice_Cod', data=yearly_avg_prices_combined, marker='o', label='Cod')
sns.lineplot(x='YearNum', y='AvgPrice_Haddock', data=yearly_avg_prices_combined, marker='o', label='Haddock')
plt.title("Yearly Average Prices of Cod and Haddock in Portland Auction")
plt.xlabel("Year")
plt.ylabel("Average Price")
plt.legend()
plt.tight_layout()
plt.show()