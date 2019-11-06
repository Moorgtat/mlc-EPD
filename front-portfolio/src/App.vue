<template>
  <div id="app">
    <nav class="navbar navbar-expand-sm navbar-light bg-light">
      <a href="/home" class="navbar-brand mb-1 h1"> Portfolio </a>
      <div class="navbar-nav mr-auto">
        <li class="nav-item">
          <a href="/home" class="nav-link">Home</a>
        </li>
        <li class="nav-item" v-if="currentUser">
          <a href="/user" class="nav-link" >Cv</a>
        </li>
        <li class="nav-item" v-if="showAdminBoard">
          <a href="/admin" class="nav-link">Admin</a>
        </li>
        <li class="nav-item" v-if="showModeratorBoard">
          <a href="/mod" class="nav-link">Moderator</a>
        </li>
      </div>
      <div class="navbar-nav ml-auto" v-if="!currentUser">
        <li class="nav-item">
          <a class="nav-link" @click="registerModal()">Register</a>
        </li>
        <li class="nav-item">
          <a class="nav-link" @click="loginModal()" @mouseover="active = true" @mouseout="active = false">Login</a>
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

    <div id="infoConnection" class="text-center" v-if="active">
      Connecte toi pour avoir accès à mon cv!
    </div>

    <div>
      <router-view />
    </div>
  </div>

</template>

<script>
    import login from '../src/components/Login'
    import register from '../src/components/Register'

    export default {
    data(){
      return {
        active: ''
      }
    },
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
    #app{
        margin: 0;
        padding: 0;
      z-index: 1;
    }
   nav{
       margin: 0;
       padding: 0;
   }
  #infoConnection{
    font-family: "Comic Sans MS";
    position: absolute;
    margin-left: 80%;
    padding: 10px;
    height: 15%;
    width: 20%;
    z-index: 2;
  }
    @media (min-width: 882px) {
      #infoConnection{
        margin-left: 88%;
        width: 12%;
      }
    }
    @media (min-width: 1222px){
      #infoConnection{
        margin-left: 92%;
        width: 8%;
      }
    }
</style>