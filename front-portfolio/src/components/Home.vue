<template>
    <div class="container">
        <header class="jumbotron">
            <div>
            <h1>{{this.content.identity.name}}</h1>
            <h1>{{this.content.identity.poste}}</h1>
            <h1>{{this.content.identity.mail}}</h1>
            <h1>{{this.content.identity.lien_git}}</h1>
            <h1>{{this.content.identity.lien_twitter}}</h1>
            <h1>{{this.content.identity.objectif_titre}}</h1>
            <h1>{{this.content.identity.objectif_description}}</h1>
            </div>
            <div>
            <ul v-for="skill in content.skills" :key="skill">
                <li>{{skill.id}}</li>
                <li>{{skill.titre}}</li>
                <li>{{skill.description}}</li>
            </ul>
            </div>
            <div>
                <ul v-for="projekt in content.projekts" :key="projekt">
                    <li>{{projekt.id}}</li>
                    <li>{{projekt.titre}}</li>
                    <li>{{projekt.description}}</li>
                    <li>{{projekt.github}}</li>
                </ul>
            </div>
        </header>
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
    div{
        margin-top: 30px;
    }
</style>