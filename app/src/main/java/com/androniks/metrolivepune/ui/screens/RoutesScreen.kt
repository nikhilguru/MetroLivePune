package com.androniks.metrolivepune.ui.screens

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.FilterChip
import androidx.compose.material3.Icon
import androidx.compose.material3.ListItem
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
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
import com.androniks.metrolivepune.ui.common.Label

@Composable
fun RoutesScreen(modifier: Modifier) {
    Column(
        modifier = modifier
    ) {
        var selectedOption by remember { mutableStateOf<String?>("Aqua Line") }
        Text(
            modifier = Modifier.padding(start = 16.dp),
            text = stringResource(R.string.select_route),
            style = MaterialTheme.typography.titleMedium,
            color = MaterialTheme.colorScheme.secondary
        )
        Spacer(modifier = Modifier.height(8.dp))

        val options = listOf("Aqua Line", "Purple Line")
        LazyRow(modifier = Modifier.padding(start = 16.dp)) {
            items(options) { option ->
                FilterChip(
                    selected = selectedOption == option,
                    onClick = { selectedOption = option },
                    label = {
                        Text(
                            text = option,
                            style = MaterialTheme.typography.bodyMedium,
                            color = MaterialTheme.colorScheme.secondary
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

}