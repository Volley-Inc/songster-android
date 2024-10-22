package com.songster.networking

import com.songster.types.SongData
import java.io.File
import kotlinx.serialization.json.Json

class SongRepository {

  private val json = Json {
    ignoreUnknownKeys = true
    coerceInputValues = true
  }

  /** Read songs from the assets file and returns them as a listg */
  fun loadSongs(): List<SongData> {
    val jsonString = File("assets/songs.json").readText()
    return json.decodeFromString<List<SongData>>(jsonString)
  }
}
