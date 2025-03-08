import Property from 'src/types/Property';
import httpClient from '../mock/HttpClient';
import Tenant from '../../types/Tenant.ts'

export default {
	getProperties(): Promise<Property[]> {
		try {
			return httpClient.fetchProperties().then((properties: any) => {
				console.log('properties:', <Property[]> properties);
				return <Property[]> properties;	
			});
		} catch (error) {
			console.error('Error fetching properties:', error);
			throw error;
		}
	},
	async getProperty(id: number): Promise<Property> {
		try {
			return httpClient.fetchProperties().then((properties: any) => {
				console.log('properties:', properties);				
				return properties.find((property: Property) => property.id === id);	
			});
		} catch (error) {
			console.error('Error fetching property:', error);
			throw error;
		}
	},
    getTenants(): Promise<Tenant[]> {
		try {
			return httpClient.fetchTenants().then((tenants: any) => {
				console.log('tenants:', <Tenant[]> tenants);
				return <Tenant[]> tenants;
			});
		} catch (error) {
			console.error('Error fetching properties:', error);
			throw error;
		}
    },
}