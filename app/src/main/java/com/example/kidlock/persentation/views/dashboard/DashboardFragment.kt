package com.example.kidlock.persentation.views.dashboard

import android.content.Context
import android.os.Build
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.RequiresApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Icon
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.ComposeView
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.fragment.app.setFragmentResultListener
import androidx.fragment.app.viewModels
import androidx.lifecycle.MutableLiveData
import androidx.navigation.Navigation
import com.example.kidlock.R
import com.example.kidlock.domain.kidlock.data.ParentUser
import com.example.kidlock.persentation.views.mainscreen.MainScreenViewModel
import com.example.kidlock.persentation.views.signup.compose.PasswordUser
import com.example.kidlock.persentation.views.signup.compose.TypeTextInputVaild
import com.example.kidlock.persentation.views.signup.compose.textInput
import com.example.kidlock.theme.KidlockTheme
import com.example.kidlock.theme.KidlockTheme.color
import com.example.kidlock.utils.gson.fromJsonToObject
import com.google.gson.Gson
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class DashboardFragment : Fragment() {
    private val dashboardViewModel by viewModels<DashboardViewModel>()
    private val mainScreenViewModel by activityViewModels<MainScreenViewModel>()
    override fun onAttach(context: Context) {
        super.onAttach(context)

    }
    override fun onCreate(savedInstanceState: Bundle?) {
        setFragmentResultListener("requestKey"){ requestKey, bundle ->
            // We use a String here, but any type that can be put in a Bundle is supported
            dashboardViewModel.result.value = fromJsonToObject<ParentUser>(bundle.getString("bundleKey").toString())
            // Do something with the result

        }
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view : View = inflater.inflate(R.layout.fragment_kids_devices, container, false)
        view.findViewById<ComposeView>(R.id.composeview_kids_devices).setContent {
            KidlockTheme {
                Column(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(16.dp),
                    verticalArrangement = Arrangement.spacedBy(2.dp),
                    horizontalAlignment = Alignment.CenterHorizontally,){
                    textInput(typeInput = (PasswordUser()))
                    Text(text = dashboardViewModel.result.observeAsState().value.toString(), style = MaterialTheme.typography.titleLarge)
                }
//                    ) {
//                        Spacer(modifier = Modifier.padding(4.dp))
//                        Box(
//                            modifier = Modifier.fillMaxWidth(),
//                            contentAlignment = Alignment.CenterEnd
//                        ) {
//                            Icon(
//                                modifier = Modifier
//                                    .size(40.dp)
//                                    .background(shape = CircleShape, color = MaterialTheme.color.Jade)
//                                    .padding(8.dp)
//                                    .clickable { Navigation.findNavController(view).navigate(R.id.action_kidsDevicesFragment_to_settingsFragment)},
//
//                                painter = painterResource(id = R.drawable.settings_1),
//                                contentDescription = "",
//                                tint = MaterialTheme.color.white
//                            )
//                        }
//                        Spacer(modifier = Modifier.padding(20.dp))
//                        Text(
//                            modifier = Modifier
//                                .fillMaxWidth()
//                                .padding(start = 10.dp),
//                            text = "Kids devices",
//                            textAlign = TextAlign.Left,
//                            fontWeight = FontWeight.Bold,
//                            style = MaterialTheme.typography.headlineSmall
//                        )
//                        Spacer(modifier = Modifier.padding(8.dp))
//                        ButtomDeviceChild(
//                            name = "Johny",
//                            subTitle = "Kid mode active",
//                            icon = R.drawable.ellipse_5,
//                            colorBackGround = MaterialTheme.color.Jade,
//                            idDestination =  R.id.action_kidsDevicesFragment_to_homeKidDeviceFragment,
//
//                            )
//                        Spacer(modifier = Modifier.padding(10.dp))
//                        Button(
//                            onClick = {},
//                            modifier = Modifier
//                                .fillMaxWidth()
//                                .padding(5.dp),
//                            colors = ButtonDefaults.buttonColors(
//                                containerColor = MaterialTheme.color.LightningYellow,
//                            ),
//                            shape = MaterialTheme.shapes.small
//                        ) {
//                            Text(
//                                text = "Enter Kid mode",
//                                style = MaterialTheme.typography.titleMedium,
//                                color = Color.White
//                            )
//                        }
//                    }
            }
        }
        return view
    }


    @Composable
    @Preview(showSystemUi = true)
    fun KidsDevicesPreview() {
        KidlockTheme {
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(16.dp),
                verticalArrangement = Arrangement.spacedBy(2.dp),
                horizontalAlignment = Alignment.CenterHorizontally,
            ) {
                Spacer(modifier = Modifier.padding(4.dp))
                Box(
                    modifier = Modifier.fillMaxWidth(),
                    contentAlignment = Alignment.CenterEnd
                ) {

                    Icon(
                        modifier = Modifier
                            .size(40.dp)
                            .background(shape = CircleShape, color = MaterialTheme.color.Jade)
                            .padding(8.dp),

                        painter = painterResource(id = R.drawable.settings_1),
                        contentDescription = "",
                        tint = MaterialTheme.color.white
                    )
                }
                Spacer(modifier = Modifier.padding(20.dp))
                Text(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(start = 10.dp),
                    text = "Kids devices",
                    textAlign = TextAlign.Left,
                    fontWeight = FontWeight.Bold,
                    style = MaterialTheme.typography.headlineSmall
                )
                Spacer(modifier = Modifier.padding(8.dp))
                ButtomDeviceChild(
                    name = "Johny",
                    subTitle = "Kid mode active",
                    icon = R.drawable.ellipse_5,
                    colorBackGround = MaterialTheme.color.Jade,
                    idDestination = R.id.action_kidsDevicesFragment_to_homeKidDeviceFragment,

                    )
                Spacer(modifier = Modifier.padding(10.dp))
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
                        text = "Enter Kid mode",
                        style = MaterialTheme.typography.titleMedium,
                        color = Color.White
                    )
                }
            }
        }
    }

    @Composable
    fun ButtomDeviceChild(
        name: String,
        subTitle: String,
        modifier: Modifier = Modifier,
        icon: Int,
        colorBackGround: Color,
        idDestination: Int
    ) {
        Row(
            modifier = modifier
                .padding(start = 5.dp, end = 5.dp)
                .shadow(
                    elevation = 4.dp,
                    spotColor = MaterialTheme.color.SealBrown,
                    ambientColor = MaterialTheme.color.SealBrown
                )
                .fillMaxWidth()
                .background(color = colorBackGround, shape = MaterialTheme.shapes.medium)
                .clickable {
//                    Navigation
//                        .findNavController(view = view)
//                        .navigate(idDestination)
                },
            horizontalArrangement = Arrangement.spacedBy(24.dp, Alignment.Start),
            verticalAlignment = Alignment.CenterVertically,
        ) {
            Image(
                modifier = modifier.padding(start = 20.dp, end = 24.dp),
                painter = painterResource(id = icon),
                contentDescription = "image description",
                contentScale = ContentScale.FillBounds
            )

            Column(
                modifier = modifier.padding(top = 20.dp, bottom = 20.dp, end = 20.dp),
                verticalArrangement = Arrangement.spacedBy(10.dp, Alignment.Top),
                horizontalAlignment = Alignment.Start,
            ) {
                Text(
                    text = name,
                    style = MaterialTheme.typography.headlineSmall,
                    color = Color.White
                )
                Text(
                    text = subTitle,
                    style = MaterialTheme.typography.titleMedium,
                    color = Color.White
                )
            }
        }
    }
}

