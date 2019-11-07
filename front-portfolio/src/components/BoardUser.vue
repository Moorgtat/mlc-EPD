<template>
    <div class="container">
        <div id="image-test">
            <div class="row">
             <div class="col-12 text-center">
                 <img :src="content" />
             </div>
            </div>
            <div class="text-center">
            <a href="SPRING Boot_Messaging.pdf" target=_blank>mon cv </a>
            </div>
        </div>
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