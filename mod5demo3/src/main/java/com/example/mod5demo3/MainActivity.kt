package com.example.mod5demo3

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.telecom.Call
import androidx.activity.ComponentActivity
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import com.example.mod5demo3.ui.theme.CoursAndroidQCDA009Theme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            CoursAndroidQCDA009Theme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    CallPhone(modifier = Modifier.padding(innerPadding))
                }
            }
        }
    }
}


@Composable
fun CallPhone(modifier: Modifier = Modifier) {

    val context = LocalContext.current

    val requestPermissionLauncher =
        rememberLauncherForActivityResult(
            contract = ActivityResultContracts.RequestPermission()
        ) {isGranted ->
            if(isGranted){
                Intent(Intent.ACTION_CALL, Uri.parse("tel:0606060606")).also {
                    context.startActivity(it)
                }
            }else{
                Intent(Intent.ACTION_DIAL, Uri.parse("tel:0606060606")).also {
                    context.startActivity(it)
                }
            }

        }

    Button(onClick = {
        requestPermissionLauncher.launch(android.Manifest.permission.CALL_PHONE)
    }) {
        Text(text = "CALL A FRIEND")
    }

}

