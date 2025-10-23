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

package com.google.samples.apps.nowinandroid.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.example.expanded_sight.ExpandedSightScreen
import com.example.home_screen.HomeScreen
import com.example.navigation.Routes.DESTINATION_LATITUDE_KEY
import com.example.navigation.Routes.DESTINATION_LONGITUDE_KEY
import com.example.navigation.Routes.EXPANDED_SIGHT_SCREEN_ROUTE
import com.example.navigation.Routes.HOME_SCREEN_ROUTE
import com.example.navigation.Routes.MAP_DATA_KEY
import com.example.navigation.Routes.ROUTE_MAP_SCREEN_ROUTE
import com.example.navigation.Routes.SIGHTS_MAP_SCREEN_ROUTE
import com.example.navigation.Routes.SIGHT_ID_KEY
import com.example.navigation.Routes.SIGHT_LIST_ALL_SIGHTS_MODE_SCREEN_ROUTE
import com.example.navigation.Routes.SIGHT_LIST_BOOKMARKED_SIGHTS_MODE_SCREEN_ROUTE
import com.example.navigation.Routes.SIGHT_LIST_SCREEN_ROUTE
import com.example.navigation.Routes.SIGHT_LIST_VISITED_SIGHTS_MODE_SCREEN_ROUTE
import com.example.navigation.Routes.SIGHT_LIST_MODE_KEY
import com.example.navigation.Routes.buildExpandedSightScreenRoute
import com.example.navigation.Routes.buildRouteScreenRoute
import com.example.navigation.Routes.buildSightsMapScreenRoute
import com.example.sights_list.SightsList
import com.example.route_map.RouteMap
import com.example.sight_map.MapData
import com.example.sight_map.SightsMapScreen

@Composable
fun AppNavHost(
    navController: NavHostController,
    modifier: Modifier = Modifier
) {
    NavHost(
        navController = navController,
        startDestination = HOME_SCREEN_ROUTE,
        modifier = modifier
    ) {
        composable(HOME_SCREEN_ROUTE) {
            HomeScreen(
                onNavigateToSightsList = { navController.navigate(SIGHT_LIST_ALL_SIGHTS_MODE_SCREEN_ROUTE) },

                onNavigateToMapOfSights =  {
                    val mapDataJson = MapData.allSightsMode().toJson()
                    navController.navigate(buildSightsMapScreenRoute(mapDataJson))
                },

                onNavigateToFavourites = {navController.navigate(SIGHT_LIST_BOOKMARKED_SIGHTS_MODE_SCREEN_ROUTE)},
                onNavigateToVisited = {navController.navigate(SIGHT_LIST_VISITED_SIGHTS_MODE_SCREEN_ROUTE)},
                )
        }
        composable(
            SIGHT_LIST_SCREEN_ROUTE,
            arguments = listOf(
                navArgument(SIGHT_LIST_MODE_KEY) { type = NavType.StringType }
            )
        ) {backStackEntry ->

            SightsList(
                onBack = {
                navController.popBackStack()
            },
                onNavigateToMapScreen = { mapData ->
                    val mapDataJson = mapData.toJson()
                    navController.navigate(buildSightsMapScreenRoute(mapDataJson))
                },
                onNavigateToRouteMap = { lat, lng ->
                    navController.navigate(buildRouteScreenRoute(lat, lng))
                },

                onImageClicked = { sightId ->
                    navController.navigate(buildExpandedSightScreenRoute(sightId))
                }
            )
        }

        composable(
            route = ROUTE_MAP_SCREEN_ROUTE,
            arguments = listOf(
                navArgument(DESTINATION_LATITUDE_KEY) { type = NavType.StringType },
                navArgument(DESTINATION_LONGITUDE_KEY) { type = NavType.StringType }
            )
        ) {
            RouteMap(
                onBack = {
                    navController.popBackStack()
                })
        }


        composable(
            route = SIGHTS_MAP_SCREEN_ROUTE,
            arguments = listOf(navArgument(MAP_DATA_KEY) { type = NavType.StringType })
        ) { backStackEntry ->
            SightsMapScreen(
                onNavigateToRouteMap = { lat, lng -> navController.navigate(buildRouteScreenRoute(lat, lng)) },
                onNavigateToExpandedSight = { sightId ->  navController.navigate(buildExpandedSightScreenRoute(sightId))},
                onBack = { navController.popBackStack() }
            )
        }

        composable(
            route = EXPANDED_SIGHT_SCREEN_ROUTE,
            arguments = listOf(navArgument(SIGHT_ID_KEY) { type = NavType.StringType })
        ) { backStackEntry ->
            ExpandedSightScreen(
                onBackClicked = { navController.popBackStack() },
                onLocationToggled = { userSight ->
                    val mapDataJson = MapData
                        .selectedSightModeData(userSight)
                        .toJson()
                    navController.navigate(buildSightsMapScreenRoute(mapDataJson))
                },
                onRouteToggled = { userSight ->
                    val lat = userSight.sight.latitude
                    val lng = userSight.sight.longitude
                    navController.navigate(buildRouteScreenRoute(lat, lng))
                }
            )
        }
    }
}