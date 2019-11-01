<template>
    <div class="container">
        <header class="jumbotron">
            <h1 class="display-4">{{content}}</h1>
        </header>
        <div>
            <img src="../static/image_1.jpg" />
            <p>{{getImage()}}</p>
            <img :src="getImage()"/>
            <p>{{link}}</p>
            <img :src="link" />
            <img src="../static/image_2.jpg"/>
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
          getImage(){
             let path = "http://localhost:8080/img/image_1.0da253b4.jpg"
              return path
          }
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