package com.androniks.metrolivepune.ui.screens

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.ListItem
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Switch
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.androniks.metrolivepune.R
import com.androniks.metrolivepune.ui.common.ExpandableTextWithIcon
import com.androniks.metrolivepune.ui.common.Label

@Composable
fun ShareLocScreen(modifier: Modifier) {
    Column(
        modifier = modifier
    ) {
        var isChecked by remember { mutableStateOf(false) }

        var showDialog by remember { mutableStateOf(false) }
        if (showDialog) {
            AlertDialog(
                onDismissRequest = { showDialog = false },  // Dismiss when clicked outside
                title = {
                    Text(text = stringResource(R.string.loc_alert))
                },
                text = {
                    Text(stringResource(R.string.loc_confirm))
                },
                confirmButton = {
                    Button(
                        onClick = {
                            showDialog = false
                            isChecked = !isChecked
                        }
                    ) {
                        Text(stringResource(R.string.yes))
                    }
                },
                dismissButton = {
                    TextButton(
                        onClick = { showDialog = false }
                    ) {
                        Text(stringResource(R.string.no))
                    }
                }
            )
        }

        ListItem(
            modifier = Modifier
                .clickable {
                    showDialog = true
                },
            headlineContent = {
                Text(
                    text = stringResource(R.string.only_commuter),
                    style = MaterialTheme.typography.bodySmall.copy(fontSize = 12.sp),
                    color = MaterialTheme.colorScheme.error
                )
            },
            supportingContent = {
                Text(
                    text = stringResource(R.string.help_live_loc),
                    style = MaterialTheme.typography.bodySmall.copy(fontSize = 12.sp),
                    color = MaterialTheme.colorScheme.primary
                )
            },
            trailingContent = {
                Switch(
                    checked = isChecked,
                    onCheckedChange = null,
                )
            },
            overlineContent = {
                Label(
                    text = stringResource(R.string.share_live_loc),
                    style = MaterialTheme.typography.bodyLarge
                )
            }
        )

        ExpandableTextWithIcon(
            text = stringResource(R.string.disclaimer_text),
        )
        Spacer(modifier = Modifier.height(8.dp))
    }
}