<template>
  <div id="app">
    <nav class="navbar navbar-expand-sm navbar-light bg-light">
      <a href="/home" class="navbar-brand">Portfolio</a>
      <div class="navbar-nav mr-auto">
        <li class="nav-item">
          <a href="/home" class="nav-link">
           Home
          </a>
        </li>
        <li class="nav-item" v-if="showAdminBoard">
          <a href="/admin" class="nav-link">Admin</a>
        </li>
        <li class="nav-item" v-if="showModeratorBoard">
          <a href="/mod" class="nav-link">Moderator Board</a>
        </li>
        <li class="nav-item" v-if="currentUser">
          <a href="/user" class="nav-link" >Cv</a>
        </li>
      </div>
      <div class="navbar-nav ml-auto" v-if="!currentUser">
        <li class="nav-item">
          <a href="/register" class="nav-link">
            Sign Up
          </a>
        </li>
        <li class="nav-item">
          <a href="/login" class="nav-link">
            Login
          </a>
        </li>
      </div>
      <div class="navbar-nav ml-auto" v-if="currentUser">
        <li class="nav-item">
          <a href="/profile" class="nav-link">
            {{currentUser.username}}
          </a>
        </li>
        <li class="nav-item">
          <a href class="nav-link" @click="logOut">
            LogOut
          </a>
        </li>
      </div>
    </nav>
    <div>
      <router-view />
    </div>
  </div>
</template>

<script>
  export default {
    computed: {
      currentUser() {
        return this.$store.state.auth.user;
      },
      showAdminBoard() {
        if (this.currentUser) {
          return this.currentUser.roles.includes('ROLE_ADMIN');
        }

        return false;
      },
      showModeratorBoard() {
        if (this.currentUser) {
          return this.currentUser.roles.includes('ROLE_MODERATOR');
        }

        return false;
      }
    },
    methods: {
      logOut() {
        this.$store.dispatch('auth/logout');
        this.$router.push('/login');
      }
    }
  };
</script>

<style>
    #app{
        margin: 0;
        padding: 0;
    }
   nav{
       margin: 0;
       padding: 0;
   }
</style>