package com.example.kidlock.uilayer.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.FocusRequester
import androidx.compose.ui.focus.focusRequester
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.ComposeView
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import com.example.kidlock.R
import com.example.kidlock.theme.KidlockTheme
import com.example.kidlock.theme.KidlockTheme.color
import com.example.kidlock.uilayer.compose.Dot
import com.example.kidlock.uilayer.viewmodel.CreateAccount
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class RepeatParentalPINFragment : Fragment() {
    private val viewModel by activityViewModels<CreateAccount>()
    private lateinit var view: View
    private var textPin by mutableStateOf("")
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
         view = inflater.inflate(R.layout.fragment_repeat_parental_pin, container, false).apply {
            findViewById<ComposeView>(R.id.composeview_repeat_parental_pin).setContent {
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
                            text = "Enter pin code again",
                            style = MaterialTheme.typography.displaySmall
                        )
                        Spacer(modifier = Modifier.padding(20.dp))
                        RepeatPinDigit(colorBackGround = Color(0XFFCDE6FE))
                        Button(
                            onClick = {
//                                viewModel.isertData(textPin, viewModel.repeatPin)
//                                if(viewModel.equalsPinRepeatPin()){
//                                    viewModel.addNewAccount()
//                                    Navigation.findNavController(view).navigate(R.id.action_repeatParentalPINFragment_to_loginFragment)
//                                }
//                                else{
//                                    Navigation.findNavController(view).navigate(R.id.action_repeatParentalPINFragment_to_setParentalPINFragment)
//                                }
                            },
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(5.dp),
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
        }
        return view
    }

    @Composable
    @Preview(showSystemUi = true)
    fun RepeatParentalPINPreview() {
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
                    text = "Enter pin code again",
                    style = MaterialTheme.typography.displaySmall
                )
                Spacer(modifier = Modifier.padding(20.dp))
                RepeatPinDigit(colorBackGround = Color(0XFFCDE6FE))
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
                        text = "Finish",
                        style = MaterialTheme.typography.titleMedium,
                        color = Color.White
                    )
                }
            }
        }
    }
    @Composable
    fun RepeatPinDigit(modifier: Modifier = Modifier, colorBackGround: Color) {
        val focusRequester = remember { FocusRequester() }
        val lenghTextInput = 6
        val focusManager = LocalFocusManager.current
        var textInputNum by remember { mutableStateOf(TextFieldValue("")) }
        Column(
            modifier = Modifier.fillMaxWidth(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally,
        ) {
            Box {
                BasicTextField(
                    modifier = Modifier
                        .focusRequester(focusRequester)
                        .fillMaxWidth()
                        .height(0.dp)
                        .background(color = Color(0XFFFFFFFF)),
                    value = textInputNum,
                    onValueChange = {
                        if (it.text.length <= lenghTextInput) textInputNum = it
                        textPin = textInputNum.text
                    },
                    singleLine = true,
                    keyboardOptions = KeyboardOptions(
                        keyboardType = KeyboardType.NumberPassword,
                        imeAction = ImeAction.Done,
                    ),
                    keyboardActions = KeyboardActions(
                        onDone = {
//                            if(viewModel.equalsPinRepeatPin()){
//                                viewModel.addNewAccount()
//                                Navigation.findNavController(view).navigate(R.id.action_repeatParentalPINFragment_to_loginFragment)
//                            }
                        }
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
}

