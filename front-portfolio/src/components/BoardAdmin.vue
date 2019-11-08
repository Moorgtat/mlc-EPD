<template>
    <div id="admin-board">

        <div id="titre_adminboard" class="col-12 text-center">
            <h1 class="display-4">{{content}}</h1>
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
    margin-top: 10%;
}
#titre_adminboard{
    margin-bottom: 60px;
}
</style>