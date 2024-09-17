/*


package com.androniks.metrolivepune.ui.screens

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.androniks.metrolivepune.ui.common.AppNavigationBar
import com.androniks.metrolivepune.ui.navigation.Screen
import com.androniks.metrolivepune.ui.viewmodel.AppViewModel

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun LandscapeScreen(viewModel: AppViewModel) {
    Row(modifier = Modifier.fillMaxSize()) {
        val navController = rememberNavController()
        Scaffold(
            modifier = Modifier
                .weight(2f),
            bottomBar = {
                AppNavigationBar(
                    Modifier.heightIn(min = 100.dp, max = 120.dp),
                    navController = navController,
                    viewModel = viewModel
                )
            }
        ) { _ ->
            NavHost(
                navController = navController,
                startDestination = Screen.Routes.route
            ) {
                val modifier = Modifier
                    .padding(
                        start = 16.dp,
                        top = 36.dp,
                        end = 16.dp,
                        bottom = 120.dp
                    )
                    .fillMaxHeight()
                composable(Screen.Routes.route) { RoutesScreen(modifier) }
                composable(Screen.LiveMetro.route) { LiveMetroScreen(modifier) }
                composable(Screen.Settings.route) { ShareLocScreen(modifier) }
            }

        }

        GoogleMapScreen(Modifier.weight(3f))

    }

}*/
