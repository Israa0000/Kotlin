package com.example.cumple

import android.R.attr.fontWeight
import android.health.connect.datatypes.ExercisePerformanceGoal
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.paddingFrom
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.cumple.ui.theme.CumpleTheme

class Ejercicio : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            CumpleTheme {
                Surface(modifier = Modifier.fillMaxSize()
                ){
                    Greeting2(
                        titulo = "Jetpack Compose Tutorial",
                        texto = "Jetpack Compose is a modern toolkit for building Native Android UI. ",
                        modifier = Modifier.padding()
                    )
                }
            }
        }
    }
}

@Composable
fun Greeting2(titulo: String,texto : String, modifier: Modifier = Modifier) {

    Row(
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.Center,
        modifier = modifier.fillMaxWidth()

    ) {
        Column(
            modifier.weight(1f)
                .background(Color.Cyan)
                .fillMaxSize(0.5f),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally,
        ) {
            Text(
                text = titulo,
                modifier = modifier.padding(10.dp,0.dp,0.dp,0.dp)
            )
            Text(
                text = texto,
            )
        }
        Column(
            modifier.weight(1f)
                .background(Color.Blue)
                .fillMaxSize(0.5f),

        verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally,
        ) {
            Text(
                text = titulo,
                modifier = modifier
                    .padding(10.dp,0.dp,0.dp,0.dp)
            )
            Text(
                text = texto,
            )
        }
    }
    Row(
        verticalAlignment = Alignment.Bottom,
        horizontalArrangement = Arrangement.End,
        modifier = modifier.padding()
            .fillMaxWidth()
            .fillMaxSize()


    ) {
        Column(
            modifier.weight(1f)
                .background(Color.Blue)
                .fillMaxSize(0.5f),

            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally,
        ) {
            Text(
                text = titulo,
                modifier = modifier
                    .padding(10.dp,0.dp,0.dp,0.dp)
            )
            Text(
                text = texto,
            )
        }
        Column(
            modifier.weight(1f)
                .background(Color.Cyan)
                .fillMaxSize(0.5f),

            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally,

        ) {
            Text(
                text = titulo,
                modifier = modifier
                    .padding(10.dp,0.dp,0.dp,0.dp)
            )
            Text(
                text = texto,
            )
        }
    }
}


@Preview(showBackground = true, showSystemUi = true, device = "spec:width=411dp,height=891dp")
@Composable
fun Greeting2Preview() {
    CumpleTheme {
        Greeting2("Hola como va la cosa,",
            " Se que es duro, pero tu puedes"
        )
    }
}