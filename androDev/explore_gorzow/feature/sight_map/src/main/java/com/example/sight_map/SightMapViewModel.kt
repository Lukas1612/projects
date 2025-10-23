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

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import com.example.navigation.Routes.MAP_DATA_KEY
import com.example.sight_map.MapData.Companion.fromJsonToMapData
import com.google.samples.apps.nowinandroid.core.domain.sights.SightseeingUseCases
import com.google.samples.apps.nowinandroid.core.model.data.sight.UserSight
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

@HiltViewModel
class SightMapViewModel @Inject constructor(
    val savedStateHandle: SavedStateHandle,
    private val useCases: SightseeingUseCases
) : ViewModel() {

    private val mapDataJson: String = savedStateHandle.get<String>(MAP_DATA_KEY)?: ""
    private val mapData = fromJsonToMapData(mapDataJson)


    fun getInitialLatitude(): Double = mapData.initialLatitude

    fun getInitialLongitude(): Double = mapData.initialLongitude


    fun getSights(): Flow<List<UserSight>> {

        val mode: MapMode = MapMode.fromString(mapData.mode)

        return when (mode) {
            is MapMode.Chosen -> getChosenSight()
            is MapMode.All -> getAllSights()
            is MapMode.Award -> getAwardSights()
        }
    }

    private fun getChosenSight(): Flow<List<UserSight>> = flow {
        val selectedSightId: String = requireNotNull(mapData.selectedSightId) {
            "SELECTED_SIGHT_ID_KEY is missing in SavedStateHandle"
        }

        val userSight = useCases.getSightByIdUseCase(selectedSightId)// suspending function call
        emit(listOf(userSight))
    }

    private fun getAllSights(): Flow<List<UserSight>> {
        return useCases.getAllSightsUseCase()
    }

    private fun getAwardSights(): Flow<List<UserSight>> {
        throw UnsupportedOperationException("Award sights mode is not implemented yet")
    }



   /* val initialLatitude: Double = savedStateHandle.get<Double>(INITIAL_LOCATION_LATITUDE_KEY) ?: DEFAULT_INITIAL_LOCATION_LATITUDE//
    val initialLongitude: Double = savedStateHandle.get<Double>(INITIAL_LOCATION_LONGITUDE_KEY) ?: DEFAULT_INITIAL_LOCATION_LONGITUDE// default is the Cathedral

    private val mode: MapMode = MapMode.fromString(savedStateHandle[MAP_MODE_KEY])


    fun getSights(): Flow<List<UserSight>> {
        return when (mode) {
            is MapMode.Chosen -> getChosenSight()
            is MapMode.All -> getAllSights()
            is MapMode.Award -> getAwardSights()
        }
    }

    private fun getChosenSight(): Flow<List<UserSight>> = flow {
        val selectedSightId: String = requireNotNull(savedStateHandle[SELECTED_SIGHT_ID_KEY]) {
            "SELECTED_SIGHT_ID_KEY is missing in SavedStateHandle"
        }

        val userSight = useCases.getSightByIdUseCase(selectedSightId)// suspending function call
        emit(listOf(userSight))
    }

    private fun getAllSights(): Flow<List<UserSight>> {
        return useCases.getAllSightsUseCase()
    }

    private fun getAwardSights(): Flow<List<UserSight>> {
        throw UnsupportedOperationException("Award sights mode is not implemented yet")
    }*/
}

/*
const val DEFAULT_INITIAL_LOCATION_LATITUDE = 52.73  //Cathedral latitude
const val DEFAULT_INITIAL_LOCATION_LONGITUDE = 15.23  //Cathedral longitude
*/

const val INITIAL_LOCATION_LATITUDE_KEY = "initial_location_latitude"
const val INITIAL_LOCATION_LONGITUDE_KEY = "initial_location_longitude"

const val SELECTED_SIGHT_ID_KEY = "selected_sight_id"