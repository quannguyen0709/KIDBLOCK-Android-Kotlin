package com.example.kidlock.persentation.views.setting.viewcompose

import android.util.Log
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.IconButton
import androidx.compose.material.Scaffold
import androidx.compose.material.TopAppBar
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.kidlock.R
import com.example.kidlock.persentation.navigation.ApplicationPages
import com.example.kidlock.persentation.navigation.popStack
import com.example.kidlock.persentation.utils.SizeScreen.wp
import com.example.kidlock.persentation.views.setting.ComposeGraph
import com.example.kidlock.persentation.views.signup.compose.PasswordUser
import com.example.kidlock.persentation.views.signup.compose.RepeatPasswordUser
import com.example.kidlock.persentation.views.signup.compose.textInput
import com.example.kidlock.theme.KidlockTheme
import com.example.kidlock.theme.KidlockTheme.color
import com.example.kidlock.utils.resource.Resource
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.async
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

@Composable
fun viewOfChangePassword(
    changePassword: (suspend () -> Boolean),
    popBackStack: (() -> Unit),
    navController: NavController,
    oldPasswordUser: PasswordUser,
    newPasswordUser: PasswordUser,
    repeatPasswordUser: RepeatPasswordUser
) {
    val rememberCoroutine = rememberCoroutineScope()
    var rememberLoading = remember {
        mutableStateOf(false)
    }
    KidlockTheme {
        Scaffold(
            topBar = {
                TopAppBar(
                    title = {
                        androidx.compose.material.Text(
                            text = "Change password",
                            style = MaterialTheme.typography.headlineSmall
                        )
                    },
                    navigationIcon = {
                        IconButton(onClick = { popBackStack() }) {
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
                        .background(Color.White)
                        .padding(5.0.wp()),
                    verticalArrangement = Arrangement.spacedBy(3.0.wp()),
                    horizontalAlignment = Alignment.Start
                ) {
                    textInput(typeInput = oldPasswordUser)
                    textInput(typeInput = newPasswordUser)
                    textInput(typeInput = repeatPasswordUser)
                }
                Column(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(3.0.wp()),
                    verticalArrangement = Arrangement.Bottom,
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {

                    Button(
                        onClick = {
                            rememberLoading.value = true
                            rememberCoroutine.launch {
                                if(async { changePassword() }.await()){
                                    navController.navigate(ComposeGraph.VIEW_OF_DASHBOARD_SETTING.name)
                                }
                                rememberLoading.value = false
                            }
                        },
                        modifier = Modifier
                            .fillMaxWidth(),
                        colors = ButtonDefaults.buttonColors(
                            containerColor = MaterialTheme.color.LightningYellow,
                        ),
                        shape = MaterialTheme.shapes.small
                    ) {
                        Text(
                            text = "Change password",
                            style = MaterialTheme.typography.titleMedium,
                            color = Color.White
                        )
//                        Spacer(modifier = Modifier.padding(5.dp))
//                        Icon(
//                            painter = painterResource(id = R.drawable.log_out_2),
//                            contentDescription = ""
//                        )
                    }
                }
                loadingCircle(loadingLogin = rememberLoading.value)
            }
        )
    }
}

@Composable
fun loadingCircle(loadingLogin: Boolean) {
   Column (Modifier.fillMaxWidth(), verticalArrangement = Arrangement.Center, horizontalAlignment = Alignment.CenterHorizontally){
       if (loadingLogin) {
           CircularProgressIndicator(
               modifier = Modifier
                   .size(20.0.wp()),
               color = MaterialTheme.colorScheme.secondary,
           )
       }
   }
}
