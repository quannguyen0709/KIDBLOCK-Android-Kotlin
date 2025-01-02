package com.example.kidlock.persentation.views.signup

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.compose.foundation.clickable
import androidx.compose.foundation.gestures.scrollable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentHeight
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
import androidx.compose.ui.focus.FocusManager
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
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.fragment.app.viewModels
import androidx.navigation.findNavController
import com.example.kidlock.R
import com.example.kidlock.persentation.utils.SizeScreen.wp
import com.example.kidlock.persentation.views.signup.compose.NameUser
import com.example.kidlock.persentation.views.signup.compose.TypeTextInputVaild
import com.example.kidlock.persentation.views.signup.compose.textInput
import com.example.kidlock.persentation.views.statekeyboard.Keyboard
import com.example.kidlock.persentation.views.statekeyboard.keyboardAsStateWithoutApi
import com.example.kidlock.theme.KidlockTheme
import com.example.kidlock.theme.KidlockTheme.color

class SignUpFragment: Fragment() {

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
                viewOfSignUp()
            }
        }
        return  view
    }

    @Composable
    fun viewOfSignUp(){
        val listLocalFocus = List(4, { LocalFocusManager.current})
        val localFocusColum = LocalFocusManager.current
        val rememberKeyState = keyboardAsStateWithoutApi()
        val paddingHeight = if(rememberKeyState.value == Keyboard.Opened){0.5.wp()}else{3.0.wp()}
        signUpViewModel.setValueOfListInforSignUp(listLocalFocus.get(0), listLocalFocus.get(1), listLocalFocus.get(2), listLocalFocus.get(3))
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
                text = "Create new account " ,
                style = MaterialTheme.typography.displaySmall
            )
            for(element in signUpViewModel.listInforSignUp ){
                textInput(typeInput = element.value)
                Spacer(modifier = Modifier.padding(paddingHeight))
            }
            Button(
                onClick = {

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
                    .clickable { },
                text = "Back to login",
                style = MaterialTheme.typography.labelMedium.copy(color = MaterialTheme.color.LightningYellow),
                textDecoration = TextDecoration.Underline,
                textAlign = TextAlign.Center
            )
        }
    }
    @Composable
    @Preview(showSystemUi = true, device = "spec:width=1079.9px,height=2340px,dpi=440")
    fun Test(){
        KidlockTheme {
            textInput(typeInput = NameUser(focusManager = LocalFocusManager.current))
        }
    }
}



