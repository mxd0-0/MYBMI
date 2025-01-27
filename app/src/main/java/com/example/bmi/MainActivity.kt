package com.example.bmi

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.animation.AnimatedContentTransitionScope
import androidx.compose.animation.core.tween
import androidx.compose.animation.fadeIn
import androidx.compose.foundation.layout.safeContentPadding
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.bmi.navigation.BmiScreens
import com.example.bmi.presentation.home.HomeScreen
import com.example.bmi.presentation.onboarding.OnBoardingScreen
import com.example.bmi.ui.theme.BMITheme

class MainActivity : ComponentActivity() {
    @SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
    override fun onCreate(savedInstanceState: Bundle?) {
        enableEdgeToEdge()
        super.onCreate(savedInstanceState)
        setContent {
            BMITheme {

                // /**
                val navController = rememberNavController()
                NavHost(
                    navController = navController,
                    startDestination = BmiScreens.OnBoarding.name,
                    modifier = Modifier
                ) {
                    composable(
                        route = BmiScreens.OnBoarding.name
                    ) {
                        OnBoardingScreen(
                            {
                                navController.navigate(BmiScreens.Home.name) {

                                    popUpTo(BmiScreens.OnBoarding.name) {
                                        inclusive = true
                                    }
                                }
                            }, modifier = Modifier
                                .safeContentPadding()
                        )
                    }
                    composable(route = BmiScreens.Home.name, enterTransition = {
                        slideIntoContainer(
                            AnimatedContentTransitionScope.SlideDirection.Left,
                            animationSpec = tween(700)
                        ) + fadeIn(animationSpec = tween(700))
                    }) {//*/
                        HomeScreen(
                            modifier = Modifier
                                .safeContentPadding()
                        )
                    }
                }
            }
        }
    }
}
