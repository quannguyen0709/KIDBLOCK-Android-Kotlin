package com.example.kidlock.persentation.views.loginfragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.TextField
import androidx.compose.material.TextFieldDefaults
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.State
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
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
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import com.example.kidlock.R
import com.example.kidlock.persentation.utils.SizeScreen.hp
import com.example.kidlock.persentation.utils.SizeScreen.wp
import com.example.kidlock.persentation.views.mainscreen.MainScreenViewModel
import com.example.kidlock.persentation.views.statekeyboard.Keyboard
import com.example.kidlock.persentation.views.statekeyboard.keyboardAsStateWithApi
import com.example.kidlock.theme.KidlockTheme
import com.example.kidlock.theme.KidlockTheme.color
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.isActive
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

@AndroidEntryPoint
class LoginFragment() : Fragment() {
    private val viewModelMain by activityViewModels<MainScreenViewModel>()
    private val viewModelLogin by activityViewModels<LoginViewModel>()
    private lateinit var view: View

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        //check xem ban phim co hien ko su dung view
        view = inflater.inflate(R.layout.fragment_login, container, false).apply {


            findViewById<ComposeView>(R.id.composeview_login).setContent {
                KidlockTheme {

                    Column(
                        modifier = Modifier
                            .fillMaxSize(),
                        verticalArrangement = Arrangement.Top,
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {
//
                        val check = keyboardAsStateWithApi()

                        //val check = keyboardAsStateWithApi()
//                        ViewCompat.setOnApplyWindowInsetsListener(view) { _, insets ->
//                            val imeVisible = insets.isVisible(WindowInsetsCompat.Type.ime())
//                            val imeHeight = insets.getInsets(WindowInsetsCompat.Type.ime()).bottom
//                            viewModelLogin.checkKeyUp.value = imeVisible
//                            insets
//                        }
                        //viewModelLogin.checkKeyUp.observe(viewLifecycleOwner, checkObserver.value)

                        //Button(onClick = { this@LoginFragment.requireView().windowInsetsController!!.show(WindowInsets.Type.ime()) }) {}
                        Spacer(
                            modifier = Modifier.padding(
                                if (check.value == Keyboard.Opened) {
                                    0.0.wp()
                                } else {
                                    3.0.hp()
                                }
                            )
                        )
                        KidLockTitle(
                            Modifier,
                            R.drawable.kidlockgreen,
                            Color.White,
                            check.value == Keyboard.Opened
                        )
                        Spacer(
                            modifier = Modifier.padding(
                                if (check.value == Keyboard.Opened) {
                                    0.0.wp()
                                } else {
                                    3.0.hp()
                                }
                            )
                        )
                        LoginParent(
                            modifier = Modifier,
                            colorBackGround = Color.White,
                            title = "Login as parent",
                            icon = R.drawable.eye_off_1,
                            valueEmailChange = {viewModelLogin.valueEmailChange(it)},
                            valuePassWordChange = { viewModelLogin.valuePasswordChange(it) },
                            checkCorrectLogin =  viewModelLogin.checkLoginCorrect.observeAsState()
                        )


                        Text(
                            modifier = Modifier
                                .padding(3.0.wp())
                                .clickable {
//                    if (view != null) {
//                        Navigation
//                            .findNavController(view = view)
//                            .navigate(R.id.action_loginFragment_to_homeFragment)
//                    }
                                },
                            text = "Cancel",
                            style = MaterialTheme.typography.labelMedium.copy(color = Color.White),
                            textDecoration = TextDecoration.Underline,
                            textAlign = TextAlign.Center
                        )
                    }
                }
            }
        }

        return view
    }


//    @Composable
//    @Preview(showSystemUi = true)
//    fun LoginPreview() {
//        KidlockTheme {
//            Column(
//                modifier = Modifier.fillMaxSize()
//            ) {
//                Spacer(modifier = Modifier.padding(30.dp))
//               // KidLockTitle(Modifier, R.drawable.kidlockgreen, Color.White, )
//                Spacer(modifier = Modifier.padding(20.dp))
//                LoginParent(
//                    modifier = Modifier,
//                    colorBackGround = Color.White,
//                    title = "Login as parent",
//                    icon = R.drawable.eye_off_1
//                )
//            }
//        }
//    }


    @Composable
    @Preview(showSystemUi = true)
    fun Preview() {
        KidlockTheme {
            LoginParent(
                modifier = Modifier,
                colorBackGround = Color.White,
                title = "Login as parent",
                icon = R.drawable.eye_off_1,
                checkCorrectLogin = remember {
                    mutableStateOf(false)
                },
                valueEmailChange = {},
                valuePassWordChange = {}
            )
        }
    }

    @Composable
    fun LoginParent(
        modifier: Modifier,
        colorBackGround: Color,
        title: String,
        icon: Int,
        valueEmailChange: (String)-> Unit,
        valuePassWordChange: (String)-> Unit,
        checkCorrectLogin: State<Boolean?>
    ) {
        val valueEmail = remember {
            mutableStateOf("")
        }
        val valuePassword = remember {
            mutableStateOf("")
        }
        var loadingLogin by rememberSaveable {
            mutableStateOf(false)
        }
        val rememberCoroutine = rememberCoroutineScope()
        val focusManager = LocalFocusManager.current
        val focusRequester = remember { FocusRequester() }
        var passwordVisible by rememberSaveable { mutableStateOf(false) }

        Box(modifier = Modifier
            .fillMaxWidth()
            .size(60.0.hp())){
            Column(
                modifier = modifier
                    .height(60.0.hp())
                    .verticalScroll(rememberScrollState())
                    .padding(horizontal = 5.0.wp(), vertical = 5.0.wp())
                    .fillMaxWidth()
                    .background(color = colorBackGround, shape = MaterialTheme.shapes.medium),
                verticalArrangement = Arrangement.spacedBy(5.dp),
                horizontalAlignment = Alignment.CenterHorizontally,
            ) {
                Spacer(modifier = modifier.padding(top = 5.0.wp()))
                Text(
                    modifier = modifier.padding(top = 1.5.wp()),
                    text = title,
                    style = MaterialTheme.typography.displaySmall
                )
                Spacer(modifier = modifier.padding(top = 5.0.wp()))
                Column(
                    modifier = modifier
                        .fillMaxWidth()
                        .padding(horizontal = 5.0.wp()),
                    verticalArrangement = Arrangement.Top,
                    horizontalAlignment = Alignment.Start,
                ) {
                    Text(
                        text = "Email",
                        style = MaterialTheme.typography.titleMedium,
                    )
                    TextField(
                        modifier = modifier
                            .fillMaxWidth()
                            .focusRequester(focusRequester),
                        value = valueEmail.value,
                        keyboardOptions = KeyboardOptions(imeAction = ImeAction.Next),
                        keyboardActions = KeyboardActions(
                            onNext = { focusManager.moveFocus(FocusDirection.Down) }
                        ),
                        onValueChange = {it ->
                            valueEmailChange(it)
                            valueEmail.value = it
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
                    Text(
                        modifier = modifier
                            .height(
                                if (checkCorrectLogin.value!!) {
                                    0.0.hp()
                                } else {
                                    Dp.Unspecified
                                }
                            )
                            .width(Dp.Unspecified)
                            .align(Alignment.End)
                            .padding(top = 1.0.wp())
                            .clickable {
//                            Navigation
//                                .findNavController(view = view)
//                                .navigate(R.id.action_loginFragment_to_forgotPassFragment)
                            },
                        text = "Email or password error",
                        style = MaterialTheme.typography.labelSmall.copy(color = MaterialTheme.color.red),
                        textDecoration = TextDecoration.Underline
                    )
                    Spacer(modifier = modifier.padding(3.0.wp()))
                    Text(
                        text = "Password",
                        style = MaterialTheme.typography.titleMedium,
                    )
                    TextField(
                        modifier = modifier
                            .fillMaxWidth(),
                        value = valuePassword.value, onValueChange = {
                            valuePassWordChange(it)
                            valuePassword.value = it
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
                    Text(
                        modifier = modifier
                            .height(
                                if (checkCorrectLogin.value!!) {
                                    0.0.hp()
                                } else {
                                    Dp.Unspecified
                                }
                            )
                            .width(Dp.Unspecified)
                            .align(Alignment.End)
                            .padding(top = 1.0.wp())
                            .clickable {
//                            Navigation
//                                .findNavController(view = view)
//                                .navigate(R.id.action_loginFragment_to_forgotPassFragment)
                            },
                        text = "Email or password error",
                        style = MaterialTheme.typography.labelSmall.copy(color = MaterialTheme.color.red),
                        textDecoration = TextDecoration.Underline
                    )
                    Spacer(modifier = modifier.padding(3.5.wp()))
                    Text(
                        modifier = modifier
                            .height(Dp.Unspecified)
                            .width(Dp.Unspecified)
                            .align(Alignment.End)
                            .clickable {
//                            Navigation
//                                .findNavController(view = view)
//                                .navigate(R.id.action_loginFragment_to_forgotPassFragment)
                            },
                        text = "Forgot password?",
                        style = MaterialTheme.typography.labelMedium.copy(color = MaterialTheme.color.LightningYellow),
                        textDecoration = TextDecoration.Underline
                    )
                }
                Button(
                    enabled =  !loadingLogin,
                    onClick = {
                        loadingLogin = true
                        rememberCoroutine.launch {
                            delay(500L)
                            viewModelLogin.loginAccoutn()
                            loadingLogin = false
                        }
                        //viewModelLogin.createDB()
                    }, modifier = modifier
                        .fillMaxWidth()
                        .padding(3.0.wp()),
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
                        .padding(3.0.wp())
                        .clickable {
//                        Navigation
//                            .findNavController(view = view)
//                            .navigate(R.id.action_loginFragment_to_createNewAccountFragment)

                        },
                    text = "Create new account",
                    style = MaterialTheme.typography.labelMedium.copy(color = MaterialTheme.color.LightningYellow),
                    textDecoration = TextDecoration.Underline
                )
                Spacer(modifier = modifier.padding(top = 3.0.wp()))


            }
            if (loadingLogin){
                CircularProgressIndicator(
                    modifier = Modifier
                        .size(20.0.wp())
                        .align(Alignment.Center),
                    color = MaterialTheme.colorScheme.secondary,
                )
            }

        }

        LaunchedEffect(Unit) {
            focusRequester.requestFocus()
        }
    }

    @Composable
    fun KidLockTitle(
        modifier: Modifier,
        icon: Int,
        color: Color,
        stateKeyUp: Boolean
    ) {
        val height = if (stateKeyUp) {
            0.0.hp()
        } else {
            7.0.hp()
        }
        Row(
            modifier = modifier
                .height(height)
                .wrapContentWidth(),
            horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.CenterVertically,
        ) {
            Image(
                painter = painterResource(id = icon),
                contentDescription = "image description",
                contentScale = ContentScale.None
            )
            Spacer(modifier = modifier.padding(5.0.wp()))
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

