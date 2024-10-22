package com.songster.types

import kotlinx.serialization.Serializable

@Serializable
data class SongData(
    val id: Int,
    val title: String,
    val artist: String,
    val duration: Int,
    val year: Int,
    val genre: String
)
