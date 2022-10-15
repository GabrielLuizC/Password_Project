<template>
  <div class="column">
    <nav class="navbar" role="navigation" aria-label="main navigation">
      <div class="navbar-brand">
        <a class="navbar-item" @click="onClickHome()">
          <img src="../assets/senha.png" width="30" height="200" />
        </a>

        <a
          role="button"
          class="navbar-burger"
          aria-label="menu"
          aria-expanded="false"
          data-target="navbarBasicExample"
        >
          <span aria-hidden="true"></span>
          <span aria-hidden="true"></span>
          <span aria-hidden="true"></span>
        </a>
      </div>

      <div id="navbarBasicExample" class="navbar-menu">
        <div class="navbar-start">
          <a class="navbar-item" @click="onClickHome()"> Home </a>

          <a class="navbar-item" @click="onClickPasswords()"> Senhas </a>

          <div class="navbar-item has-dropdown is-hoverable">
            <a class="navbar-link"> Ferramentas </a>

            <div class="navbar-dropdown">
              <a class="navbar-item" @click="onClickChangePassword()">
                Alterar Senha
              </a>
            </div>
          </div>
        </div>

        <div class="navbar-end">
          <div class="navbar-item">
            <div class="buttons">
              <a class="button is-primary" @click="onClickRegister()">
                <b>Registrar</b>
              </a>
              <a class="button is-info" @click="onClickLogin()">
                <b>Logar</b>
              </a>
              <a class="button is-danger" @click="onClickLogout()">
                <b>Sair</b>
              </a>
            </div>
          </div>
        </div>
      </div>
    </nav>
  </div>

  <div class="columns">
    <div class="column conteudo">
      <router-view> </router-view>
    </div>
  </div>
</template>

<script lang="ts">
import { Vue } from "vue-class-component";
import { removeCookie } from "typescript-cookie";
import { AuthUtils } from "@/utils/AuthUtils";

export default class SidebarUtils extends Vue {
  authUtils: AuthUtils = new AuthUtils();
  isAuthenticated!: boolean;

  public mounted(): void {
    this.isAuthenticated = this.authUtils.checkAuthenticated();
  }

  public onClickLogout(): void {
    removeCookie("access");
    this.$router.push({ name: "user-login" });
  }

  public onClickPasswords(): void {
    this.$router.push({ name: "password" });
  }

  public onClickHome(): void {
    this.$router.push({ name: "home" });
  }

  public onClickLogin(): void {
    this.$router.push({ name: "user-login" });
  }

  public onClickRegister(): void {
    this.$router.push({ name: "user-register" });
  }

  public onClickChangePassword(): void {
    this.$router.push({ name: "user-update-pw" });
  }
}
</script>

<style lang="scss">
.column {
  margin-bottom: 40px;
}
</style>
