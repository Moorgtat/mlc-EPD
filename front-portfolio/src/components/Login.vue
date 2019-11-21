<template>
    <div class="col-md-12">
        <div class="card card-container">
            <form name="form" @submit.prevent="handleLogin">
                <div class="form-group">
                    <label>Nom d'utilisateur :
                    <input
                            type="text"
                            class="form-control"
                            name="username"
                            v-model="user.username"
                    />
                    </label>
                </div>
                <div class="form-group">
                    <label>Mot de passe :
                    <input
                            type="password"
                            class="form-control"
                            name="password"
                            v-model="user.password"
                    />
                    </label>
                </div>
            <button class="btn btn-dark btn-block" type="submit" @click="closeModal()">Se connecter</button>
            </form>
        </div>
    </div>
</template>

<script>
    import User from '../models/user'

    export default {
        name: 'login',
        computed: {
            loggedIn() {
                return this.$store.state.auth.status.loggedIn
            }
        },
        data() {
            return {
                user: new User('', ''),
                loading: false,
                message: ''
            };
        },
        mounted() {
            if (this.loggedIn) {
                this.$router.push('/profile')
            }
        },
        methods: {
            closeModal(){
               return this.$emit('close')
            },
            handleLogin() {
                if (this.user.username && this.user.password) {
                    this.$store.dispatch('auth/login', this.user).then(
                        () => {
                            this.$router.push('/profile')
                        },
                        error => {
                            this.loading = false;
                            this.message = error.message
                        }
                    )
                }
            }
        }
    }
</script>

<style scoped>
    label {
        font-family: "Comic Sans MS", serif;
        display: block;
        margin-top: 10px;
    }

    .card-container.card {
        max-width: 350px !important;
        padding: 40px 40px;
    }

    .card {
        color: black;
        background-color: white;
        padding: 20px 25px 30px;
        margin: 50px auto 25px;
        border-radius: 12px;
    }

</style>