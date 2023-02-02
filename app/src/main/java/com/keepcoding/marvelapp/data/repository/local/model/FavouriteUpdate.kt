package com.keepcoding.marvelapp.data.repository.local.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity()
data class FavouriteUpdate(
    @ColumnInfo(name = "id") val id: Int,
    @ColumnInfo(name = "favorite") val favorite: Boolean,
)
