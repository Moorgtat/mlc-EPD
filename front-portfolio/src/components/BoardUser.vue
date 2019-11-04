<template>
    <div class="container">
        <div id="image-test">
            <div class="row">
             <div class="col-12 text-center">
                 <img :src="content" />
             </div>
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
                content: '',
                link: "http://localhost:8080/img/image_1.0da253b4.jpg"
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