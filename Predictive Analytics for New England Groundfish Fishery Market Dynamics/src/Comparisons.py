import pandas as pd
import matplotlib.pyplot as plt

# Load the dataset
data = pd.read_csv('data/Regression.csv')

# Create a figure with subplots
fig, axes = plt.subplots(nrows=4, ncols=2, figsize=(12, 12))

# Subplot 1: Import
axes[0, 0].plot(data['Year'], data['Cod_Import_Vol'], label='Cod')
axes[0, 0].plot(data['Year'], data['Haddock_Import_Vol'], label='Haddock')
axes[0, 0].set_title('Total Import Volumes (Pounds)')
axes[0, 0].set_ylabel('Pounds')
axes[0, 0].legend()

# Subplot 2: Export
axes[0, 1].plot(data['Year'], data['Haddock_Export_Vol'], label='Haddock')
axes[0, 1].plot(data['Year'], data['Cod_Export_Vol'], label='Cod')
axes[0, 1].set_title('Total Export Volumes (Pounds')
axes[0, 1].set_ylabel('Pounds')
axes[0, 1].legend()

# Subplot 3: Unemployment
axes[1, 0].plot(data['Year'], data['Maine Unemployment'], label='Maine')
axes[1, 0].plot(data['Year'], data['MASS Unemployment'], label='Massachusetts')
axes[1, 0].set_title('Unemployment Rate (%)')
axes[1, 0].set_ylabel('Rate (%)')
axes[1, 0].legend()

# Subplot 4: Inflation Rate
axes[1, 1].plot(data['Year'], data['Inflation Rate'], label='Inflation Rate')
axes[1, 1].set_title('Inflation Rate (%)')
axes[1, 1].set_ylabel('Rate (%)')
axes[1, 1].legend()

# Subplot 5: Consumption
axes[2, 0].plot(data['Year'], data['consumption'], label='Consumption')
axes[2, 0].set_title('Consumption (Pounds)')
axes[2, 0].set_ylabel('Pounds')
axes[2, 0].legend()

# Subplot 6: Populations
axes[2, 1].plot(data['Year'], data['ME Pop'], label='Maine')
axes[2, 1].plot(data['Year'], data['MA Pop'], label='Massachusetts')
axes[2, 1].set_title('Population Growth Rate (%)')
axes[2, 1].set_ylabel('Rate (%)')
axes[2, 1].legend()

# Subplot 7: Personal Income Per Capita
axes[3, 0].plot(data['Year'], data['Mass PI'], label='Massachusetts')
axes[3, 0].plot(data['Year'], data['Maine PI'], label='Maine')
axes[3, 0].set_title('Personal Income Per Capita (US dollars)')
axes[3, 0].set_ylabel('dollars')
axes[3, 0].legend()

# Subplot 8: Yearly Average Temperature
axes[3, 1].plot(data['Year'], data['Maine Temp'], label='Maine')
axes[3, 1].plot(data['Year'], data['Mass Temp'], label='Mass')
axes[3, 1].set_title('Yearly Average Temperature (°C)')
axes[3, 1].set_ylabel('F')
axes[3, 1].legend()

# Set the x-label for all subplots
for ax in axes.flatten():
    ax.set_xlabel('Year')

# Adjust subplot spacing
plt.subplots_adjust(hspace=1.4, wspace=0.3)

# Show the plot
plt.show()