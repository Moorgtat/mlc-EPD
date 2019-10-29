import Vue from 'vue'
import Router from 'vue-router'
import Home from './components/Home.vue'
import Login from './components/Login.vue'
import Register from './components/Register.vue'

Vue.use(Router)

export const router = new Router({
    mode: 'history',
    routes: [
        {
            path: '/',
            name: 'home',
            component: Home
        },
        {
            path: '/home',
            component: Home
        },
        {
            path: '/login',
            component: Login
        },
        {
            path: '/register',
            component: Register
        },
        {
            path: '/profile',
            name: 'profile',
            // lazy-loaded
            component: () => import('./components/Profile.vue')
        },
        {
            path: '/admin',
            name: 'admin',
            // lazy-loaded
            component: () => import('./components/BoardAdmin.vue')
        },
        {
            path: '/mod',
            name: 'moderator',
            // lazy-loaded
            component: () => import('./components/BoardModerator.vue')
        },
        {
            path: '/user',
            name: 'user',
            // lazy-loaded
            component: () => import('./components/BoardUser.vue')
        }
    ]
})

router.beforeEach((to, from, next) => {
    const publicPages = ['/login', '/home','/register'];
    const authRequired = !publicPages.includes(to.path);
    const loggedIn = localStorage.getItem('user');

    // try to access a restricted page + not logged in
    if (authRequired && !loggedIn) {
        return next('/home');
    }

    next();
});