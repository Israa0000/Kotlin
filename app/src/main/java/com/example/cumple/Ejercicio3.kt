package com.example.cumple

import android.R.attr.password
import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.cumple.ui.theme.CumpleTheme

class Ejercicio3 : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            CumpleTheme {
                Surface(modifier = Modifier.fillMaxSize()) {
                    InputTexto(
                    )
                }
            }
        }
    }
    @Composable
    fun InputTexto(modifier: Modifier = Modifier) {
        val context = LocalContext.current

        var textoUsuario by remember { mutableStateOf("") }
        var textoContraseña by remember { mutableStateOf("") }

        var mensajeResultado by remember { mutableStateOf("") }


        Column (
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = modifier.fillMaxSize()
        ){
            var image = painterResource(R.drawable.icono_perfil)

            Image(
                painter = image,
                contentDescription = null,
                modifier = modifier.size(100.dp)
            )

            NumberTextField(
                label = "Usuario",
                value = textoUsuario,
                onValueChange = {textoUsuario = it},
                modifier = modifier.padding(bottom = 32.dp)
            )

            NumberTextField(
                label = "Contraseña",
                value = textoContraseña,
                onValueChange = {textoContraseña = it},
                modifier = modifier
            )
            Button(
                onClick = {
                    if (textoUsuario.isEmpty() || textoContraseña.isEmpty()) {
                        mensajeResultado = "Error"
                        Toast.makeText(context, mensajeResultado, Toast.LENGTH_LONG).show()
                    } else {
                        mensajeResultado = "Login valido"
                        Toast.makeText(context, mensajeResultado, Toast.LENGTH_LONG).show()

                    }
                }
            ) {
                Text(
                    text = "Login"
                )
            }

        }
    }

    @Composable
    fun NumberTextField(label : String, value : String, onValueChange : (String) -> Unit,modifier : Modifier = Modifier){//hacemos el proceso de abstraccion con esta funcion

        TextField(
            label = {
                Text(
                    text = label
                )
            },
            value = value,
            onValueChange = onValueChange, // v ->
            singleLine = true,
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
            modifier = modifier,
        )
    }


    @Preview(showBackground = true, device = "spec:width=411dp,height=891dp", showSystemUi = true)
    @Composable
    fun GreetingPreview2() {
        CumpleTheme {
            InputTexto()
        }
    }
}

