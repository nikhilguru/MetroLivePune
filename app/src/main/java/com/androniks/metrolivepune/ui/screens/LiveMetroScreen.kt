package com.androniks.metrolivepune.ui.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.androniks.metrolivepune.R
import com.androniks.metrolivepune.ui.common.ExpandableTextWithIcon
import com.androniks.metrolivepune.ui.common.Label

@Composable
fun LiveMetroScreen(modifier: Modifier) {
    Column(
        modifier = modifier
    ) {
        OutlinedButton(
            modifier = Modifier
                .align(Alignment.CenterHorizontally),
            onClick = {}) {
            Label(
                text = stringResource(R.string.get_location),
                style = MaterialTheme.typography.labelMedium
            )
        }
        Spacer(modifier = Modifier.height(16.dp))
        ExpandableTextWithIcon(
            text = stringResource(R.string.live_loc_disclaimer),
        )
        Spacer(modifier = Modifier.height(8.dp))
    }
}