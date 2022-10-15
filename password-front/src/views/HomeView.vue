<template>
  <SenhasHome />
</template>

<script lang="ts">
import { Options, Vue } from "vue-class-component";
import SenhasHome from "../components/SenhasHome.vue";

@Options({
  components: {
    SenhasHome,
  },
})
export default class HomeView extends Vue {}
</script>
