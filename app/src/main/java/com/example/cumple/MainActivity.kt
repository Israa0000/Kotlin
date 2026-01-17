package com.example.cumple

import android.media.Image
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.content.MediaType.Companion.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.semantics.Role.Companion.Image
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.cumple.ui.theme.CumpleTheme

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        setContent {
            CumpleTheme {
                Surface( //es una linea pero se tabula,
                    modifier = Modifier.fillMaxSize()  //modificador es como una propiedad de css
                ) { //es una funcion y dentro tiene otra funcion (greeting)
                    Greeting(
                        años = "30",
                        nombre = "Charlie Kirk"
                    )
                }
            }
        }
    }
}

@Composable
fun Greeting(años: String, modifier: Modifier = Modifier,nombre : String) {

    val image = painterResource(R.drawable._2df04cd_c4c9_4f27_8b1b_a5e2974af753)


    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = modifier
            .fillMaxSize()
        ){

        Image(
            painter = image,
            contentDescription = null,
            //alpha = 0.5F,
            contentScale = ContentScale.Fit
        )

        Text (//tres elementos basicos: box, column, row
            text = stringResource(R.string.feliz_cumplea_os, años),
            fontWeight = FontWeight.Bold,
            fontSize = 36.sp,
            lineHeight = 40.sp,
            textAlign = TextAlign.Center,
            modifier = modifier
                .padding(15.dp)
        )
        Text(
            text = stringResource(R.string.nombre, nombre)
        )
    }
}

@Preview(showBackground = true, showSystemUi = true, device = "spec:width=411dp,height=891dp")
@Composable
fun GreetingPreview() {
    CumpleTheme {
        Greeting("30",nombre = "Charlie Kirk")
    }
}