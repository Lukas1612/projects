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

import android.util.Log
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.navigation.Routes.EXPANDED_SIGHT_SCREEN_ROUTE
import com.example.navigation.Routes.SIGHT_ID_KEY
import com.google.samples.apps.nowinandroid.core.domain.sights.SightseeingUseCases
import com.google.samples.apps.nowinandroid.core.model.data.sight.UserSight
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Job
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ExpandedSightViewModel @Inject constructor(
    savedStateHandle: SavedStateHandle,
    private val useCases: SightseeingUseCases
) : ViewModel() {

    private val _state = MutableStateFlow<UserSight?>(null)
    val state: StateFlow<UserSight?> = _state


    private val sightId: String = savedStateHandle[SIGHT_ID_KEY]
        ?: throw IllegalStateException("Missing $SIGHT_ID_KEY in the path: $EXPANDED_SIGHT_SCREEN_ROUTE")

    init {
        viewModelScope.launch {
            val updatedSight = useCases.getSightByIdUseCase(sightId)
            _state.value = updatedSight
        }
    }


     fun bookmarkSight(sightId: String) {
         viewModelScope.launch {
             _state.value.also { userSight ->
                 if(userSight!!.isBookmarked){
                     useCases.bookmarkSightUseCase(sightId, false)
                 }else{
                     useCases.bookmarkSightUseCase(sightId, true)
                 }
             }

             val updatedSight = useCases.getSightByIdUseCase(sightId)
             _state.value = updatedSight
         }
    }
}