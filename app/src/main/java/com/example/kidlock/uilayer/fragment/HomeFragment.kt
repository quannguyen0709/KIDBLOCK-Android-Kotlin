package com.example.kidlock.uilayer.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.ComposeView
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.fragment.app.Fragment
import com.example.kidlock.R
import com.example.kidlock.theme.KidlockTheme
import com.example.kidlock.theme.KidlockTheme.color
import com.example.kidlock.uilayer.compose.CardButtonPrimary
import com.example.kidlock.uilayer.compose.KidLockTitle
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class HomeFragment : Fragment(R.layout.fragment_home) {
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_home, container, false).apply {
            findViewById<ComposeView>(R.id.composeview_home).setContent {
                KidlockTheme {
                    Column(
                        Modifier.fillMaxSize(),
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {
                        Spacer(modifier = Modifier.padding(30.dp))
                        KidLockTitle(Modifier, R.drawable.kidlockgreen, MaterialTheme.color.Jacarta)
                        Spacer(modifier = Modifier.padding(36.dp))
                        Text(
                            text = "Who use this device?",
                            style = MaterialTheme.typography.headlineSmall,
                            modifier = Modifier.padding(start = 83.dp, end = 83.dp),
                            textAlign = TextAlign.Center
                        )
                        Spacer(modifier = Modifier.padding(30.dp))
                        CardButtonPrimary(
                            Modifier,
                            R.drawable.kidlockgreen,
                            "Parent phone",
                            "Monitor children phone",
                            MaterialTheme.color.Jacarta,
                            R.id.action_homeFragment_to_fragment1Fragment,
                            this@apply
                        )
                        Spacer(modifier = Modifier.padding(15.dp))
                        CardButtonPrimary(
                            Modifier,
                            R.drawable.kidlockgreen,
                            "Child phone",
                            "Supervise by parent",
                            MaterialTheme.color.LightningYellow,
                            R.id.action_homeFragment_to_fragment1Fragment,
                            this@apply
                        )
                    }
                }
            }
        }
    }

    @Composable
    @Preview(showSystemUi = true)
    fun HomePreview(){
        KidlockTheme {
            Column(
                Modifier.fillMaxSize(),
            ) {
                Spacer(modifier = Modifier.padding(30.dp))
                KidLockTitle(Modifier, R.drawable.kidlockgreen, MaterialTheme.color.Jacarta)
                Spacer(modifier = Modifier.padding(36.dp))
                Text(
                    text = "Who use this device?",
                    style = MaterialTheme.typography.headlineSmall,
                    modifier = Modifier.padding(start = 83.dp, end = 83.dp)
                )
                Spacer(modifier = Modifier.padding(30.dp))
                CardButtonPrimary(
                    Modifier,
                    R.drawable.kidlockgreen,
                    "Parent phone",
                    "Monitor children phone",
                    MaterialTheme.color.Jacarta,
                    R.id.action_homeFragment_to_fragment1Fragment
                )
                Spacer(modifier = Modifier.padding(15.dp))
                CardButtonPrimary(
                    Modifier,
                    R.drawable.kidlockgreen,
                    "Child phone",
                    "Supervise by parent",
                    MaterialTheme.color.LightningYellow,
                    R.id.action_homeFragment_to_fragment1Fragment
                )
            }
        }
    }
}

