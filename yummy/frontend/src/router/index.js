import Vue from 'vue'
import Router from 'vue-router'
import index from '@/pages/index'
import login from '@/pages/login'
import memberInfo from '@/pages/memberInfo'
import memberAddress from '@/pages/memberAddress'
import register from '@/pages/register'
import selectAddress from '@/pages/selectAddress'
import foodList from '@/pages/foodList'
import restInfo from '@/pages/restInfo'
import basket from '@/pages/basket'
import order from '@/pages/order'
import notPaidOrder from '@/pages/notPaidOrder'
import paidOrder from '@/pages/paidOrder'
import invalidOrder from '@/pages/invalidOrder'
import memberStatistics from '@/pages/memberStatistics'
import restLogin from '@/pages/restLogin'
import restPage from '@/pages/restPage'
import launchNewFood from '@/pages/launchNewFood'
import launchSetMeal from '@/pages/launchSetMeal'
import launchDiscount from '@/pages/launchDiscount'
import expressRecord from '@/pages/expressRecord'
import restStatistics from '@/pages/restStatistics'
import adminLogin from '@/pages/adminLogin'
import adminPage from '@/pages/adminPage'
import approveModifyInfo from '@/pages/approveModifyInfo'
import adminStatistics from '@/pages/adminStatistics'
import welcome from '@/pages/welcome'
import nearbyRestaurant from '@/pages/nearbyRestaurant'
import memberRegister from '@/pages/memberRegister'
import restaurantRegister from '@/pages/restaurantRegister'
import loadingPage from '@/pages/loadingPage'

Vue.use(Router);

export default new Router({
  routes: [
    {
      path: '/',
      name: 'welcome',
      component: welcome
    },
    {
      path: '/nearbyRestaurant',
      name: 'nearbyRestaurant',
      component: nearbyRestaurant
    },
    {
      path: '/login',
      name: 'login',
      component: login
    },
    {
      path: '/memberAddress',
      name: 'memberAddress',
      component: memberAddress
    },
    {
      path: '/memberInfo',
      name: 'memberInfo',
      component: memberInfo
    },
    {
      path: '/restLogin',
      name: 'restLogin',
      component: restLogin
    },
    {
      path: '/memberRegister',
      name: 'memberRegister',
      component: memberRegister
    },
    {
      path: '/restaurantRegister',
      name: 'restaurantRegister',
      component: restaurantRegister
    },
    {
      path: '/register',
      name: 'register',
      component: register
    },
    {
      path: '/selectAddress',
      name: 'selectAddress',
      component: selectAddress
    },
    {
      path: '/foodList',
      name: 'foodList',
      component: foodList
    },
    {
      path: '/restInfo',
      name: 'restInfo',
      component: restInfo
    },
    {
      path: '/basket',
      name: 'basket',
      component: basket
    },
    {
      path: '/order',
      name: 'order',
      component: order
    },
    {
      path: '/notPaidOrder',
      name: 'notPaidOrder',
      component: notPaidOrder
    },
    {
      path: '/paidOrder',
      name: 'paidOrder',
      component: paidOrder
    },
    {
      path: '/invalidOrder',
      name: 'invalidOrder',
      component: invalidOrder
    },
    {
      path: '/memberStatistics',
      name: 'memberStatistics',
      component: memberStatistics
    },
    {
      path: '/restPage',
      name: 'restPage',
      component: restPage
    },
    {
      path: '/launchNewFood',
      name: 'launchNewFood',
      component: launchNewFood
    },
    {
      path: '/launchSetMeal',
      name: 'launchSetMeal',
      component: launchSetMeal
    },
    {
      path: '/launchDiscount',
      name: 'launchDiscount',
      component: launchDiscount
    },
    {
      path: '/expressRecord',
      name: 'expressRecord',
      component: expressRecord
    },
    {
      path: '/restStatistics',
      name: 'restStatistics',
      component: restStatistics
    },
    {
      path: '/adminLogin',
      name: 'adminLogin',
      component: adminLogin
    },
    {
      path: '/adminPage',
      name: 'adminPage',
      component: adminPage
    },
    {
      path: '/approveModifyInfo',
      name: 'approveModifyInfo',
      component: approveModifyInfo
    },
    {
      path: '/adminStatistics',
      name: 'adminStatistics',
      component: adminStatistics
    },
    {
      path: '/loadingPage',
      name: 'loadingPage',
      component: loadingPage
    },
  ]
})
