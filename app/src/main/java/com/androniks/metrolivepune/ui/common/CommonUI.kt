package com.androniks.metrolivepune.ui.common

import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import com.androniks.metrolivepune.R
import com.androniks.metrolivepune.ui.theme.MetroLivePuneTheme

@Composable
fun Label(modifier: Modifier = Modifier, text: String, style: TextStyle) {
    MetroLivePuneTheme {
        Text(
            modifier = modifier,
            text = text,
            style = style,
            color = MaterialTheme.colorScheme.onSurface,
        )
    }
}

@Composable
fun AppNavigationBar(modifier: Modifier) {
    val routes = stringResource(R.string.routes)
    val liveMetro = stringResource(R.string.live_metro)
    val settings = stringResource(R.string.settings)


    var selectedItem by remember { mutableStateOf(routes) }

    NavigationBar(modifier = modifier) {
        NavigationBarItem(
            icon = {
                Icon(
                    painter = painterResource(R.drawable.twotone_directions_railway_24),
                    contentDescription = routes,
                    tint = MaterialTheme.colorScheme.primary
                )
            },
            label = { Label(text = routes, style = MaterialTheme.typography.labelMedium) },
            selected = selectedItem == routes,
            onClick = { selectedItem = routes }
        )
        NavigationBarItem(
            icon = {
                Icon(
                    painter = painterResource(R.drawable.twotone_emergency_share_24),
                    contentDescription = liveMetro,
                    tint = MaterialTheme.colorScheme.primary
                )
            },
            label = { Label(text = liveMetro, style = MaterialTheme.typography.labelMedium) },
            selected = selectedItem == liveMetro,
            onClick = { selectedItem = liveMetro }
        )
        NavigationBarItem(
            icon = {
                Icon(
                    painter = painterResource(R.drawable.twotone_settings_24),
                    contentDescription = settings,
                    tint = MaterialTheme.colorScheme.primary
                )
            },
            label = { Label(text = settings, style = MaterialTheme.typography.labelMedium) },
            selected = selectedItem == settings,
            onClick = { selectedItem = settings }
        )
    }
}
