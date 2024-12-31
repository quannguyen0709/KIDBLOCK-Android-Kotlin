package com.example.kidlock.uilayer.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.layout.wrapContentWidth
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
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.navigation.Navigation
import com.example.kidlock.R
import com.example.kidlock.theme.KidlockTheme
import com.example.kidlock.theme.KidlockTheme.color
import com.example.kidlock.persentation.views.loginfragment.LoginViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class SettingsFragment : Fragment() {
    private lateinit var view: View
    private val viewModel by activityViewModels<LoginViewModel>()
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        view = inflater.inflate(R.layout.fragment_setting, container, false).apply {
            findViewById<ComposeView>(R.id.composeview_settings).setContent {
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
                                    .background(Color.White),
                                verticalArrangement = Arrangement.Top,
                                horizontalAlignment = Alignment.Start
                            ) {
                                Spacer(modifier = Modifier.padding(15.dp))
                                Text(
                                    modifier = Modifier.padding(start = 15.dp),
                                    text = "My details",
                                    fontSize = 18.sp,
                                    style = MaterialTheme.typography.titleMedium,
                                    fontWeight = FontWeight.Bold
                                )
                                Spacer(modifier = Modifier.padding(10.dp))
                                Row(
                                    modifier = Modifier
                                        .fillMaxWidth()
                                        .wrapContentHeight(),
                                    verticalAlignment = Alignment.CenterVertically,
                                    horizontalArrangement = Arrangement.Start
                                ) {
                                    Spacer(modifier = Modifier.padding(start = 15.dp))
                                    Icon(
                                        modifier = Modifier
                                            .size(30.dp)
                                            .background(
                                                color = MaterialTheme.color.Jade,
                                                shape = CircleShape
                                            )
                                            .padding(4.dp),
                                        tint = MaterialTheme.color.white,
                                        painter = painterResource(id = R.drawable.user_1),
                                        contentDescription = ""
                                    )
                                    Spacer(modifier = Modifier.padding(start = 10.dp))
                                    Text(
                                        text = "Name",
                                        style = MaterialTheme.typography.titleMedium,
                                        fontWeight = FontWeight.Normal
                                    )
                                    Text(
                                        modifier = Modifier
                                            .fillMaxWidth()
                                            .padding(end = 15.dp),
                                        text = "viewModel.userSate.value!!.userAccount.data!!.name",
                                        style = MaterialTheme.typography.titleMedium,
                                        fontWeight = FontWeight.Bold,
                                        textAlign = TextAlign.End
                                    )

                                }
                                Spacer(modifier = Modifier.padding(8.dp))
                                Row(
                                    modifier = Modifier
                                        .fillMaxWidth()
                                        .wrapContentHeight(),
                                    verticalAlignment = Alignment.CenterVertically,
                                    horizontalArrangement = Arrangement.Start
                                ) {
                                    Spacer(modifier = Modifier.padding(start = 15.dp))
                                    Icon(
                                        modifier = Modifier
                                            .size(30.dp)
                                            .background(
                                                color = MaterialTheme.color.Jade,
                                                shape = CircleShape
                                            )
                                            .padding(4.dp),
                                        tint = MaterialTheme.color.white,
                                        painter = painterResource(id = R.drawable.at_sign_1),
                                        contentDescription = ""
                                    )
                                    Spacer(modifier = Modifier.padding(start = 10.dp))
                                    Text(
                                        text = "Email",
                                        style = MaterialTheme.typography.titleMedium,
                                        fontWeight = FontWeight.Normal
                                    )
                                    Text(
                                        modifier = Modifier
                                            .fillMaxWidth()
                                            .padding(end = 15.dp),
                                        text = "viewModel.userSate.value!!.userAccount.data!!.email",
                                        style = MaterialTheme.typography.titleMedium,
                                        fontWeight = FontWeight.Bold,
                                        textAlign = TextAlign.End
                                    )

                                }


                                Spacer(modifier = Modifier.padding(15.dp))
                                Text(
                                    modifier = Modifier.padding(start = 15.dp),
                                    text = "Settings",
                                    fontSize = 18.sp,
                                    style = MaterialTheme.typography.titleMedium,
                                    fontWeight = FontWeight.Bold
                                )
                                Spacer(modifier = Modifier.padding(10.dp))
                                Row(
                                    modifier = Modifier
                                        .fillMaxWidth()
                                        .wrapContentHeight().clickable {
                                            Navigation.findNavController(view)
                                                .navigate(R.id.action_settingsFragment_to_changePasswordFragment)
                                        },
                                    verticalAlignment = Alignment.CenterVertically,
                                    horizontalArrangement = Arrangement.Start
                                ) {
                                    Spacer(modifier = Modifier.padding(start = 15.dp))
                                    Icon(
                                        modifier = Modifier
                                            .size(30.dp)
                                            .background(
                                                color = MaterialTheme.color.Jade,
                                                shape = CircleShape
                                            )
                                            .padding(4.dp),
                                        tint = MaterialTheme.color.white,
                                        painter = painterResource(id = R.drawable.lock_1),
                                        contentDescription = ""
                                    )
                                    Spacer(modifier = Modifier.padding(start = 10.dp))
                                    Text(
                                        modifier = Modifier.wrapContentWidth(),
                                        text = "Change password",
                                        style = MaterialTheme.typography.titleMedium,
                                        fontWeight = FontWeight.Normal,
                                        textAlign = TextAlign.Start
                                    )
                                    Spacer(modifier = Modifier.fillMaxWidth(0.9f))
                                    Icon(
                                        modifier = Modifier
                                            .size(18.dp)
                                            .padding(end = 10.dp),
                                        painter = painterResource(id = R.drawable.vector),
                                        contentDescription = "",
                                        tint = MaterialTheme.color.Jade,
                                    )

                                }
                                Spacer(modifier = Modifier.padding(8.dp))
                                Row(
                                    modifier = Modifier
                                        .fillMaxWidth()
                                        .wrapContentHeight().clickable {
                                            Navigation.findNavController(view)
                                                .navigate(R.id.action_settingsFragment_to_oldParentalPINFragment)
                                        },
                                    verticalAlignment = Alignment.CenterVertically,
                                    horizontalArrangement = Arrangement.Start
                                ) {
                                    Spacer(modifier = Modifier.padding(start = 15.dp))
                                    Icon(
                                        modifier = Modifier
                                            .size(30.dp)
                                            .background(
                                                color = MaterialTheme.color.Jade,
                                                shape = CircleShape
                                            )
                                            .padding(4.dp),
                                        tint = MaterialTheme.color.white,
                                        painter = painterResource(id = R.drawable.key),
                                        contentDescription = ""
                                    )
                                    Spacer(modifier = Modifier.padding(start = 10.dp))
                                    Text(
                                        text = "Change parental PIN",
                                        style = MaterialTheme.typography.titleMedium,
                                        fontWeight = FontWeight.Normal
                                    )
                                    Spacer(modifier = Modifier.fillMaxWidth(0.9f))
                                    Icon(
                                        modifier = Modifier
                                            .size(18.dp)
                                            .padding(end = 10.dp),
                                        painter = painterResource(id = R.drawable.vector),
                                        contentDescription = "",
                                        tint = MaterialTheme.color.Jade,
                                    )

                                }
                                Spacer(modifier = Modifier.padding(15.dp))
                                Text(
                                    modifier = Modifier.fillMaxWidth(),
                                    text = "Delete account",
                                    style = MaterialTheme.typography.titleMedium,
                                    fontWeight = FontWeight.Normal,
                                    color = MaterialTheme.color.red,
                                    textAlign = TextAlign.Center
                                )
                                Spacer(modifier = Modifier.fillMaxHeight(0.8f))
                                Button(
                                    onClick = {},
                                    modifier = Modifier
                                        .fillMaxWidth()
                                        .padding(10.dp),
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
        return view
    }

    @Composable
    @Preview(showSystemUi = true)
    fun SettingsPreview() {
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
                            .background(Color.White),
                        verticalArrangement = Arrangement.Top,
                        horizontalAlignment = Alignment.Start
                    ) {
                        Spacer(modifier = Modifier.padding(15.dp))
                        Text(
                            modifier = Modifier.padding(start = 15.dp),
                            text = "My details",
                            fontSize = 18.sp,
                            style = MaterialTheme.typography.titleMedium,
                            fontWeight = FontWeight.Bold
                        )
                        Spacer(modifier = Modifier.padding(10.dp))
                        Row(
                            modifier = Modifier
                                .fillMaxWidth()
                                .wrapContentHeight(),
                            verticalAlignment = Alignment.CenterVertically,
                            horizontalArrangement = Arrangement.Start
                        ) {
                            Spacer(modifier = Modifier.padding(start = 15.dp))
                            Icon(
                                modifier = Modifier
                                    .size(30.dp)
                                    .background(
                                        color = MaterialTheme.color.Jade,
                                        shape = CircleShape
                                    )
                                    .padding(4.dp),
                                tint = MaterialTheme.color.white,
                                painter = painterResource(id = R.drawable.user_1),
                                contentDescription = ""
                            )
                            Spacer(modifier = Modifier.padding(start = 10.dp))
                            Text(
                                text = "Name",
                                style = MaterialTheme.typography.titleMedium,
                                fontWeight = FontWeight.Normal
                            )
                            Text(
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .padding(end = 15.dp),
                                text = "John Doe",
                                style = MaterialTheme.typography.titleMedium,
                                fontWeight = FontWeight.Bold,
                                textAlign = TextAlign.End
                            )

                        }
                        Spacer(modifier = Modifier.padding(8.dp))
                        Row(
                            modifier = Modifier
                                .fillMaxWidth()
                                .wrapContentHeight(),
                            verticalAlignment = Alignment.CenterVertically,
                            horizontalArrangement = Arrangement.Start
                        ) {
                            Spacer(modifier = Modifier.padding(start = 15.dp))
                            Icon(
                                modifier = Modifier
                                    .size(30.dp)
                                    .background(
                                        color = MaterialTheme.color.Jade,
                                        shape = CircleShape
                                    )
                                    .padding(4.dp),
                                tint = MaterialTheme.color.white,
                                painter = painterResource(id = R.drawable.at_sign_1),
                                contentDescription = ""
                            )
                            Spacer(modifier = Modifier.padding(start = 10.dp))
                            Text(
                                text = "Email",
                                style = MaterialTheme.typography.titleMedium,
                                fontWeight = FontWeight.Normal
                            )
                            Text(
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .padding(end = 15.dp),
                                text = "johndoe@example.com",
                                style = MaterialTheme.typography.titleMedium,
                                fontWeight = FontWeight.Bold,
                                textAlign = TextAlign.End
                            )

                        }


                        Spacer(modifier = Modifier.padding(15.dp))
                        Text(
                            modifier = Modifier.padding(start = 15.dp),
                            text = "Settings",
                            fontSize = 18.sp,
                            style = MaterialTheme.typography.titleMedium,
                            fontWeight = FontWeight.Bold
                        )
                        Spacer(modifier = Modifier.padding(10.dp))
                        Row(
                            modifier = Modifier
                                .fillMaxWidth()
                                .wrapContentHeight(),
                            verticalAlignment = Alignment.CenterVertically,
                            horizontalArrangement = Arrangement.Start
                        ) {
                            Spacer(modifier = Modifier.padding(start = 15.dp))
                            Icon(
                                modifier = Modifier
                                    .size(30.dp)
                                    .background(
                                        color = MaterialTheme.color.Jade,
                                        shape = CircleShape
                                    )
                                    .padding(4.dp),
                                tint = MaterialTheme.color.white,
                                painter = painterResource(id = R.drawable.lock_1),
                                contentDescription = ""
                            )
                            Spacer(modifier = Modifier.padding(start = 10.dp))
                            Text(
                                modifier = Modifier.wrapContentWidth(),
                                text = "Change password",
                                style = MaterialTheme.typography.titleMedium,
                                fontWeight = FontWeight.Normal,
                                textAlign = TextAlign.Start
                            )
                            Spacer(modifier = Modifier.fillMaxWidth(0.9f))
                            Icon(
                                modifier = Modifier
                                    .size(18.dp)
                                    .padding(end = 10.dp),
                                painter = painterResource(id = R.drawable.vector),
                                contentDescription = "",
                                tint = MaterialTheme.color.Jade,
                            )

                        }
                        Spacer(modifier = Modifier.padding(8.dp))
                        Row(
                            modifier = Modifier
                                .fillMaxWidth()
                                .wrapContentHeight(),
                            verticalAlignment = Alignment.CenterVertically,
                            horizontalArrangement = Arrangement.Start
                        ) {
                            Spacer(modifier = Modifier.padding(start = 15.dp))
                            Icon(
                                modifier = Modifier
                                    .size(30.dp)
                                    .background(
                                        color = MaterialTheme.color.Jade,
                                        shape = CircleShape
                                    )
                                    .padding(4.dp),
                                tint = MaterialTheme.color.white,
                                painter = painterResource(id = R.drawable.key),
                                contentDescription = ""
                            )
                            Spacer(modifier = Modifier.padding(start = 10.dp))
                            Text(
                                text = "Change parental PIN",
                                style = MaterialTheme.typography.titleMedium,
                                fontWeight = FontWeight.Normal
                            )
                            Spacer(modifier = Modifier.fillMaxWidth(0.9f))
                            Icon(
                                modifier = Modifier
                                    .size(18.dp)
                                    .padding(end = 10.dp),
                                painter = painterResource(id = R.drawable.vector),
                                contentDescription = "",
                                tint = MaterialTheme.color.Jade,
                            )

                        }
                        Spacer(modifier = Modifier.padding(15.dp))
                        Text(
                            modifier = Modifier.fillMaxWidth(),
                            text = "Delete account", style = MaterialTheme.typography.titleMedium,
                            fontWeight = FontWeight.Normal,
                            color = MaterialTheme.color.red,
                            textAlign = TextAlign.Center
                        )
                        Spacer(modifier = Modifier.fillMaxHeight(0.8f))
                        Button(
                            onClick = {},
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(10.dp),
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