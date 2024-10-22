package com.songster.types

import kotlinx.serialization.Serializable

@Serializable
data class SongData(
    val title: String,
    val artist: String,
    val image: String,
)

@Serializable
data class SongList(val songs: List<SongData>)
