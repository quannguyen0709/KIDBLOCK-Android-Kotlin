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
import androidx.compose.foundation.layout.padding
import androidx.compose.material.IconButton
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.ComposeView
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import com.example.kidlock.R
import com.example.kidlock.theme.KidlockTheme
import com.example.kidlock.theme.KidlockTheme.color
import com.example.kidlock.uilayer.compose.TextBox
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class ForgotPassFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_forgot_pass, container, false).apply {
            findViewById<ComposeView>(R.id.composeview_forgot_pass).setContent {
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
                                    IconButton(onClick = { findNavController().navigate(R.id.action_forgotPassFragment_to_loginFragment) }) {
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
    }

    @Composable
    @Preview(showSystemUi = true)
    fun ForgotPassPreview(){
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
                            IconButton(onClick = {  }) {
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




