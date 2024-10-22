package com.songster.networking

import com.songster.types.SongList
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import kotlinx.serialization.json.Json

class SongRepository {

  fun loadSongs(): SongList {
    withContext(Dispatchers.Main) {
      val inputStream = javaClass.classLoader?.getResourceAsStream("res/raw/songs.json")
      val jsonString = inputStream?.bufferedReader().use { it?.readText() }
      return Json.decodeFromString(jsonString ?: "")
    }
  }
}
