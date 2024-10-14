from DRY import Product_import
import pandas as pd 
import matplotlib.pyplot as plt
import seaborn as sns


fish_filtered= Product_import('data/Imports.csv')

# Aggregating total volume and value for Cod and Haddock across all years
total_fish_summary = fish_filtered.groupby(['Product Name', 'Year']).agg({
    'Volume (kg)': 'sum',
    'Value (USD)': 'sum'
}).reset_index()

# Ensuring that we're only looking at Cod and Haddock by checking for these substrings in the 'Product Name'
total_fish_summary['Fish Type'] = total_fish_summary['Product Name'].apply(lambda x: 'Cod' if 'COD' in x.upper() else 'Haddock')

# Aggregating again to ensure we sum across all Cod and Haddock variations
total_fish_summary = total_fish_summary.groupby(['Fish Type', 'Year']).agg({
    'Volume (kg)': 'sum',
    'Value (USD)': 'sum'
}).reset_index()

# Splitting the aggregated data into separate DataFrames for Cod and Haddock
cod_total = total_fish_summary[total_fish_summary['Fish Type'] == 'Cod']
haddock_total = total_fish_summary[total_fish_summary['Fish Type'] == 'Haddock']

# Plotting
plt.figure(figsize=(10, 6))

# Plotting total Volume for Cod and Haddock
plt.plot(cod_total['Year'], cod_total['Volume (kg)'], label='Cod', marker='o')
plt.plot(haddock_total['Year'], haddock_total['Volume (kg)'], label='Haddock', marker='s')

plt.title('Total Import Volume of Cod vs. Haddock Over the Years')
plt.xlabel('Year')
plt.ylabel('Volume (kg)')
plt.legend()
plt.grid(True)
plt.show()
