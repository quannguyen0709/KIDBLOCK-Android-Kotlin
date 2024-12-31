@file:OptIn(ExperimentalMaterial3Api::class)

package com.example.kidlock.uilayer.compose

import android.view.View
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.TextField
import androidx.compose.material.TextFieldDefaults
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.focus.FocusDirection
import androidx.compose.ui.focus.FocusRequester
import androidx.compose.ui.focus.focusRequester
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.unit.dp
import androidx.navigation.Navigation.findNavController
import com.example.kidlock.R
import com.example.kidlock.persentation.utils.SizeScreen.wp
import com.example.kidlock.theme.KidlockTheme.color

@Composable
fun KidLockTitle(
    modifier: Modifier,
    icon: Int,
    color: Color
) {
    Row(
        modifier = modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.Center,
        verticalAlignment = Alignment.CenterVertically,
    ) {
        Image(
            painter = painterResource(id = icon),
            contentDescription = "image description",
            contentScale = ContentScale.None
        )
        Spacer(modifier = modifier.padding(1.0.wp()))
        Text(
            text = "Kid",
            style = MaterialTheme.typography.titleLarge,
        )
        Text(
            text = "lock",
            style = MaterialTheme.typography.titleLarge,
            color = color
        )
    }
}

@Composable
fun CardButtonPrimary(
    modifier: Modifier,
    icon: Int,
    title: String,
    subTitle: String,
    colorBackGround: Color,
    callBack:()-> Unit
) {
    Row(
        modifier = modifier
            .shadow(
                elevation = 4.dp,
                spotColor = MaterialTheme.color.SealBrown,
                ambientColor = MaterialTheme.color.SealBrown
            )
            .fillMaxWidth()
            .background(color = colorBackGround, shape = MaterialTheme.shapes.medium)
            .clickable {
                callBack()
            }
            .padding(6.0.wp()),
        verticalAlignment = Alignment.CenterVertically,
    ) {
        Image(
            modifier = modifier,
            painter = painterResource(id = icon),
            contentDescription = "image description",
            contentScale = ContentScale.FillBounds
        )
        Spacer(modifier = modifier.padding(3.0.wp()))
        Column(
            modifier = modifier,
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.Start,
        ) {
            Text(
                text = title,
                style = MaterialTheme.typography.headlineSmall,
                color = Color.White
            )
            Text(
                text = subTitle,
                style = MaterialTheme.typography.titleMedium,
                color = Color.White
            )
        }
    }
}

@Composable
fun CardLoginParent(
    modifier: Modifier,
    colorBackGround: Color,
    title: String,
    icon: Int,
    callBack: () -> Unit
) {
    val focusRequester = remember { FocusRequester() }
    var textEmail by remember { mutableStateOf(TextFieldValue("")) }
    var textPassword by remember { mutableStateOf(TextFieldValue("")) }
    var passwordVisible by rememberSaveable { mutableStateOf(false) }
    Column(
        modifier = modifier
            .fillMaxWidth()
            .wrapContentHeight()
            .padding(start = 20.dp, end = 20.dp, top = 16.dp, bottom = 20.dp)
            .background(color = colorBackGround, shape = MaterialTheme.shapes.medium),
        verticalArrangement = Arrangement.spacedBy(5.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        Spacer(modifier = modifier.padding(top = 25.dp))
        Text(
            modifier = modifier.padding(top = 15.dp),
            text = title,
            style = MaterialTheme.typography.displaySmall
        )

        Column(
            modifier = modifier
                .fillMaxWidth()
                .wrapContentHeight()
                .padding(20.dp),
            verticalArrangement = Arrangement.spacedBy(0.dp),
            horizontalAlignment = Alignment.Start,
        ) {
            val focusManager = LocalFocusManager.current
            Text(
                text = "Email",
                style = MaterialTheme.typography.titleMedium,
            )
            TextField(
                modifier = modifier
                    .fillMaxWidth()
                    .wrapContentHeight()
                    .focusRequester(focusRequester)
                    .padding(start = 5.dp),
                value = textEmail,
                keyboardOptions = KeyboardOptions(imeAction = ImeAction.Next),
                keyboardActions = KeyboardActions(
                    onNext = { focusManager.moveFocus(FocusDirection.Down) }
                ),
                onValueChange = { textEmail = it },
                placeholder = {
                    Text(
                        text = "Enter your e-mail",
                        color = Color.Black.copy(alpha = 0.5f),
                    )
                },
                shape = MaterialTheme.shapes.medium,
                colors = TextFieldDefaults.textFieldColors(
                    backgroundColor = Color(0XFFA0A0A0).copy(0.1f),
                    unfocusedIndicatorColor = Color.Transparent,
                    focusedIndicatorColor = Color.Transparent,
                    focusedLabelColor = Color(0XFFA0A0A0).copy(alpha = 0.5f),
                    unfocusedLabelColor = Color(0XFFA0A0A0).copy(alpha = 0.5f),
                )
            )
            Spacer(modifier = modifier.padding(8.dp))
            Text(
                text = "Password",
                style = MaterialTheme.typography.titleMedium,
            )
            TextField(
                modifier = modifier
                    .fillMaxWidth()
                    .wrapContentHeight()
                    .padding(start = 5.dp),
                value = textPassword, onValueChange = { textPassword = it },
                visualTransformation = if (passwordVisible) VisualTransformation.None else PasswordVisualTransformation(),
                keyboardOptions = KeyboardOptions(
                    imeAction = ImeAction.Go,
                    keyboardType = KeyboardType.Password
                ),
                keyboardActions = KeyboardActions(
                    onGo = { }
                ),
                trailingIcon = {
                    IconButton(onClick = { passwordVisible = !passwordVisible }) {
                        Icon(
                            painter = painterResource(id = icon),
                            contentDescription = ""
                        )
                    }
                },
                placeholder = {
                    Text(
                        text = "******",
                        color = Color.Black.copy(alpha = 0.5f),
                    )
                },
                shape = MaterialTheme.shapes.medium,
                colors = TextFieldDefaults.textFieldColors(
                    backgroundColor = Color(0XFFA0A0A0).copy(0.1f),
                    unfocusedIndicatorColor = Color.Transparent,
                    focusedIndicatorColor = Color.Transparent,
                    focusedLabelColor = Color(0XFFA0A0A0).copy(alpha = 0.2f),
                    unfocusedLabelColor = Color(0XFFA0A0A0).copy(alpha = 0.2f),
                    trailingIconColor = Color(0XFF00BD6E)
                )
            )
            Spacer(modifier = modifier.padding(8.dp))
            Text(
                modifier = modifier
                    .fillMaxWidth()
                    .clickable {
                        callBack
                    },
                textAlign = TextAlign.End,
                text = "Forgot password?",
                style = MaterialTheme.typography.labelMedium.copy(color = MaterialTheme.color.LightningYellow),
                textDecoration = TextDecoration.Underline
            )
        }
        Button(
            onClick = {}, modifier = modifier
                .fillMaxWidth()
                .padding(10.dp),
            colors = ButtonDefaults.buttonColors(
                containerColor = MaterialTheme.color.LightningYellow,
            ),
            shape = MaterialTheme.shapes.small
        ) {
            Text(text = "Login", style = MaterialTheme.typography.titleMedium, color = Color.White)
        }
        Text(
            modifier = modifier
                .padding(10.dp)
                .clickable {
                    callBack
                },
            text = "Create new account",
            style = MaterialTheme.typography.labelMedium.copy(color = MaterialTheme.color.LightningYellow),
            textDecoration = TextDecoration.Underline
        )
        Spacer(modifier = modifier.padding(top = 10.dp))
    }
    Spacer(modifier = modifier.padding(20.dp))
    Text(
        modifier = modifier
            .padding(10.dp)
            .fillMaxWidth()
            .clickable {
                callBack
            },
        text = "Cancel",
        style = MaterialTheme.typography.labelMedium.copy(color = Color.White),
        textDecoration = TextDecoration.Underline,
        textAlign = TextAlign.Center
    )
    LaunchedEffect(Unit) {
        focusRequester.requestFocus()
    }
}

@Composable
fun TextBox(
    modifier: Modifier = Modifier,
    title: String,
    placeholder: String,
    pass: Boolean,
    icon: Int,
    end: Boolean,
) {
    var textInput by remember { mutableStateOf(TextFieldValue("")) }
    var passwordVisible by rememberSaveable { mutableStateOf(false) }
    val focusManager = LocalFocusManager.current
    var keyboardOptions: KeyboardOptions
    var keyboardActions: KeyboardActions
    if (end) {
        keyboardOptions = KeyboardOptions(imeAction = ImeAction.Go)
        keyboardActions = KeyboardActions(
            onGo = { }
        )
    } else {
        keyboardOptions = KeyboardOptions(imeAction = ImeAction.Next)
        keyboardActions = KeyboardActions(
            onNext = { focusManager.moveFocus(FocusDirection.Down) }
        )
    }
    Column(
        modifier = modifier
            .fillMaxWidth()
            .wrapContentHeight()
            .padding(20.dp),
        verticalArrangement = Arrangement.spacedBy(5.dp),
        horizontalAlignment = Alignment.Start,
    ) {
        Text(
            text = title,
            style = MaterialTheme.typography.titleMedium,
        )
        if (pass) {
            TextField(
                modifier = modifier
                    .fillMaxWidth()
                    .wrapContentHeight()
                    .padding(start = 0.dp),
                placeholder = {
                    Text(
                        text = placeholder,
                        color = Color.Black.copy(alpha = 0.5f),
                    )
                },
                keyboardActions = keyboardActions,
                keyboardOptions = keyboardOptions,
                value = textInput, onValueChange = { textInput = it },
                visualTransformation = if (passwordVisible) VisualTransformation.None else PasswordVisualTransformation(),
                trailingIcon = {
                    IconButton(onClick = { passwordVisible = !passwordVisible }) {
                        Icon(
                            painter = painterResource(id = icon),
                            contentDescription = ""
                        )
                    }
                },
                shape = MaterialTheme.shapes.medium,
                colors = TextFieldDefaults.textFieldColors(
                    backgroundColor = Color(0XFFA0A0A0).copy(0.1f),
                    unfocusedIndicatorColor = Color.Transparent,
                    focusedIndicatorColor = Color.Transparent,
                    focusedLabelColor = Color(0XFFA0A0A0).copy(alpha = 0.2f),
                    unfocusedLabelColor = Color(0XFFA0A0A0).copy(alpha = 0.2f),
                    trailingIconColor = Color(0XFF00BD6E)
                )
            )
        } else {
            TextField(
                modifier = modifier
                    .fillMaxWidth()
                    .wrapContentHeight()
                    .padding(start = 0.dp),
                value = textInput, onValueChange = { textInput = it },
                keyboardActions = keyboardActions,
                keyboardOptions = keyboardOptions,
                shape = MaterialTheme.shapes.medium,
                colors = TextFieldDefaults.textFieldColors(
                    backgroundColor = Color(0XFFA0A0A0).copy(0.1f),
                    unfocusedIndicatorColor = Color.Transparent,
                    focusedIndicatorColor = Color.Transparent,
                    focusedLabelColor = Color(0XFFA0A0A0).copy(alpha = 0.2f),
                    unfocusedLabelColor = Color(0XFFA0A0A0).copy(alpha = 0.2f),
                    trailingIconColor = Color(0XFF00BD6E)
                )
            )
        }
    }
}

@Composable
fun PinDigit(modifier: Modifier = Modifier, colorBackGround: Color) {
    val focusRequester = remember { FocusRequester() }
    val lenghTextInput = 6
    val focusManager = LocalFocusManager.current
    var textInputNum by remember { mutableStateOf(TextFieldValue("")) }
    Column(
        modifier = Modifier.fillMaxWidth(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {Box {
        BasicTextField(
            modifier = Modifier
                .focusRequester(focusRequester)
                .fillMaxWidth()
                .height(0.dp)
                .background(color = Color(0XFFFFFFFF)),
            value = textInputNum,
            onValueChange = {
                if ( it.text.length <= lenghTextInput) textInputNum = it
            },
            singleLine = true,
            keyboardOptions = KeyboardOptions(
                keyboardType = KeyboardType.NumberPassword,
                imeAction = ImeAction.Done,
            )
        )
        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceEvenly,
            modifier = Modifier
                .fillMaxWidth()
                .height(100.dp)
                .background(Color(0xEEEEEE)),
        ) {
            for (i in 0 until lenghTextInput) {
                if (i < textInputNum.text.length) {
                    Dot(check = true, color = colorBackGround)
                } else {
                    Dot(check = false, color = Color(0XFFD9D9D9))
                }
            }
        }
    }
        LaunchedEffect(Unit) {
            focusRequester.requestFocus()
        }
    }
}

@Composable
fun Dot(check: Boolean, color: Color) {
    Box(
        modifier = Modifier
            .size(42.dp)
            .background(shape = MaterialTheme.shapes.medium, color = color),
        contentAlignment = Alignment.Center,
    ) {
        if (check) {
            Icon(
                modifier = Modifier
                    .size(32.dp)
                    .padding(2.dp),
                painter = painterResource(id = R.drawable.ellipse_16),
                contentDescription = "",
                tint =  Color(0XFF2092FA)

            )
        }
    }
}