/*
 * Copyright 2025 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.example.sight_map

import android.Manifest
import android.content.Context
import android.content.pm.PackageManager
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.DisposableEffect
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.compose.ui.viewinterop.AndroidView
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.DefaultLifecycleObserver
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.compose.LocalLifecycleOwner
import org.osmdroid.config.Configuration
import org.osmdroid.tileprovider.tilesource.TileSourceFactory
import org.osmdroid.util.GeoPoint
import org.osmdroid.views.MapView
import org.osmdroid.views.overlay.Marker
import org.osmdroid.views.overlay.mylocation.GpsMyLocationProvider
import org.osmdroid.views.overlay.mylocation.MyLocationNewOverlay


@Composable
fun SightsMapScreen(
    viewModel: SightMapViewModel = hiltViewModel(),
    onNavigateToRouteMap: (Double, Double) -> Unit,
    onNavigateToExpandedSight: (String) -> Unit,
    onBack: () -> Unit
) {
    val context = LocalContext.current
    val lifecycleOwner = LocalLifecycleOwner.current

    //  Configure user agent once before MapView creation
    LaunchedEffect(Unit) {
        val config = Configuration.getInstance()
        config.userAgentValue = context.packageName
        config.load(context, context.getSharedPreferences("osm_prefs", Context.MODE_PRIVATE))
    }

    // Create and remember the MapView so it survives recompositions
    val mapView = remember {
        MapView(context).apply {
            setTileSource(TileSourceFactory.MAPNIK)
            setMultiTouchControls(true)
        }
    }

    // Handle lifecycle (Compose doesn't call onPause/onResume automatically)
    DisposableEffect(lifecycleOwner) {
        val lifecycleObserver = object : DefaultLifecycleObserver {
            override fun onResume(owner: LifecycleOwner) = mapView.onResume()
            override fun onPause(owner: LifecycleOwner) = mapView.onPause()
        }
        lifecycleOwner.lifecycle.addObserver(lifecycleObserver)
        onDispose { lifecycleOwner.lifecycle.removeObserver(lifecycleObserver) }
    }

    // Collect sights from ViewModel
    val sights by viewModel.getSights().collectAsState(initial = emptyList())

    // Update markers when sights change
    LaunchedEffect(sights) {
        mapView.overlays.clear()
        sights.forEach { userSight ->
            val marker = Marker(mapView).apply {
                position = GeoPoint(userSight.sight.latitude, userSight.sight.longitude)
                title = userSight.sight.name
                subDescription = userSight.sight.description
                relatedObject = userSight.sight.id
                icon = if (userSight.isVisited)
                    ContextCompat.getDrawable(context, R.drawable.outline_check_circle_24)
                else
                    ContextCompat.getDrawable(context, R.drawable.outline_x_circle_24)
                infoWindow = CustomInfoWindow(
                    mapView,
                    onNavigationButtonClick = { marker ->
                        val lat = marker.position.latitude
                        val lng = marker.position.longitude
                        onNavigateToRouteMap(lat, lng)
                    },
                    onReadMoreButtonClick = {marker ->
                        val sightId = marker.relatedObject as? String
                        if (sightId != null) {
                            onNavigateToExpandedSight(sightId)
                        }else{
                            error("Marker.relatedObject is null or not a String for marker: ${marker.title}")
                        }
                    }
                )
            }
            mapView.overlays.add(marker)
        }
        mapView.invalidate()
    }

    // Set user location overlay
    LaunchedEffect(Unit) {
        if (ActivityCompat.checkSelfPermission(
                context,
                Manifest.permission.ACCESS_FINE_LOCATION
            ) == PackageManager.PERMISSION_GRANTED
        ) {
            val locationOverlay = MyLocationNewOverlay(GpsMyLocationProvider(context), mapView)
            locationOverlay.enableMyLocation()
            mapView.overlays.add(locationOverlay)
        }
    }

    // Center map
    LaunchedEffect(Unit) {
        val lat = viewModel.getInitialLatitude()
        val lng = viewModel.getInitialLongitude()
        mapView.controller.setZoom(18.0)
        mapView.controller.setCenter(GeoPoint(lat, lng))
    }

    // Compose layout with map and button
    Box(modifier = Modifier.fillMaxSize()) {
        AndroidView(factory = { mapView }, modifier = Modifier.fillMaxSize())

        // Optional UI overlay
        IconButton(
            onClick = onBack,
            modifier = Modifier
                .align(Alignment.TopStart)
                .padding(16.dp)
                .background(MaterialTheme.colorScheme.surface.copy(alpha = 0.8f), CircleShape)
        ) {
            Icon(Icons.Default.ArrowBack, contentDescription = "Back")
        }
    }
}