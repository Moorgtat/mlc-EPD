<template>
  <div id="app">
    <nav class="navbar navbar-expand-sm navbar-light">
      <div class="navbar-nav mr-auto">
        <li class="nav-item">
          <a href="/home" class="navbar-brand mb-auto h1">Portfolio</a>
        </li>
        <li class="nav-item" v-if="currentUser">
          <a href="/user" class="nav-link" >Cv</a>
        </li>
        <li class="nav-item" v-if="showAdminBoard">
          <a href="/admin" class="nav-link">Admin</a>
        </li>
      </div>
      <div class="navbar-nav ml-auto" v-if="!currentUser">
        <li class="nav-item">
          <a class="nav-link" @click="registerModal()">Register</a>
        </li>
        <li class="nav-item">
          <a class="nav-link" @click="loginModal()">Login</a>
        </li>
      </div>
      <div class="navbar-nav ml-auto" v-if="currentUser">
        <li class="nav-item">
          <a href="/profile" class="nav-link">{{currentUser.username}}</a>
        </li>
        <li class="nav-item">
          <a href class="nav-link" @click="logOut">Logout</a>
        </li>
      </div>
    </nav>
    <div>
      <router-view />
    </div>
  </div>
</template>

<script>
    import login from '../src/components/Login'
    import register from '../src/components/Register'

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
        this.$router.push('/home')
      },
     loginModal() {
        this.$buefy.modal.open({
          parent: this,
          component: login,
          hasModalCard: true
        })
      },
      registerModal() {
        this.$buefy.modal.open({
          parent: this,
          component: register,
          hasModalCard: true
        })
      }
    }
  }
</script>

<style>
    .navbar-expand-sm {
         background-color: transparent;
    }

</style>