package com.example.kidlock.persentation.views.kiddevice

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.material.BottomNavigation
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material.IconButton
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.ComposeView
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.fragment.app.setFragmentResultListener
import androidx.fragment.app.viewModels
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.example.kidlock.R
import com.example.kidlock.domain.model.KidUserInfor
import com.example.kidlock.persentation.utils.SizeScreen.wp
import com.example.kidlock.persentation.views.kiddevice.viewcompose.BadApp
import com.example.kidlock.persentation.views.kiddevice.viewcompose.BadWebsite
import com.example.kidlock.persentation.views.kiddevice.viewcompose.BlockSetting
import com.example.kidlock.persentation.views.kiddevice.viewcompose.Home
import com.example.kidlock.persentation.views.kiddevice.viewcompose.NavigationModeScreen
import com.example.kidlock.persentation.views.mainscreen.MainScreenViewModel
import com.example.kidlock.theme.KidlockTheme
import com.example.kidlock.theme.KidlockTheme.color
import com.example.kidlock.uilayer.customview.NavigationBottomItem
import com.example.kidlock.utils.gson.fromJsonToObject
import java.util.Date

class KidDeviceFragment : Fragment(R.layout.fragment_home_kid_device) {
    private val kidDeviceViewModel by viewModels<KidDeviceViewModel>()
    private val mainScreenViewModel by activityViewModels<MainScreenViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        setFragmentResultListener("test") { requestKey, bundle ->
            val result = bundle.getString("bundleKey").toString()
            kidDeviceViewModel.kidUserInfor = fromJsonToObject<KidUserInfor>(result)
            kidDeviceViewModel.setUp()
        }

        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_home_kid_device, container, false).apply {
            findViewById<ComposeView>(R.id.composeview_home_kid_device).setContent {
                KidlockTheme {
                    val navController = rememberNavController()
                    KidlockTheme {
                        Scaffold(
                            contentColor = MaterialTheme.color.Jade.copy(alpha = 0F),
                            backgroundColor = MaterialTheme.color.Jade.copy(alpha = 0F),
                            topBar = {
                                TopAppHomeKidDevice()
                            },
                            bottomBar = { NavigationBottomKidDevice(navController = navController) },
                            content = {
                                it
                                Column(
                                    modifier = Modifier
                                        .fillMaxSize()
                                        .background(color = Color.Green.copy(alpha = 0F)),
                                    verticalArrangement = Arrangement.Top,
                                    horizontalAlignment = Alignment.CenterHorizontally
                                ) {
                                    NavigationHomeDeviceKid(navController = navController)
                                }
                            }
                        )
                    }
                }
            }
        }
        return view
    }
    @Composable
    fun NavigationHomeDeviceKid(navController: NavHostController) {
        NavHost(
            navController = navController,
            startDestination = NavigationBottomItem.Home.route
        ) {
            composable(NavigationBottomItem.Home.route) {
                Home(
                    textDay = Date(2024, 6, 3, 14, 34).toString(),
                    badWebsite = "30",
                    totalBlock = "40",
                    badApp = "10",
                    listBadWebsite = listOf(
                        BadWebsite(
                            nameApp = "google.com",
                            time = "10:10pm"
                        )
                    ),
                    listBadApp = listOf(
                        BadApp(
                            nameApp = "google",
                            time = "10:10pm",
                            imageUrl = ""
                        )
                    )
                )
                Log.e(
                    "mode of kid device",
                    kidDeviceViewModel.kidUserInfor.listDevicesByKidUser[0].stateModeKidDevice
                )
            }
            composable(NavigationBottomItem.Mode.route) {
                NavigationModeScreen(kidDeviceViewModel.modeKidDevice)
            }
            composable(NavigationBottomItem.BlockSetting.route) {
                BlockSetting()
                Log.e(
                    "mode of kid device",
                    kidDeviceViewModel.kidUserInfor.listDevicesByKidUser[2].stateModeKidDevice
                )

            }
        }
    }

    @Composable
    fun TopAppHomeKidDevice() {
        Row(
            modifier = Modifier
                .padding(5.dp)
                .wrapContentHeight()
                .fillMaxWidth(),
            horizontalArrangement = Arrangement.Start,
            verticalAlignment = Alignment.CenterVertically
        ) {
            IconButton(onClick = { /*TODO*/ }) {
                Icon(
                    painter = painterResource(id = R.drawable.arrow_left_1),
                    contentDescription = "",
                    tint = MaterialTheme.color.Jade
                )
            }
            Spacer(modifier = Modifier.padding(5.dp))
            Text(
                text = "Your Name KidDevice",
                color = Color.Black,
                style = MaterialTheme.typography.headlineSmall
            )
        }
    }

    @Composable
    fun NavigationBottomKidDevice(navController: NavHostController) {
        var item = listOf<NavigationBottomItem>(
            NavigationBottomItem.Home,
            NavigationBottomItem.Mode,
            NavigationBottomItem.BlockSetting
        )

        BottomNavigation(
            modifier = Modifier.height(15.0.wp()),
            backgroundColor = MaterialTheme.color.white,
            contentColor = MaterialTheme.color.Jade
        ) {
            val navBackStackEntry by navController.currentBackStackEntryAsState()
            val currentRoute = navBackStackEntry?.destination?.route
            item.forEach { item ->
                BottomNavigationItem(
                    icon = {
                        Icon(
                            painterResource(id = item.icon),
                            contentDescription = item.title,
                            tint = if (item.route == currentRoute) {
                                MaterialTheme.color.Jade
                            } else {
                                Color.Black
                            }
                        )
                    },
                    label = { Text(text = item.title, fontWeight = FontWeight.Bold) },
                    selectedContentColor = MaterialTheme.color.Jade,
                    unselectedContentColor = Color.Black,
                    alwaysShowLabel = true,
                    selected = item.route == currentRoute,
                    onClick = {
                        navController.navigate(item.route) {
                            navController.graph.startDestinationRoute?.let { route ->
                                popUpTo(route = route) {
                                    saveState = true
                                }

                                launchSingleTop = true

                                restoreState = true
                            }
                        }
                    }
                )
            }
        }
    }


}







