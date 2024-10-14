from DRY import Exports
import pandas as pd
import matplotlib.pyplot as plt


data= Exports('data/Exports.csv')

# Aggregate the exports data by year
exports_summary_corrected = data.groupby('Year').agg({
    'Volume (kg)': 'sum',
    'Value (USD)': 'sum'
}).reset_index()

# Plotting
plt.figure(figsize=(14, 7))

# Volume Plot
plt.subplot(1, 2, 1)
plt.plot(exports_summary_corrected['Year'], exports_summary_corrected['Volume (kg)'], marker='o', linestyle='-', color='blue')
plt.title('Total Volume of Exports (kg) per Year')
plt.xlabel('Year')
plt.ylabel('Volume (kg)')
plt.xticks(rotation=45)

# Value Plot
plt.subplot(1, 2, 2)
plt.plot(exports_summary_corrected['Year'], exports_summary_corrected['Value (USD)'], marker='s', linestyle='-', color='green')
plt.title('Total Value of Exports (USD) per Year')
plt.xlabel('Year')
plt.ylabel('Value (USD)')
plt.xticks(rotation=45)

plt.tight_layout()
plt.show()