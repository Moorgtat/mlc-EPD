<template>
    <div class="container">
        <header class="jumbotron">
            <h3>{{content}}</h3>
            <br>
            <p>Lorem ipsum dolor sit amet, consectetur adipisicing elit. A blanditiis eligendi modi quia rerum. Fugit natus provident, repellat soluta suscipit voluptates voluptatum? Error iure laboriosam modi nemo, omnis recusandae voluptatibus!</p>
        </header>
    </div>
</template>

<script>
    import UserService from '../services/user.service';

    export default {
        name: 'user',
        data() {
            return {
                content: ''
            };
        },
        mounted() {
            UserService.getUserBoard().then(
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