<template>
    <div id="home">
        <div id="test-row" class="row">
        <div class="col-12">
            <div class="jumbotron jumbotron-fluid">
                <div class="container">
            <h1 class="display-3">{{this.content.identity.name}}</h1>
                    <p class="lead">{{this.content.identity.poste}}</p>
            <h1>{{this.content.identity.mail}}</h1>
            <h1>{{this.content.identity.lien_git}}</h1>
            <h1>{{this.content.identity.lien_twitter}}</h1>
            <h1>{{this.content.identity.objectif_titre}}</h1>
            <h1>{{this.content.identity.objectif_description}}</h1>
                </div>
            </div>
        </div>
        <div class="col-12">
            <div class="jumbotron jumbotron-fluid">
                <div class="container">
            <ul v-for="skill in content.skills" :key="skill">
                <li><h3 class="display-4">{{skill.titre}}</h3></li>
                <li>{{skill.description}}</li>
            </ul>
                </div>
         </div>
        </div>

        <div class="col-12">
            <div class="jumbotron jumbotron-fluid">
                <div class="container">
                <ul v-for="projekt in content.projekts" :key="projekt">
                    <li><h1 class="display-4">{{projekt.titre}}</h1></li>
                    <li>{{projekt.description}}</li>
                    <li>{{projekt.github}}</li>
                </ul>
                </div>
            </div>
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

<style scoped>
    #home{
    margin: 0px;
    background-color: white;
    text-align: center;
    }
    .container{
    }
    #test-row{
      }
    .jumbotron{
    background-color: white;
}
</style>