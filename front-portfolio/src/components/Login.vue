<template>
    <div class="col-md-12">
        <div class="card card-container">
            <form name="form" @submit.prevent="handleLogin">
                <label>Username</label>
                <div class="form-group">
                    <input
                            type="text"
                            class="form-control"
                            name="username"
                            v-model="user.username"
                    />
                </div>
                <label>Password</label>
                <div class="form-group">
                    <input
                            type="password"
                            class="form-control"
                            name="password"
                            v-model="user.password"
                    />
                </div>
            <button class="btn btn-secondary btn-block" type="submit" @click="closeModal()">Login</button>
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
        display: block;
        margin-top: 10px;
    }

    .card-container.card {
        max-width: 350px !important;
        padding: 40px 40px;
    }

    .card {
        background-color: #f7f7f7;
        padding: 20px 25px 30px;
        margin: 0 auto 25px;
        margin-top: 50px;
        border-radius: 12px;
    }

</style>