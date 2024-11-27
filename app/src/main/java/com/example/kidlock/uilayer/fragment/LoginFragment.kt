package com.example.kidlock.uilayer.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.layout.wrapContentWidth
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
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberUpdatedState
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.FocusDirection
import androidx.compose.ui.focus.FocusRequester
import androidx.compose.ui.focus.focusRequester
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.ComposeView
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.navigation.Navigation
import com.example.kidlock.R
import com.example.kidlock.persentation.utils.SizeScreen
import com.example.kidlock.theme.KidlockTheme
import com.example.kidlock.theme.KidlockTheme.color
import com.example.kidlock.uilayer.viewmodel.LoginAccount
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.async
import kotlinx.coroutines.runBlocking

@AndroidEntryPoint
class LoginFragment() : Fragment() {
    private val viewModel by activityViewModels<LoginAccount>()
    private lateinit var view: View
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        view = inflater.inflate(R.layout.fragment_login, container, false).apply {
            findViewById<ComposeView>(R.id.composeview_login).setContent {
                KidlockTheme {
                    Column(
                        modifier = Modifier.fillMaxSize(),
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {
                        val insets  by rememberUpdatedState{ mutableStateOf(
                            ViewCompat.getRootWindowInsets(view)!!.isVisible(WindowInsetsCompat.Type.ime())) }
                        val height = if(!insets.invoke().value ){10.dp}else{30.dp}
                        val height2 = if(!insets.invoke().value ){0.dp}else{25.dp}
                        Spacer(modifier = Modifier.padding(height))
                        KidLockTitle(Modifier, R.drawable.kidlockgreen, Color.White)
                        Spacer(modifier = Modifier.padding(height2))
                        LoginParent(
                            modifier = Modifier,
                            colorBackGround = Color.White,
                            title = "Login as parent",
                            icon = R.drawable.eye_off_1
                        )
                    }
                }
            }
        }
        return view
    }

    @Composable
    @Preview(showSystemUi = true)
    fun LoginPreview() {
        KidlockTheme {
            Column(
                modifier = Modifier.fillMaxSize()
            ) {
                Spacer(modifier = Modifier.padding(30.dp))
                KidLockTitle(Modifier, R.drawable.kidlockgreen, Color.White)
                Spacer(modifier = Modifier.padding(20.dp))
                LoginParent(
                    modifier = Modifier,
                    colorBackGround = Color.White,
                    title = "Login as parent",
                    icon = R.drawable.eye_off_1
                )
            }
        }
    }

    @Composable
    fun LoginParent(
        modifier: Modifier,
        colorBackGround: Color,
        title: String,
        icon: Int,
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
                    onValueChange = {
                        textEmail = it
                    },
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
                    value = textPassword, onValueChange = {
                        textPassword = it
                    },
                    visualTransformation = if (passwordVisible) VisualTransformation.None else PasswordVisualTransformation(),
                    keyboardOptions = KeyboardOptions(
                        imeAction = ImeAction.Go,
                        keyboardType = KeyboardType.Password
                    ),
                    keyboardActions = KeyboardActions(
                        onGo = {

                        }
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
                            Navigation
                                .findNavController(view = view)
                                .navigate(R.id.action_loginFragment_to_forgotPassFragment)
                        },
                    textAlign = TextAlign.End,
                    text = "Forgot password?",
                    style = MaterialTheme.typography.labelMedium.copy(color = MaterialTheme.color.LightningYellow),
                    textDecoration = TextDecoration.Underline
                )
            }
            Button(
                onClick =   {
                    viewModel.createDB()
                }, modifier = modifier
                    .fillMaxWidth()
                    .padding(10.dp),
                colors = ButtonDefaults.buttonColors(
                    containerColor = MaterialTheme.color.LightningYellow,
                ),
                shape = MaterialTheme.shapes.small
            ) {
                Text(
                    text = "Login",
                    style = MaterialTheme.typography.titleMedium,
                    color = Color.White
                )
            }
            Text(
                modifier = modifier
                    .padding(10.dp)
                    .clickable {
                        Navigation
                            .findNavController(view = view)
                            .navigate(R.id.action_loginFragment_to_createNewAccountFragment)

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
                    if (view != null) {
                        Navigation
                            .findNavController(view = view)
                            .navigate(R.id.action_loginFragment_to_homeFragment)
                    }
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
    fun KidLockTitle(
        modifier: Modifier,
        icon: Int,
        color: Color
    ) {
        val insets  by rememberUpdatedState{ mutableStateOf(
            ViewCompat.getRootWindowInsets(view)!!.isVisible(WindowInsetsCompat.Type.ime())) }
        val height = if(!insets.invoke().value ){
            SizeScreen.heightSize(0.17f)}else{
            SizeScreen.heightSize(0f)}
        Row(
            modifier = modifier
                .height(height)
                .wrapContentWidth()
                .padding(start = 69.dp, end = 69.dp),
            horizontalArrangement = Arrangement.SpaceAround,
            verticalAlignment = Alignment.CenterVertically,
        ) {
            Image(
                painter = painterResource(id = icon),
                contentDescription = "image description",
                contentScale = ContentScale.None
            )
            Spacer(modifier = modifier.padding(8.dp))
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
}

