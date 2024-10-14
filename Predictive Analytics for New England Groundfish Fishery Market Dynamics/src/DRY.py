
import pandas as pd

def remove_outliers(data, column):
    Q1 = data[column].quantile(0.25)
    Q3 = data[column].quantile(0.75)
    IQR = Q3 - Q1
    lower = Q1 - 1.5 * IQR
    upper = Q3 + 1.5 * IQR
    return data[(data[column] >= lower) & (data[column] <= upper)]


def Trends(file_path):
    # Load the data
    data = pd.read_csv(file_path, header=1)

    # Remove rows with null values
    data = data.dropna()

    # Clean and prepare the data
    data.columns = ['Year', 'State', 'NMFS Name', 'Pounds', 'Metric Tons', 'Dollars', 'Confidentiality', 'Collection', 'Scientific Name', 'Tsn', 'Source']
    data['Pounds'] = pd.to_numeric(data['Pounds'].str.replace(',', ''), errors='coerce')
    data['Dollars'] = pd.to_numeric(data['Dollars'].str.replace(',', ''), errors='coerce')

    # Remove outliers based on Z-score
    data = remove_outliers(data, 'Pounds')
    data = remove_outliers(data, 'Dollars')

    return data

def Imports(file_path):
    # Load the datasets, skipping the first row which might be causing the issue
    data = pd.read_csv(file_path, skiprows=[0])

    # Remove rows with null values
    data = data.dropna()

    # Rename columns for easier access
    data.columns = ['Year', 'Source', 'Product Name', 'Country Name', 'Volume (kg)', 'Value (USD)', 'Calculated Duty (USD)', 'Edible code']

    # Convert 'Volume (kg)' and 'Value (USD)' to numeric values
    data['Volume (kg)'] = pd.to_numeric(data['Volume (kg)'].str.replace(',', ''), errors='coerce')
    data['Value (USD)'] = pd.to_numeric(data['Value (USD)'].str.replace(',', ''), errors='coerce')

    # Filter the dataset for Norway, Iceland, Russia, Denmark, and England
    countries = ['NORWAY', 'ICELAND', 'RUSSIAN FEDERATION', 'DENMARK', 'UNITED KINGDOM']
    imports_filtered = data[data['Country Name'].isin(countries)]

    # Remove outliers in 'Volume (kg)' and 'Value (USD)' columns
    imports_filtered= remove_outliers(imports_filtered, 'Volume (kg)')
    imports_filtered = remove_outliers(imports_filtered, 'Value (USD)')

    return imports_filtered

def Exports(file_path):
    # Load the exports dataset, ensuring to skip any header rows that may cause issues
    data = pd.read_csv(file_path, skiprows=[0])

    # Remove rows with null values
    data = data.dropna()

    # Rename columns for easier access
    data.columns = ['Year', 'Source', 'Product Name', 'Country Name', 'Volume (kg)', 'Value (USD)', 'Edible code']

    # Convert 'Volume (kg)' and 'Value (USD)' to numeric values
    data['Volume (kg)'] = pd.to_numeric(data['Volume (kg)'].str.replace(',', ''), errors='coerce')
    data['Value (USD)'] = pd.to_numeric(data['Value (USD)'].str.replace(',', ''), errors='coerce')

    # Remove outliers in 'Volume (kg)' and 'Value (USD)' columns
    data = remove_outliers(data, 'Volume (kg)')
    data = remove_outliers(data, 'Value (USD)')

    return data


def Auction(file_path):
    # Load the dataset
    data = pd.read_csv(file_path)

    # Handle Null Values: fill with median
    data['AvgPrice'].fillna(data['AvgPrice'].median(), inplace=True)

    # Filter for 'Cod' and 'Haddock' in the 'FishDesc' column
    filtered_data = data[data['FishDesc'].str.contains('Cod|Haddock', case=False, na=False)]

    # Removing outliers in 'AvgPrice' using the remove_outliers function
    cleaneded_data = remove_outliers(filtered_data, 'AvgPrice')

    
    return cleaneded_data


def DomesticVsImport(imports_file_path, landings_file_path):

    imports_data = pd.read_csv(imports_file_path, skiprows=[0])
    landings_data = pd.read_csv(landings_file_path, header=1)
    
    # Prepare imports_data
    imports_data['Volume (kg)'] = pd.to_numeric(imports_data['Volume (kg)'].str.replace(',', ''), errors='coerce')
    imports_data['Value (USD)'] = pd.to_numeric(imports_data['Value (USD)'].str.replace(',', ''), errors='coerce')
    imports_filtered = imports_data[(imports_data['Country Name'].isin(['NORWAY', 'ICELAND'])) & (imports_data['Product Name'].str.contains('COD|HADDOCK', na=False))]
    imports_summary = imports_filtered.groupby('Year').agg({'Volume (kg)': 'sum', 'Value (USD)': 'sum'}).reset_index()

    # Remove outliers from imports_summary
    imports_summary = remove_outliers(imports_summary, 'Volume (kg)')
    imports_summary = remove_outliers(imports_summary, 'Value (USD)')

    # Prepare landings_data
    landings_data['Pounds'] = pd.to_numeric(landings_data['Pounds'].str.replace(',', ''), errors='coerce')
    landings_data['Dollars'] = pd.to_numeric(landings_data['Dollars'].str.replace(',', ''), errors='coerce')
    landings_filtered = landings_data[(landings_data['NMFS Name'].str.contains('COD|HADDOCK', na=False))]
    landings_summary = landings_filtered.groupby('Year').agg({'Pounds': 'sum', 'Dollars': 'sum'}).reset_index()
    landings_summary['Pounds'] = landings_summary['Pounds'] * 0.453592  # Convert pounds to kilograms

    # Remove outliers from landings_summary
    landings_summary = remove_outliers(landings_summary, 'Pounds')
    landings_summary = remove_outliers(landings_summary, 'Dollars')

    # Ensure 'Year' columns in both summaries are of the same data type for merging
    imports_summary['Year'] = imports_summary['Year'].astype(int)
    landings_summary['Year'] = landings_summary['Year'].astype(int)

    # Merge the summaries for comparison
    combined_summary = pd.merge(imports_summary, landings_summary, on='Year', how='inner')

    return combined_summary


def Product_import(file_path):
    
    # Load the dataset, correcting the path as necessary
    data = pd.read_csv(file_path, skiprows=[0])

    # Remove rows with null values
    data = data.dropna()

    # Rename columns for easier access
    data.columns = ['Year', 'Source', 'Product Name', 'Country Name', 'Volume (kg)', 'Value (USD)', 'Calculated Duty (USD)', 'Edible code']

    # Convert 'Volume (kg)' and 'Value (USD)' to numeric values
    data['Volume (kg)'] = pd.to_numeric(data['Volume (kg)'].str.replace(',', ''), errors='coerce')
    data['Value (USD)'] = pd.to_numeric(data['Value (USD)'].str.replace(',', ''), errors='coerce')

    fish_filtered = data[data['Product Name'].str.contains('COD|HADDOCK', case=False)]

    fish_filtered = remove_outliers(fish_filtered, 'Volume (kg)')

    return fish_filtered


def PortsLandings(file_path):
    # Load the dataset
    data = pd.read_csv(file_path, skiprows=[0])

    # Remove rows with null values
    data = data.dropna()

    # Rename columns for easier access
    data.columns = ['Year', 'Port', 'Millions of Pounds', 'Millions of Dollars']

    # List of New England state abbreviations to look for (excluding VT)
    new_england_states = ['ME', 'MA', 'NH', 'RI']

    # Extract state abbreviation from 'Port' column
    data['State'] = data['Port'].apply(lambda x: x.split(', ')[-1] if ', ' in x else None)

    # Ensure 'Year' is in an appropriate format for grouping
    data['Year'] = pd.to_numeric(data['Year'], errors='coerce')

    # Filter the dataframe for ports that are located in the New England states
    new_england_data = data[data['State'].isin(new_england_states)]

    # Convert 'Millions of Pounds' and 'Millions of Dollars' to numeric values for aggregation and visualization
    new_england_data['Millions of Pounds'] = pd.to_numeric(new_england_data['Millions of Pounds'], errors='coerce')
    new_england_data['Millions of Dollars'] = pd.to_numeric(new_england_data['Millions of Dollars'], errors='coerce')

    # Remove outliers in 'Millions of Pounds' and 'Millions of Dollars' columns
    new_england_data = remove_outliers(new_england_data, 'Millions of Pounds')
    new_england_data = remove_outliers(new_england_data, 'Millions of Dollars')


    return new_england_data


def Auction_Analysis(file_path):
    # Load the data
    data = pd.read_csv('data/pfex_report.csv')

    # Remove rows with null values
    data = data.dropna()

    # Calculate the midpoint price as the average price
    data['AvgPrice'] = (data['HighPrice'] + data['LowPrice']) / 2

    # Remove outliers in 'AvgPrice' column
    data = remove_outliers(data, 'AvgPrice')

    return data
