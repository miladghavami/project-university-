import matplotlib.pyplot as plt
from DRY import Trends


# Load and process the data
data = Trends('data/FossLandings.csv')

# Filter for New England states
new_england_states = ['CONNECTICUT', 'MAINE', 'MASSACHUSETTS', 'NEW HAMPSHIRE', 'RHODE ISLAND', 'VERMONT']
new_england_data = data[data['State'].isin(new_england_states)]

# Identify the species by total pounds landed
species_data = new_england_data.groupby('NMFS Name')['Pounds'].sum()
species_names = species_data.index.tolist()

# Trend Analysis Graph for Top Species by Volume
fig, ax1 = plt.subplots(figsize=(14, 7))
for species in species_names:
    species_data = new_england_data[new_england_data['NMFS Name'] == species]
    yearly_sum = species_data.groupby('Year')['Pounds'].sum()
    ax1.plot(yearly_sum.index, yearly_sum.values, label=species)
ax1.set_xlabel('Year')
ax1.set_ylabel('Pounds')
ax1.set_title('Trend of Fish Landings in New England for Species by Volume')
ax1.legend()

# Value Analysis Graph for Top Species by Economic Value
fig, ax2 = plt.subplots(figsize=(14, 7))
for species in species_names:
    species_data = new_england_data[new_england_data['NMFS Name'] == species]
    yearly_value = species_data.groupby('Year')['Dollars'].sum()
    ax2.plot(yearly_value.index, yearly_value.values, label=species)
ax2.set_xlabel('Year')
ax2.set_ylabel('Dollars')
ax2.set_title('Value of Fish Landings in New England for Species by Economic Value')
ax2.legend()

plt.tight_layout()
plt.show()

# Calculate total values and pounds for each state over all years
state_totals = data.groupby('State').agg({'Pounds': 'sum', 'Dollars': 'sum'}).sort_values(by=['Dollars', 'Pounds'], ascending=False)

# Calculate the average rate of fish landings (in pounds) for each year across all states
yearly_average_pounds = data.groupby('Year')['Pounds'].mean()

print(state_totals)
print(yearly_average_pounds)