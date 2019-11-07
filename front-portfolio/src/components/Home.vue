<template>
    <div id="home">

        <article class="scroller">
            <section id="uno">
                <h2>Section one</h2>
                <p>{{this.content.identity.name}}</p>
                <p>{{this.content.identity.poste}}</p>
                <p>{{this.content.identity.presentation}}</p>
                <p>{{this.content.identity.presentation}}</p>
                <p>{{this.content.identity.presentation}}</p>
            </section>
            <section id="deuxio">
                <h2>Section two</h2>
                <ul v-for="skill in content.skills" :key="skill">
                    <li>{{skill.titre}}</li>
                    <li>{{skill.description}}</li>
                </ul>
            </section>
            <section id="tercio">
                <h2>Section three</h2>
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
        height: 100vh;
        overflow-y: scroll;
        scroll-snap-stop: always;
        scroll-snap-type: y mandatory;
    }
    .scroller section {
        scroll-snap-align: center;
    }
    #uno{
        height: 100vh;
        background-color: darkseagreen;
    }
    #deuxio{
        height: 100vh;
        background-color: #2f2f2f;
    }
    #tercio{
        height: 100vh;
        background-color: darkkhaki;
    }

</style>