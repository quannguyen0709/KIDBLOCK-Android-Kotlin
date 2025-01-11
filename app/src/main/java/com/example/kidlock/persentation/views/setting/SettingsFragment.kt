package com.example.kidlock.persentation.views.setting

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
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
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.ComposeView
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.fragment.app.setFragmentResultListener
import androidx.navigation.NavController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.kidlock.R
import com.example.kidlock.domain.model.ParentUser
import com.example.kidlock.persentation.navigation.ApplicationPages
import com.example.kidlock.persentation.navigation.popStack
import com.example.kidlock.persentation.utils.SizeScreen.wp
import com.example.kidlock.theme.KidlockTheme
import com.example.kidlock.theme.KidlockTheme.color
import com.example.kidlock.persentation.views.mainscreen.MainScreenViewModel
import com.example.kidlock.persentation.views.setting.viewcompose.viewOfAskPinCode
import com.example.kidlock.persentation.views.setting.viewcompose.viewOfChangePassword
import com.example.kidlock.persentation.views.setting.viewcompose.viewOfChangePinCode
import com.example.kidlock.persentation.views.setting.viewcompose.viewOfForgotPinCode
import com.example.kidlock.persentation.views.signup.compose.PasswordUser
import com.example.kidlock.persentation.views.signup.compose.RepeatPasswordUser
import com.example.kidlock.utils.gson.fromJsonToObject
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class SettingsFragment : Fragment() {
    private val settingViewModel by activityViewModels<SettingViewModel>()
    private val mainScreenViewModel by activityViewModels<MainScreenViewModel>()


    override fun onCreate(savedInstanceState: Bundle?) {

        setFragmentResultListener("requestKey1") { requestKey, bundle ->
            // We use a String here, but any type that can be put in a Bundle is supported
            settingViewModel.parentUser.value =
                fromJsonToObject<ParentUser>(bundle.getString("bundleKey").toString())
            // Do something with the result

        }
        super.onCreate(savedInstanceState)
    }

    override fun onStart() {
        super.onStart()
        Log.e("CHECK BUNDLE PASS", settingViewModel.parentUser.value.toString())
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_setting, container, false).apply {
            findViewById<ComposeView>(R.id.composeview_settings).setContent {
                val rememberNavControll = rememberNavController()
                NavHost(
                    navController = rememberNavControll,
                    startDestination = ComposeGraph.VIEW_OF_DASHBOARD_SETTING.name,
                    modifier = Modifier.fillMaxSize()
                ) {
                    composable(ComposeGraph.VIEW_OF_DASHBOARD_SETTING.name) {
                        viewOfDashboardSetting(navController = rememberNavControll)
                    }
                    composable(ComposeGraph.VIEW_OF_CHANGE_PASSWORD.name) {
                        viewOfChangePassword(
                            changePassword = { settingViewModel.changePassword() },
                            popBackStack = {
                                rememberNavControll.navigate(ComposeGraph.VIEW_OF_DASHBOARD_SETTING.name) {
                                    popUpTo(ComposeGraph.VIEW_OF_CHANGE_PASSWORD.name) {
                                        inclusive = true
                                        saveState = false
                                    }
                                    launchSingleTop = true
                                    restoreState = false
                                }
                            },
                            rememberNavControll,
                            settingViewModel.changePassword[0] as PasswordUser,
                            settingViewModel.changePassword[1] as PasswordUser,
                            settingViewModel.changePassword[2] as RepeatPasswordUser
                        )
                    }
                    composable(ComposeGraph.VIEW_OF_CHANGE_PIN_CODE.name) {
                        viewOfChangePinCode(
                            pinCode = settingViewModel.inputPinCodeChange,
                            popBackStack = {
                                rememberNavControll.navigate(ComposeGraph.VIEW_OF_DASHBOARD_SETTING.name) {
                                    popUpTo(ComposeGraph.VIEW_OF_CHANGE_PIN_CODE.name) {
                                        inclusive = true
                                        saveState = false
                                    }
                                    launchSingleTop = true
                                    restoreState = false
                                }
                            },
                            navController = rememberNavControll,
                            checkValidPinCode = { settingViewModel.checkChangePinCode(ComposeGraph.VIEW_OF_FORGOT_PIN_CODE) }
                        )
                    }
                    composable(ComposeGraph.VIEW_OF_FORGOT_PIN_CODE.name) {
                        viewOfForgotPinCode(
                            passwordUser = settingViewModel.passWordOfForgotPincode,
                            popBackStack = {
                                rememberNavControll.navigate(ComposeGraph.VIEW_OF_DASHBOARD_SETTING.name) {
                                    popUpTo(ComposeGraph.VIEW_OF_FORGOT_PIN_CODE.name) {
                                        inclusive = true
                                        saveState = false
                                    }
                                    launchSingleTop = true
                                    restoreState = false
                                }
                            },
                            navController = rememberNavControll,
                            pinCode = settingViewModel.inputPinCodeChange,
                            checkValidPinCode = {settingViewModel.checkChangePinCode(ComposeGraph.VIEW_OF_FORGOT_PIN_CODE)}
                        )
                    }
                    composable(ComposeGraph.VIEW_OF_ASK_PIN_CODE.name){
                        viewOfAskPinCode(
                            popBackStack = {
                                rememberNavControll.navigate(ComposeGraph.VIEW_OF_DASHBOARD_SETTING.name) {
                                    popUpTo(ComposeGraph.VIEW_OF_ASK_PIN_CODE.name) {
                                        inclusive = true
                                        saveState = false
                                    }
                                    launchSingleTop = true
                                    restoreState = false
                                }
                            },
                            navController = rememberNavControll,
                            pinCode = settingViewModel.inputPinCodeAsk,
                            checkValidPinCode = {settingViewModel.checkValidPinCode()}
                        )
                    }
                }
            }
        }
        return view
    }


    @Composable
    fun viewOfDashboardSetting(navController: NavController) {
        KidlockTheme {
            Scaffold(
                topBar = {
                    TopAppBar(
                        title = {
                            androidx.compose.material.Text(
                                text = "Setting",
                                style = MaterialTheme.typography.headlineSmall
                            )
                        },
                        navigationIcon = {
                            IconButton(onClick = {
                                popStack(
                                    mainScreenViewModel.navControllerApplication,
                                    ApplicationPages.DASHBOARD,
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
                        Text(
                            text = "My details",
                            fontSize = 18.sp,
                            style = MaterialTheme.typography.titleMedium,
                            fontWeight = FontWeight.Bold
                        )
                        Row(
                            modifier = Modifier
                                .fillMaxWidth()
                                .wrapContentHeight(),
                            verticalAlignment = Alignment.CenterVertically,
                            horizontalArrangement = Arrangement.spacedBy(3.0.wp())
                        ) {
                            Icon(
                                modifier = Modifier
                                    .size(8.0.wp())
                                    .background(
                                        color = MaterialTheme.color.Jade,
                                        shape = CircleShape
                                    )
                                    .padding(1.5.wp()),
                                tint = MaterialTheme.color.white,
                                painter = painterResource(id = R.drawable.user_1),
                                contentDescription = ""
                            )
                            Text(
                                modifier = Modifier.weight(1f),
                                text = "Name",
                                style = MaterialTheme.typography.titleMedium,
                                fontWeight = FontWeight.Normal
                            )
                            Text(
                                modifier = Modifier
                                    .weight(5f)
                                    .padding(end = 15.dp),
                                text = settingViewModel.parentUser.value!!.name,
                                style = MaterialTheme.typography.titleMedium,
                                fontWeight = FontWeight.Bold,
                                textAlign = TextAlign.End
                            )

                        }
                        Row(
                            modifier = Modifier
                                .fillMaxWidth()
                                .wrapContentHeight(),
                            verticalAlignment = Alignment.CenterVertically,
                            horizontalArrangement = Arrangement.spacedBy(3.0.wp())
                        ) {
                            Icon(
                                modifier = Modifier
                                    .size(8.0.wp())
                                    .background(
                                        color = MaterialTheme.color.Jade,
                                        shape = CircleShape
                                    )
                                    .padding(1.5.wp()),
                                tint = MaterialTheme.color.white,
                                painter = painterResource(id = R.drawable.at_sign_1),
                                contentDescription = ""
                            )
                            Text(
                                modifier = Modifier.weight(1f),
                                text = "Email",
                                style = MaterialTheme.typography.titleMedium,
                                fontWeight = FontWeight.Normal
                            )
                            Text(
                                modifier = Modifier
                                    .weight(5f)
                                    .padding(end = 15.dp),
                                text = settingViewModel.parentUser.value!!.gmail,
                                style = MaterialTheme.typography.titleMedium,
                                fontWeight = FontWeight.Bold,
                                textAlign = TextAlign.End
                            )

                        }

                        Text(
                            modifier = Modifier,
                            text = "Settings",
                            fontSize = 18.sp,
                            style = MaterialTheme.typography.titleMedium,
                            fontWeight = FontWeight.Bold
                        )
                        Row(
                            modifier = Modifier
                                .fillMaxWidth()
                                .wrapContentHeight()
                                .clickable {
                                    navController.navigate(ComposeGraph.VIEW_OF_CHANGE_PASSWORD.name)
//                                            Navigation.findNavController(view)
//                                                .navigate(R.id.action_settingsFragment_to_changePasswordFragment)
                                },
                            verticalAlignment = Alignment.CenterVertically,
                            horizontalArrangement = Arrangement.spacedBy(3.0.wp())
                        ) {
                            Icon(
                                modifier = Modifier
                                    .size(8.0.wp())
                                    .background(
                                        color = MaterialTheme.color.Jade,
                                        shape = CircleShape
                                    )
                                    .padding(1.5.wp()),
                                tint = MaterialTheme.color.white,
                                painter = painterResource(id = R.drawable.lock_1),
                                contentDescription = ""
                            )
                            Text(
                                modifier = Modifier.weight(1f),
                                text = "Change password",
                                style = MaterialTheme.typography.titleMedium,
                                fontWeight = FontWeight.Normal,
                                textAlign = TextAlign.Start
                            )
                            Icon(
                                modifier = Modifier
                                    .size(8.0.wp())
                                    .padding(2.0.wp()),
                                painter = painterResource(id = R.drawable.vector),
                                contentDescription = "",
                                tint = MaterialTheme.color.Jade,
                            )

                        }
                        Row(
                            modifier = Modifier
                                .fillMaxWidth()
                                .wrapContentHeight()
                                .clickable {
                                    navController.navigate(ComposeGraph.VIEW_OF_ASK_PIN_CODE.name)
//                                            Navigation.findNavController(view)
//                                                .navigate(R.id.action_settingsFragment_to_changePasswordFragment)
                                },
                            verticalAlignment = Alignment.CenterVertically,
                            horizontalArrangement = Arrangement.spacedBy(3.0.wp())
                        ) {
                            Icon(
                                modifier = Modifier
                                    .size(8.0.wp())
                                    .background(
                                        color = MaterialTheme.color.Jade,
                                        shape = CircleShape
                                    )
                                    .padding(1.5.wp()),
                                tint = MaterialTheme.color.white,
                                painter = painterResource(id = R.drawable.key),
                                contentDescription = ""
                            )
                            Text(
                                modifier = Modifier.weight(1f),
                                text = "Change parental PIN",
                                style = MaterialTheme.typography.titleMedium,
                                fontWeight = FontWeight.Normal,
                                textAlign = TextAlign.Start
                            )
                            Icon(
                                modifier = Modifier
                                    .size(8.0.wp())
                                    .padding(2.0.wp()),
                                painter = painterResource(id = R.drawable.vector),
                                contentDescription = "",
                                tint = MaterialTheme.color.Jade,
                            )

                        }
                        Text(
                            modifier = Modifier.fillMaxWidth(),
                            text = "Delete account",
                            style = MaterialTheme.typography.titleMedium,
                            fontWeight = FontWeight.Normal,
                            color = MaterialTheme.color.red,
                            textAlign = TextAlign.Center
                        )
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
                                Log.e(
                                    "CHECK BUNDLE PASS",
                                    settingViewModel.parentUser.value.toString()
                                )
                            },
                            modifier = Modifier
                                .fillMaxWidth(),
                            colors = ButtonDefaults.buttonColors(
                                containerColor = MaterialTheme.color.LightningYellow,
                            ),
                            shape = MaterialTheme.shapes.small
                        ) {
                            Text(
                                text = "Logout",
                                style = MaterialTheme.typography.titleMedium,
                                color = Color.White
                            )
                            Spacer(modifier = Modifier.padding(5.dp))
                            Icon(
                                painter = painterResource(id = R.drawable.log_out_2),
                                contentDescription = ""
                            )
                        }
                    }
                }
            )
        }
    }

}

enum class ComposeGraph {
    VIEW_OF_DASHBOARD_SETTING,
    VIEW_OF_CHANGE_PASSWORD,
    VIEW_OF_CHANGE_PIN_CODE,
    VIEW_OF_ASK_PIN_CODE,
    VIEW_OF_FORGOT_PIN_CODE
}

