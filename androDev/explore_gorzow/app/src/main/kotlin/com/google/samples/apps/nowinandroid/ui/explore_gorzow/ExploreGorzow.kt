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

package com.google.samples.apps.nowinandroid.ui.explore_gorzow

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.rememberNavController
import com.google.samples.apps.nowinandroid.navigation.AppNavHost

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ExploreGorzow() {

    val navController = rememberNavController()

    MaterialTheme {
        Scaffold(
            // 🧹 Removed the topBar block
        ) { padding ->
            AppNavHost(
                navController = navController,
                modifier = Modifier.padding(padding)
            )
        }
    }
}
