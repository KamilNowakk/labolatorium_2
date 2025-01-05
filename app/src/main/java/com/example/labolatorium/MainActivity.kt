package com.example.labolatorium

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountBox
import androidx.compose.material3.Card
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.CardDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.labolatorium.ui.theme.LabolatoriumTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            LabolatoriumTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(), color = MaterialTheme.colorScheme.background
                ) {
                    Greeting("Android")
                    MainContent()
                }
            }
        }
    }
}

@Composable
fun MainContent(
    movieList: List<String> = listOf(
        "Avatar", "3000", "PBS", "Christmas is Coming", "03.12.2022", "Cat", "Dog", "Bon Appétit"
    )
) {
    Column(modifier = Modifier.padding(12.dp)) {
        LazyColumn {
            items(items = movieList) { movie ->
                MovieRow(movie = movie) { selectedMovie ->
                    Log.d("TAG", "MainContent: $selectedMovie")
                }
            }
        }
    }
}

@Composable
fun MovieRow(movie: String, onItemClick: (String) -> Unit = {}) {
    Card(
        modifier = Modifier
            .padding(4.dp)
            .fillMaxWidth()
            .height(130.dp)
            .clickable { onItemClick(movie) },
        shape = RoundedCornerShape(corner = CornerSize(26.dp)),
        elevation = CardDefaults.cardElevation(defaultElevation = 16.dp) // Użycie CardDefaults
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Start
        ) {
            Surface(
                modifier = Modifier
                    .padding(12.dp)
                    .size(100.dp),
                shape = RectangleShape,
                shadowElevation = 4.dp // W Material3 użyj shadowElevation
            ) {
                Icon(imageVector = Icons.Default.AccountBox, contentDescription = "Movie image")
            }
            Text(
                text = movie,
                modifier = Modifier
                    .padding(start = 8.dp) // Dodajemy przestrzeń po lewej stronie tekstu
                    .align(Alignment.CenterVertically) // Wyrównujemy tekst w pionie
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    LabolatoriumTheme {
        Greeting("Android")
    }
}

@Composable
fun Greeting(name: String) {
    Text(text = "Hello $name!")
}
