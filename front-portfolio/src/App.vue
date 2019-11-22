<template>
    <div id="app">
        <nav class="navbar navbar-expand-sm navbar-light">
            <ul class="navbar-nav mr-auto">
                <li class="nav-item">
                    <a id="affportfo" href="/home" class="navbar-brand mb-auto h1"><strong>Portfolio</strong></a>
                </li>
            </ul>
            <div class="collapse navbar-collapse" id="navbarTogglerDemo01">
                <ul class="navbar-nav mr-auto">
                    <li class="nav-item" v-if="currentUser">
                        <a href="/user" class="nav-link">Goodies</a>
                    </li>
                    <li class="nav-item" v-if="showAdminBoard">
                        <a href="/admin" class="nav-link">Admin</a>
                    </li>
                </ul>
                <ul class="navbar-nav ml-auto" v-if="!currentUser">
                    <!--        <li class="nav-item">-->
                    <!--          <a class="nav-link" @click="registerModal()">Register</a>-->
                    <!--        </li>-->
                    <li class="nav-item">
                        <a class="nav-link"><img id="iconetwitter" src="../public/icone-twitter.png"
                                                 onclick="window.open('https://twitter.com/MatLcd')" alt="Mon Twitter"/></a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link"> <img id="iconegithub" src="../public/icone-github.png"
                                                  onclick="window.open('https://github.com/Moorgtat')" alt="Mon GitHub"/></a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" @click="loginModal()"><img id="iconelogin" src="../public/icone-login.png"
                        alt="icone de login"/></a>
                    </li>
                </ul>
                <ul class="navbar-nav ml-auto" v-if="currentUser">
                    <li class="nav-item">
                        <a href="/profile" class="nav-link">{{currentUser.username}}</a>
                    </li>
                    <li class="nav-item">
                        <a href class="nav-link" @click="logOut">Logout</a>
                    </li>
                </ul>
            </div>
            <button class="navbar-toggler ml-auto" type="button" data-toggle="collapse"
                    data-target="#navbarTogglerDemo01" aria-controls="navbarTogglerDemo01" aria-expanded="false"
                    aria-label="Toggle navigation">
                <img src="../public/icone-toggler.png" alt="icone du toggler">
            </button>
        </nav>
        <div>
            <router-view/>
        </div>
    </div>
</template>

<script>
    import login from '../src/components/Login'
    // import register from '../src/components/Register'
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
      // showModeratorBoard() {
      //   if (this.currentUser) {
      //     return this.currentUser.roles.includes('ROLE_MODERATOR')
      //   }
      //
      //   return false;
      // }
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
      }
      // ,
      // registerModal() {
      //   this.$buefy.modal.open({
      //     parent: this,
      //     component: register,
      //     hasModalCard: true
      //   })
      // }
    }
  }
</script>

<style>
    #app{
        font-family: "Comic Sans MS", serif;
    }
    .navbar-expand-sm {
         background-color: transparent;
    }
    #iconelogin:hover{
        transform: rotate(4deg);
    }
    #iconegithub:hover{
        transform: rotate(6deg);
    }
    #iconetwitter:hover{
        transform: rotate(4deg);
    }
    #affportfo:hover{
        transform: rotate(3deg);
    }
</style>