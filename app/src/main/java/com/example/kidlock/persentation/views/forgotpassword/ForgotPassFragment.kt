package com.example.kidlock.persentation.views.forgotpassword

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.IconButton
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.ComposeView
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.fragment.app.setFragmentResultListener
import androidx.lifecycle.MutableLiveData
import androidx.navigation.findNavController
import com.example.kidlock.R
import com.example.kidlock.domain.kidlock.data.ParentUser
import com.example.kidlock.persentation.navigation.ApplicationPages
import com.example.kidlock.persentation.navigation.popStack
import com.example.kidlock.persentation.utils.SizeScreen.hp
import com.example.kidlock.persentation.utils.SizeScreen.wp
import com.example.kidlock.persentation.views.loginfragment.LoginViewModel
import com.example.kidlock.persentation.views.mainscreen.MainScreenViewModel
import com.example.kidlock.persentation.views.signup.compose.EmailUser
import com.example.kidlock.persentation.views.signup.compose.TypeTextInputVaild
import com.example.kidlock.persentation.views.signup.compose.textInput
import com.example.kidlock.theme.KidlockTheme
import com.example.kidlock.theme.KidlockTheme.color
import com.example.kidlock.uilayer.compose.TextBox
import com.example.kidlock.utils.gson.fromJsonToObject
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.async
import kotlinx.coroutines.launch

@AndroidEntryPoint
class ForgotPassFragment : Fragment() {
    private val loginViewModel by activityViewModels<LoginViewModel>()
    private val mainScreenViewModel by activityViewModels<MainScreenViewModel>()
    private val executeCorrect = MutableLiveData(false)
    private val parentUser = MutableLiveData(ParentUser())

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setFragmentResultListener("requestKey") { requestKey, bundle ->
            // We use a String here, but any type that can be put in a Bundle is supported
            parentUser.value =
                fromJsonToObject<ParentUser>(bundle.getString("bundleKey").toString())
            // Do something with the result

        }
    }

    override fun onStart() {
        super.onStart()
        Log.e("CHECK BUNDLE PASS", parentUser.value.toString())
    }
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_forgot_pass, container, false).apply {
            findViewById<ComposeView>(R.id.composeview_forgot_pass).setContent {
                KidlockTheme {
                    val localFocus = LocalFocusManager.current.clearFocus()
                    val rememberCoroutine = rememberCoroutineScope()
                    var loadingLogin by remember {
                        mutableStateOf(false)
                    }
                    Scaffold(
                        topBar = {
                            TopAppBar(
                                title = {
                                    Text(
                                        text = "Forgot password",
                                        style = MaterialTheme.typography.headlineSmall
                                    )
                                },
                                navigationIcon = {
                                    IconButton(onClick = {
                                        popStack(
                                            mainScreenViewModel.navControllerApplication,
                                            ApplicationPages.LOGIN_ACCOUNT_FRAGMENT,
                                            true,
                                            false
                                        )
                                    }) {
                                        Icon(
                                            tint = MaterialTheme.color.Jade,
                                            painter = painterResource(id = R.drawable.arrow_left_1),
                                            contentDescription = ""
                                        )
                                    }
                                },
                                backgroundColor = Color.White,
                                contentColor = Color.Black,
                                elevation = 3.0.wp()
                            )
                        },
                        content = {
                            it
                            Column(
                                modifier = Modifier
                                    .fillMaxSize()
                                    .padding(3.0.wp())
                                    .background(Color.White),
                                verticalArrangement = Arrangement.Top,
                                horizontalAlignment = Alignment.CenterHorizontally
                            ) {

                                Spacer(modifier = Modifier.padding(10.0.hp()))
                                if (!executeCorrect.observeAsState().value!!) {
                                    textInput(typeInput = loginViewModel.emailUserForgotPassword.apply {
                                        this.keyboardOptions.copy(imeAction = ImeAction.Done)
                                        this.keyboardActions =
                                            KeyboardActions(onDone = { localFocus })
                                    })
                                } else {
                                    Text(
                                        modifier = Modifier.fillMaxWidth(),
                                        text = "Password reset link has been sent to " + loginViewModel.emailUserForgotPassword.input.value,
                                        style = MaterialTheme.typography.titleMedium
                                    )
                                }
                                Spacer(modifier = Modifier.padding(5.0.hp()))
                                if (!executeCorrect.observeAsState().value!!) {
                                    Button(
                                        onClick = {
                                            loadingLogin = true
                                            rememberCoroutine.launch {
                                                if (loginViewModel.emailUserForgotPassword.vaildCheck.value!!) {
                                                    executeCorrect.value = async {
                                                        loginViewModel.exxcuteRequestChangePassWord()
                                                    }.await()
                                                    if (executeCorrect.value!!) {

                                                    }
                                                    loadingLogin = false
                                                }
                                                loadingLogin = false
                                            }

                                        }, modifier = Modifier
                                            .fillMaxWidth()
                                            .padding(10.dp),
                                        colors = ButtonDefaults.buttonColors(
                                            containerColor = MaterialTheme.color.LightningYellow,
                                        ),
                                        shape = MaterialTheme.shapes.small
                                    ) {
                                        androidx.compose.material3.Text(
                                            text = "Login",
                                            style = MaterialTheme.typography.titleMedium,
                                            color = Color.White
                                        )
                                    }
                                }else{}
                            }
                            Box(modifier = Modifier.fillMaxSize()) {
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
                    )

                }
            }
        }
    }

    @Composable
    @Preview(showSystemUi = true)
    fun ForgotPassPreview() {
        KidlockTheme {
            Scaffold(
                topBar = {
                    TopAppBar(
                        title = {
                            Text(
                                text = "Forgot password",
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
                            .background(Color.White),
                        verticalArrangement = Arrangement.Top,
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {
                        TextBox(
                            modifier = Modifier,
                            title = "Email",
                            placeholder = "johndoe@example.com",
                            pass = false,
                            icon = 0,
                            end = true
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
                            androidx.compose.material3.Text(
                                text = "Login",
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




