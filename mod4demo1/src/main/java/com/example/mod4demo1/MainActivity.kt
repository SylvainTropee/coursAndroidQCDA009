package com.example.mod4demo1

import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Snackbar
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import com.example.mod4demo1.ui.theme.CoursAndroidQCDA009Theme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            CoursAndroidQCDA009Theme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    Form(modifier = Modifier.padding(innerPadding))
                }
            }
        }
    }
}


@Composable
fun Form(modifier: Modifier = Modifier) {

    var firstname = ""
    var lastname by remember {
        mutableStateOf("")
    }
    var age by rememberSaveable {
        mutableStateOf("")
    }
    val context = LocalContext.current

    Column {


        TextField(
            value = firstname, onValueChange = {
                firstname = it
            },
            label = { Text(text = "Prénom") },
            modifier = Modifier.fillMaxWidth()
        )
        TextField(
            value = lastname, onValueChange = {
                lastname = it
            },
            label = { Text(text = "Nom") },
            modifier = Modifier.fillMaxWidth()
        )
        TextField(
            value = age, onValueChange = {
                age = it
            },
            label = { Text(text = "Age") },
            modifier = Modifier.fillMaxWidth(),
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number)
        )
        Button(
            onClick = {
                Toast.makeText(context , "$lastname a $age ans", Toast.LENGTH_LONG).show()

            }) {
            Text(text = "Valider")
        }
    }
}


@Composable
@Preview
fun Preview() {
    Form()
}










