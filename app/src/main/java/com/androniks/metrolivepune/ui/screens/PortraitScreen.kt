package com.androniks.metrolivepune.ui.screens

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.heightIn
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.compose.rememberNavController
import com.androniks.metrolivepune.ui.common.AppNavigationBar
import com.androniks.metrolivepune.ui.viewmodel.AppViewModel

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun PortraitScreen(viewModel: AppViewModel) {
    val navController = rememberNavController()
    Scaffold(
        bottomBar = {
            AppNavigationBar(
                Modifier.heightIn(min = 100.dp, max = 120.dp),
                navController = navController,
                viewModel = viewModel
            )
        }
    ) { _ ->
        BottomSheetBaseScreen(viewModel, navController)
    }
}