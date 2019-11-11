<template>
    <div id="admin-board">

        <div id="titre_adminboard" class="col-12 text-center">
            <h1 class="display-4">{{content}}</h1>
            <div id="skillboard">
            <div id="myskills" v-for="skill in skills" :key="skill.id">
                <p> {{skill.titre}} </p>
                <p> {{skill.description}} </p>
            </div>
            </div>
        </div>

    </div>
</template>

<script>
    import UserService from '../services/user.service'

    export default {
        name: "admin",
        data() {
            return {
                skills: [],
                content: ''
            }
        },
        mounted() {
            UserService.getAdminBoard().then(
                response => {
                    this.content = response.data;
                },
                error => {
                    this.content = error.response.data.message;
                }
            ),
                UserService.getSkills().then(
                    response => {
                        this.skills = response.data;
                    },
                    error => {
                        this.skills = error.response.data.message;
                    }
                )
        }
    }
</script>

<style>
#admin-board{
    margin-top: 10%;
}
#titre_adminboard{
    margin-bottom: 60px;
}
</style>