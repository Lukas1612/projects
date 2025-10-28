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

package com.example.expanded_sight

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Map
import androidx.compose.material.icons.filled.Navigation
import androidx.compose.material.icons.outlined.FavoriteBorder
import androidx.compose.material3.Card
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.google.samples.apps.nowinandroid.core.model.data.sight.UserSight

@Composable
fun ExpandedSightScreen(
    onBackClicked: () -> Unit,
    onLocationToggled: (UserSight) -> Unit,
    onRouteToggled: (UserSight) -> Unit,
    sightsListViewModel: ExpandedSightViewModel = hiltViewModel()
) {
    val userSight by sightsListViewModel.state.collectAsState()

    if (userSight == null) {
        Box(
            modifier = Modifier.fillMaxSize(),
            contentAlignment = Alignment.Center
        ) {
            CircularProgressIndicator()
        }
    } else {
        Box(modifier = Modifier.fillMaxSize()) {
            ExpandedSightContent(
                userSight = userSight!!,
                onLocationToggled = onLocationToggled,
                onRouteToggled = onRouteToggled,
                sightsListViewModel = sightsListViewModel
            )

            // Floating circular back button
            Box(
                modifier = Modifier
                    .align(Alignment.TopStart) // <-- aligns this Box inside the parent Box
                    .padding(16.dp)
                    .size(48.dp)
                    .clip(CircleShape)
                    .background(MaterialTheme.colorScheme.surfaceVariant)
                    .clickable { onBackClicked() },
                contentAlignment = Alignment.Center // centers icon inside this box
            ) {
                Icon(
                    imageVector = Icons.Default.ArrowBack,
                    contentDescription = "Back",
                    tint = MaterialTheme.colorScheme.onSurfaceVariant
                )
            }
        }
    }
}

@Composable
private fun ExpandedSightContent(
    userSight: UserSight,
    onLocationToggled: (UserSight) -> Unit,
    onRouteToggled: (UserSight) -> Unit,
    sightsListViewModel: ExpandedSightViewModel
) {
    val painter = painterResource(id = userSight.sight.imageResId)
    val scrollState = rememberScrollState() // remember scroll state

    Column(
        modifier = Modifier
            .fillMaxSize() // take full height to allow scrolling
            .verticalScroll(scrollState) // make it scrollable
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Card(
            modifier = Modifier
                .fillMaxWidth()
                .heightIn(min = 160.dp)
        ) {
            Image(
                painter = painter,
                contentDescription = userSight.sight.name,
                modifier = Modifier
                    .fillMaxWidth()
                    .height(220.dp),
                contentScale = ContentScale.Crop
            )
        }

        Spacer(modifier = Modifier.height(12.dp))

        Row(
            horizontalArrangement = Arrangement.spacedBy(16.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            IconButton(
                onClick = { sightsListViewModel.bookmarkSight(userSight.sight.id) }
            ) {
                Icon(
                    contentDescription = "Favorite",
                    imageVector = if (userSight.isBookmarked)
                        Icons.Filled.Favorite
                    else
                        Icons.Outlined.FavoriteBorder
                )
            }

            IconButton(onClick = { onLocationToggled(userSight) }) {
                Icon(
                    imageVector = Icons.Default.Map,
                    contentDescription = "Show on Map"
                )
            }

            IconButton(onClick = { onRouteToggled(userSight) }) {
                Icon(
                    imageVector = Icons.Default.Navigation,
                    contentDescription = "Show route"
                )
            }
        }

        Spacer(modifier = Modifier.height(12.dp))

        Text(
            text = userSight.sight.name,
            style = MaterialTheme.typography.titleMedium,
            maxLines = 2,
            overflow = TextOverflow.Ellipsis,
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 4.dp)
        )

        Spacer(modifier = Modifier.height(6.dp))

        Text(
            text = userSight.sight.description,
            style = MaterialTheme.typography.bodyMedium,
            modifier = Modifier.fillMaxWidth() // no maxLines limit for full scrolling
        )

        Spacer(modifier = Modifier.height(16.dp)) // optional padding at bottom
    }
}
