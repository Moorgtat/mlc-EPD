<template>
    <div class="container">
        <h1 class="display-4">UserBoard</h1>
    </div>
</template>

<script>
    import UserService from '../services/user.service'

    export default {
        name: 'user',
        data() {
            return {
                content: ''
            }
        },
        methods:{
        },
        mounted() {
            UserService.getUserBoard().then(
                response => {
                    this.content = response.data
                },
                error => {
                    this.content = error.response.data.message
                }
            )
        }
    }
</script>

<style>
    #image-test{
        margin-top: 10%;
        margin-bottom: 40px;
    }
    img{
        height: 360px;
        width: 440px;
    }
</style>