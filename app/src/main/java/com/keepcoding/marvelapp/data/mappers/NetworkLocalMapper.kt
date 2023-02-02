package com.keepcoding.marvelapp.data.mappers

import com.keepcoding.marvelapp.data.repository.local.model.LocalHero
import com.keepcoding.marvelapp.data.repository.remote.responses.NetworkHero
import com.keepcoding.marvelapp.data.repository.remote.responses.mapToPhotoString
import javax.inject.Inject

class NetworkLocalMapper @Inject constructor() {
    fun mapHeros(remoteList: List<NetworkHero>): List<LocalHero> {
        return remoteList.map { map(it) }
    }

    private fun map(networkHero: NetworkHero): LocalHero {
        return LocalHero(
            networkHero.id,
            networkHero.name,
            networkHero.thumbnail.mapToPhotoString(),
            false
        )
    }
}
