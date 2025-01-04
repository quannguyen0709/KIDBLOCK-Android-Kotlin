package com.example.kidlock.persentation.views.setting.viewcompose

import android.os.Bundle
import android.util.Log
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
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.IconButton
import androidx.compose.material.Scaffold
import androidx.compose.material.TopAppBar
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.fragment.app.setFragmentResult
import androidx.lifecycle.MutableLiveData
import androidx.navigation.NavController
import com.example.kidlock.R
import com.example.kidlock.persentation.navigation.ApplicationPages
import com.example.kidlock.persentation.navigation.popStack
import com.example.kidlock.persentation.utils.SizeScreen.wp
import com.example.kidlock.persentation.views.setting.ComposeGraph
import com.example.kidlock.persentation.views.signup.ComposeGrap
import com.example.kidlock.persentation.views.signup.compose.textInputPinCode
import com.example.kidlock.theme.KidlockTheme
import com.example.kidlock.theme.KidlockTheme.color
import com.example.kidlock.utils.gson.toJsonFromObject


@Composable
fun viewOfAskPinCode(popBackStack:(()->Unit),navController: NavController,pinCode: MutableLiveData<String>, checkValidPinCode: (()->Boolean)){

    val localFocusColum = LocalFocusManager.current
    val paddingHeight = 3.0.wp()
    KidlockTheme {
        Scaffold(
            topBar = {
                TopAppBar(
                    title = {
                        androidx.compose.material.Text(
                            text = "Enter parental PIN",
                            style = MaterialTheme.typography.headlineSmall
                        )
                    },
                    navigationIcon = {
                        IconButton(onClick = {popBackStack()}) {
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
                    textInputPinCode(input = pinCode, 6)
                    Text(
                        modifier = Modifier
                            .height(Dp.Unspecified)
                            .width(Dp.Unspecified)
                            .align(Alignment.End)
                            .clickable {
                                navController.navigate(ComposeGraph.VIEW_OF_FORGOT_PIN_CODE.name)
                            },
                        text = "Forgot password?",
                        style = MaterialTheme.typography.labelMedium.copy(color = MaterialTheme.color.LightningYellow),
                        textDecoration = TextDecoration.Underline
                    )
                    Button(
                        onClick = {
                            if (checkValidPinCode()) {
                                navController.navigate(ComposeGraph.VIEW_OF_CHANGE_PIN_CODE.name)
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
        )
    }
}