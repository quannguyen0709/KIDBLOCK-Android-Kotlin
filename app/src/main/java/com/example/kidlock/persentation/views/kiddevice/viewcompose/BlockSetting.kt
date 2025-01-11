package com.example.kidlock.persentation.views.kiddevice.viewcompose

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Text
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.example.kidlock.R
import com.example.kidlock.persentation.utils.SizeScreen
import com.example.kidlock.theme.KidlockTheme.color

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