import matplotlib.pyplot as plt
from DRY import Imports
import pandas as pd

imports_filtered = Imports('data/Imports.csv')

# Aggregate the data by country and year
imports_summary = imports_filtered.groupby(['Country Name', 'Year']).agg({
    'Volume (kg)': 'sum',
    'Value (USD)': 'sum'
}).reset_index().sort_values(by=['Country Name', 'Year'])

# Separate the data for each country for easier plotting
iceland_data = imports_summary[imports_summary['Country Name'] == 'ICELAND']
norway_data = imports_summary[imports_summary['Country Name'] == 'NORWAY']
russia_data = imports_summary[imports_summary['Country Name'] == 'RUSSIAN FEDERATION']
denmark_data = imports_summary[imports_summary['Country Name'] == 'DENMARK']
england_data = imports_summary[imports_summary['Country Name'] == 'UNITED KINGDOM']

# Plotting
plt.figure(figsize=(14, 7))

# Volume Plot
plt.subplot(1, 2, 1)
plt.plot(iceland_data['Year'], iceland_data['Volume (kg)'], marker='o', label='Iceland')
plt.plot(norway_data['Year'], norway_data['Volume (kg)'], marker='s', label='Norway')
plt.plot(russia_data['Year'], russia_data['Volume (kg)'], marker='^', label='Russia')
plt.plot(denmark_data['Year'], denmark_data['Volume (kg)'], marker='d', label='Denmark')
plt.plot(england_data['Year'], england_data['Volume (kg)'], marker='*', label='England')
plt.title('Imports Volume (kg) from Selected Countries (2010-2024)')
plt.xlabel('Year')
plt.ylabel('Volume (kg)')
plt.xticks(rotation=45)
plt.legend()

# Value Plot
plt.subplot(1, 2, 2)
plt.plot(iceland_data['Year'], iceland_data['Value (USD)'], marker='o', label='Iceland')
plt.plot(norway_data['Year'], norway_data['Value (USD)'], marker='s', label='Norway')
plt.plot(russia_data['Year'], russia_data['Value (USD)'], marker='^', label='Russia')
plt.plot(denmark_data['Year'], denmark_data['Value (USD)'], marker='d', label='Denmark')
plt.plot(england_data['Year'], england_data['Value (USD)'], marker='*', label='England')
plt.title('Imports Value (USD) from Selected Countries (2010-2024)')
plt.xlabel('Year')
plt.ylabel('Value (USD)')
plt.xticks(rotation=45)
plt.legend()

plt.tight_layout()
plt.show()

# Calculate the sum of all imports (volume and value) from selected countries in each year
total_imports_yearly = imports_filtered.groupby('Year').agg({
    'Volume (kg)': 'sum',
    'Value (USD)': 'sum'
}).reset_index().sort_values(by='Year')

print(total_imports_yearly)