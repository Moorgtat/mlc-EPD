<template>
    <div id="app">
        <nav id="genNavbar" class="navbar navbar-expand navbar-light">
            <div class="container-fluid">
            <ul class="navbar-nav mr-auto">
                <li class="nav-item">
                    <a id="affportfo" href="/home" class="navbar-brand"  v-for="identity in myIdentity" :key="identity.id">
                       <span><b>{{identity.titreprojet}}</b></span>
                    </a>
                </li>
            </ul>

            <ul class="navbar-nav" v-if="!currentUser">
                <li class="nav-item">
                    <a class="nav-link"><img id="iconetwitter" src="../public/icone-twitter.png"
                                                 onclick="window.open('https://twitter.com/MatLcd')" alt="Mon Twitter"/></a>
                </li>
                <li class="nav-item">
                    <a class="nav-link"> <img id="iconegithub" src="../public/icone-github.png"
                                                  onclick="window.open('https://github.com/Moorgtat')" alt="Mon GitHub"/></a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" @click="loginModal()"><img id="iconelogin" src="../public/icone-login3.png"
                        alt="Une icone de login"/></a>
                </li>
            </ul>

            <ul class="navbar-nav" v-if="currentUser">
                <li class="nav-item" v-if="showAdminBoard">
                    <a href="/admin" class="nav-link">Admin</a>
                </li>
                <li class="nav-item">
                    <a href="/profile" class="nav-link">{{currentUser.username}}</a>
                </li>
                <li class="nav-item">
                    <a href class="nav-link" @click="logOut">Logout</a>
                </li>
            </ul>
            </div>
        </nav>
        <div>
            <router-view/>
        </div>
    </div>
</template>

<script>
    import {mapActions, mapGetters} from 'vuex';
    import login from '../src/components/Login'

    export default {
    computed: {
        ...mapGetters(['myIdentity']),
      currentUser() {
        return this.$store.state.auth.user
      },
      showAdminBoard() {
        if (this.currentUser) {
          return this.currentUser.roles.includes('ROLE_ADMIN')
        }
        return false;
      }
    },
    methods: {
        ...mapActions(['fetchIdentity']),
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
    },
      mounted() {
          this.fetchIdentity();
      },
  }
</script>

<style>
    #app{
        font-family: "Comic Sans MS", serif;
    }
    #genNavbar{
        max-height: 20px;
    }
    #iconelogin{
        height: 22px;
    }
    #iconelogin:hover{
        transform: rotate(4deg);
    }
    #iconegithub{
        height: 22px;
    }
    #iconegithub:hover{
        transform: rotate(6deg);
    }
    #iconetwitter{
        height: 22px;
    }
    #iconetwitter:hover{
        transform: rotate(4deg);
    }
    #affportfo{
        font-family: "AR BERKLEY", sans-serif;
        color: black;
        font-size: 18px;
    }
    #affportfo:hover{
        transform: rotate(3deg);
    }
</style>