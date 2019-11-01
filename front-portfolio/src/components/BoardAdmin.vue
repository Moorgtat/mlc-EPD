<template>
    <div class="container">
        <header class="jumbotron">
            <h1 class="display-4">{{content}}</h1>
        </header>
    </div>
</template>

<script>
    import UserService from '../services/user.service';

    export default {
        name: "admin",
        data() {
            return {
                content: ''
            };
        },
        mounted() {
            UserService.getAdminBoard().then(
                response => {
                    this.content = response.data;
                },
                error => {
                    this.content = error.response.data.message;
                }
            );
        }
    };
</script>

<style scoped>

</style>