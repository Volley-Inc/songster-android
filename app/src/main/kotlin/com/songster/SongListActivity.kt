package com.songster

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import coil3.compose.AsyncImage
import coil3.util.Logger
import com.songster.types.SongData
import com.songster.ui.SongsterTheme

class MainActivity : ComponentActivity() {
  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    enableEdgeToEdge()
    setContent {
      SongsterTheme {
        Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
          SongList(modifier = Modifier.padding(innerPadding))
        }
      }
    }
  }
}

@Composable
fun SongList(modifier: Modifier) {
  val viewModel: SongViewModel = viewModel()
  val state = viewModel.songs.collectAsState()
  LazyColumn(modifier = Modifier.then(modifier)) { items(state.value) { SongItem(song = it) } }
}

@Composable
fun SongItem(song: SongData) {
    Log.e("QQQ", "SongItem: $song")
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        AsyncImage(
            model = song.image ?: "",
            contentDescription = "Album art for ${song.title}",
            modifier = Modifier
                .padding(16.dp)
                .size(64.dp),
            contentScale = ContentScale.Crop,
//            error = painterResource(R.drawable.ic_error_placeholder), // Add a placeholder
//            placeholder = painterResource(R.drawable.ic_loading_placeholder) // Add a placeholder
        )
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp)
        ) {
            Text(
                text = song.title,
                style = MaterialTheme.typography.headlineLarge,
                maxLines = 1,
                overflow = TextOverflow.Ellipsis
            )
            Text(
                text = song.artist,
                style = MaterialTheme.typography.bodyMedium,
                maxLines = 1,
                overflow = TextOverflow.Ellipsis
            )
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
