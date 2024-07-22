package com.example.mod5demo2

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import com.example.mod5demo2.ui.theme.CoursAndroidQCDA009Theme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            CoursAndroidQCDA009Theme {
                GoToMap()
            }
        }
    }
}


@Composable
fun GoToMap() {
    val context = LocalContext.current
    Button(onClick = {
        Intent(Intent.ACTION_VIEW, Uri.parse("geo:47.97, -4.08")).also {
            context.startActivity(it)
        }
    }) {
        Text(text = "GO !")
    }
}
