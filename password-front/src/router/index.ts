import { createRouter, createWebHistory, RouteRecordRaw } from 'vue-router'

const routes: Array<RouteRecordRaw> = [
  {
    path: '/',
    name: 'home',
    component: () => import("../views/HomeView.vue")
  },
  {
    path: '/senhas',
    name: 'password',
    component: () => import("../views/Password/PasswordListView.vue")
  },
  {
    path: '/senhas/:id',
    name: 'password-detail',
    props: (router) => ({ id: router.params.id }),
    component: () => import("../views/Password/PasswordDetailView.vue")
  },
  {
    path: '/senhas/editar/:id',
    name: 'password-edit',
    props: (router) => ({ id: router.params.id }),
    component: () => import("../views/Password/PasswordUpdateView.vue")
  },
  {
    path: '/senhas/cadastrar',
    name: 'password-register',
    component: () => import("../views/Password/PasswordInsertView.vue")
  },
  {
    path: '/usuarios/login',
    name: 'user-login',
    component: () => import("../views/Login/LoginView.vue")
  },
  {
    path: '/usuarios/registrar',
    name: 'user-register',
    component: () => import("../views/User/UserInsertView.vue")
  },
  {
    path: '/usuarios/editar-senha',
    name: 'user-update-pw',
    component: () => import("../views/User/UserUpdatePasswordView.vue")
  },
]

const router = createRouter({
  history: createWebHistory(process.env.BASE_URL),
  routes
})

export default router
