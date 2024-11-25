package com.example.kidlock.uilayer.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
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
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.IconButton
import androidx.compose.material.Scaffold
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
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.FocusRequester
import androidx.compose.ui.focus.focusRequester
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.ComposeView
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.fragment.app.Fragment
import androidx.navigation.Navigation
import com.example.kidlock.R
import com.example.kidlock.theme.KidlockTheme
import com.example.kidlock.theme.KidlockTheme.color
import com.example.kidlock.uilayer.compose.Dot
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class OldParentalPINFragment : Fragment() {
    lateinit private var view: View
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
                                        text = "Parental PIN",
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
                                    .padding(15.dp)
                                    .background(Color.White),
                                verticalArrangement = Arrangement.Top,
                                horizontalAlignment = Alignment.CenterHorizontally
                            ) {
                                Text(
                                    modifier = Modifier.padding(20.dp),
                                    text = "Enter parental PIN",
                                    style = MaterialTheme.typography.displaySmall
                                )
                                Spacer(modifier = Modifier.padding(20.dp))
                                OldPinDigit(colorBackGround = Color(0XFFCDE6FE))
                                Text(
                                    modifier = Modifier
                                        .fillMaxWidth()
                                        .padding(end = 10.dp)
                                        .clickable {

                                        },
                                    textAlign = TextAlign.End,
                                    text = "Forgot PIN?",
                                    style = MaterialTheme.typography.labelMedium.copy(color = MaterialTheme.color.LightningYellow),
                                    textDecoration = TextDecoration.Underline
                                )
                                Spacer(modifier = Modifier.padding(20.dp))
                                Button(
                                    onClick = {
                                        Navigation.findNavController(view)
                                            .navigate(R.id.action_oldParentalPINFragment_to_changeParentalPINFragment)
                                    }, modifier = Modifier
                                        .fillMaxWidth()
                                        .padding(10.dp),
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
                    )
                }
            }
        }
        return view
    }


    @Composable
    @Preview(showSystemUi = true)
    fun OldParentalPINPreview() {
        KidlockTheme {
            Scaffold(
                topBar = {
                    TopAppBar(
                        title = {
                            androidx.compose.material.Text(
                                text = "Parental PIN",
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
                            .padding(15.dp)
                            .background(Color.White),
                        verticalArrangement = Arrangement.Top,
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {
                        Text(
                            modifier = Modifier.padding(20.dp),
                            text = "Enter parental PIN",
                            style = MaterialTheme.typography.displaySmall
                        )
                        Spacer(modifier = Modifier.padding(20.dp))
                        OldPinDigit(colorBackGround = Color(0XFFCDE6FE))
                        Text(
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(end = 10.dp)
                                .clickable {

                                },
                            textAlign = TextAlign.End,
                            text = "Forgot PIN?",
                            style = MaterialTheme.typography.labelMedium.copy(color = MaterialTheme.color.LightningYellow),
                            textDecoration = TextDecoration.Underline
                        )
                        Spacer(modifier = Modifier.padding(20.dp))
                        Button(
                            onClick = {

                            }, modifier = Modifier
                                .fillMaxWidth()
                                .padding(10.dp),
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
            )
        }
    }

    @Composable
    fun OldPinDigit(modifier: Modifier = Modifier, colorBackGround: Color) {
        val focusRequester = remember { FocusRequester() }
        val lenghTextInput = 6
        val focusManager = LocalFocusManager.current
        var textInputNum by remember { mutableStateOf(TextFieldValue("")) }
        val keyboardActions = KeyboardActions(onGo = {

        })
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
                    },
                    singleLine = true,
                    keyboardOptions = KeyboardOptions(
                        keyboardType = KeyboardType.NumberPassword,
                        imeAction = ImeAction.Done,
                    ),
                    keyboardActions = keyboardActions
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