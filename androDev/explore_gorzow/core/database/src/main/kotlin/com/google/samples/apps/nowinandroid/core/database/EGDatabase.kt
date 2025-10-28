/*
 * Copyright 2022 The Android Open Source Project
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

package com.google.samples.apps.nowinandroid.core.database

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.google.samples.apps.nowinandroid.core.database.dao.sights.SightsDao
import com.google.samples.apps.nowinandroid.core.database.model.sight.SightEntity
import com.google.samples.apps.nowinandroid.core.database.util.InstantConverter

@Database(
    entities = [
        SightEntity::class,
    ],
    version = 1
)
@TypeConverters(
    InstantConverter::class,
)
internal abstract class EGDatabase : RoomDatabase() {
    abstract fun sightsDao(): SightsDao
}
