import pandas as pd
import matplotlib.pyplot as plt

# Read the CSV file 
df = pd.read_csv('data/Regression.csv')

# Create a figure and four subplots
fig, axs = plt.subplots(3, 2, figsize=(12, 8))

# Plot Cod_avg
axs[0, 0].plot(df['Year'], df['Cod_avg'])
axs[0, 0].set_xlabel('Year')
axs[0, 0].set_ylabel('USD')
axs[0, 0].set_title('Cod Yearly Average')

# Plot Haddock_avg
axs[0, 1].plot(df['Year'], df['Haddock_avg'])
axs[0, 1].set_xlabel('Year')
axs[0, 1].set_ylabel('USD')
axs[0, 1].set_title('Haddock Yearly Average')

# Plot Inflation Rate
axs[1, 0].plot(df['Year'], df['Inflation Rate'])
axs[1, 0].set_xlabel('Year')
axs[1, 0].set_ylabel('Ratio %')
axs[1, 0].set_title('Inflation Rate')

# Plot Mass Temp
axs[1, 1].plot(df['Year'], df['Mass Temp'])
axs[1, 1].set_xlabel('Year')
axs[1, 1].set_ylabel('F')
axs[1, 1].set_title('Massachusets Tempreture')

# Plot Mass Personal Income
axs[2, 0].plot(df['Year'], df['Mass PI'])
axs[2, 0].set_xlabel('Year')
axs[2, 0].set_ylabel('USD')
axs[2, 0].set_title('Massachusets Personal Income Per Capita')

# Plot product Consumption
axs[2, 1].plot(df['Year'], df['consumption'])
axs[2, 1].set_xlabel('Year')
axs[2, 1].set_ylabel('Pounds')
axs[2, 1].set_title('United States Product Consumption')

# Adjust subplot spacing
plt.subplots_adjust(hspace=0.7, wspace=0.2)

# Display the graph
plt.show()