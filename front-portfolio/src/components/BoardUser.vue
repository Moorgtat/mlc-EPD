<template>
    <div class="container">
        <h1 class="display-4">Goodies</h1>
        <p>Développer des jeux en JavaScript comme Arkanoid ou d'autres jeux de plateforme puis
        donner un accès à Goodies aux users.</p>
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
    img{
        height: 360px;
        width: 440px;
    }
</style>