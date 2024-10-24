package com.songster.types

import kotlinx.serialization.Serializable

@Serializable
data class SongData(
    val title: String,
    val artist: String,
    val image: String? = null,
)

@Serializable
data class SongList(val songs: List<SongData>)
