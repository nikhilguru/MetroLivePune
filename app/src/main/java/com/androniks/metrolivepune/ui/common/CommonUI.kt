package com.androniks.metrolivepune.ui.common

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
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
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState
import com.androniks.metrolivepune.R
import com.androniks.metrolivepune.ui.navigation.Screen
import com.androniks.metrolivepune.ui.theme.MetroLivePuneTheme
import com.androniks.metrolivepune.ui.viewmodel.AppViewModel

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
fun AppNavigationBar(
    modifier: Modifier,
    navController: NavHostController,
    viewModel: AppViewModel
) {
    val items = listOf(
        Screen.Routes,
        Screen.LiveMetro,
        Screen.Settings
    )
    val backStackEntry by navController.currentBackStackEntryAsState()
    val currentRoute = backStackEntry?.destination?.route

    NavigationBar(modifier = modifier) {
        items.forEach { screen ->
            NavigationBarItem(
                modifier = modifier,
                icon = {
                    Icon(
                        painterResource(screen.iconId),
                        contentDescription = getNavTitle(screen.route),
                        tint = MaterialTheme.colorScheme.primary
                    )
                },
                label = {
                    Label(
                        text = getNavTitle(screen.route),
                        style = MaterialTheme.typography.labelMedium
                    )
                },
                selected = currentRoute == screen.route,
                onClick = {

                    // Prevent multiple copies of the same destination when reselecting the same item
                    if (currentRoute != screen.route) {
                        navController.navigate(screen.route) {
                            // Pop up to the start of the graph to avoid building up a large stack
                            popUpTo(navController.graph.findStartDestination().id) {
                                saveState = true
                            }
                            // Avoid multiple copies of the same destination
                            launchSingleTop = true
                            // Restore state when reselecting a previously selected item
                            restoreState = true
                        }
                    }
                }
            )
        }
    }
}

@Composable
fun getNavTitle(currentRoute: String) = when (currentRoute) {
    Screen.Routes.route -> stringResource(R.string.routes)
    Screen.LiveMetro.route -> stringResource(R.string.live_metro)
    Screen.Settings.route -> stringResource(R.string.settings)
    else -> ""
}

@Composable
fun ExpandableTextWithIcon(text: String, minimizedMaxLines: Int = 2) {
    var expanded by remember { mutableStateOf(false) }

    Row(modifier = Modifier
        .padding(start = 16.dp)
        .fillMaxWidth()
        .clickable { expanded = !expanded }) {
        Text(
            text = buildAnnotatedString {
                pushStyle(SpanStyle(fontWeight = FontWeight.Bold))
                append(text.substring(0, 11))
                pop()
                append(text.substring(11)) // Regular end part
            },
            maxLines = if (expanded) Int.MAX_VALUE else minimizedMaxLines,
            style = MaterialTheme.typography.bodySmall
                .copy(textAlign = TextAlign.Justify),
            modifier = Modifier.weight(0.5F),
            color = MaterialTheme.colorScheme.secondary
        )

        Icon(
            painter = if (expanded)
                painterResource(R.drawable.twotone_expand_less_24)
            else painterResource(R.drawable.twotone_expand_more_24),
            contentDescription = null,
            tint = MaterialTheme.colorScheme.primary,
            modifier = Modifier.weight(0.05F)
        )
    }
}
