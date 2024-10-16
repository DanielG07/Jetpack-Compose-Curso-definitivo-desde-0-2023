package com.example.jetpackcomposecatalogo

import androidx.annotation.DrawableRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Divider
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.window.Dialog
import androidx.compose.ui.window.DialogProperties

@Composable
fun MyConfirmationDialog(
    show: Boolean,
    onDismiss: () -> Unit,
) {
    if (show) {
        Dialog(
            onDismissRequest = { onDismiss() },
        ) {
            Column(
                modifier =
                    Modifier
                        .fillMaxWidth()
                        .background(Color.White),
            ) {
                MyTitleDialog(
                    text = "Phone ringtone",
                    modifier = Modifier.padding(24.dp),
                )
                Divider(
                    modifier = Modifier.fillMaxWidth(),
                    color = Color.LightGray,
                )

                var status by remember {
                    mutableStateOf("")
                }
                MyRadioButtonList(name = status, onItemSelected = { status = it })

                Divider(
                    modifier = Modifier.fillMaxWidth(),
                    color = Color.LightGray,
                )
                Row(
                    modifier =
                        Modifier
                            .align(Alignment.End)
                            .padding(8.dp),
                ) {
                    TextButton(onClick = { /*TODO*/ }) {
                        Text(text = "CANCEL")
                    }

                    TextButton(onClick = { /*TODO*/ }) {
                        Text(text = "OK")
                    }
                }
            }
        }
    }
}

@Composable
fun MyCustomDialog(
    show: Boolean,
    onDismiss: () -> Unit,
) {
    if (show) {
        Dialog(
            onDismissRequest = { onDismiss() },
        ) {
            Column(
                modifier =
                    Modifier
                        .background(Color.White)
                        .padding(24.dp)
                        .fillMaxWidth(),
            ) {
                MyTitleDialog(text = "Set backup account")
                AccountItem(
                    email = "ejemplo1@gmail.com",
                    drawable = R.drawable.dsc05626,
                )
                AccountItem(
                    email = "ejemplo2@gmail.com",
                    drawable = R.drawable.dsc05626,
                )
                AccountItem(
                    email = "Añadir nueva cuenta",
                    drawable = R.drawable.dsc05626,
                )
            }
        }
    }
}

@Composable
fun MyCustomAlertDialog(
    show: Boolean,
    onDismiss: () -> Unit,
) {
    if (show) {
        Dialog(
            onDismissRequest = onDismiss,
            properties =
                DialogProperties(
                    dismissOnBackPress = false,
                    dismissOnClickOutside = false,
                ),
        ) {
            Column(
                modifier =
                    Modifier
                        .background(Color.White)
                        .padding(24.dp)
                        .fillMaxWidth(),
            ) {
                Text(text = "Esto es un ejemplo")
            }
        }
    }
}

@Composable
fun MyDialog(
    show: Boolean,
    onConfirm: () -> Unit,
    onDismiss: () -> Unit,
) {
    if (show) {
        AlertDialog(
            title = {
                Text(text = "Titulo")
            },
            text = {
                Text(text = "Hola soy una descripción super padre")
            },
            confirmButton = {
                TextButton(onClick = { onConfirm() }) {
                    Text(text = "Confirmar")
                }
            },
            onDismissRequest = { onDismiss() },
            dismissButton = {
                TextButton(onClick = { onDismiss() }) {
                    Text(text = "Denegar")
                }
            },
        )
    }
}

@Composable
fun MyTitleDialog(
    text: String,
    modifier: Modifier = Modifier.padding(bottom = 12.dp),
) {
    Text(
        text = text,
        fontWeight = FontWeight.SemiBold,
        fontSize = 20.sp,
        modifier = modifier,
    )
}

@Composable
fun AccountItem(
    email: String,
    @DrawableRes drawable: Int,
) {
    Row {
        Image(
            painter = painterResource(id = drawable),
            contentDescription = "avatar",
            contentScale = ContentScale.Crop,
            modifier =
                Modifier
                    .padding(8.dp)
                    .size(40.dp)
                    .clip(CircleShape),
        )

        Text(
            text = email,
            fontSize = 14.sp,
            color = Color.Gray,
            modifier = Modifier.padding(8.dp),
        )
    }
}
