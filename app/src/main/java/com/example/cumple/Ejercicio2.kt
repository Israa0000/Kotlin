package com.example.cumple

import android.R.attr.text
import android.media.Image
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.modifier.ModifierLocalReadScope
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import com.example.cumple.ui.theme.CumpleTheme

class Ejercicio2 : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            CumpleTheme {
                Surface(modifier = Modifier.fillMaxSize()
                ) {
                    diceWithButton()
                }
            }
        }
    }
}

@Composable
fun diceWithButton(modifier: Modifier = Modifier){

    var result by remember{ mutableStateOf(1) }
    var ImageDice =
        when(result){
            1-> (R.drawable.dice_1)
            2->(R.drawable.dice_2)
            3-> (R.drawable.dice_3)
            4-> (R.drawable.dice_4)
            5-> (R.drawable.dice_5)
            else -> (R.drawable.dice_6)
        }

    Column(
        modifier = modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Image(
            painter = painterResource(ImageDice),
            contentDescription = result.toString()
        )
        Button(
            onClick = {
                result =  (1 .. 6).random()
            }
        ){
            Text(
                text = "Roll"
            )
        }
    }
}

fun Test(){

}


@Preview(showBackground = true, showSystemUi = true, device = "spec:width=411dp,height=891dp")
@Composable
fun Preview(){
    diceWithButton()
}

@Preview(showBackground = true, showSystemUi = true, device = "spec:width=411dp,height=891dp,orientation=landscape")
@Composable
fun PreviewLandscape(){
    diceWithButton()
}
