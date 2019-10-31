<template>
    <div id="home">
        <div class="row">
        <div class="col-3">
            <h1>{{this.content.identity.name}}</h1>
            <h1>{{this.content.identity.poste}}</h1>
            <h1>{{this.content.identity.mail}}</h1>
            <h1>{{this.content.identity.lien_git}}</h1>
            <h1>{{this.content.identity.lien_twitter}}</h1>
            <h1>{{this.content.identity.objectif_titre}}</h1>
            <h1>{{this.content.identity.objectif_description}}</h1>
        </div>
        <div class="col-5">
            <ul v-for="skill in content.skills" :key="skill">
                <li>{{skill.titre}}</li>
                <li>{{skill.description}}</li>
            </ul>
         </div>

        <div class="col-3">
                <ul v-for="projekt in content.projekts" :key="projekt">
                    <li>{{projekt.titre}}</li>
                    <li>{{projekt.description}}</li>
                    <li>{{projekt.github}}</li>
                </ul>
        </div>
        </div>

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
#home{
    margin-top: 10px;
    background-color: white;
    text-align: center;
}
</style>