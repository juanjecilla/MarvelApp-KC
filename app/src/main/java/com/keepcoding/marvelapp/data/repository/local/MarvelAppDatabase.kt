package com.keepcoding.androidavanzado.data.local

import androidx.room.Database
import androidx.room.RoomDatabase
import com.keepcoding.androidavanzado.data.local.model.SuperHeroDetailLocal
import com.keepcoding.marvelapp.data.repository.local.MarvelDAO
import com.keepcoding.marvelapp.data.repository.local.model.LocalHero

@Database(entities = [LocalHero::class, SuperHeroDetailLocal::class], version = 1)
abstract class MarvelAppDatabase : RoomDatabase() {
    abstract fun getDAO(): MarvelDAO
}
