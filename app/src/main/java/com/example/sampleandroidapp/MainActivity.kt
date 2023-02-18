package com.example.sampleandroidapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.lifecycleScope
import com.example.sampleandroidapp.data.SemusicDataSource
import com.example.sampleandroidapp.model.SemusicRepository
import com.example.sampleandroidapp.ui.theme.SampleAndroidAppTheme
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.async

class MainActivity : ComponentActivity() {

    val repository : SemusicRepository = SemusicRepository(SemusicDataSource())
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            SampleAndroidAppTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    Greeting("Android")
                }
            }
        }

        lifecycleScope.launchWhenCreated {
            val playlists = repository.getPlaylists()
            val length = playlists.length
            println("Length: $length")
            println(">>>>>> $playlists")

            repository.testSSL()
        }
    }
}

@Composable
fun Greeting(name: String) {
    Text(text = "Hello $name!")
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    SampleAndroidAppTheme {
        Greeting("Android")
    }
}