package com.songster

import androidx.lifecycle.ViewModel
import com.songster.networking.SongRepository
import com.songster.types.SongData
import kotlinx.coroutines.flow.MutableStateFlow

class SongViewModel(val songRepository: SongRepository = SongRepository()) : ViewModel() {
  var songs = MutableStateFlow<List<SongData>>(emptyList())

  init {
    loadSongs()
  }

  fun loadSongs() {
    songs.value = songRepository.loadSongs().songs
  }
}
