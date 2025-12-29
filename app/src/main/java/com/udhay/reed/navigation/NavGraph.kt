package com.udhay.reed.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.udhay.reed.ui.features.auth.LoginScreen
import com.udhay.reed.ui.features.auth.SignupScreen
import com.udhay.reed.ui.features.home.HomeScreen
import com.udhay.reed.ui.features.onboarding.OnboardingScreen

@Composable
fun NavGraph(
    navController: NavHostController, startDestination: String = Routes.Onboarding.route
) {

    NavHost(
        navController = navController,
        startDestination = startDestination,
    ){
        composable(route = Routes.Onboarding.route) {
            OnboardingScreen(
                onNavigateToLogin = {
                    navController.navigate(Routes.Login.route)
                }
            )
        }

        composable(route = Routes.Login.route) {
            LoginScreen(
                onLoginSuccess = {
                    navController.navigate(Routes.Home.route) {
                        popUpTo(Routes.Login.route) { inclusive = true }
                    }
                },
                onNavigateToSignup = {
                    navController.navigate(Routes.Signup.route)
                }
            )
        }

        composable(route = Routes.Login.route) {
            SignupScreen(
                onSignupSuccess = {
                    navController.navigate(Routes.Home.route) {
                        popUpTo(Routes.Login.route) { inclusive = true }
                    }
                },
                onNavigateToLogin = {
                    navController.navigate(Routes.Login.route)
                }
            )
        }

        composable(route = Routes.Home.route) {
            HomeScreen()
        }
    }
}
