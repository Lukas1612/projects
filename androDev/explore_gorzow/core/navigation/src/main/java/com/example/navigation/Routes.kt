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

package com.example.navigation

object Routes {

    const val DESTINATION_LATITUDE_KEY = "destination_latitude_key"
    const val DESTINATION_LONGITUDE_KEY = "destination_longitude_key"

    const val MAP_MODE_KEY = "map_mode_key"
    const val SELECTED_SIGHT_MODE = "selected_sight_mode"
    const val ALL_SIGHTS_MODE = "all_sights_mode"
    const val AWARD_SIGHTS_MODE = "award_sights_mode"


    const val SIGHT_LIST_MODE_KEY = "sight_list_mode"
    const val BOOKMARKED_SIGHTS_LIST_MODE = "bookmarked_sights_list_mode"
    const val VISITED_SIGHTS_LIST_MODE = "visited_sights_list_mode"
    const val ALL_SIGHTS_LIST_MODE = "all_sights_list_mode"
   /* const val MONUMENTS_LIST_MODE = "monuments_mode_list_mode"
    const val PARKS_AND_PLACES_LIST_MODE = "parks_and_places_mode_list_mode"
    const val MEMORIALS_LIST_MODE = "memorials_mode_list_mode"
    const val POST_WAR_ARCHITECTURE_LIST_MODE = "post_war_architecture_mode_list_mode"*/


    const val HOME_SCREEN_ROUTE = "home"
    const val ROUTE_MAP_SCREEN_ROUTE = "route_map/{$DESTINATION_LATITUDE_KEY}/{$DESTINATION_LONGITUDE_KEY}"

    const val MAP_DATA_KEY = "map_data_key"
    const val SIGHTS_MAP_SCREEN_ROUTE = "sights_map/{$MAP_DATA_KEY}"

    const val SIGHT_LIST_SCREEN_ROUTE = "sight_list/{$SIGHT_LIST_MODE_KEY}"
    const val SIGHT_LIST_ALL_SIGHTS_MODE_SCREEN_ROUTE = "sight_list/$ALL_SIGHTS_LIST_MODE"
    const val SIGHT_LIST_BOOKMARKED_SIGHTS_MODE_SCREEN_ROUTE = "sight_list/$BOOKMARKED_SIGHTS_LIST_MODE"
    const val SIGHT_LIST_VISITED_SIGHTS_MODE_SCREEN_ROUTE = "sight_list/$VISITED_SIGHTS_LIST_MODE"

    const val SIGHT_ID_KEY = "sight_id_key"
    const val EXPANDED_SIGHT_SCREEN_ROUTE = "expanded_sight/{$SIGHT_ID_KEY}"

    fun buildRouteScreenRoute(lat: Double, lng: Double): String =
        "route_map/$lat/$lng"

    fun buildSightsMapScreenRoute(mapDataJson: String): String =
        "sights_map/$mapDataJson"

    fun buildExpandedSightScreenRoute(sightId: String): String =
        "expanded_sight/$sightId"


    const val DESTINATION_SCREEN_KEY = "navigate_to"
    const val DESTINATION_LAT = "destination_lat"
    const val DESTINATION_LNG = "destination_lng"
    const val ROUTE_MAP_SCREEN_NAME = "route_map"



    const val AWARD_ID_KEY = "award_id_key"
}