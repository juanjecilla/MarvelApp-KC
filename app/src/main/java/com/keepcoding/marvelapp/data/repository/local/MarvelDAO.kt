package com.keepcoding.marvelapp.data.repository.local

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.keepcoding.androidavanzado.data.local.model.SuperHeroDetailLocal
import com.keepcoding.marvelapp.data.repository.local.model.LocalHero
import kotlinx.coroutines.flow.Flow

@Dao
interface MarvelDAO {
    @Query("SELECT * FROM superheros")
    fun getAllSuperheros(): Flow<List<LocalHero>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertAll(superHero: List<LocalHero>)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertSuperhero(superHero: LocalHero)
}
