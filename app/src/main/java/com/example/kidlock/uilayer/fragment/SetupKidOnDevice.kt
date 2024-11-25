package com.example.kidlock.uilayer.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.shape.CircleShape
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
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.FocusDirection
import androidx.compose.ui.focus.FocusRequester
import androidx.compose.ui.focus.focusRequester
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.ComposeView
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import com.example.kidlock.R
import com.example.kidlock.theme.KidlockTheme
import com.example.kidlock.theme.KidlockTheme.color
import com.example.kidlock.uilayer.viewmodel.CreateAccount
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class SetupKidOnDevice : Fragment() {
    private lateinit var view: View
    private val viewModel by activityViewModels<CreateAccount>()
    private var isErrorNameKid by mutableStateOf(false)
    private var isErrorAgeKid by mutableStateOf(false)
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        view = inflater.inflate(R.layout.fragment_setup_kid_on_device, container, false).apply {
            findViewById<ComposeView>(R.id.composeview_setup_kid_on_device).setContent {
                KidlockTheme {
                    Scaffold(
                        topBar = {
                            TopAppBar(
                                title = {
                                    androidx.compose.material.Text(
                                        text = "Setup kid on device",
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
                                    .fillMaxSize()
                                    .padding(10.dp)
                                    .background(Color.White),
                                verticalArrangement = Arrangement.Top,
                                horizontalAlignment = Alignment.Start
                            ) {
                                Spacer(modifier = Modifier.padding(5.dp))
                                NameKidTextBox(
                                    title = "Name",
                                    placeholder = "Johny",
                                    pass = false,
                                    icon = 0,
                                    end = false,
                                    isError = isErrorNameKid
                                )
                                Spacer(modifier = Modifier.padding(5.dp))
                                AgeKidTextBox(
                                    title = "Age",
                                    placeholder = "",
                                    pass = false,
                                    icon = 0,
                                    end = true,
                                    isError = isErrorAgeKid
                                )
                                Text(
                                    modifier = Modifier.padding(10.dp),
                                    text = "Pick an avatar",
                                    style = MaterialTheme.typography.titleMedium
                                )
                                Icon(
                                    modifier = Modifier
                                        .size(80.dp)
                                        .background(
                                            shape = CircleShape,
                                            color = MaterialTheme.color.LightningYellow.copy(alpha = 0.2f)
                                        )
                                        .padding(20.dp)
                                        .align(Alignment.CenterHorizontally),
                                    painter = painterResource(id = R.drawable.image_1),
                                    contentDescription = "",
                                    tint = MaterialTheme.color.LightningYellow
                                )
                                Row(
                                    modifier = Modifier.padding(10.dp),
                                    horizontalArrangement = Arrangement.spacedBy(space = 17.dp),
                                    verticalAlignment = Alignment.CenterVertically
                                ) {
                                    Icon(
                                        modifier = Modifier
                                            .size(70.dp)
                                            .background(
                                                shape = CircleShape,
                                                color = MaterialTheme.color.Jade.copy(alpha = 0.2f)
                                            )
                                            .padding(20.dp),
                                        painter = painterResource(id = R.drawable.camera_1),
                                        contentDescription = "",
                                        tint = MaterialTheme.color.Jade
                                    )
                                    Image(
                                        modifier = Modifier.size(70.dp),
                                        painter = painterResource(id = R.drawable.ellipse_5),
                                        contentDescription = ""
                                    )
                                    Image(
                                        modifier = Modifier.size(70.dp),
                                        painter = painterResource(id = R.drawable.ellipse_6),
                                        contentDescription = ""
                                    )
                                    Image(
                                        modifier = Modifier.size(70.dp),
                                        painter = painterResource(id = R.drawable.ellipse_7),
                                        contentDescription = ""
                                    )
                                }
                                Row(
                                    modifier = Modifier.padding(10.dp),
                                    horizontalArrangement = Arrangement.spacedBy(space = 17.dp),
                                    verticalAlignment = Alignment.CenterVertically
                                ) {
                                    Image(
                                        modifier = Modifier.size(70.dp),
                                        painter = painterResource(id = R.drawable.ellipse_10),
                                        contentDescription = ""
                                    )
                                    Image(
                                        modifier = Modifier.size(70.dp),
                                        painter = painterResource(id = R.drawable.ellipse_11),
                                        contentDescription = ""
                                    )
                                    Image(
                                        modifier = Modifier.size(70.dp),
                                        painter = painterResource(id = R.drawable.ellipse_8),
                                        contentDescription = ""
                                    )
                                    Image(
                                        modifier = Modifier.size(70.dp),
                                        painter = painterResource(id = R.drawable.ellipse_9),
                                        contentDescription = ""
                                    )

                                }
                                Button(
                                    onClick = {},
                                    modifier = Modifier
                                        .fillMaxWidth()
                                        .padding(5.dp),
                                    colors = ButtonDefaults.buttonColors(
                                        containerColor = MaterialTheme.color.LightningYellow,
                                    ),
                                    shape = MaterialTheme.shapes.small
                                ) {
                                    Text(
                                        text = "Register kid",
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
    fun SetupKidOnDevicePreview() {
        KidlockTheme {
            Scaffold(
                topBar = {
                    TopAppBar(
                        title = {
                            androidx.compose.material.Text(
                                text = "Setup kid on device",
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
                            .fillMaxSize()
                            .padding(10.dp)
                            .background(Color.White),
                        verticalArrangement = Arrangement.Top,
                        horizontalAlignment = Alignment.Start
                    ) {
                        Spacer(modifier = Modifier.padding(5.dp))
                        NameKidTextBox(
                            title = "Name",
                            placeholder = "Johny",
                            pass = false,
                            icon = 0,
                            end = false,
                            isError = isErrorNameKid
                        )
                        Spacer(modifier = Modifier.padding(5.dp))
                        AgeKidTextBox(
                            title = "Age",
                            placeholder = "",
                            pass = false,
                            icon = 0,
                            end = true,
                            isError = isErrorAgeKid
                        )
                        Text(
                            modifier = Modifier.padding(10.dp),
                            text = "Pick an avatar",
                            style = MaterialTheme.typography.titleMedium
                        )
                        Icon(
                            modifier = Modifier
                                .size(80.dp)
                                .background(
                                    shape = CircleShape,
                                    color = MaterialTheme.color.LightningYellow.copy(alpha = 0.2f)
                                )
                                .padding(20.dp)
                                .align(Alignment.CenterHorizontally),
                            painter = painterResource(id = R.drawable.image_1),
                            contentDescription = "",
                            tint = MaterialTheme.color.LightningYellow
                        )
                        Row(
                            modifier = Modifier.padding(10.dp),
                            horizontalArrangement = Arrangement.spacedBy(space = 17.dp),
                            verticalAlignment = Alignment.CenterVertically
                        ) {
                            Icon(
                                modifier = Modifier
                                    .size(70.dp)
                                    .background(
                                        shape = CircleShape,
                                        color = MaterialTheme.color.Jade.copy(alpha = 0.2f)
                                    )
                                    .padding(20.dp),
                                painter = painterResource(id = R.drawable.camera_1),
                                contentDescription = "",
                                tint = MaterialTheme.color.Jade
                            )
                            Image(
                                modifier = Modifier.size(70.dp),
                                painter = painterResource(id = R.drawable.ellipse_5),
                                contentDescription = ""
                            )
                            Image(
                                modifier = Modifier.size(70.dp),
                                painter = painterResource(id = R.drawable.ellipse_6),
                                contentDescription = ""
                            )
                            Image(
                                modifier = Modifier.size(70.dp),
                                painter = painterResource(id = R.drawable.ellipse_7),
                                contentDescription = ""
                            )
                        }
                        Row(
                            modifier = Modifier.padding(10.dp),
                            horizontalArrangement = Arrangement.spacedBy(space = 17.dp),
                            verticalAlignment = Alignment.CenterVertically
                        ) {
                            Image(
                                modifier = Modifier.size(70.dp),
                                painter = painterResource(id = R.drawable.ellipse_10),
                                contentDescription = ""
                            )
                            Image(
                                modifier = Modifier.size(70.dp),
                                painter = painterResource(id = R.drawable.ellipse_11),
                                contentDescription = ""
                            )
                            Image(
                                modifier = Modifier.size(70.dp),
                                painter = painterResource(id = R.drawable.ellipse_8),
                                contentDescription = ""
                            )
                            Image(
                                modifier = Modifier.size(70.dp),
                                painter = painterResource(id = R.drawable.ellipse_9),
                                contentDescription = ""
                            )

                        }
                        Button(
                            onClick = {},
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(5.dp),
                            colors = ButtonDefaults.buttonColors(
                                containerColor = MaterialTheme.color.LightningYellow,
                            ),
                            shape = MaterialTheme.shapes.small
                        ) {
                            Text(
                                text = "Register kid",
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
    fun NameKidTextBox(
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
                        .focusRequester(focusRequester)
                        .fillMaxWidth().height(60.dp)
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

    @OptIn(ExperimentalComposeUiApi::class)
    @Composable
    fun AgeKidTextBox(
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
                        .fillMaxWidth().height(45.dp)
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
                        backgroundColor = Color(0XFFA0A0A0).copy(0.2f),
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
                        .height(60.dp)
                        .padding(start = 0.dp),
                    singleLine = true,
                    value = textInput, onValueChange = {
                        run {
                            textInput = it
                        }
                    },
                    isError = isError,
                    keyboardActions = KeyboardActions(
                        onNext = { }
                    ),
                    keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
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