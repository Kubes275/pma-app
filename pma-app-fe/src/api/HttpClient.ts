import axios from 'axios';
import Property from 'src/types/Property';

const HttpClient = axios.create({
	baseURL: 'https://localhost:8080/api', // Replace with your API base URL
	timeout: 1000,
	headers: { 'Content-Type': 'application/json' }
});

export default {
	async fetchProperties() : Promise<Property[]> {
		const response = await HttpClient
			.get('/properties');
		return response.data;
	}
}