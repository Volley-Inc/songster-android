package com.songster.networking

import com.songster.types.SongList
import kotlinx.serialization.json.Json

class SongRepository {

  private val json = Json {
    ignoreUnknownKeys = true
    coerceInputValues = true
  }

  fun loadSongs(): SongList {
    val inputStream = javaClass.classLoader?.getResourceAsStream("res/raw/songs.json")
    val jsonString = inputStream?.bufferedReader().use { it?.readText() }
    return json.decodeFromString(jsonString ?: "")
  }
}
