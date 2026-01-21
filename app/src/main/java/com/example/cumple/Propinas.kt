package com.example.cumple

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.safeDrawing
import androidx.compose.foundation.layout.safeDrawingPadding
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.MaterialTheme
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
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.cumple.ui.theme.CumpleTheme
import java.text.NumberFormat

class Propinas : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            CumpleTheme {
                Surface() {
                    tipTimeLayout()

                }
            }
        }
    }
    @Composable
    fun tipTimeLayout() {

        var inputText by remember { mutableStateOf("") }
        var porcentajeText by remember {mutableStateOf("")}

        val total = inputText.toDoubleOrNull() ?: 0.0
        val porcentaje = porcentajeText.toDoubleOrNull() ?: 0.0

        val tip = calculateTip(total, porcentaje)

        Column(
            modifier = Modifier
                .padding(40.dp)
                .statusBarsPadding()
                .fillMaxSize()
                .safeDrawingPadding(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center,
        ){
            Text(
                text = "Propina",
                modifier = Modifier.padding(bottom = 16.dp, top = 40.dp)
                    .align(alignment = Alignment.Start)
            )

            NumberTextField(
                label = "Cantidad",
                value = inputText,
                onValueChange = {inputText = it},
                modifier = Modifier.padding(bottom = 32.dp)
                    .fillMaxWidth()
            )

            NumberTextField(
                label = "Porcentaje",
                value = porcentajeText,
                onValueChange = {porcentajeText = it},
                modifier = Modifier.padding(bottom = 32.dp)
                    .fillMaxWidth(),
            )

            Text(
                text = "propina de $tip",
                style = MaterialTheme.typography.displaySmall
            )

            Spacer(modifier = Modifier.height(150.dp))
        }
    }

    private fun calculateTip(amount: Double, tipPercent: Double = 15.0): String {
        val tip = tipPercent / 100 * amount
        return NumberFormat.getCurrencyInstance().format(tip)
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

    @Preview(showBackground = true, showSystemUi = true)
    @Composable
    fun propinasPreview3() {
        CumpleTheme {
            tipTimeLayout()
        }
    }
}

