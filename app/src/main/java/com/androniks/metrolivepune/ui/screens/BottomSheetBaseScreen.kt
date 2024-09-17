package com.androniks.metrolivepune.ui.screens

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.BottomSheetScaffold
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.SheetValue
import androidx.compose.material3.rememberBottomSheetScaffoldState
import androidx.compose.material3.rememberStandardBottomSheetState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import com.androniks.metrolivepune.ui.navigation.Screen
import com.androniks.metrolivepune.ui.viewmodel.AppViewModel
import kotlinx.coroutines.launch

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun BottomSheetBaseScreen(viewModel: AppViewModel, navController: NavHostController) {
    val coroutineScope = rememberCoroutineScope()
    val backStackEntry by navController.currentBackStackEntryAsState()
    val currentRoute = backStackEntry?.destination?.route
    val bottomSheetScaffoldState = rememberBottomSheetScaffoldState(
        bottomSheetState = rememberStandardBottomSheetState(initialValue = SheetValue.PartiallyExpanded)
    )
    BottomSheetScaffold(
        scaffoldState = bottomSheetScaffoldState,
        sheetContent = {
            NavHost(navController = navController, startDestination = Screen.Routes.route) {
                val modifier = Modifier
                    .fillMaxWidth()
                    .padding(start = 16.dp, end = 16.dp, bottom = 120.dp)
                composable(Screen.Routes.route) { RoutesScreen(modifier) }
                composable(Screen.LiveMetro.route) { LiveMetroScreen(modifier) }
                composable(Screen.Settings.route) { ShareLocScreen(modifier) }
            }
        },
        sheetPeekHeight = 300.dp,
        modifier = Modifier
            .fillMaxSize()
    ) {
        GoogleMapScreen(
            modifier = Modifier.fillMaxSize(),
        )
    }
    LaunchedEffect(currentRoute) {
        coroutineScope.launch {
            if (currentRoute == Screen.LiveMetro.route) {
                bottomSheetScaffoldState.bottomSheetState.partialExpand()
            }
        }
    }
}