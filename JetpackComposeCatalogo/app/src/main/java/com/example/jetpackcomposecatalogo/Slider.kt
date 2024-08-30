package com.example.jetpackcomposecatalogo

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Slider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun MyBasicSlider() {
    var sliderPositions by remember {
        mutableStateOf(0F)
    }

    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        Slider(value = sliderPositions, onValueChange = {
            sliderPositions = it
        })
        Text(text = sliderPositions.toString())
    }
}

@Composable
fun MyAdvanceSlider() {
    var sliderPositions by remember {
        mutableStateOf(0f)
    }

    var completeValue by remember {
        mutableStateOf("")
    }

    Column(
        modifier = Modifier.padding(horizontal = 8.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        Slider(
            value = sliderPositions,
            onValueChange = {
                sliderPositions = it
            },
            valueRange = 0f..100f,
            steps = 99, // Siempre quitar dos, ya que no se toma en cuenta el primero ni el ultimo
            onValueChangeFinished = {
                completeValue = sliderPositions.toString()
            },
        )
        Text(text = completeValue)
    }
}
