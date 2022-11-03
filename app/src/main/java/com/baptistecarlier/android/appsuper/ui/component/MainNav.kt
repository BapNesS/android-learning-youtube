package com.baptistecarlier.android.appsuper.ui.component

import android.util.Log
import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.baptistecarlier.android.appsuper.ui.navigation.Detail
import com.baptistecarlier.android.appsuper.ui.navigation.Home
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject


@HiltViewModel
class DetailVM @Inject constructor(savedStateHandle: SavedStateHandle) : ViewModel() {
    init {
        val id = savedStateHandle.get<Int>("id")
        Log.d("BDM", "VM id : $id")
    }
}

@Composable
fun MainNav() {
    val navController = rememberNavController()
    NavHost(
        navController = navController,
        startDestination = Home.route
    ) {
        composable(Home.route) {
            HomeView {
                navController.navigate(Detail.giveId("43"))
            }
        }
        composable(route = Detail.route,
            arguments = listOf(navArgument("id") { type = NavType.IntType })) { backStackEntry ->
            val id : Int = backStackEntry.arguments?.getInt("id") ?: 10

            val viewModel : DetailVM = hiltViewModel()
            DetailView(id) { navController.popBackStack() }
        }
    }
}
