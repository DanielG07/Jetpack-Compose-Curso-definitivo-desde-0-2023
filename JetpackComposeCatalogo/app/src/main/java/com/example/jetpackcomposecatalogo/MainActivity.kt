package com.example.jetpackcomposecatalogo

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
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
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Star
import androidx.compose.material.icons.outlined.Star
import androidx.compose.material.icons.sharp.Star
import androidx.compose.material3.Badge
import androidx.compose.material3.BadgedBox
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Checkbox
import androidx.compose.material3.CheckboxDefaults
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Divider
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.LinearProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.RadioButton
import androidx.compose.material3.RadioButtonDefaults
import androidx.compose.material3.Surface
import androidx.compose.material3.Switch
import androidx.compose.material3.SwitchDefaults
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.material3.TriStateCheckbox
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.state.ToggleableState
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.jetpackcomposecatalogo.model.Routes.*
import com.example.jetpackcomposecatalogo.ui.CheckInfo
import com.example.jetpackcomposecatalogo.ui.theme.JetpackComposeCatalogoTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            JetpackComposeCatalogoTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    color = MaterialTheme.colorScheme.background,
                ) {
                    CrossfadeExampleAnimation()
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    JetpackComposeCatalogoTheme {
        MyConfirmationDialog(
            show = true,
            onDismiss = {
                Log.i("Dialog", "Dismiss")
            },
        )
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MyDropDownMenu() {
    var selectedText by remember {
        mutableStateOf("")
    }

    var expanded by remember {
        mutableStateOf(false)
    }

    val desserts =
        listOf(
            "Chocolate",
            "Cafe",
            "Helado",
            "Fruta",
            "Chilaquiles",
        )

    Column(
        modifier = Modifier.padding(20.dp),
    ) {
        OutlinedTextField(
            value = selectedText,
            onValueChange = { selectedText = it },
            enabled = false,
            readOnly = true,
            modifier =
                Modifier
                    .clickable { expanded = true }
                    .fillMaxWidth(),
        )
        DropdownMenu(
            expanded = expanded,
            onDismissRequest = { expanded = false },
            modifier = Modifier.fillMaxWidth(),
        ) {
            desserts.forEach { dessert ->
                DropdownMenuItem(
                    text = { dessert },
                    onClick = {
                        expanded = false
                        selectedText = dessert
                    },
                )
            }
        }
    }
}

@Composable
fun MyDivider() {
    Divider(
        modifier =
            Modifier
                .fillMaxWidth()
                .padding(16.dp),
        color = Color.Red,
    )
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MyBadgeBox() {
    BadgedBox(
        badge = {
            Badge(
                content = {
                    Text(text = "100")
                },
                contentColor = Color.Blue,
            )
        },
        modifier = Modifier.padding(16.dp),
    ) {
        Icon(imageVector = Icons.Default.Star, contentDescription = "a")
    }
}

@Composable
fun MyCard() {
    Card(
        modifier =
            Modifier
                .fillMaxWidth()
                .padding(16.dp),
        elevation =
            CardDefaults.cardElevation(
                defaultElevation = 16.dp,
            ),
        shape = MaterialTheme.shapes.small,
        colors =
            CardDefaults.cardColors(
                containerColor = Color.Red,
                contentColor = Color.Green,
            ),
        border = BorderStroke(5.dp, Color.Green),
    ) {
        Column(modifier = Modifier.padding(16.dp)) {
            Text(text = "Ejemplo 1")
            Text(text = "Ejemplo 2")
            Text(text = "Ejemplo 3")
        }
    }
}

@Composable
fun MyRadioButtonList(
    name: String,
    onItemSelected: (String) -> Unit,
) {
    Column(
        modifier = Modifier.fillMaxWidth(),
    ) {
        Row {
            RadioButton(
                selected = name == "Dani",
                onClick = { onItemSelected("Dani") },
            )
            Text(text = "Dani")
        }
        Row {
            RadioButton(
                selected = name == "Daniel",
                onClick = { onItemSelected("Daniel") },
            )
            Text(text = "Daniel")
        }
        Row {
            RadioButton(
                selected = name == "Daniela",
                onClick = { onItemSelected("Daniela") },
            )
            Text(text = "Daniela")
        }
        Row {
            RadioButton(
                selected = name == "Danielito",
                onClick = { onItemSelected("Danielito") },
            )
            Text(text = "Danielito")
        }
    }
}

@Composable
fun MyRadioButton() {
    var state by rememberSaveable {
        mutableStateOf(false)
    }

    Row(
        modifier = Modifier.fillMaxWidth(),
    ) {
        RadioButton(
            selected = state,
            onClick = { state = !state },
            colors =
                RadioButtonDefaults.colors(
                    selectedColor = Color.Red,
                    unselectedColor = Color.Yellow,
                    disabledSelectedColor = Color.Green,
                    disabledUnselectedColor = Color.Green,
                ),
        )
        Text(text = "Ejemplo 1")
    }
}

@Composable
fun MyTriStatusCheckBox() {
    var status by rememberSaveable {
        mutableStateOf(ToggleableState.Off)
    }

    TriStateCheckbox(state = status, onClick = {
        status =
            when (status) {
                ToggleableState.Off -> ToggleableState.Indeterminate
                ToggleableState.On -> ToggleableState.Off
                ToggleableState.Indeterminate -> ToggleableState.On
            }
    })
}

@Composable
fun getOptions(titles: List<String>): List<CheckInfo> =
    titles.map {
        var status by rememberSaveable {
            mutableStateOf(false)
        }
        CheckInfo(
            title = it,
            selected = status,
            onCheckedChange = { status = it },
        )
    }

@Composable
fun MyCheckBoxWithTextComplete(checkInfo: CheckInfo) {
    Row(
        modifier = Modifier.padding(8.dp),
        verticalAlignment = Alignment.CenterVertically,
    ) {
        Checkbox(
            checked = checkInfo.selected,
            onCheckedChange = { checkInfo.onCheckedChange(!checkInfo.selected) },
        )
        Spacer(modifier = Modifier.width(8.dp))
        Text(text = checkInfo.title)
    }
}

@Composable
fun MyCheckBoxWithText() {
    var state by rememberSaveable {
        mutableStateOf(false)
    }

    Row(
        modifier = Modifier.padding(8.dp),
        verticalAlignment = Alignment.CenterVertically,
    ) {
        Checkbox(checked = state, onCheckedChange = { state = !state })
        Spacer(modifier = Modifier.width(8.dp))
        Text(text = "Ejemplo 1")
    }
}

@Composable
fun MyCheckBox() {
    var state by rememberSaveable {
        mutableStateOf(false)
    }

    Checkbox(
        checked = state,
        onCheckedChange = { state = !state },
        enabled = true,
        colors =
            CheckboxDefaults.colors(
                checkedColor = Color.Red,
                uncheckedColor = Color.Yellow,
                checkmarkColor = Color.Blue,
            ),
    )
}

@Composable
fun MySwitch() {
    var state by rememberSaveable {
        mutableStateOf(true)
    }

    Switch(
        checked = state,
        onCheckedChange = {
            state = !state
        },
        enabled = true,
        colors =
            SwitchDefaults.colors(
                uncheckedThumbColor = Color.Red,
                uncheckedTrackColor = Color.Magenta,
                checkedThumbColor = Color.Green,
                checkedTrackColor = Color.Cyan,
            ),
    )
}

@Composable
fun MyProgressAdvance() {
    var progressBar by rememberSaveable {
        mutableStateOf(0.0F)
    }

    Column(
        modifier =
            Modifier
                .padding(24.dp)
                .fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        CircularProgressIndicator(
            progress = progressBar,
        )

        LinearProgressIndicator(
            progress = progressBar,
        )

        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceEvenly,
        ) {
            Button(onClick = { progressBar -= 0.1F }) {
                Text(text = "Reducir")
            }
            Button(onClick = { progressBar += 0.1F }) {
                Text(text = "Incrementar")
            }
        }
    }
}

@Composable
fun MyProgress() {
    var showLoading by rememberSaveable {
        mutableStateOf(false)
    }

    Column(
        modifier =
            Modifier
                .padding(24.dp)
                .fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        if (showLoading) {
            CircularProgressIndicator(
                color = Color.Red,
                strokeWidth = 8.dp,
            )
            LinearProgressIndicator(
                modifier = Modifier.padding(top = 12.dp),
                trackColor = Color.Red,
                color = Color.Green,
            )
        }
        Button(onClick = { showLoading = !showLoading }) {
            Text(text = "Cargar")
        }
    }
}

@Composable
fun MyIcon() {
    Icon(
        imageVector = Icons.Outlined.Star,
        contentDescription = "star",
        tint = Color.Red,
    )
}

@Composable
fun MyImageAdvance() {
    Image(
        painter = painterResource(id = R.drawable.ic_launcher_background),
        contentDescription = "ejemplo",
        modifier =
            Modifier
                .clip(RoundedCornerShape(25.dp))
                .border(5.dp, Color.Red, RoundedCornerShape(25.dp)),
    )
}

@Composable
fun MyImage() {
    Image(
        painter = painterResource(id = R.drawable.ic_launcher_background),
        contentDescription = "ejemplo",
    )
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

        OutlinedButton(
            modifier = Modifier.padding(top = 8.dp),
            colors =
                ButtonDefaults.buttonColors(
                    containerColor = Color.Magenta,
                    contentColor = Color.Blue,
                    disabledContainerColor = Color.Blue,
                    disabledContentColor = Color.Red,
                ),
            enabled = enabled,
            onClick = { enabled = false },
        ) {
            Text(text = "Hola Outlined")
        }

        TextButton(onClick = { enabled = false }) {
            Text(text = "Hola TextButton")
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
