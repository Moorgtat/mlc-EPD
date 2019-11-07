<template>
    <div id="admin-board">

        <div id="titreBoard" class="col-12 text-center">
            <h1 class="display-4">{{content}}</h1>
        </div>

        <div id="skillsBoard">
            <div class="is-3">
            test vuex
            </div>

            <div>
            test vuex
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
            )
        }
    }
</script>

<style>
#admin-board{
    margin-top: 5%;
}
#titreBoard{
    margin-bottom: 60px;
}
</style>