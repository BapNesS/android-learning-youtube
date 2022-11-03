package com.baptistecarlier.android.appsuper.ui.navigation

sealed class Screen(val route: String)
object Home: Screen("/home")
object Detail: Screen("/detail/{id}") {
    fun giveId(id: String) = "/detail/${id}"
}