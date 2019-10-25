<template>
    <div>
  <p> login a mettre en place</p>
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
        handleLogin() {
            this.loading = true;
            this.$validator.validateAll()

            if (this.errors.any()) {
                this.loading = false;
                return;
            }

            if (this.user.username && this.user.password) {
                this.$store.dispatch('auth/login', this.user).then(
                    () => {
                        this.$router.push('/profile')
                    },
                    error => {
                        this.loading = false
                        this.message = error.message
                    }
                )
            }
         }
      }
    }
</script>

<style scoped>

</style>