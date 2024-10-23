package com.example.jetpackcomposecatalogo

import android.widget.Toast
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.jetpackcomposecatalogo.model.SuperHero

@Composable
fun MySimpleRecyclerView() {
    val myList = listOf("Daniel", "Mauricio", "Alejandra")

    LazyColumn {
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

@Composable
fun MySuperHeroView() {
    val context = LocalContext.current
    LazyRow(horizontalArrangement = Arrangement.spacedBy(8.dp)) {
        items(getSuperHero()) { superhero ->
            ItemHero(superHero = superhero) {
                Toast.makeText(context, it.superHeroName, Toast.LENGTH_SHORT).show()
            }
        }
    }
}

@Composable
fun ItemHero(
    superHero: SuperHero,
    onItemSelected: (SuperHero) -> Unit,
) {
    Card(
        border = BorderStroke(2.dp, Color.Red),
        modifier = Modifier.width(200.dp).clickable { onItemSelected(superHero) },
    ) {
        Column {
            Image(
                painter = painterResource(id = superHero.photo),
                contentDescription = "SuperHero Avatar",
                modifier = Modifier.fillMaxWidth(),
                contentScale = ContentScale.Crop,
            )
            Text(
                text = superHero.superHeroName,
                modifier = Modifier.align(Alignment.CenterHorizontally),
            )
            Text(
                text = superHero.realName,
                modifier = Modifier.align(Alignment.CenterHorizontally),
                fontSize = 12.sp,
            )
            Text(
                text = superHero.publisher,
                fontSize = 10.sp,
                modifier =
                    Modifier
                        .align(Alignment.End)
                        .padding(bottom = 4.dp, end = 4.dp),
            )
        }
    }
}

fun getSuperHero(): List<SuperHero> =
    listOf(
        SuperHero("Spiderman", "Petter Parker", "Marvel", R.drawable.spiderman),
        SuperHero("Spiderman1", "Petter Parker", "Marvel", R.drawable.logan),
        SuperHero("Spiderman2", "Petter Parker", "Marvel", R.drawable.batman),
        SuperHero("Spiderman3", "Petter Parker", "Marvel", R.drawable.thor),
        SuperHero("Spiderman4", "Petter Parker", "Marvel", R.drawable.flash),
        SuperHero("Spiderman5", "Petter Parker", "Marvel", R.drawable.green_lantern),
        SuperHero("Spiderman6", "Petter Parker", "Marvel", R.drawable.wonder_woman),
    )
