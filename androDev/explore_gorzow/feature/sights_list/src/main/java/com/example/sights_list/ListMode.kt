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

package com.example.sights_list

import com.example.navigation.Routes.ALL_SIGHTS_LIST_MODE
import com.example.navigation.Routes.BOOKMARKED_SIGHTS_LIST_MODE
import com.example.navigation.Routes.VISITED_SIGHTS_LIST_MODE

sealed class ListMode {
    object All : ListMode()
    object Visited : ListMode()
    object Bookmarked : ListMode()
    /*object Monuments :  ListMode()
    object Parks : ListMode()
    object Memorials : ListMode()
    object PostWarArchitecture : ListMode()*/

    companion object {
        fun fromString(value: String?): ListMode {
            return when (value) {
                BOOKMARKED_SIGHTS_LIST_MODE -> Bookmarked
                VISITED_SIGHTS_LIST_MODE -> Visited
                ALL_SIGHTS_LIST_MODE -> All
               /* MONUMENTS_LIST_MODE -> Monuments
                PARKS_AND_PLACES_LIST_MODE -> Parks
                MEMORIALS_LIST_MODE -> Memorials
                POST_WAR_ARCHITECTURE_LIST_MODE -> PostWarArchitecture*/
                else -> throw IllegalArgumentException(
                    "Invalid mode: $value. Expected one of: $BOOKMARKED_SIGHTS_LIST_MODE, $VISITED_SIGHTS_LIST_MODE, $ALL_SIGHTS_LIST_MODE" /*+ "$MONUMENTS_LIST_MODE, $PARKS_AND_PLACES_LIST_MODE, $MEMORIALS_LIST_MODE, $POST_WAR_ARCHITECTURE_LIST_MODE"*/
                )
            }
        }
    }
}