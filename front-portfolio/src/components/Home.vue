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
                  <div v-for="identity in myIdentity" :key="identity.id">
                      <div id="texte-presente">{{identity.presentation}}</div>
                  </div>
                  <b-button  onclick="window.open('cv-mlc.pdf')" type="is-warning" outlined><b><strong>GET CV</strong></b></b-button>
              </div>
            </section>
            <section class="text-center" id="skill_section">
                <div id="backskills-container">
                    <h1><strong>Back skills</strong></h1>
                    <div id="forBSkills" v-for="skill in allBackSkills" :key="skill.id">
                        <div> {{skill.titre}} </div>
                        <div> {{skill.description}} </div>
                        <img id="logo-backskills" :src='skill.logo' alt="logo des skills back"/>
                    </div>
               </div>
                <div id="frontskills-container">
                    <h1><strong>Front Skills</strong></h1>
                    <div id="forFSkills" v-for="skill in allFrontSkills" :key="skill.id">
                        <p> {{skill.titre}} </p>
                        <p> {{skill.description}} </p>
                        <img id="logo-frontskills" :src='skill.logo' alt="logo des skills front"/>
                    </div>
                </div>
            </section>
            <section class="text-center" id="projekt_section">
                <h1 class="display-4"> Projekt </h1>
                <div v-for="projekt in allProjekts" :key="projekt.id">
                    <p><strong>{{projekt.titre}}</strong></p>
                    <p>{{projekt.description}}</p>
                    <p>{{projekt.slide_1}}</p>
                    <p>{{projekt.slide_2}}</p>
                    <p>{{projekt.slide_3}}</p>
                </div>
            </section>
            <section class="text-center" id="contact_section">
                <h1 class="display-4"> Contact </h1>
            </section>
        </article>
    </div>
</template>

<script>
    import NameFullstack from "@/components/svg/namefullstack";
    import {mapActions, mapGetters} from 'vuex'

    export default {
        name: 'home',
        components: {NameFullstack},
        data() {
            return {
                homecontent: "",
                skills: {}
            }
        },
        methods: {
            ...mapActions(['fetchSkills']),
            ...mapActions(['fetchIdentity']),
            ...mapActions(['fetchProjekts'])
        },
        computed: {
            ...mapGetters(['allBackSkills']),
            ...mapGetters(['allFrontSkills']),
            ...mapGetters(['myIdentity']),
            ...mapGetters(['allProjekts'])
        },
        mounted() {
            this.fetchSkills();
            this.fetchIdentity();
            this.fetchProjekts()
        }
    }
</script>

<style scoped>
 /*Gestion du Scroller*/
    .scroller {
        margin: 0;
        height: 100vh;
        overflow-y: scroll;
        scroll-snap-stop: always;
        scroll-snap-type: y mandatory;
    }
    .scroller section {
        scroll-snap-align: start;
    }

    /*Section Animation et Présentation*/
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

    /*Section des Compétences*/
    #skill_section{
        padding-top: 3%;
        background-color: white;
        display: flex;
        flex-direction: row;
        flex-wrap: wrap;
        justify-content: space-evenly;
        align-items: center;
        padding-bottom: 25%;
    }
    #backskills-container{
        width: 430px;
        display: flex;
        flex-direction: row;
        flex-wrap: wrap;
        justify-content: space-evenly;
        align-items: center;
    }
    #frontskills-container{
        width: 430px;
        display: flex;
        flex-direction: row;
        flex-wrap: wrap;
        justify-content: space-evenly;
        align-items: center;
    }
    #forBSkills{
        margin: 15px;
    }
    #forFSkills{
        margin: 15px;
    }
    #logo-backskills{
        height: 25px;
    }
    #logo-frontskills{
        height: 25px;
    }

    /*Section des Projets*/
    #projekt_section{
        padding-top: 3%;
        height: 100vh;
        margin-bottom: 160px;
    }

    /*Section Contact*/
    #contact_section{
        padding-top: 3%;
        height: 100vh;
        margin-bottom: 160px;
    }

</style>