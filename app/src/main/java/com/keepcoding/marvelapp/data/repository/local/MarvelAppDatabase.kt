package com.keepcoding.marvelapp.data.repository.local

import androidx.room.Database
import androidx.room.RoomDatabase
import com.keepcoding.marvelapp.data.repository.local.MarvelDAO
import com.keepcoding.marvelapp.data.repository.local.model.LocalHero

@Database(entities = [LocalHero::class], version = 1, exportSchema = false)
abstract class MarvelAppDatabase : RoomDatabase() {
    abstract fun getDAO(): MarvelDAO
}
