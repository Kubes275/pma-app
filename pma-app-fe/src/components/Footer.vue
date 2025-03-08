<template>
	<v-footer>
		<div class="text-caption text-disabled" style="position: absolute; right: 16px;">
			&copy; 2016-{{ (new Date()).getFullYear() }} <span class="d-none d-sm-inline-block">Vuetify, LLC</span>
			—
			<a class="text-decoration-none on-surface" href="https://vuetifyjs.com/about/licensing/"
				rel="noopener noreferrer" target="_blank">
				MIT License
			</a>
		</div>
	</v-footer>
</template>

<script lang="ts">
export default {
	name: 'Footer',
}
</script>