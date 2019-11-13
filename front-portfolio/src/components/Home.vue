<template>
    <div id="home">
        <article class="scroller">
            <section class="text-center" id="animation_section">
                    <img id="anim" alt="animation" src="../../public/image_1.jpg">
            </section>
            <section class="text-center" id="intro_section">
                <h1 class="display-4"> INTRO </h1>
                <p>{{this.content.identity.presentation}}</p>
                <p>{{this.content.identity.presentation}}</p>
            </section>
            <section class="text-center" id="skills_section">
                <h1 class="display-4"> Skills </h1>
                <ul v-for="skill in content.skills" :key="skill">
                    <li>{{skill.titre}}</li>
                    <li>{{skill.description}}</li>
                </ul>
            </section>
            <section class="text-center" id="projekt_section">
                <h1 class="display-4"> Projekt </h1>
                <ul v-for="projekt in content.projekts" :key="projekt">
                    <li>{{projekt.titre}}</li>
                    <li>{{projekt.description}}</li>
                </ul>
            </section>
        </article>
    </div>
</template>

<script>
    import UserService from '../services/user.service';

    export default {
        name: 'home',
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

<style>
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
    #animation_section{
        padding: 10%;
        height: 100vh;
        background-color: white;
    }
    #anim{
        margin-top: 5%;
        width: 548px;
        height: 400px;
    }
    #intro_section{
        padding: 10%;
        height: 100vh;
        background-color: white;
    }
    #skills_section{
        padding: 10%;
        height: 100vh;
        background-color: white;
    }
    #projekt_section{
        padding: 10%;
        height: 100vh;
        background-color: white;
    }
</style>