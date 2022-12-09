package com.baptistecarlier.android.appsuper.ui.component

import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.baptistecarlier.android.appsuper.repository.libs
import com.baptistecarlier.android.appsuper.ui.component.library.LibraryView
import com.baptistecarlier.android.appsuper.ui.component.librarydetails.LibraryDetailsScreen
import com.baptistecarlier.android.appsuper.ui.component.main.MainView
import com.baptistecarlier.android.appsuper.ui.component.settings.SettingsScreen
import com.baptistecarlier.android.appsuper.ui.component.weight.WeightScreen
import com.baptistecarlier.android.appsuper.ui.navigation.Library
import com.baptistecarlier.android.appsuper.ui.navigation.LibraryDetails
import com.baptistecarlier.android.appsuper.ui.navigation.Main
import com.baptistecarlier.android.appsuper.ui.navigation.Screen
import com.baptistecarlier.android.appsuper.ui.navigation.Settings
import com.baptistecarlier.android.appsuper.ui.navigation.Weight


@Composable
fun MainNav() {
    val navController = rememberNavController()
    NavHost(
        navController = navController,
        startDestination = Main.route
    ) {
        val navigate: (Screen) -> Unit = { navController.navigate(it.route) }

        composable(Main.route) {
            MainView(
                modifier = Modifier.padding(32.dp),
                navigate = navigate
            )
        }
        composable(Weight.route) {
            WeightScreen(
                modifier = Modifier.padding(32.dp)
            )
        }
        composable(Settings.route) {
            SettingsScreen(
                modifier = Modifier.padding(32.dp),
                navigate = navigate)
        }
        composable(Library.route) {
            LibraryView(libs) { library ->
                val position = libs.indexOf(library)
                navController.navigate(LibraryDetails.giveId(position.toString()))
            }
        }
        composable(
            route = LibraryDetails.route,
            arguments = listOf(navArgument("id") { defaultValue = 0 })
        ) {
            LibraryDetailsScreen(
                modifier = Modifier.padding(32.dp)
            )
        }

    }
}

