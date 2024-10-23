package com.songster.networking

import com.songster.types.SongList
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import kotlinx.serialization.json.Json

class SongRepository {

  private val json = Json {
    ignoreUnknownKeys = true
    coerceInputValues = true
    encodeDefaults = true
  }

  suspend fun loadSongs(): SongList =
      withContext(Dispatchers.IO) {
        val inputStream = javaClass.classLoader?.getResourceAsStream("res/raw/songs.json")
        val jsonString = inputStream?.bufferedReader().use { it?.readText() }
        return@withContext json.decodeFromString(jsonString ?: "")
      }
}
