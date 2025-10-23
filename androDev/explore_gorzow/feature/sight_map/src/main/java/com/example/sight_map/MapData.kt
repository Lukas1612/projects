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

import com.example.navigation.Routes.ALL_SIGHTS_MODE
import com.example.navigation.Routes.SELECTED_SIGHT_MODE
import com.google.gson.Gson
import com.google.samples.apps.nowinandroid.core.model.data.sight.UserSight

data class MapData(
    val initialLatitude: Double = DEFAULT_INITIAL_LOCATION_LATITUDE,
    val initialLongitude: Double = DEFAULT_INITIAL_LOCATION_LONGITUDE,
    val mode: String,
    val selectedSightId: String? = null,
    val awardId: String? = null
){
    companion object {
        fun selectedSightModeData(selectedSightId: String,  latitude: Double, longitude: Double): MapData = MapData(
            mode = SELECTED_SIGHT_MODE,
            initialLatitude = latitude,
            initialLongitude = longitude,
            selectedSightId = selectedSightId
        )

        fun selectedSightModeData(userSight: UserSight): MapData{
            val id = userSight.sight.id
            val lat = userSight.sight.latitude
            val lng = userSight.sight.longitude

            return selectedSightModeData(id, lat, lng)
        }

        fun allSightsMode(): MapData = MapData(
            mode = ALL_SIGHTS_MODE
        )

        fun fromJsonToMapData(mapDataJson: String): MapData{
            val gson = Gson()
            return gson.fromJson(mapDataJson, MapData::class.java)
        }

        fun fromMapDataToJson(mapData: MapData): String{
            val gson = Gson()
            return gson.toJson(mapData)
        }
    }

    fun toJson(): String{
        return fromMapDataToJson(this)
    }



}

private val DEFAULT_INITIAL_LOCATION_LATITUDE = 52.73  //Cathedral latitude
private val DEFAULT_INITIAL_LOCATION_LONGITUDE = 15.23  //Cathedral longitude


