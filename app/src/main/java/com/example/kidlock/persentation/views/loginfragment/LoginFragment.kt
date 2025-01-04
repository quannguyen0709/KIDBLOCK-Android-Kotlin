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
import androidx.compose.ui.focus.focusProperties
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
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.activityViewModels
import androidx.fragment.app.setFragmentResult
import com.example.kidlock.R
import com.example.kidlock.persentation.navigation.ApplicationPages
import com.example.kidlock.persentation.utils.SizeScreen.hp
import com.example.kidlock.persentation.utils.SizeScreen.wp
import com.example.kidlock.persentation.views.mainscreen.MainScreenViewModel
import com.example.kidlock.persentation.views.signup.compose.TypeInput
import com.example.kidlock.persentation.views.signup.compose.textInput
import com.example.kidlock.persentation.views.statekeyboard.Keyboard
import com.example.kidlock.persentation.views.statekeyboard.keyboardAsStateWithApi
import com.example.kidlock.theme.KidlockTheme
import com.example.kidlock.theme.KidlockTheme.color
import com.example.kidlock.utils.gson.toJsonFromObject
import com.google.gson.Gson
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.async
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
                        )


                        Text(
                            modifier = Modifier
                                .padding(3.0.wp())
                                .clickable {
                                    viewModelMain.navControllerApplication.popBackStack()
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
            )
        }
    }

    @Composable
    fun LoginParent(
        modifier: Modifier,
        colorBackGround: Color,
        title: String,
    ) {
        var loadingLogin by rememberSaveable {
            mutableStateOf(false)
        }
        val rememberCoroutine = rememberCoroutineScope()
        val focusManager = LocalFocusManager.current

        Box(
            modifier = Modifier
                .fillMaxWidth()
                .size(60.0.hp())
        ) {
            Column(
                modifier = modifier.clickable { focusManager.clearFocus() }
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
                    textInput(
                        typeInput = viewModelLogin.typeTextInputVaild.getValue(TypeInput.EMAIL_USER)
                            .apply {
                                this.keyboardActions =
                                    KeyboardActions(onNext = { focusManager.moveFocus(FocusDirection.Down) })
                                this.keyboardOptions = KeyboardOptions(imeAction = ImeAction.Next)
                            })
                    textInput(
                        typeInput = viewModelLogin.typeTextInputVaild.getValue(TypeInput.PASSWORD_USER)
                            .apply {
                                this.keyboardActions =
                                    KeyboardActions(onNext = { focusManager.clearFocus() })
                                this.keyboardOptions.copy(imeAction = ImeAction.Done)
                            })

                    Spacer(modifier = modifier.padding(3.5.wp()))

                    Text(
                        modifier = modifier
                            .height(Dp.Unspecified)
                            .width(Dp.Unspecified)
                            .align(Alignment.End)
                            .clickable {
                                val bundle: Bundle = Bundle().apply {
                                    this.putSerializable(
                                        "bundleKey",
                                        toJsonFromObject(viewModelLogin.parentUser)
                                    )
                                }
                                setFragmentResult("requestKey", bundle)
                                viewModelMain.navControllerApplication.navigate(ApplicationPages.FORGOT_PASSWORD)
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
                    modifier = modifier
                        .fillMaxWidth()
                        .padding(3.0.wp()),
                    colors = ButtonDefaults.buttonColors(
                        containerColor = MaterialTheme.color.LightningYellow,
                    ),
                    shape = MaterialTheme.shapes.small,
                    enabled = !loadingLogin,
                    onClick = {
                        loadingLogin = true
                        rememberCoroutine.launch {
                            delay(500L)
                            val loginCorrect = async {
                                viewModelLogin.loginAccoutn()
                            }.await()
                            if(loginCorrect){
                                runBlocking {
                                    val bundle: Bundle = Bundle().apply {
                                        this.putSerializable(
                                            "bundleKey",
                                            toJsonFromObject(viewModelLogin.parentUser)
                                        )
                                    }
                                    setFragmentResult("requestKey", bundle)

                                }
                                viewModelMain.navControllerApplication.navigate(ApplicationPages.DASHBOARD)
                                loadingLogin = false
                            }else{
                                loadingLogin = false
                            }
                        }
                        //viewModelMain.navControllerApplication.navigate(ApplicationPages.DASHBOARD)
                    },
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
                            viewModelMain.navControllerApplication.navigate(ApplicationPages.SIGNUP)
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
            if (loadingLogin) {
                CircularProgressIndicator(
                    modifier = Modifier
                        .size(20.0.wp())
                        .align(Alignment.Center),
                    color = MaterialTheme.colorScheme.secondary,
                )
            }

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

