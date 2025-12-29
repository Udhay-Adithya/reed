package com.udhay.reed.navigation

sealed class Routes(val route: String) {

    object Onboarding : Routes("onboarding")
    object Login : Routes("login")
    object Signup : Routes("signup")
    object Home : Routes("home")
}