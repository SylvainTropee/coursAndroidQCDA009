package com.example.mod5demo4

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Face
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import com.example.mod5demo4.ui.theme.CoursAndroidQCDA009Theme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            CoursAndroidQCDA009Theme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    PasswordTextField(modifier = Modifier.padding(innerPadding))
                }
            }
        }
    }
}

const val TEXT_TAG_TEXFIELD_PWD = "TextFieldPassword"

@Composable
fun PasswordTextField(modifier: Modifier = Modifier) {

    var password by remember {
        mutableStateOf("")
    }
    var isPasswordVisible by remember {
        mutableStateOf(false)
    }

    TextField(
        modifier = modifier.fillMaxWidth().testTag(TEXT_TAG_TEXFIELD_PWD),
        value = password,
        onValueChange = {
            password = it
        },
        visualTransformation = if (isPasswordVisible) {
            VisualTransformation.None
        } else {
            PasswordVisualTransformation()
        },
        label = { Text(text = "Mot de passe") },
        singleLine = true,
        placeholder = { Text(text = "Mot de passe") },
        trailingIcon = {

            val icon = if (isPasswordVisible) {
                Icons.Default.Face
            } else {
                Icons.Default.Lock
            }
            val description = if (isPasswordVisible) {
                "Cacher mot de passe"
            } else {
                "Montrer mot de passe"
            }

            Icon(
                imageVector = icon,
                contentDescription = description,
                modifier = Modifier.clickable {
                    isPasswordVisible = !isPasswordVisible
                }
            )
        }
    )
}

@Preview
@Composable
fun Preview() {
    PasswordTextField()
}









