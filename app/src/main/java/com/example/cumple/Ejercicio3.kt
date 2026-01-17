package com.example.cumple

import android.R.attr.password
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
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
import androidx.compose.ui.res.painterResource
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
}

@Composable
fun InputTexto(modifier: Modifier = Modifier) {

    var textoUsuario by remember { mutableStateOf("") }
    var textoContraseña by remember { mutableStateOf("") }

    var error by remember { mutableStateOf(false) }


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

        TextField(
        value = textoUsuario,
        label = {
            Text(
                text = "Usuario"
            )
        },
        onValueChange = {
            textoUsuario = it // it = a de for(a in array) iteracion
        },
            isError = error,
            modifier = modifier.padding(25.dp)
    )
        TextField(
            value = textoContraseña,
            label = {
                Text(
                    text = "Contraseña",
                    )
            },
            onValueChange = {
                textoContraseña = it
            },
            isError = error,
            modifier = modifier.padding(50.dp)
        )

        Button(
            onClick = {
                error = textoUsuario.isEmpty() || textoContraseña.isEmpty()
            }
        ) {
            Text(
                text = "Login"
        )
        }
        Text(
            text = if(!error){
                ""
            }else{
                "Error"
            }
        )
    }
}

@Preview(showBackground = true, device = "spec:width=411dp,height=891dp", showSystemUi = true)
@Composable
fun GreetingPreview2() {
    CumpleTheme {
        InputTexto()
    }
}