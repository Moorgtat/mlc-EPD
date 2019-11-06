<template>
    <div id="home">
        <section class="column is-full-screen">
                <div class="container">
                    <h1 class="display-4">{{this.content.identity.name}}</h1>
                    <p class="lead">{{this.content.identity.poste}}</p>
                </div>
                <div class="jumbotron">{{this.content.identity.presentation}}</div>
        </section>

        <section class="column is-full-screen">
                <div class="container">
            <ul v-for="skill in content.skills" :key="skill">
                <li><h3 class="display-4">{{skill.titre}}</h3></li>
                <li><div class="jumbotron">{{skill.description}}</div></li>
            </ul>
                </div>
        </section>

        <section class="column is-full-screen">
                <div class="container">
                <ul v-for="projekt in content.projekts" :key="projekt">
                    <li><h1 class="display-4">{{projekt.titre}}</h1></li>
                    <li><div class="jumbotron">{{projekt.description}}</div></li>
                </ul>
                </div>
        </section>
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

<style scoped>
    #home{
    margin: 0px;
    background-color: white;
    text-align: center;
    }
    .jumbotron{
    background-color: white;
    }
</style>