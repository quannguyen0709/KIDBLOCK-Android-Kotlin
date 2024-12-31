package com.example.kidlock.persentation.views.signup

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.TextField
import androidx.compose.material.TextFieldDefaults
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.FocusDirection
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.ComposeView
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.unit.dp
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import com.example.kidlock.R
import com.example.kidlock.theme.KidlockTheme
import com.example.kidlock.theme.KidlockTheme.color

class SignUpFragment: Fragment() {
    private var isErrorName by mutableStateOf(false)
    private var isErrorEmail  by mutableStateOf(false)
    private var isErrorPass  by mutableStateOf(false)
    private var isErrorReapeatPass by mutableStateOf(false)
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        super.onCreateView(inflater, container, savedInstanceState)
        val view = inflater.inflate(R.layout.fragment_signup, container, true).apply {
            findViewById<ComposeView>(R.id.composeview_signup).setContent {
                KidlockTheme {
                    Column(
                        modifier = Modifier
                            .fillMaxSize()
                            .padding(16.dp),
                        verticalArrangement = Arrangement.spacedBy(2.dp),
                        horizontalAlignment = Alignment.CenterHorizontally,
                    ) {
                        Text(
                            modifier = Modifier.padding(top = 20.dp),
                            text = "Create new account " ,
                            style = MaterialTheme.typography.displaySmall
                        )
                        NameTextBox(
                            title = "Name",
                            placeholder = "John Doe",
                            pass = false,
                            icon = 0,
                            end = false,
                            isError = isErrorName

                        )
                        EmailTextBox(
                            title = "Email",
                            placeholder = "johndoe@example.com",
                            pass = false,
                            icon = 0,
                            end = false,
                            isError = isErrorEmail
                        )
                        PassTextBox(
                            title = "Password",
                            placeholder = "******",
                            pass = true,
                            icon = R.drawable.eye_off_1,
                            end = false,
                            isError = isErrorPass
                        )
                        RepeatPassTextBox(
                            title = "Repeat Password",
                            placeholder = "******",
                            pass = true,
                            icon = R.drawable.eye_off_1,
                            end = false,
                            isError = isErrorReapeatPass
                        )
                        Button(
                            onClick = {

                            },

                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(10.dp),
                            colors = ButtonDefaults.buttonColors(
                                containerColor = MaterialTheme.color.LightningYellow,
                            ),
                            shape = MaterialTheme.shapes.small
                        ) {
                            Text(
                                text = "Signup",
                                style = MaterialTheme.typography.titleMedium,
                                color = Color.White
                            )
                        }

                        Text(
                            modifier = Modifier
                                .padding(10.dp)
                                .fillMaxWidth()
                                .clickable { findNavController().navigate(R.id.action_createNewAccountFragment_to_loginFragment) },
                            text = "Back to login",
                            style = MaterialTheme.typography.labelMedium.copy(color = MaterialTheme.color.LightningYellow),
                            textDecoration = TextDecoration.Underline,
                            textAlign = TextAlign.Center
                        )
                    }
                }
            }
        }
        return  view
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }
}


@Composable
fun NameTextBox(
    modifier: Modifier = Modifier,
    title: String,
    placeholder: String,
    pass: Boolean,
    icon: Int,
    end: Boolean,
    isError: Boolean
) {
    var textInput by remember { mutableStateOf(TextFieldValue("")) }
    var passwordVisible by rememberSaveable { mutableStateOf(false) }
    val focusManager = LocalFocusManager.current
    val keyboardOptions: KeyboardOptions
    val keyboardActions: KeyboardActions
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
                isError = isError,
                singleLine = true,
                keyboardActions = keyboardActions,
                keyboardOptions = keyboardOptions,
                value = textInput, onValueChange = { it ->
                    run {
                        textInput = it
                    }
                },
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
                singleLine = true,
                value = textInput, onValueChange = { it ->
                    run {
                        textInput = it
                    }
                },
                isError = isError,
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
fun EmailTextBox(
    modifier: Modifier = Modifier,
    title: String,
    placeholder: String,
    pass: Boolean,
    icon: Int,
    end: Boolean,
    isError: Boolean
) {
    var textInput by remember { mutableStateOf(TextFieldValue("")) }
    var passwordVisible by rememberSaveable { mutableStateOf(false) }
    val focusManager = LocalFocusManager.current
    val keyboardOptions: KeyboardOptions
    val keyboardActions: KeyboardActions
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
                isError = isError,
                singleLine = true,
                keyboardActions = keyboardActions,
                keyboardOptions = keyboardOptions,
                value = textInput, onValueChange = { it ->
                    run {
                        textInput = it
                    }
                },
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
                value = textInput, onValueChange = { it ->
                    run {
                        textInput = it
                    }
                },
                isError = isError,
                singleLine = true,
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
fun PassTextBox(
    modifier: Modifier = Modifier,
    title: String,
    placeholder: String,
    pass: Boolean,
    icon: Int,
    end: Boolean,
    isError: Boolean
) {
    var textInput by remember { mutableStateOf(TextFieldValue("")) }
    var passwordVisible by rememberSaveable { mutableStateOf(false) }
    val focusManager = LocalFocusManager.current
    val keyboardOptions: KeyboardOptions
    val keyboardActions: KeyboardActions
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
                isError = isError,
                singleLine = true,
                keyboardActions = keyboardActions,
                keyboardOptions = keyboardOptions,
                value = textInput, onValueChange = { it ->
                    run {
                        textInput = it
                    }
                },
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
                value = textInput, onValueChange = { it ->
                    run {
                        textInput = it
                    }
                },
                singleLine = true,
                isError =  isError,
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
fun RepeatPassTextBox(
    modifier: Modifier = Modifier,
    title: String,
    placeholder: String,
    pass: Boolean,
    icon: Int,
    end: Boolean,
    isError: Boolean,
) {
    var textInput by remember { mutableStateOf(TextFieldValue("")) }
    var passwordVisible by rememberSaveable { mutableStateOf(false) }
    val focusManager = LocalFocusManager.current
    val keyboardOptions: KeyboardOptions
    val keyboardActions: KeyboardActions
    if (end) {
        keyboardOptions = KeyboardOptions(imeAction = ImeAction.Go)
        keyboardActions = KeyboardActions(
            onGo = { }
        )
    } else {
        keyboardOptions = KeyboardOptions(imeAction = ImeAction.Next)
        keyboardActions = KeyboardActions(
            onNext = {

            }
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
                isError = isError,
                singleLine = true,
                keyboardActions = keyboardActions,
                keyboardOptions = keyboardOptions,
                value = textInput, onValueChange = { it ->
                    run {
                        textInput = it
                    }
                },
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
                value = textInput, onValueChange = { it ->
                    run {
                        textInput = it
                    }
                },
                isError = isError,
                singleLine = true,
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