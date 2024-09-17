package com.androniks.metrolivepune.ui.navigation

import androidx.annotation.DrawableRes
import com.androniks.metrolivepune.R

sealed class Screen(val route: String, @DrawableRes val iconId: Int) {
    data object Routes : Screen("routes", R.drawable.twotone_directions_railway_24)
    data object LiveMetro : Screen("live_metro", R.drawable.twotone_tram_24)
    data object Settings : Screen("settings", R.drawable.twotone_emergency_share_24)
}