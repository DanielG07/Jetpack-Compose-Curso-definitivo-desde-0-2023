package com.example.jetpackcomposecatalogo

import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable

@Composable
fun MySimpleRecyclerView() {
    val myList = listOf("Daniel", "Mauricio", "Alejandra")

    LazyRow {
        item { Text(text = "Header") }
        items(7) {
            Text(text = "Este es el item $it")
        }
        items(myList) {
            Text(text = "Mi nombre es $it")
        }
        item { Text(text = "Footer") }
    }
}
