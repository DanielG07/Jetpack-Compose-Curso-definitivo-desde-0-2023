package com.example.jetpackcomposecatalogo

import android.widget.Toast
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.jetpackcomposecatalogo.model.SuperHero
import kotlinx.coroutines.launch

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun MySuperHeroStickyView() {
    val context = LocalContext.current
    val superHeroes: Map<String, List<SuperHero>> = getSuperHero().groupBy { it.publisher }
    LazyColumn(
        verticalArrangement = Arrangement.spacedBy(8.dp),
    ) {
        superHeroes.forEach { (publisher, mySuperHero) ->

            stickyHeader {
                Text(
                    text = publisher,
                    modifier = Modifier.fillMaxWidth().background(Color.Green),
                    fontSize = 16.sp,
                    color = Color.White,
                )
            }

            items(mySuperHero) { superhero ->
                ItemHero(superHero = superhero) {
                    Toast.makeText(context, it.superHeroName, Toast.LENGTH_SHORT).show()
                }
            }
        }
    }
}

@Composable
fun MySuperHeroSpecialControlView() {
    val context = LocalContext.current
    val rvState = rememberLazyListState()
    val coroutineScope = rememberCoroutineScope()
    Column {
        LazyColumn(
            state = rvState,
            verticalArrangement = Arrangement.spacedBy(8.dp),
            modifier = Modifier.weight(1f),
        ) {
            items(getSuperHero()) { superhero ->
                ItemHero(superHero = superhero) {
                    Toast.makeText(context, it.superHeroName, Toast.LENGTH_SHORT).show()
                }
            }
        }

        val showButton by remember {
            derivedStateOf {
                rvState.firstVisibleItemIndex > 0
            }
        }

        rvState.firstVisibleItemScrollOffset

        if (showButton) {
            Button(onClick = {
                coroutineScope.launch {
                    rvState.animateScrollToItem(0)
                }
            }, modifier = Modifier.align(Alignment.CenterHorizontally)) {
                Text(text = "Soy un boton cool")
            }
        }
    }
}

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
fun MySuperHeroGridView() {
    val context = LocalContext.current
    LazyVerticalGrid(
        columns = GridCells.Adaptive(150.dp),
        verticalArrangement = Arrangement.spacedBy(8.dp),
        horizontalArrangement = Arrangement.spacedBy(4.dp),
        content = {
            items(getSuperHero()) { superhero ->
                ItemHero(superHero = superhero) {
                    Toast.makeText(context, it.superHeroName, Toast.LENGTH_SHORT).show()
                }
            }
        },
    )
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
        modifier =
            Modifier
                .fillMaxWidth()
                .clickable { onItemSelected(superHero) },
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
        SuperHero("Wolverine", "James Howlett", "Marvel", R.drawable.logan),
        SuperHero("Batman", "Bruce Wayne", "DC", R.drawable.batman),
        SuperHero("Thor", "Thor Odinson", "Marvel", R.drawable.thor),
        SuperHero("Flash", "Jay Garrick", "DC", R.drawable.flash),
        SuperHero("Green Lanter", "Alan Scott", "DC", R.drawable.green_lantern),
        SuperHero("Wonder Woman", "Princess Diana", "DC", R.drawable.wonder_woman),
    )
