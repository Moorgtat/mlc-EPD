<template>
  <div id="app">

    <b-navbar>
      <template slot="brand">
        <b-navbar-item>
          <img
                  src="https://raw.githubusercontent.com/buefy/buefy/dev/static/img/buefy-logo.png"
          >
        </b-navbar-item>
      </template>

      <template slot="start">
        <b-navbar-item href="/home">
          Home
        </b-navbar-item>
        <b-navbar-item v-if="currentUser" href="/user">
          CV
        </b-navbar-item>
        <b-navbar-item v-if="showModeratorBoard" href="/mod">
          Moderator Board
        </b-navbar-item>
        <b-navbar-item v-if="showAdminBoard" href="/admin">
          Admin Board
        </b-navbar-item>
      </template>

      <template slot="end">
        <b-navbar-item tag="div">
          <div class="buttons" v-if="!currentUser">
            <a  class="button is-primary" href="/register">
              <strong>Sign up</strong>
            </a>
            <a class="button is-light" href="/login">
              Log in
            </a>
            <div class="buttons" v-if="currentUser">
              <a  class="button is-primary" href="/profile">
                <strong>{{currentUser.username}}</strong>
              </a>
              <a class="button is-light" @click="logOut">
                LogOut
              </a>
            </div></div>


        </b-navbar-item>
      </template>
    </b-navbar>

    <div class="container">
      <router-view />
    </div>
  </div>
</template>

<script>
  export default {
    computed: {
      currentUser() {
        return this.$store.state.auth.user
      },
      showAdminBoard() {
        if (this.currentUser) {
          return this.currentUser.roles.includes('ROLE_ADMIN')
        }

        return false;
      },
      showModeratorBoard() {
        if (this.currentUser) {
          return this.currentUser.roles.includes('ROLE_MODERATOR')
        }

        return false;
      }
    },
    methods: {
      logOut() {
        this.$store.dispatch('auth/logout')
        this.$router.push('/login')
      }
    }
  }
</script>

<style>
#app {

}
</style>
