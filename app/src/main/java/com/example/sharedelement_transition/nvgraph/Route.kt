package com.example.sharedelement_transition.nvgraph

import kotlinx.serialization.Serializable

@Serializable
sealed class Route {

    @Serializable
    data object HomeScreen : Route()

    @Serializable
    data class DetailScreen(
        val resId: Int,
        val text: String
    ) : Route()
}