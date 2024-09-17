package com.androniks.metrolivepune.ui.screens

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.BottomSheetScaffold
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FilterChip
import androidx.compose.material3.Icon
import androidx.compose.material3.ListItem
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.rememberBottomSheetScaffoldState
import androidx.compose.material3.rememberStandardBottomSheetState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.androniks.metrolivepune.R
import com.androniks.metrolivepune.ui.common.AppNavigationBar
import com.androniks.metrolivepune.ui.common.Label

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun PortraitScreen() {
    Scaffold(
        bottomBar = {
            AppNavigationBar(Modifier.heightIn(min = 100.dp, max = 120.dp))
        }
    ) { _ ->
        val bottomSheetScaffoldState = rememberBottomSheetScaffoldState(
            bottomSheetState = rememberStandardBottomSheetState()
        )
        BottomSheetScaffold(
            scaffoldState = bottomSheetScaffoldState,
            sheetContent = {
                // Bottom sheet content
                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(start = 16.dp, end = 16.dp, bottom = 120.dp)
                ) {
                    var selectedOption by remember { mutableStateOf<String?>("Aqua Line") }
                    Label(
                        text = stringResource(R.string.select_route),
                        style = MaterialTheme.typography.titleMedium
                    )
                    Spacer(modifier = Modifier.height(8.dp))

                    val options = listOf("Aqua Line", "Purple Line")
                    LazyRow {
                        items(options) { option ->
                            FilterChip(
                                selected = selectedOption == option,
                                onClick = { selectedOption = option },
                                label = {
                                    Label(
                                        text = option,
                                        style = MaterialTheme.typography.bodyMedium
                                    )
                                },
                                modifier = Modifier.padding(end = 8.dp),
                                border = BorderStroke(
                                    width = 1.dp,
                                    color = if (selectedOption == option) Color.Transparent else MaterialTheme.colorScheme.outlineVariant
                                ),
                                shape = RoundedCornerShape(16.dp)
                            )
                        }
                    }
                    Spacer(modifier = Modifier.height(8.dp))
                    LazyColumn {
                        items(20) {
                            ListItem(
                                modifier = Modifier.height(height = 60.dp),
                                headlineContent = {
                                    Label(
                                        text = "Station Name $it",
                                        style = MaterialTheme.typography.bodyMedium
                                    )
                                },
                                supportingContent = {
                                    Label(
                                        text = "Station code: ${
                                            it.toString().repeat(4)
                                        }",
                                        style = MaterialTheme.typography.bodySmall
                                    )
                                },
                                trailingContent = {
                                    Icon(
                                        painter = painterResource(R.drawable.twotone_train_24),
                                        contentDescription = "station icon",
                                        tint = MaterialTheme.colorScheme.primary
                                    )
                                }
                            )
                        }

                    }
                    Spacer(modifier = Modifier.height(8.dp))
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
    }
}