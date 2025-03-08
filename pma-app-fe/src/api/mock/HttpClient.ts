import properties from './data/properties.json'
import tenants from './data/tenants.json'

const fetch = (mockData: any, time = 0) => {
	return new Promise((resolve) => {
		setTimeout(() => {
			resolve(mockData)
		}, time)
	})
}
export default {
	fetchProperties() {
		return fetch(properties, 1000) // wait 1s before returning posts
	},
	fetchTenants() {
		return fetch(tenants)
	},
}