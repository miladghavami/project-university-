from DRY import Auction_Analysis
import pandas as pd 
import matplotlib.pyplot as plt
import seaborn as sns

data= Auction_Analysis('data/pfex_report.csv')

# Calculating the average price range for all species by year
species_range = data.groupby(['YearNum', 'FishDesc'])['AvgPrice'].mean().unstack()

# Adjust the number of colors based on the number of unique species for accurate representation
num_species = len(data['FishDesc'].unique())
colormap = plt.cm.get_cmap('tab10', num_species)

# Start working on the second part
# Calculate the revenue for each row
data['Revenue'] = data['Sold'] * data['AvgPrice']

# Calculate the yearly revenue for each species
yearly_revenue = data.groupby(['YearNum', 'FishDesc'])['Revenue'].sum().unstack()

# Plotting the average standardized price range for all species by year with specified colors
fig, ax = plt.subplots(figsize=(12, 8))
species_range.plot(kind='bar', ax=ax, color=[colormap(i) for i in range(num_species)])
ax.set_xlabel('Year')
ax.set_ylabel('Average Price Range')
ax.set_title('Average Price Range for All Species in Portland Auction')
plt.legend(title='Species', bbox_to_anchor=(1.05, 1), loc='upper left')
plt.xticks(rotation=45)
plt.tight_layout()
plt.show()

# Plotting the yearly revenue for each species
fig, ax = plt.subplots(figsize=(12, 8))
yearly_revenue.plot(kind='bar', ax=ax)
ax.set_xlabel('Year')
ax.set_ylabel('Total Revenue ($)')
ax.set_title('Yearly Revenue for Each Species in Portland Auction')
plt.legend(title='Species', bbox_to_anchor=(1.05, 1), loc='upper left')
plt.xticks(rotation=45)
plt.tight_layout()
plt.show()