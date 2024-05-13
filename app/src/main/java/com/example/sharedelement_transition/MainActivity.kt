package com.example.sharedelement_transition

import android.graphics.Color
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.SystemBarStyle
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.animation.ExperimentalSharedTransitionApi
import androidx.compose.animation.SharedTransitionLayout
import androidx.compose.animation.SharedTransitionScope
import androidx.navigation.compose.rememberNavController
import com.example.sharedelement_transition.nvgraph.NavGraph
import com.example.sharedelement_transition.ui.theme.SharedElementTransitionTheme


class MainActivity : ComponentActivity() {


    @OptIn(ExperimentalSharedTransitionApi::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        enableEdgeToEdge(
            statusBarStyle = SystemBarStyle.light(
                Color.TRANSPARENT,
                Color.TRANSPARENT
            )
        )
        super.onCreate(savedInstanceState)
        setContent {
            //Allows us the access to a special modifier
            SharedElementTransitionTheme {
                SharedTransitionLayout {
                    val navController = rememberNavController()
                    NavGraph(navController = navController)
                }
            }
        }
    }

}