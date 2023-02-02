package com.keepcoding.marvelapp.data.repository.local

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import com.keepcoding.marvelapp.data.repository.local.model.FavouriteUpdate
import com.keepcoding.marvelapp.data.repository.local.model.LocalHero
import kotlinx.coroutines.flow.Flow

@Dao
interface MarvelDAO {
    @Query("SELECT * FROM superheros")
    fun getHeros(): Flow<List<LocalHero>>

    @Query("SELECT COUNT(id) FROM superheros")
    fun getHerosCount(): Int

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertAll(superHero: List<LocalHero>)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertHero(superHero: LocalHero)
    @Update(LocalHero::class)
    fun updateFavourite(update: FavouriteUpdate)
}
