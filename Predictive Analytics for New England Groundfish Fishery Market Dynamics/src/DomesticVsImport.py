from DRY import DomesticVsImport
import pandas as pd
import matplotlib.pyplot as plt


# Merge the summaries for comparison
combined_summary = DomesticVsImport('data/Imports.csv', 'data/FossLandings.csv')


# Line Plot for Volumes over Years
plt.figure(figsize=(14, 7))
plt.plot(combined_summary['Year'], combined_summary['Volume (kg)'], label='Import Volume', marker='o', linestyle='-', color='blue')
plt.plot(combined_summary['Year'], combined_summary['Pounds'], label='Landing Volume', marker='s', linestyle='-', color='green')
plt.title('Comparison of Import and Landing Volumes Over Years')
plt.xlabel('Year')
plt.ylabel('Volume (kg)')
plt.legend()
plt.xticks(combined_summary['Year'], rotation=45)
plt.show()

# Line Plot for Values over Years
plt.figure(figsize=(14, 7))
plt.plot(combined_summary['Year'], combined_summary['Value (USD)'], label='Import Value', marker='o', linestyle='-', color='red')
plt.plot(combined_summary['Year'], combined_summary['Dollars'], label='Landing Value', marker='s', linestyle='-', color='purple')
plt.title('Comparison of Import and Landing Values Over Years')
plt.xlabel('Year')
plt.ylabel('Value (USD)')
plt.legend()
plt.xticks(combined_summary['Year'], rotation=45)
plt.show()

# Scatter Plot for Volume Relationship
plt.figure(figsize=(7, 7))
plt.scatter(combined_summary['Volume (kg)'], combined_summary['Pounds'], color='orange')
plt.title('Relationship Between Import and Landing Volumes')
plt.xlabel('Import Volume (kg)')
plt.ylabel('Landing Volume (kg)')
plt.grid(True)
plt.show()

# Scatter Plot for Value Relationship
plt.figure(figsize=(7, 7))
plt.scatter(combined_summary['Value (USD)'], combined_summary['Dollars'], color='cyan')
plt.title('Relationship Between Import and Landing Values')
plt.xlabel('Import Value (USD)')
plt.ylabel('Landing Value (USD)')
plt.grid(True)
plt.show()
