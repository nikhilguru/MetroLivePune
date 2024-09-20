package com.androniks.metrolivepune.ui.screens

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import com.androniks.metrolivepune.R
import com.google.android.gms.maps.model.CameraPosition
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.MapStyleOptions
import com.google.maps.android.compose.GoogleMap
import com.google.maps.android.compose.MapProperties
import com.google.maps.android.compose.MapUiSettings
import com.google.maps.android.compose.Marker
import com.google.maps.android.compose.MarkerState
import com.google.maps.android.compose.rememberCameraPositionState

@Composable
fun GoogleMapScreen(modifier: Modifier = Modifier) {
    val puneLocation = LatLng(18.5204, 73.8567)
    val cameraPositionState = rememberCameraPositionState {
        position = CameraPosition.fromLatLngZoom(puneLocation, 12f)
    }
    val context = LocalContext.current
    val mapStyleOptions = if (isSystemInDarkTheme()) {
        MapStyleOptions.loadRawResourceStyle(context, R.raw.dark_map_style)
    } else {
        MapStyleOptions.loadRawResourceStyle(context, R.raw.light_map_style)
    }

    GoogleMap(
        modifier = modifier
            .fillMaxSize()
            .padding(),
        cameraPositionState = cameraPositionState,
        uiSettings = MapUiSettings(zoomControlsEnabled = false),
        properties = MapProperties(
            mapStyleOptions = mapStyleOptions
        )

    ) {
        Marker(
            state = MarkerState(position = puneLocation),
            title = "Pune Metro Station",
            snippet = "This is Pune Metro.",

            )
    }
}