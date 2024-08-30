package com.example.jetpackcomposecatalogo

import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Slider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment

@Composable
fun MyBasicSlider() {
    var sliderPositions by remember {
        mutableStateOf(0F)
    }

    Column(
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Slider(value = sliderPositions, onValueChange = {
            sliderPositions = it
        })
        Text(text = sliderPositions.toString())
    }

}
