package com.example.kidlock.persentation.views.signup

import android.annotation.SuppressLint
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.gestures.scrollable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.verticalScroll
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
import androidx.compose.runtime.State
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.FocusDirection
import androidx.compose.ui.focus.FocusManager
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
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.fragment.app.viewModels
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.findNavController
import com.example.kidlock.R
import com.example.kidlock.persentation.navigation.ApplicationPages
import com.example.kidlock.persentation.navigation.NavigationApplication
import com.example.kidlock.persentation.navigation.popStack
import com.example.kidlock.persentation.utils.SizeScreen.wp
import com.example.kidlock.persentation.views.mainscreen.MainScreenViewModel
import com.example.kidlock.persentation.views.signup.compose.NameUser
import com.example.kidlock.persentation.views.signup.compose.TypeInput
import com.example.kidlock.persentation.views.signup.compose.TypeTextInputVaild
import com.example.kidlock.persentation.views.signup.compose.textInput
import com.example.kidlock.persentation.views.signup.compose.textInputPinCode
import com.example.kidlock.persentation.views.statekeyboard.Keyboard
import com.example.kidlock.persentation.views.statekeyboard.keyboardAsStateWithoutApi
import com.example.kidlock.theme.KidlockTheme
import com.example.kidlock.theme.KidlockTheme.color
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class SignUpFragment : Fragment() {

    val mainViewModel by activityViewModels<MainScreenViewModel>()
    val signUpViewModel by viewModels<SignUpViewModel>()
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        super.onCreateView(inflater, container, savedInstanceState)
        val view = inflater.inflate(R.layout.fragment_signup, container, false)
        view.findViewById<ComposeView>(R.id.composeview_signup).setContent {
            KidlockTheme {

                val rememberNavControll = rememberNavController()
                NavHost(
                    navController = rememberNavControll,
                    startDestination = ComposeGrap.VIEW_OF_SIGN_UP.name,
                    modifier = Modifier.fillMaxSize()
                ) {
                    composable(ComposeGrap.VIEW_OF_SIGN_UP.name) {
                        viewOfSignUp(rememberNavControll)
                    }
                    composable(ComposeGrap.VIEW_OF_SET_PIN_CODE.name) {
                        viewOfSetPinCode(rememberNavControll)
                    }
                    composable(ComposeGrap.VIEW_OF_REPEAT_PIN_CODE.name) {
                        viewOfRepeatPinCode(rememberNavControll)
                    }
                }
            }
        }
        return view
    }

    override fun onStart() {
        super.onStart()
        Log.e(
            "Number instance of object ", "So instnace cuar nameuser"
                    + TypeTextInputVaild.counter.toString()
        )
        signUpViewModel.pinCode.observeForever(Observer() { it ->
            Log.e("TEST INPUT", it)
        })

    }


    @Composable
    fun viewOfSignUp(navController: NavController) {
        val localFocusColum = LocalFocusManager.current
        val rememberKeyState = keyboardAsStateWithoutApi()
        val paddingHeight = if (rememberKeyState.value == Keyboard.Opened) {
            0.5.wp()
        } else {
            3.0.wp()
        }
        Column(
            modifier = Modifier
                .fillMaxSize()
                .verticalScroll(rememberScrollState())
                .clickable {
                    localFocusColum.clearFocus()
                }
                .fillMaxSize()
                .padding(3.0.wp()),
            verticalArrangement = Arrangement.spacedBy(paddingHeight),
            horizontalAlignment = Alignment.CenterHorizontally,
        ) {
            Text(
                modifier = Modifier.padding(top = 3.0.wp() + paddingHeight),
                text = "Create new account ",
                style = MaterialTheme.typography.displaySmall
            )

            for (element in signUpViewModel.listInforSignUp) {
                if (element.key != TypeInput.REPEAT_PASSWORD_USER) {
                    textInput(typeInput = element.value.apply {
                        this.keyboardOptions.copy(imeAction = ImeAction.Next)
                        this.keyboardActions = KeyboardActions(onNext = {
                            localFocusColum.moveFocus(
                                FocusDirection.Down
                            )
                        })
                    })
                    Spacer(modifier = Modifier.padding(paddingHeight))
                } else {
                    textInput(typeInput = element.value.apply {
                        this.keyboardOptions.copy(imeAction = ImeAction.Done)
                        this.keyboardActions = KeyboardActions(onNext = {
                            localFocusColum.clearFocus()
                        })
                    })
                    Spacer(modifier = Modifier.padding(paddingHeight))
                }
            }
            Button(
                onClick = {
                    if (signUpViewModel.checkvVaildTextInput()) {
                        navController.navigate(ComposeGrap.VIEW_OF_SET_PIN_CODE.name)
                    }
                },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(5.0.wp()),
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
                    .align(Alignment.CenterHorizontally)
                    .padding(3.0.wp())
                    .clickable {
                        mainViewModel.navControllerApplication.popBackStack()
                    },
                text = "Back to login",
                style = MaterialTheme.typography.labelMedium.copy(color = MaterialTheme.color.LightningYellow),
                textDecoration = TextDecoration.Underline,
                textAlign = TextAlign.Center
            )
        }
    }


    @Composable
    fun viewOfSetPinCode(navController: NavController) {
        val localFocusColum = LocalFocusManager.current
        val paddingHeight = 3.0.wp()
        Column(
            modifier = Modifier
                .fillMaxSize()
                .verticalScroll(rememberScrollState())
                .clickable {
                    localFocusColum.clearFocus()
                }
                .fillMaxSize()
                .padding(3.0.wp()),
            verticalArrangement = Arrangement.spacedBy(paddingHeight),
            horizontalAlignment = Alignment.CenterHorizontally,
        ) {
            Text(
                modifier = Modifier.padding(top = 3.0.wp() + paddingHeight),
                text = "Set parental PIN ",
                style = MaterialTheme.typography.displaySmall
            )
            textInputPinCode(input = signUpViewModel.pinCode, 6)
            Button(
                onClick = {
                    if (signUpViewModel.pinCode.value!!.toIntOrNull() != null) {
                        navController.navigate(ComposeGrap.VIEW_OF_REPEAT_PIN_CODE.name)
                    }
                },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(5.0.wp()),
                colors = ButtonDefaults.buttonColors(
                    containerColor = MaterialTheme.color.LightningYellow,
                ),
                shape = MaterialTheme.shapes.small
            ) {
                Text(
                    text = "Next step",
                    style = MaterialTheme.typography.titleMedium,
                    color = Color.White
                )
            }


        }
    }


    @Composable
    fun viewOfRepeatPinCode(navController: NavController) {
        val localFocusColum = LocalFocusManager.current
        val paddingHeight = 3.0.wp()
        Column(
            modifier = Modifier
                .fillMaxSize()
                .verticalScroll(rememberScrollState())
                .clickable {
                    localFocusColum.clearFocus()
                }
                .fillMaxSize()
                .padding(3.0.wp()),
            verticalArrangement = Arrangement.spacedBy(paddingHeight),
            horizontalAlignment = Alignment.CenterHorizontally,
        ) {
            Text(
                modifier = Modifier.padding(top = 3.0.wp() + paddingHeight),
                text = "Enter pin code again ",
                style = MaterialTheme.typography.displaySmall
            )
            textInputPinCode(input = signUpViewModel.repeatPinCode, 6)
            Button(
                onClick = {
                    if (signUpViewModel.checkValidPincode()) {
                        popStack(
                            mainViewModel.navControllerApplication,
                            ApplicationPages.LOGIN_ACCOUNT_FRAGMENT,
                            true,
                            false
                        )
                    }
                },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(5.0.wp()),
                colors = ButtonDefaults.buttonColors(
                    containerColor = MaterialTheme.color.LightningYellow,
                ),
                shape = MaterialTheme.shapes.small
            ) {
                Text(
                    text = "Finish",
                    style = MaterialTheme.typography.titleMedium,
                    color = Color.White
                )
            }


        }
    }
}



