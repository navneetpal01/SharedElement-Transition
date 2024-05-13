package com.example.sharedelement_transition.nvgraph

import androidx.compose.animation.ExperimentalSharedTransitionApi
import androidx.compose.animation.SharedTransitionScope
import androidx.compose.runtime.Composable
import androidx.navigation.NavDestination
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import androidx.navigation.toRoute
import com.example.sharedelement_transition.DetailScreen
import com.example.sharedelement_transition.ListScreen


@OptIn(ExperimentalSharedTransitionApi::class)
@Composable
fun SharedTransitionScope.NavGraph(
    navController : NavHostController = rememberNavController(),
    startDestination: Route = Route.HomeScreen
){
    NavHost(
        navController = navController,
        startDestination = startDestination
    ){
        composable<Route.HomeScreen> {
            ListScreen(
                onItemClick = { resId , text ->
                    navController.navigate(Route.DetailScreen(resId,text))
                },
                animatedVisibilityScope = this
            )
        }
        composable<Route.DetailScreen> {backStackEntry->
            val profile = backStackEntry.toRoute<Route.DetailScreen>()
            DetailScreen(
                resId = profile.resId,
                text = profile.text,
                animatedVisibilityScope = this
            )
        }
    }
}

