<template>
    <div id="home">
        <article class="scroller">
            <section class="text-center" id="anim_section">
              <div id="fullstack-container">
                  <name-fullstack></name-fullstack>
              </div>
              <div id="presente">
                  <div id="image-profil-container">
                  <img id="image-profil" src="avatar.png" alt="Mon image de progil"/>
                  </div>
                  <div id="texte-presente">{{this.content.identity.presentation}}</div>
                  <b-button  onclick="window.open('cv-mlc.pdf')" type="is-warning" outlined><b><strong>GET CV</strong></b></b-button>
              </div>
            </section>
            <section class="text-center" id="skill_section">
                <div id="bkcontainer">
                <h1 class="display-4"> Skills Backend </h1>
                <ul v-for="skill in content.skills" :key="skill">
                    <li><strong>{{skill.titre}}</strong></li>
                    <li>{{skill.description}}</li>
                </ul>
               </div>
                <div id="ftcontainer">
                    <h1 class="display-4"> Skills Frontend </h1>
                    <ul v-for="skill in content.skills" :key="skill">
                        <li><strong>{{skill.titre}}</strong></li>
                        <li>{{skill.description}}</li>
                    </ul>
                </div>
            </section>
            <section class="text-center" id="projekt_section">
                <h1 class="display-4"> Projekt </h1>
                <ul v-for="projekt in content.projekts" :key="projekt">
                    <li><strong>{{projekt.titre}}</strong></li>
                    <li>{{projekt.description}}</li>
                </ul>
            </section>
            <section class="text-center" id="contact_section">
                <h1 class="display-4"> Contact </h1>
            </section>
        </article>
    </div>
</template>

<script>
    import UserService from '../services/user.service';
    import NameFullstack from "@/components/svg/namefullstack";

    export default {
        name: 'home',
        components: {NameFullstack},
        data() {
            return {
                content: ""
            }
        },
        mounted() {
            UserService.getPublicContent().then(
                response => {
                    this.content = response.data;
                },
                error => {
                    this.content = error.response.data.message
                }
            )
        }
    }
</script>

<style scoped>
    body{
        display: flex;
        flex-wrap: wrap;
    }
    #home{
    }
    .scroller {
        margin: 0;
        height: 100vh;
        overflow-y: scroll;
        scroll-snap-stop: always;
        scroll-snap-type: y mandatory;
    }
    .scroller section {
        scroll-snap-align: center;
    }
    #anim_section{
        height: 100vh;
        padding-bottom: 20%;
        background-color: white;
        display: flex;
        flex-direction: row;
        flex-wrap: wrap;
        justify-content: space-evenly;
        align-items: center;
    }
    #presente{
        width: 400px;
        height: 340px;
        display: flex;
        flex-direction: column;
        align-items: center;
    }
    #image-profil-container{
        height: 250px;
        width: 250px;
    }
    #image-profil{
        width: 155px;
    }
    #image-profil:hover{
        animation: bounce 2s ease infinite;
        opacity: 85%;
    }
    @keyframes bounce {
        from{
            width: 155px;
        }
        50%{
            width: 175px;
        }
        to{
            width: 155px;
        }
    }
    #texte-presente{
        margin-bottom: 15px;
    }
    #skill_section{
        height: 100vh;
        padding-bottom: 20%;
        background-color: white;
        display: flex;
        flex-direction: row;
        flex-wrap: wrap;
        justify-content: space-evenly;
        align-items: center;
    }
    #bkcontainer{
        background-color: darkseagreen;
    }
    #ftcontainer{
        background-color: lightgoldenrodyellow;
    }
    #projekt_section{
        height: 100vh;
        margin-bottom: 160px;
    }
    #contact_section{
        height: 100vh;
        margin-bottom: 160px;
    }

</style>