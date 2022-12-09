package com.baptistecarlier.android.appsuper.ui.navigation

sealed class Screen(val route: String)

/**
 * Navigation
 */
object Main: Screen("/main")
object Weight: Screen("/weight")
object Settings: Screen("/settings")
object Library: Screen("/library")
object LibraryDetails: Screen("/library/{id}") {
    fun giveId(id: String) = "/library/${id}"
}
