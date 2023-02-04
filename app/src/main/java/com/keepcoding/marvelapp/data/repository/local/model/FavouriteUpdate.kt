package com.keepcoding.marvelapp.data.repository.local.model

import androidx.room.ColumnInfo
import androidx.room.Entity

@Entity()
data class FavouriteUpdate(
    @ColumnInfo(name = "id") val id: Int,
    @ColumnInfo(name = "favorite") val favorite: Boolean,
)
