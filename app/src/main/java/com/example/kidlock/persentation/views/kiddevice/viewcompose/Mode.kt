package com.example.kidlock.persentation.views.kiddevice.viewcompose

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Text
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.State
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.lifecycle.MutableLiveData
import androidx.navigation.NavController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.kidlock.R
import com.example.kidlock.persentation.utils.SizeScreen
import com.example.kidlock.persentation.utils.SizeScreen.hp
import com.example.kidlock.persentation.utils.SizeScreen.wp
import com.example.kidlock.theme.KidlockTheme.color

enum class  StateModeScreen{
    PARENT_MODE,
    CHILD_MODE,
    LOCK_MODE
}

abstract class Mode{
    abstract val stateModeScreen: StateModeScreen
    abstract val labelMode: String
    abstract val description: String
    abstract val colorSelect: Color
    abstract val colorBackgroud: Color
    val colorText: Color = Color.White
    abstract val imageMode: Int
    abstract val icon: Int
    abstract val nameIcon: String
}

data class Parent(
    override val labelMode: String = "Parent mode active",
    override val description: String = "You can do anything on this device",
    override val imageMode: Int = R.drawable.pasted_image,
    override val colorSelect: Color= Color(0XFF00BD6E),
    override val colorBackgroud: Color = Color(0xFFFD6FFEE),
    override val icon: Int = R.drawable._01_parents,
    override val nameIcon: String = "parent",
    override val stateModeScreen: StateModeScreen = StateModeScreen.PARENT_MODE,
    ): Mode()

data class Child(
    override val labelMode: String= "Child mode active",
    override val description: String  = "You can config what to block.\n" +
            "Keeping your child away from harmful content",
    override val imageMode: Int =R.drawable.pasted_image_1,
    override val colorSelect: Color = Color(0XFFFA9620),
    override val colorBackgroud: Color = Color(0xFFFFEF5EA),
    override val icon: Int = R.drawable._02_children,
    override val nameIcon: String = "child",
    override val stateModeScreen: StateModeScreen= StateModeScreen.CHILD_MODE,
): Mode()


data class Lock(
    override val labelMode: String ="Lock mode active",
    override val description: String = "Nothing is allowed to use",
    override val imageMode: Int = R.drawable.pasted_image_3,
    override val colorSelect: Color = Color(0XFFFF3E13),
    override val colorBackgroud: Color = Color(0xFFFFFE2DC),
    override val icon: Int = R.drawable.lock_2,
    override val nameIcon: String = "lock",
    override val stateModeScreen: StateModeScreen = StateModeScreen.LOCK_MODE
): Mode()


fun getMode(stateModeScreen: StateModeScreen): Mode{
    return when(stateModeScreen){
        StateModeScreen.PARENT_MODE -> Parent()
        StateModeScreen.CHILD_MODE -> Child()
        StateModeScreen.LOCK_MODE -> Lock()
    }
}


@Composable
fun NavigationModeScreen(stateModeScreen: MutableLiveData<StateModeScreen>){
//    var rememberState  = remember {
//        mutableStateOf(stateModeScreen.value)
//    }
    val modeSelect = getMode(stateModeScreen.observeAsState().value!!)

    val listMode = listOf(
        Parent(),
        Child(),
        Lock()
    )
    Column(
        verticalArrangement = Arrangement.Top,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Spacer(modifier = Modifier.padding(SizeScreen.heightSize(0.025f)))
        Text(
            text = modeSelect.labelMode,
            style = MaterialTheme.typography.headlineSmall,
            color = Color.Black,
            fontWeight = FontWeight.Bold
        )
        Spacer(modifier = Modifier.padding(SizeScreen.heightSize(0.018f)))
        Text(
            modifier = Modifier
                .height(SizeScreen.heightSize(0.08f))
                .fillMaxWidth(),
            text = modeSelect.description,
            style = MaterialTheme.typography.titleMedium,
            fontWeight = FontWeight.Normal,
            color = Color.Black,
            textAlign = TextAlign.Center
        )
        Spacer(modifier = Modifier.padding(SizeScreen.heightSize(0.02f)))
        Row(
            modifier = Modifier
                .height(12.0.hp())
                .width(80.0.wp())
                .shadow(5.dp, shape = CircleShape)
                .background(
                    color = modeSelect.colorBackgroud,
                    shape = CircleShape
                )
                .padding(3.0.wp()),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.spacedBy(
                10.dp,
                alignment = Alignment.CenterHorizontally
            )
        ) {
           for (element in listMode){
               if( element.stateModeScreen == stateModeScreen.observeAsState().value){
                   Column(
                       modifier = Modifier
                           .fillMaxHeight()
                           .weight(1f)
                           .shadow(2.dp, shape = CircleShape)
                           .background(color = modeSelect.colorSelect, shape = CircleShape),
                       verticalArrangement = Arrangement.Center,
                       horizontalAlignment = Alignment.CenterHorizontally,

                       ) {
                       if (stateModeScreen.observeAsState().value == StateModeScreen.LOCK_MODE){
                           Icon(
                               modifier = Modifier
                                   .weight(2f),
                               painter = painterResource(id = modeSelect.icon),
                               contentDescription = "",
                               tint = Color.White
                           )
                       }else{
                           Image(
                               modifier = Modifier.weight(2f),
                               painter = painterResource(id = element.icon),
                               contentDescription = ""
                           )
                       }

                       Text(
                           modifier = Modifier.weight(1f),
                           text = element.nameIcon,
                           style = MaterialTheme.typography.titleMedium,
                           color = Color.White
                       )
                   }
               }else{
                   Column(
                       modifier = Modifier
                           .fillMaxHeight()
                           .clickable {
                               stateModeScreen.value = element.stateModeScreen
                           }
                           .weight(1f),
                       verticalArrangement = Arrangement.Center,
                       horizontalAlignment = Alignment.CenterHorizontally,

                       ) {
                       Image(
                           modifier = Modifier.weight(2f),
                           painter = painterResource(id = element.icon),
                           contentDescription = ""
                       )
                       Text(
                           modifier = Modifier.weight(1f),
                           text = element.nameIcon,
                           style = MaterialTheme.typography.titleMedium,
                           color = Color.Black
                       )
                   }
               }
           }
        }
        Image(
            modifier = Modifier.size(SizeScreen.widthSize(0.8F)),
            painter = painterResource(id = modeSelect.imageMode),
            contentDescription = ""
        )
    }
}






//dont use
@Composable
fun NavigationModeScreenTest(stateModeScreen: StateModeScreen) {
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = stateModeScreen.name) {
        composable(StateModeScreen.PARENT_MODE.name) {
            ParentMode(navController = navController)
        }
        composable(StateModeScreen.CHILD_MODE.name) {
            ChildMode(navController = navController)
        }
        composable(StateModeScreen.LOCK_MODE.name) {
            LockMode(navController = navController)
        }
    }
}

//dont use
fun popUp(navController: NavController, route: StateModeScreen){
    navController.navigate(route.name) {
        navController.graph.startDestinationRoute?.let { route ->
            popUpTo(route = route) {
                saveState = true
            }

            launchSingleTop = true

            restoreState = true
        }
    }
}

//dont use
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
                    .clickable { popUp(navController, StateModeScreen.CHILD_MODE) },
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
                    .clickable { popUp(navController, StateModeScreen.LOCK_MODE) },
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

//dont use
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
                    .clickable { popUp(navController, StateModeScreen.PARENT_MODE) }
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
                    .clickable { popUp(navController, StateModeScreen.LOCK_MODE) }
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

//dont use
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
                    .clickable { popUp(navController, StateModeScreen.PARENT_MODE) }
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
                    .clickable { popUp(navController, StateModeScreen.CHILD_MODE) }
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
