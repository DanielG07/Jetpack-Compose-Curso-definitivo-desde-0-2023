package com.example.jetpackcomposecatalogo

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.jetpackcomposecatalogo.ui.theme.JetpackComposeCatalogoTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            var myText by remember {
                mutableStateOf("")
            }

            JetpackComposeCatalogoTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background,
                ) {
                    MyButtonExample()
                }
            }
        }
    }
}

@Composable
fun MyButtonExample() {
    var enabled by rememberSaveable { mutableStateOf(true) }

    Column(
        modifier =
            Modifier
                .fillMaxSize()
                .padding(24.dp),
    ) {
        Button(
            enabled = enabled,
            colors =
                ButtonDefaults.buttonColors(
                    containerColor = Color.Magenta,
                    contentColor = Color.Blue,
                ),
            border = BorderStroke(5.dp, Color.Green),
            onClick = {
                enabled = false
                Log.i("Daniel", "Esto es un ejemplo")
            },
        ) {
            Text(text = "Hola")
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MyTextFieldOutlined(
    myText: String,
    onValueChange: (String) -> Unit,
) {
    OutlinedTextField(
        value = myText,
        onValueChange = { newText ->
            onValueChange(newText)
        },
        modifier = Modifier.padding(8.dp),
        label = { Text(text = "Nombre") },
        colors =
            TextFieldDefaults.outlinedTextFieldColors(
                focusedBorderColor = Color.Magenta,
                unfocusedBorderColor = Color.Blue,
            ),
    )
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MyAdvanceTextField() {
    var myText by remember {
        mutableStateOf("")
    }

    TextField(
        value = myText,
        onValueChange = { newText ->
            myText =
                if (newText.contains("a")) {
                    newText.replace("a", "")
                } else {
                    newText
                }
        },
        label = { Text(text = "Introduce tu nombre") },
    )
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MyTextField() {
    var myText by remember {
        mutableStateOf("")
    }

    TextField(value = myText, onValueChange = { newText ->
        myText = newText
    })
}

@Composable
fun MyText() {
    Column(modifier = Modifier.fillMaxSize()) {
        Text(text = "Esto es un ejemplo")
        Text(text = "Esto es un ejemplo", color = Color.Blue)
        Text(text = "Esto es un ejemplo", fontWeight = FontWeight.ExtraBold)
        Text(text = "Esto es un ejemplo", style = TextStyle(fontFamily = FontFamily.Cursive))
        Text(
            text = "Esto es un ejemplo",
            style = TextStyle(textDecoration = TextDecoration.LineThrough),
        )
        Text(
            text = "Esto es un ejemplo",
            style = TextStyle(textDecoration = TextDecoration.Underline),
        )
        Text(
            text = "Esto es un ejemplo",
            style =
                TextStyle(
                    textDecoration =
                        TextDecoration.combine(
                            listOf(TextDecoration.LineThrough, TextDecoration.Underline),
                        ),
                ),
        )
        Text(text = "Esto es un ejemplo", fontSize = 36.sp)
    }
}

@Composable
fun MyStateExample() {
    var counter by rememberSaveable { mutableStateOf(0) }
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        Button(onClick = {
            counter += 1
        }) {
            Text(text = "Pulsar")
        }
        Text(text = "He sido pulsado $counter veces")
    }
}

@Composable
fun MyComplexLayout() {
    Column(modifier = Modifier.fillMaxSize()) {
        Box(
            modifier =
                Modifier
                    .fillMaxSize()
                    .weight(1f)
                    .background(Color.Cyan),
            contentAlignment = Alignment.Center,
        ) {
            Text(text = "Ejemplo 1")
        }
        MySpacer(10)
        Row(
            modifier =
                Modifier
                    .fillMaxWidth()
                    .weight(1f),
        ) {
            Box(
                modifier =
                    Modifier
                        .weight(1f)
                        .fillMaxHeight()
                        .background(Color.Red),
                contentAlignment = Alignment.Center,
            ) {
                Text(text = "Ejemplo 2")
            }
            Box(
                modifier =
                    Modifier
                        .weight(1f)
                        .fillMaxHeight()
                        .background(Color.Green),
                contentAlignment = Alignment.Center,
            ) {
                Text(text = "Ejemplo 3")
            }
        }
        MySpacer(10)
        Box(
            modifier =
                Modifier
                    .fillMaxWidth()
                    .weight(1f)
                    .background(Color.Magenta),
            contentAlignment = Alignment.BottomCenter,
        ) {
            Text(text = "Ejemplo 4")
        }
    }
}

@Composable
fun MySpacer(size: Int) {
    Spacer(modifier = Modifier.height(size.dp))
}

@Composable
fun MyRow() {
    Row(
        modifier =
            Modifier
                .fillMaxSize()
                .horizontalScroll(rememberScrollState()),
        horizontalArrangement = Arrangement.SpaceBetween,
    ) {
        Text(text = "Ejemplo 2", modifier = Modifier.background(Color.Red))
        Text(text = "Ejemplo 3", modifier = Modifier.background(Color.Black))
        Text(text = "Ejemplo 1", modifier = Modifier.background(Color.Cyan))
        Text(text = "Ejemplo 4", modifier = Modifier.background(Color.Blue))
    }
}

@Composable
fun MyColumn() {
    Column(
        modifier =
            Modifier
                .fillMaxSize()
                .verticalScroll(rememberScrollState()),
        verticalArrangement = Arrangement.SpaceBetween,
    ) {
        Text(text = "Ejemplo 2", modifier = Modifier.background(Color.Red))
        Text(text = "Ejemplo 3", modifier = Modifier.background(Color.Black))
        Text(text = "Ejemplo 1", modifier = Modifier.background(Color.Cyan))
        Text(text = "Ejemplo 4", modifier = Modifier.background(Color.Blue))
    }
}

@Composable
fun MyBox() {
    Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
        Box(
            modifier =
                Modifier
                    .width(200.dp)
                    .height(200.dp)
                    .background(Color.Cyan)
                    .verticalScroll(rememberScrollState()),
            contentAlignment = Alignment.Center,
        ) {
            Text(text = "Esto es un EJEMPLO")
        }
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    JetpackComposeCatalogoTheme {
        MyButtonExample()
    }
}
