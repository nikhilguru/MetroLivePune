package com.androniks.metrolivepune

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.core.view.WindowCompat
import com.androniks.metrolivepune.ui.screens.PortraitScreen
import com.androniks.metrolivepune.ui.theme.MetroLivePuneTheme
import com.androniks.metrolivepune.ui.viewmodel.AppViewModel

class MainActivity : ComponentActivity() {
    private val viewModel: AppViewModel by viewModels()

    @SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        WindowCompat.setDecorFitsSystemWindows(window, false)
        enableEdgeToEdge()
        setContent {
            MetroLivePuneTheme {
                PortraitScreen(viewModel)
            }
        }
    }
}

/*@Composable
fun OrientationAwareScreen(viewModel: AppViewModel) {
    val configuration = LocalConfiguration.current
    val isPortrait =
        configuration.orientation == android.content.res.Configuration.ORIENTATION_PORTRAIT
    if (isPortrait) {
        PortraitScreen(viewModel)
    } else {
        LandscapeScreen(viewModel)
    }
}*/

