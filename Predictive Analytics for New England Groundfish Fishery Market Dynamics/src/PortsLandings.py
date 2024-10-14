import matplotlib.pyplot as plt
from DRY import PortsLandings
import seaborn as sns

new_england_data= PortsLandings('data/PortLandings.csv')

# Aggregate data to get the sum of 'Millions of Pounds' and 'Millions of Dollars' for each state per year
state_yearly_totals = new_england_data.groupby(['State', 'Year']).agg({'Millions of Pounds': 'sum', 'Millions of Dollars': 'sum'}).reset_index()

# Visualization for all New England data
plt.figure(figsize=(12, 8))
sns.barplot(data=new_england_data, x='Millions of Pounds', y='Port', hue='State', palette='mako', order=new_england_data.sort_values('Millions of Pounds', ascending=False)['Port'])
plt.title('Fishing Tonnage by Port in New England (2022)')
plt.xlabel('Millions of Pounds')
plt.ylabel('Port')
plt.tight_layout()
plt.show()

# Visualization of the sum of fishing tonnage for each state across different years
plt.figure(figsize=(12, 8))
sns.lineplot(data=state_yearly_totals, x='Year', y='Millions of Pounds', hue='State', marker='o', palette='mako')
plt.title('Yearly Fishing Tonnage Comparison Among New England States')
plt.xlabel('Year')
plt.ylabel('Total Millions of Pounds')
plt.legend(title='State')
plt.grid(True)
plt.tight_layout()
plt.show()

# Visualization of the sum of fishing value for each state across different years
plt.figure(figsize=(12, 8))
sns.lineplot(data=state_yearly_totals, x='Year', y='Millions of Dollars', hue='State', marker='o', palette='mako')
plt.title('Yearly Fishing Value Comparison Among New England States')
plt.xlabel('Year')
plt.ylabel('Total Millions of Dollars')
plt.legend(title='State')
plt.grid(True)
plt.tight_layout()
plt.show()