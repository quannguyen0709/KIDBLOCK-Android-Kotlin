package com.example.kidlock.uilayer.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.IconButton
import androidx.compose.material.Scaffold
import androidx.compose.material.TextField
import androidx.compose.material.TextFieldDefaults
import androidx.compose.material.TopAppBar
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
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
import androidx.compose.ui.focus.FocusDirection
import androidx.compose.ui.focus.FocusRequester
import androidx.compose.ui.focus.focusRequester
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.ComposeView
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.fragment.app.Fragment
import com.example.kidlock.R
import com.example.kidlock.theme.KidlockTheme
import com.example.kidlock.theme.KidlockTheme.color
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class ChangePasswordFragment :Fragment(){
    private lateinit var view: View
    private val isErrorOldPassword by mutableStateOf(false)
    private val isErrorNewPassword by mutableStateOf(false)
    private val isErrorRepeatPassword by mutableStateOf(false)
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        view = inflater.inflate(R.layout.fragment_change_password, container, false).apply {
            findViewById<ComposeView>(R.id.composeview_change_password).setContent {
                KidlockTheme {
                    Scaffold(
                        topBar = {
                            TopAppBar(
                                title = {
                                    androidx.compose.material.Text(
                                        text = "Change password",
                                        style = MaterialTheme.typography.headlineSmall
                                    )
                                },
                                navigationIcon = {
                                    IconButton(onClick = { }) {
                                        Icon(
                                            tint = MaterialTheme.color.Jade,
                                            painter = painterResource(id = R.drawable.arrow_left_1),
                                            contentDescription = ""
                                        )
                                    }
                                },
                                backgroundColor = Color.White,
                                contentColor = Color.Black,
                                elevation = 10.dp
                            )
                        }, content = {
                            it
                            Column(
                                modifier = Modifier
                                    .fillMaxSize().padding(15.dp)
                                    .background(Color.White),
                                verticalArrangement = Arrangement.Top,
                                horizontalAlignment = Alignment.CenterHorizontally
                            ) {
                                OldPasswordTextBox(
                                    title = "Old password",
                                    placeholder = "******",
                                    pass = true,
                                    icon = R.drawable.eye_off_1,
                                    end = false,
                                    isError = isErrorOldPassword
                                )
                                NewPasswordTextBox(
                                    title = "New password",
                                    placeholder = "******",
                                    pass = true,
                                    icon = R.drawable.eye_off_1,
                                    end = false,
                                    isError = isErrorNewPassword
                                )
                                RepeatPasswordTextBox(
                                    title = "Repeat password",
                                    placeholder = "******",
                                    pass = true,
                                    icon = R.drawable.eye_off_1,
                                    end = true,
                                    isError = isErrorRepeatPassword
                                )

                                Button(
                                    onClick = {}, modifier = Modifier
                                        .fillMaxWidth()
                                        .padding(10.dp),
                                    colors = ButtonDefaults.buttonColors(
                                        containerColor = MaterialTheme.color.LightningYellow,
                                    ),
                                    shape = MaterialTheme.shapes.small
                                ) {
                                    Text(
                                        text = "Change password",
                                        style = MaterialTheme.typography.titleMedium,
                                        color = Color.White
                                    )
                                }
                            }

                        }
                    )
                }
            }
        }
        return view
    }

    @Composable
    @Preview(showSystemUi = true)
    fun ChangePasswordPreview(){
        KidlockTheme {
            Scaffold(
                topBar = {
                    TopAppBar(
                        title = {
                            androidx.compose.material.Text(
                                text = "Change password",
                                style = MaterialTheme.typography.headlineSmall
                            )
                        },
                        navigationIcon = {
                            IconButton(onClick = { }) {
                                Icon(
                                    tint = MaterialTheme.color.Jade,
                                    painter = painterResource(id = R.drawable.arrow_left_1),
                                    contentDescription = ""
                                )
                            }
                        },
                        backgroundColor = Color.White,
                        contentColor = Color.Black,
                        elevation = 10.dp
                    )
                }, content = {
                    it
                    Column(
                        modifier = Modifier
                            .fillMaxSize().padding(15.dp)
                            .background(Color.White),
                        verticalArrangement = Arrangement.Top,
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {
                        OldPasswordTextBox(
                            title = "Old password",
                            placeholder = "******",
                            pass = true,
                            icon = R.drawable.eye_off_1,
                            end = false,
                            isError = isErrorOldPassword
                        )
                        NewPasswordTextBox(
                            title = "New password",
                            placeholder = "******",
                            pass = true,
                            icon = R.drawable.eye_off_1,
                            end = false,
                            isError = isErrorNewPassword
                        )
                        RepeatPasswordTextBox(
                            title = "Repeat password",
                            placeholder = "******",
                            pass = true,
                            icon = R.drawable.eye_off_1,
                            end = true,
                            isError = isErrorRepeatPassword
                        )

                        Button(
                            onClick = {}, modifier = Modifier
                                .fillMaxWidth()
                                .padding(10.dp),
                            colors = ButtonDefaults.buttonColors(
                                containerColor = MaterialTheme.color.LightningYellow,
                            ),
                            shape = MaterialTheme.shapes.small
                        ) {
                            Text(
                                text = "Change password",
                                style = MaterialTheme.typography.titleMedium,
                                color = Color.White
                            )
                        }
                    }

                }
            )
        }
    }



    @Composable
    fun OldPasswordTextBox(
        modifier: Modifier = Modifier,
        title: String,
        placeholder: String,
        pass: Boolean,
        icon: Int,
        end: Boolean,
        isError: Boolean
    ) {
        val focusRequester = remember { FocusRequester() }
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
                .padding(10.dp),
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
                        .focusRequester(focusRequester)
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
                    value = textInput, onValueChange = {
                        run {
                            textInput = it
                        }
                    },
                    visualTransformation = if (passwordVisible) VisualTransformation.None else PasswordVisualTransformation(),
                    trailingIcon = {
                        IconButton(onClick = { passwordVisible = !passwordVisible }) {
                            androidx.compose.material.Icon(
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
                        .height(45.dp)
                        .padding(start = 0.dp),
                    singleLine = true,
                    value = textInput, onValueChange = {
                        run {
                            textInput = it
                        }
                    },
                    isError = isError,
                    keyboardActions = keyboardActions,
                    keyboardOptions = keyboardOptions,
                    shape = MaterialTheme.shapes.medium,
                    colors = TextFieldDefaults.textFieldColors(
                        backgroundColor = Color(0XFFA0A0A0).copy(0.2f),
                        unfocusedIndicatorColor = Color.Transparent,
                        focusedIndicatorColor = Color.Transparent,
                        focusedLabelColor = Color(0XFFA0A0A0).copy(alpha = 0.2f),
                        unfocusedLabelColor = Color(0XFFA0A0A0).copy(alpha = 0.2f),
                        trailingIconColor = Color(0XFF00BD6E)
                    )
                )
            }
        }
        LaunchedEffect(Unit) {
            focusRequester.requestFocus()
        }
    }

    @Composable
    fun NewPasswordTextBox(
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
                .padding(10.dp),
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
                    value = textInput, onValueChange = {
                        run {
                            textInput = it
                        }
                    },
                    visualTransformation = if (passwordVisible) VisualTransformation.None else PasswordVisualTransformation(),
                    trailingIcon = {
                        IconButton(onClick = { passwordVisible = !passwordVisible }) {
                            androidx.compose.material.Icon(
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
                        .height(45.dp)
                        .padding(start = 0.dp),
                    singleLine = true,
                    value = textInput, onValueChange = {
                        run {
                            textInput = it
                        }
                    },
                    isError = isError,
                    keyboardActions = keyboardActions,
                    keyboardOptions = keyboardOptions,
                    shape = MaterialTheme.shapes.medium,
                    colors = TextFieldDefaults.textFieldColors(
                        backgroundColor = Color(0XFFA0A0A0).copy(0.2f),
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
    fun RepeatPasswordTextBox(
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
            keyboardOptions = KeyboardOptions(imeAction = ImeAction.Done)
            keyboardActions = KeyboardActions(
                onDone = null
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
                .padding(10.dp),
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
                    value = textInput, onValueChange = {
                        run {
                            textInput = it
                        }
                    },
                    visualTransformation = if (passwordVisible) VisualTransformation.None else PasswordVisualTransformation(),
                    trailingIcon = {
                        IconButton(onClick = { passwordVisible = !passwordVisible }) {
                            androidx.compose.material.Icon(
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
                        .height(45.dp)
                        .padding(start = 0.dp),
                    singleLine = true,
                    value = textInput, onValueChange = {
                        run {
                            textInput = it
                        }
                    },
                    isError = isError,
                    keyboardActions = keyboardActions,
                    keyboardOptions = keyboardOptions,
                    shape = MaterialTheme.shapes.medium,
                    colors = TextFieldDefaults.textFieldColors(
                        backgroundColor = Color(0XFFA0A0A0).copy(0.2f),
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
}