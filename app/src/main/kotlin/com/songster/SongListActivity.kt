package com.songster

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import coil3.compose.AsyncImage
import com.songster.types.SongData
import com.songster.ui.SongsterTheme

class MainActivity : ComponentActivity() {
  private lateinit var viewModel: SongViewModel

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    viewModel = SongViewModel()
    enableEdgeToEdge()
    setContent {
      SongsterTheme {
        Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
          SongList(modifier = Modifier.padding(innerPadding), viewModel = viewModel)
        }
      }
    }
  }
}

@Composable
fun SongList(modifier: Modifier, viewModel: SongViewModel) {
  val songs = viewModel.songs.value
  Column { songs.forEach { SongItem(song = it) } }
}

@Composable
fun SongItem(song: SongData) {
  Row(
      modifier = Modifier.fillMaxWidth().padding(8.dp),
      verticalAlignment = Alignment.CenterVertically) {
        AsyncImage(
            model = song.image ?: "",
            contentDescription = "Album art for ${song.title}",
            modifier = Modifier,
        )
        Column(modifier = Modifier.fillMaxWidth().padding(16.dp)) {
          Text(
              text = song.title,
              style = MaterialTheme.typography.headlineLarge,
              maxLines = 1,
              overflow = TextOverflow.Ellipsis)
          Text(
              text = song.artist,
              style = MaterialTheme.typography.bodyMedium,
              maxLines = 1,
              overflow = TextOverflow.Ellipsis)
        }
      }
}

@Preview
@Composable
fun SongItemPreview() {
  SongsterTheme {
    SongItem(
        SongData(
            title = "Title",
            artist = "Artist",
            image = "www.imageurl.com",
        ))
  }
}
