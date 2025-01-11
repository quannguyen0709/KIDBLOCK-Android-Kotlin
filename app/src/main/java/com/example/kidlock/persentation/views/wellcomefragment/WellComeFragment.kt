package com.example.kidlock.persentation.views.wellcomefragment

import android.content.Intent
import android.os.Bundle
import android.provider.Settings
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.asImageBitmap
import androidx.compose.ui.platform.ComposeView
import androidx.compose.ui.tooling.preview.Preview
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import com.example.kidlock.R
import com.example.kidlock.persentation.navigation.ApplicationPages
import com.example.kidlock.persentation.utils.SizeScreen.hp
import com.example.kidlock.persentation.utils.SizeScreen.wp
import com.example.kidlock.persentation.views.mainscreen.MainScreenViewModel
import com.example.kidlock.service.MyAccessibilityService
import com.example.kidlock.theme.KidlockTheme
import com.example.kidlock.theme.KidlockTheme.color
import com.example.kidlock.uilayer.compose.CardButtonPrimary
import com.example.kidlock.uilayer.compose.KidLockTitle
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.runBlocking
import kotlin.system.measureTimeMillis


@AndroidEntryPoint
class WellComeFragment : Fragment() {
    val screenViewModel by activityViewModels<MainScreenViewModel> ()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        println("time run test " + measureTimeMillis {
            runBlocking {
                screenViewModel.test(this@WellComeFragment.requireContext())
                screenViewModel.testWrite(this@WellComeFragment.requireContext())
            }
        }
        )

    }


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_home, container, false).apply {
            findViewById<ComposeView>(R.id.composeview_home).setContent {
                KidlockTheme {
                    val rememberId = remember {
                        mutableStateOf(true)
                    }
                    Column(
                        Modifier
                            .padding(horizontal = 6.0.wp())
                            .fillMaxSize(),
                        horizontalAlignment = Alignment.CenterHorizontally

                    ) {

                        Spacer(modifier = Modifier.padding(3.0.hp()))
                        KidLockTitle(Modifier, R.drawable.kidlockgreen, MaterialTheme.color.Jacarta)
                        Spacer(modifier = Modifier.padding(3.0.hp()))
                        Text(
                            text = "Who use this device?",
                            style = MaterialTheme.typography.headlineSmall,
                        )
                        Spacer(modifier = Modifier.padding(3.0.hp()))
                        CardButtonPrimary(
                            Modifier,
                            R.drawable.kidlockgreen,
                            "Parent phone",
                            "Monitor children phone",
                            MaterialTheme.color.Jacarta,
                            callBack = {
                                screenViewModel.navControllerApplication.navigate(ApplicationPages.LOGIN_ACCOUNT_FRAGMENT)
                          }
                        )
                        //test(rememberId.value)
                        Spacer(modifier = Modifier.padding(1.5.hp()))
                        CardButtonPrimary(
                            Modifier,
                            R.drawable.kidlockgreen,
                            "Child phone",
                            "Supervise by parent",
                            MaterialTheme.color.LightningYellow,
                            callBack = {this@WellComeFragment.requireContext().startActivity(Intent(Settings.ACTION_ACCESSIBILITY_SETTINGS))}
                        )
                    }
                }
            }
        }
    }

    @Composable
    @Preview(showSystemUi = true, device = "spec:width=1079.9px,height=2340px,dpi=440")
    fun HomePreview(){
        KidlockTheme {
            Column(
                Modifier
                    .padding(horizontal = 6.0.wp())
                    .fillMaxSize(),
                horizontalAlignment = Alignment.CenterHorizontally

            ) {
                Spacer(modifier = Modifier.padding(3.0.hp()))
                KidLockTitle(Modifier, R.drawable.kidlockgreen, MaterialTheme.color.Jacarta)
                Spacer(modifier = Modifier.padding(3.0.hp()))
                Text(
                    text = "Who use this device?",
                    style = MaterialTheme.typography.headlineSmall,
                )
                Spacer(modifier = Modifier.padding(3.0.hp()))
                CardButtonPrimary(
                    Modifier,
                    R.drawable.kidlockgreen,
                    "Parent phone",
                    "Monitor children phone",
                    MaterialTheme.color.Jacarta,
                    callBack = {}
                )
                Spacer(modifier = Modifier.padding(1.5.hp()))
                CardButtonPrimary(
                    Modifier,
                    R.drawable.kidlockgreen,
                    "Child phone",
                    "Supervise by parent",
                    MaterialTheme.color.LightningYellow,
                    callBack = {}
                )
            }
        }
    }


    @Composable
    fun test(id: Boolean){
        if(id){
            Box (modifier = Modifier.size(80.0.wp())){
                LazyColumn {
                    items(screenViewModel.listAppInstalledLabel.size){element ->
                        Row {
                            Image(
                                modifier = Modifier.size(10.0.wp()),
                                bitmap = screenViewModel.listAppInstalledIcon.get(element).asImageBitmap(),
                                contentDescription = "content description",
                            )
                            Text(text = screenViewModel.listAppInstalledLabel.get(element))
                        }
                    }
                }
            }
        }

    }
}


