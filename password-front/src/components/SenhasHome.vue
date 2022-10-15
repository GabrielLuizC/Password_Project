<template>
  <div class="home">
    <h1 class="is-flex is-flex-direction-column is-align-items-center mt-6">
      <b class="mb-6"
        >UM SISTEMA DE SENHAS, FEITO A PARTIR DE UM PROJETO SOLICITADO</b
      >
      <img src="../assets/senha.png" width="200" height="400" />
    </h1>
  </div>
</template>

<script lang="ts">
import { Options, Vue } from "vue-class-component";

@Options({
  props: {
    msg: String,
  },
})
export default class HelloWorld extends Vue {
  msg!: string;
}
</script>

<style scoped></style>
