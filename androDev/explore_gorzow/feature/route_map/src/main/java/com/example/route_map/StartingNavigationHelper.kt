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

package com.example.route_map

import android.content.Context
import android.content.Intent
import androidx.core.net.toUri

class StartingNavigationHelper {

    companion object {
        fun startNavigationActivity(lat: Double, lng: Double, context: Context){

            val destination = "$lat,$lng"

            val gmmIntentUri =
                "https://www.google.com/maps/dir/?api=1&destination=$destination&travelmode=driving".toUri()
            val mapIntent = Intent(Intent.ACTION_VIEW, gmmIntentUri).apply {
                setPackage("com.google.android.apps.maps")
            }

            if (mapIntent.resolveActivity(context.packageManager) != null) {
                context.startActivity(mapIntent)
            } else {
                // Fallback: open in browser
                val browserIntent = Intent(Intent.ACTION_VIEW, gmmIntentUri)
                context.startActivity(browserIntent)
            }
        }
    }
}