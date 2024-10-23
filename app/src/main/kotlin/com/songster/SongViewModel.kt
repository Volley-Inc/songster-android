package com.songster

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.songster.networking.SongRepository
import com.songster.types.SongData
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch

class SongViewModel(val songRepository: SongRepository = SongRepository()) : ViewModel() {
  var songs = MutableStateFlow<List<SongData>>(emptyList())

  init {
    loadSongs()
  }

  fun loadSongs() {
    viewModelScope.launch { songs.value = songRepository.loadSongs().songs }
  }
}
