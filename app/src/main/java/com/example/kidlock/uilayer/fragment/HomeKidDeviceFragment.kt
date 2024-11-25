package com.example.kidlock.uilayer.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.BottomNavigation
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.IconButton
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.ComposeView
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.fragment.app.Fragment
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.example.kidlock.R
import com.example.kidlock.persentation.utils.SizeScreen
import com.example.kidlock.theme.KidlockTheme
import com.example.kidlock.theme.KidlockTheme.color
import com.example.kidlock.uilayer.customview.NavigationBottomItem

class HomeKidDeviceFragment : Fragment() {
    private var view: View? = null

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        view = inflater.inflate(R.layout.fragment_home_kid_device, container, false).apply {
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
    @Preview(showSystemUi = true)
    fun HomeKidDevicePreview() {
        val navController = rememberNavController()
        KidlockTheme {
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


    @Composable
    @Preview(showSystemUi = true)
    fun Blocksetting() {
        KidlockTheme {
            Column(
                modifier = Modifier.fillMaxSize(),
                verticalArrangement = Arrangement.Top,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Home()
            }
        }
    }

    @Composable
    fun BlockSetting() {
        Column(
            modifier = Modifier
                .padding(SizeScreen.heightSize(0.025f))
                .fillMaxWidth()
                .fillMaxHeight(),
            verticalArrangement = Arrangement.Top,
            horizontalAlignment = Alignment.Start
        )
        {
            Spacer(
                modifier = Modifier
                    .padding(SizeScreen.heightSize(0.01f))
            )
            Text(
                modifier = Modifier.padding(5.dp),
                text = "Restriction for kid mode",
                style = MaterialTheme.typography.headlineSmall,
                fontWeight = FontWeight.Bold,
                textAlign = TextAlign.Start,
                color = Color.Black
            )
            Spacer(modifier = Modifier.padding(SizeScreen.heightSize(0.025f)))
            Button(
                modifier = Modifier
                    .size(width = SizeScreen.widthSize(), height = SizeScreen.heightSize(0.13f))
                    .padding(5.dp),
                colors = ButtonDefaults.buttonColors(backgroundColor = MaterialTheme.color.Jade),
                shape = MaterialTheme.shapes.medium,
                onClick = { /*TODO*/ }) {
                Text(

                    text = "Block apps",
                    color = Color.White,
                    style = MaterialTheme.typography.headlineSmall,
                    fontWeight = FontWeight.Bold,
                    textAlign = TextAlign.Start
                )
                Spacer(modifier = Modifier.fillMaxWidth(0.58f))
                Image(
                    modifier = Modifier.size(110.dp),
                    painter = painterResource(id = R.drawable._02_mobile_app),
                    contentDescription = "",
                    alignment = Alignment.BottomEnd
                )
            }
            Spacer(modifier = Modifier.padding(10.dp))
            Button(
                modifier = Modifier
                    .size(
                        width = SizeScreen.widthSize(),
                        height = SizeScreen.heightSize(0.13f)
                    )
                    .padding(5.dp),
                colors = ButtonDefaults.buttonColors(backgroundColor = MaterialTheme.color.DodgerBlue),
                shape = MaterialTheme.shapes.medium,
                onClick = { /*TODO*/ }) {
                Text(

                    text = "Block Sites",
                    color = Color.White,
                    style = MaterialTheme.typography.headlineSmall,
                    fontWeight = FontWeight.Bold,
                    textAlign = TextAlign.Start
                )
                Spacer(modifier = Modifier.fillMaxWidth(0.58f))
                Image(
                    modifier = Modifier.size(110.dp),
                    painter = painterResource(id = R.drawable._01_application),
                    contentDescription = "",
                    alignment = Alignment.BottomEnd
                )
            }

            Spacer(modifier = Modifier.padding(10.dp))
            Button(
                modifier = Modifier
                    .size(
                        width = SizeScreen.widthSize(),
                        height = SizeScreen.heightSize(0.13f)
                    )
                    .padding(5.dp),
                colors = ButtonDefaults.buttonColors(backgroundColor = MaterialTheme.color.Jacarta),
                shape = MaterialTheme.shapes.medium,
                onClick = { /*TODO*/ }) {
                Text(

                    text = "System protection",
                    color = Color.White,
                    style = MaterialTheme.typography.headlineSmall,
                    fontWeight = FontWeight.Bold,
                    textAlign = TextAlign.Start
                )
                Spacer(modifier = Modifier.fillMaxWidth(0.4f))
                Image(
                    modifier = Modifier.size(200.dp),
                    painter = painterResource(id = R.drawable.settings_2),
                    contentDescription = "",
                    alignment = Alignment.BottomEnd
                )
            }

        }
    }

    @Composable
    fun Home() {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(SizeScreen.heightSize(0.018f))
                .verticalScroll(enabled = true, state = rememberScrollState()),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Top
        ) {
            Spacer(modifier = Modifier.padding(SizeScreen.heightSize(0.005f)))
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(SizeScreen.heightSize(0.075f))
                    .shadow(3.dp, shape = CircleShape)
                    .background(color = Color.White, shape = CircleShape)
                    .padding(2.dp),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.Center
            ) {
                IconButton(
                    modifier = Modifier
                        .size(SizeScreen.heightSize(0.05f))
                        .background(
                            color = MaterialTheme.color.JadeBackGround,
                            shape = CircleShape
                        ),
                    onClick = { /*TODO*/ }) {
                    Icon(
                        painter = painterResource(id = R.drawable.chevron_right),
                        contentDescription = "",
                        tint = MaterialTheme.color.Jade
                    )
                }
                Spacer(modifier = Modifier.padding(SizeScreen.widthSize(0.1f)))
                Text(
                    text = "2022-12-12",
                    style = MaterialTheme.typography.headlineSmall.copy(fontSize = 18.sp),
                    fontWeight = FontWeight.Bold,
                    color = Color.Black
                )
                Spacer(modifier = Modifier.padding(SizeScreen.widthSize(0.1f)))
                IconButton(
                    modifier = Modifier
                        .size(SizeScreen.heightSize(0.05f))
                        .background(
                            color = MaterialTheme.color.JadeBackGround,
                            shape = CircleShape
                        ),
                    onClick = { /*TODO*/ }) {
                    Icon(
                        painter = painterResource(id = R.drawable.chevron_left_2),
                        contentDescription = "",
                        tint = MaterialTheme.color.Jade
                    )
                }
            }
            Spacer(modifier = Modifier.padding(SizeScreen.heightSize(0.01f)))
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .wrapContentHeight()
                    .shadow(3.dp, shape = MaterialTheme.shapes.extraLarge)
                    .background(color = Color.White, shape = MaterialTheme.shapes.small)
                    .padding(20.dp),
                verticalArrangement = Arrangement.Top,
                horizontalAlignment = Alignment.Start
            ) {
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.Start,
                ) {
                    Icon(
                        modifier = Modifier
                            .size(SizeScreen.heightSize(0.04f))
                            .background(color = MaterialTheme.color.Jade, shape = CircleShape)
                            .padding(3.dp),
                        painter = painterResource(id = R.drawable.radio_1),
                        contentDescription = "",
                        tint = Color.White
                    )
                    Spacer(modifier = Modifier.padding(10.dp))
                    Text(
                        "Summary",
                        style = MaterialTheme.typography.headlineSmall,
                        fontWeight = FontWeight.Bold,
                        color = Color.Black,
                        fontSize = 16.sp
                    )
                }
                Spacer(modifier = Modifier.padding(10.dp))
                Text(
                    text = "Total blocked: 40 \n" +
                            "Bad websites: 30 \n" +
                            "Bad apps: 10",
                    style = MaterialTheme.typography.headlineSmall,
                    color = Color.Black,
                    fontWeight = FontWeight.Normal,
                    fontSize = 16.sp
                )
            }
            Spacer(modifier = Modifier.padding(SizeScreen.heightSize(0.01f)))
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .wrapContentHeight()
                    .shadow(4.dp, shape = MaterialTheme.shapes.extraLarge)
                    .background(color = Color.White, shape = MaterialTheme.shapes.small)
                    .padding(20.dp),
                verticalArrangement = Arrangement.Top,
                horizontalAlignment = Alignment.Start
            ) {
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.Start,
                ) {
                    Icon(
                        modifier = Modifier
                            .size(SizeScreen.heightSize(0.04f))
                            .background(
                                color = MaterialTheme.color.LightningYellow,
                                shape = CircleShape
                            )
                            .padding(4.dp),
                        painter = painterResource(id = R.drawable.globe_1),
                        contentDescription = "",
                        tint = Color.White
                    )
                    Spacer(modifier = Modifier.padding(10.dp))
                    Text(
                        "Bad Websites",
                        style = MaterialTheme.typography.headlineSmall,
                        fontWeight = FontWeight.Bold,
                        color = Color.Black,
                        fontSize = 16.sp
                    )
                }
                Spacer(modifier = Modifier.padding(10.dp))
                Text(
                    text = "Total blocked: 40 \n" +
                            "Bad websites: 30 \n" +
                            "Bad apps: 10",
                    style = MaterialTheme.typography.headlineSmall,
                    color = Color.Black,
                    fontWeight = FontWeight.Normal,
                    fontSize = 16.sp
                )
                Spacer(modifier = Modifier.padding(10.dp))
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.Center,
                    modifier = Modifier
                        .height(60.dp)
                        .fillMaxWidth()
                        .padding(5.dp)
                        .border(
                            1.dp,
                            color = MaterialTheme.color.LightningYellow,
                            shape = CircleShape
                        ) ){
                    Text(
                        text = " View more", style = MaterialTheme.typography.headlineSmall,
                        color = MaterialTheme.color.LightningYellow,
                        fontWeight = FontWeight.Normal,
                        fontSize = 16.sp
                    )
                }
                Spacer(modifier = Modifier.padding(10.dp))

                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.Start,
                ) {
                    Icon(
                        modifier = Modifier
                            .size(SizeScreen.heightSize(0.04f))
                            .background(
                                color = MaterialTheme.color.LightningYellow,
                                shape = CircleShape
                            )
                            .padding(4.dp),
                        painter = painterResource(id = R.drawable.grid_1),
                        contentDescription = "",
                        tint = Color.White
                    )
                    Spacer(modifier = Modifier.padding(10.dp))
                    Text(
                        "Bad apps",
                        style = MaterialTheme.typography.headlineSmall,
                        fontWeight = FontWeight.Bold,
                        color = Color.Black,
                        fontSize = 16.sp
                    )
                }
                Spacer(modifier = Modifier.padding(10.dp))
                Text(
                    text = "Total blocked: 40 \n" +
                            "Bad websites: 30 \n" +
                            "Bad apps: 10",
                    style = MaterialTheme.typography.headlineSmall,
                    color = Color.Black,
                    fontWeight = FontWeight.Normal,
                    fontSize = 16.sp
                )
                Spacer(modifier = Modifier.padding(5.dp))
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.Center,
                    modifier = Modifier
                        .height(60.dp)
                        .fillMaxWidth()
                        .padding(5.dp)
                        .border(
                            1.dp,
                            color = MaterialTheme.color.LightningYellow,
                            shape = CircleShape
                        ) ){
                    Text(
                        text = " View more", style = MaterialTheme.typography.headlineSmall,
                        color = MaterialTheme.color.LightningYellow,
                        fontWeight = FontWeight.Normal,
                        fontSize = 16.sp
                    )
                }
            }
            
            Spacer(modifier = Modifier.padding(50.dp))
        }
    }


    @Composable
    fun ParentMode(navController: NavController) {
        Column(
            verticalArrangement = Arrangement.Top,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {

            Spacer(modifier = Modifier.padding(SizeScreen.heightSize(0.025f)))
            Text(
                text = "Parent mode active",
                style = MaterialTheme.typography.headlineSmall,
                color = Color.Black,
                fontWeight = FontWeight.Bold
            )
            Spacer(modifier = Modifier.padding(SizeScreen.heightSize(0.018f)))
            Text(
                modifier = Modifier
                    .height(SizeScreen.heightSize(0.08f))
                    .fillMaxWidth(),
                text = "You can do anything on this device",
                style = MaterialTheme.typography.titleMedium,
                fontWeight = FontWeight.Normal,
                color = Color.Black,
                textAlign = TextAlign.Center
            )
            Spacer(modifier = Modifier.padding(SizeScreen.heightSize(0.02f)))
            Row(
                modifier = Modifier
                    .wrapContentSize()
                    .shadow(5.dp, shape = CircleShape)
                    .background(
                        color = MaterialTheme.color.JadeBackGround.copy(1f),
                        shape = CircleShape
                    )
                    .padding(8.dp),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.spacedBy(
                    10.dp,
                    alignment = Alignment.CenterHorizontally
                )
            ) {
                Column(
                    modifier = Modifier
                        .size(90.dp)
                        .shadow(2.dp, shape = CircleShape)
                        .background(color = MaterialTheme.color.Jade, shape = CircleShape),
                    verticalArrangement = Arrangement.Center,
                    horizontalAlignment = Alignment.CenterHorizontally,

                    ) {
                    Image(
                        modifier = Modifier
                            .size(40.dp),
                        painter = painterResource(id = R.drawable._01_parents),
                        contentDescription = ""
                    )
                    Text(
                        text = "parent",
                        style = MaterialTheme.typography.titleMedium,
                        color = Color.White
                    )
                }

                Column(
                    modifier = Modifier
                        .size(90.dp)
                        .clickable { navController.navigate("childMode") },
                    verticalArrangement = Arrangement.Center,
                    horizontalAlignment = Alignment.CenterHorizontally,

                    ) {
                    Image(
                        modifier = Modifier
                            .size(40.dp),
                        painter = painterResource(id = R.drawable._02_children),
                        contentDescription = ""
                    )
                    Text(
                        text = "child",
                        style = MaterialTheme.typography.titleMedium,
                        color = Color.Black
                    )
                }
                Column(
                    modifier = Modifier
                        .size(90.dp)
                        .clickable { navController.navigate("lockMode") },
                    verticalArrangement = Arrangement.Center,
                    horizontalAlignment = Alignment.CenterHorizontally,

                    ) {
                    Image(
                        modifier = Modifier
                            .size(40.dp),
                        painter = painterResource(id = R.drawable.lock_2),
                        contentDescription = ""
                    )
                    Text(
                        text = "parent",
                        style = MaterialTheme.typography.titleMedium,
                        color = Color.Black
                    )
                }
            }
            Image(
                modifier = Modifier.size(SizeScreen.widthSize(0.8F)),
                painter = painterResource(id = R.drawable.pasted_image),
                contentDescription = ""
            )
        }
    }


    @Composable
    fun ChildMode(navController: NavController) {
        Column(
            verticalArrangement = Arrangement.Top,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {

            Spacer(modifier = Modifier.padding(SizeScreen.heightSize(0.025f)))
            Text(
                text = "Child mode active",
                style = MaterialTheme.typography.headlineSmall,
                color = Color.Black,
                fontWeight = FontWeight.Bold
            )
            Spacer(modifier = Modifier.padding(SizeScreen.heightSize(0.018f)))
            Text(
                modifier = Modifier
                    .height(SizeScreen.heightSize(0.08f))
                    .fillMaxWidth(),
                text = "You can config what to block.\n" +
                        "Keeping your child away from harmful content",
                style = MaterialTheme.typography.titleMedium,
                fontWeight = FontWeight.Normal,
                color = Color.Black,
                textAlign = TextAlign.Center
            )
            Spacer(modifier = Modifier.padding(SizeScreen.heightSize(0.02f)))
            Row(
                modifier = Modifier
                    .wrapContentSize()
                    .shadow(5.dp, shape = CircleShape)
                    .background(
                        color = MaterialTheme.color.LightningYellowBackGround.copy(1f),
                        shape = CircleShape
                    )
                    .padding(8.dp),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.spacedBy(
                    10.dp,
                    alignment = Alignment.CenterHorizontally
                )
            ) {
                Column(
                    modifier = Modifier
                        .clickable { navController.navigate("parentMode") }
                        .size(90.dp)
                        .shadow(0.dp, shape = CircleShape)
                        .background(color = MaterialTheme.color.Jade.copy(0f), shape = CircleShape),
                    verticalArrangement = Arrangement.Center,
                    horizontalAlignment = Alignment.CenterHorizontally,

                    ) {
                    Image(
                        modifier = Modifier
                            .size(40.dp),
                        painter = painterResource(id = R.drawable._01_parents),
                        contentDescription = ""
                    )
                    Text(
                        text = "parent",
                        style = MaterialTheme.typography.titleMedium,
                        color = Color.Black
                    )
                }

                Column(
                    modifier = Modifier
                        .size(90.dp)
                        .shadow(2.dp, shape = CircleShape)
                        .background(
                            color = MaterialTheme.color.LightningYellow.copy(1f),
                            shape = CircleShape
                        ),
                    verticalArrangement = Arrangement.Center,
                    horizontalAlignment = Alignment.CenterHorizontally,

                    ) {
                    Image(
                        modifier = Modifier
                            .size(40.dp),
                        painter = painterResource(id = R.drawable._02_children),
                        contentDescription = ""
                    )
                    Text(
                        text = "child",
                        style = MaterialTheme.typography.titleMedium,
                        color = Color.White
                    )
                }
                Column(
                    modifier = Modifier
                        .clickable { navController.navigate("lockMode") }
                        .size(90.dp),
                    verticalArrangement = Arrangement.Center,
                    horizontalAlignment = Alignment.CenterHorizontally,

                    ) {
                    Image(
                        modifier = Modifier
                            .size(40.dp),
                        painter = painterResource(id = R.drawable.lock_2),
                        contentDescription = ""
                    )
                    Text(
                        text = "parent",
                        style = MaterialTheme.typography.titleMedium,
                        color = Color.Black
                    )
                }
            }
            Image(
                modifier = Modifier.size(SizeScreen.widthSize(0.8F)),
                painter = painterResource(id = R.drawable.pasted_image_1),
                contentDescription = ""
            )
        }
    }


    @Composable
    fun LockMode(navController: NavController) {
        Column(
            verticalArrangement = Arrangement.Top,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {

            Spacer(modifier = Modifier.padding(SizeScreen.heightSize(0.025f)))
            Text(
                text = "Lock mode active",
                style = MaterialTheme.typography.headlineSmall,
                color = Color.Black,
                fontWeight = FontWeight.Bold
            )
            Spacer(modifier = Modifier.padding(SizeScreen.heightSize(0.018f)))
            Text(
                modifier = Modifier
                    .height(SizeScreen.heightSize(0.08f))
                    .fillMaxWidth(),
                text = "Nothing is allowed to use",
                style = MaterialTheme.typography.titleMedium,
                fontWeight = FontWeight.Normal,
                color = Color.Black,
                textAlign = TextAlign.Center
            )
            Spacer(modifier = Modifier.padding(SizeScreen.heightSize(0.02f)))
            Row(
                modifier = Modifier
                    .wrapContentSize()
                    .shadow(5.dp, shape = CircleShape)
                    .background(
                        color = MaterialTheme.color.OrangeRedBackGround.copy(1f),
                        shape = CircleShape
                    )
                    .padding(8.dp),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.spacedBy(
                    10.dp,
                    alignment = Alignment.CenterHorizontally
                )
            ) {
                Column(
                    modifier = Modifier
                        .clickable { navController.navigate("parentMode") }
                        .size(90.dp)
                        .shadow(0.dp, shape = CircleShape)
                        .background(color = MaterialTheme.color.Jade.copy(0f), shape = CircleShape),
                    verticalArrangement = Arrangement.Center,
                    horizontalAlignment = Alignment.CenterHorizontally,

                    ) {
                    Image(
                        modifier = Modifier
                            .size(40.dp),
                        painter = painterResource(id = R.drawable._01_parents),
                        contentDescription = ""
                    )
                    Text(
                        text = "parent",
                        style = MaterialTheme.typography.titleMedium,
                        color = Color.Black
                    )
                }

                Column(
                    modifier = Modifier
                        .clickable { navController.navigate("childMode") }
                        .size(90.dp)
                        .shadow(0.dp, shape = CircleShape)
                        .background(
                            color = MaterialTheme.color.LightningYellow.copy(0f),
                            shape = CircleShape
                        ),
                    verticalArrangement = Arrangement.Center,
                    horizontalAlignment = Alignment.CenterHorizontally,

                    ) {
                    Image(
                        modifier = Modifier
                            .size(40.dp),
                        painter = painterResource(id = R.drawable._02_children),
                        contentDescription = ""
                    )
                    Text(
                        text = "child",
                        style = MaterialTheme.typography.titleMedium,
                        color = Color.Black
                    )
                }
                Column(
                    modifier = Modifier
                        .size(90.dp)
                        .shadow(2.dp, shape = CircleShape)
                        .background(
                            color = MaterialTheme.color.OrangeRed.copy(1f),
                            shape = CircleShape
                        ),
                    verticalArrangement = Arrangement.Center,
                    horizontalAlignment = Alignment.CenterHorizontally,

                    ) {
                    Icon(
                        modifier = Modifier
                            .size(40.dp),
                        painter = painterResource(id = R.drawable.lock_2),
                        contentDescription = "",
                        tint = Color.White
                    )
                    Text(
                        text = "parent",
                        style = MaterialTheme.typography.titleMedium,
                        color = Color.White
                    )
                }
            }
            Image(
                modifier = Modifier.size(SizeScreen.widthSize(0.8F)),
                painter = painterResource(id = R.drawable.pasted_image_3),
                contentDescription = ""
            )
        }
    }


    @Composable
    fun NavigationModeScreen() {
        val navController = rememberNavController()
        NavHost(navController = navController, startDestination = "childMode") {
            composable("parentMode") {
                ParentMode(navController = navController)
            }
            composable("childMode") {
                ChildMode(navController = navController)
            }
            composable("lockMode") {
                LockMode(navController = navController)
            }
        }
    }

    @Composable
    fun NavigationHomeDeviceKid(navController: NavHostController) {
        NavHost(navController = navController, startDestination = NavigationBottomItem.Home.route) {
            composable(NavigationBottomItem.Home.route) {
                Home()
            }
            composable(NavigationBottomItem.Mode.route) {
                NavigationModeScreen()
            }
            composable(NavigationBottomItem.BlockSetting.route) {
                BlockSetting()
            }
        }
    }

}