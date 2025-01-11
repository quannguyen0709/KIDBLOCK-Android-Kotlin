package com.example.kidlock.persentation.views.kiddevice.viewcompose

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.IconButton
import androidx.compose.material.Text
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.kidlock.R
import com.example.kidlock.persentation.utils.SizeScreen
import com.example.kidlock.persentation.utils.SizeScreen.hp
import com.example.kidlock.persentation.utils.SizeScreen.wp
import com.example.kidlock.theme.KidlockTheme.color

data class BadApp(val imageUrl: String, val nameApp: String,val time: String)
data class BadWebsite(val nameApp: String,val time: String)


@Composable
fun Home(textDay: String, totalBlock: String, badApp: String, badWebsite: String, listBadApp:List<BadApp>, listBadWebsite: List<BadWebsite>) {
    Column(
        modifier = Modifier
            .padding(horizontal = 5.0.wp())
            .verticalScroll(state = rememberScrollState()),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.SpaceBetween
    ) {
        Spacer(modifier = Modifier.padding(SizeScreen.heightSize(0.005f)))
        Row(
            modifier = Modifier
                .height(13.0.wp())
                .fillMaxWidth()
                .shadow(3.dp, shape = CircleShape)
                .background(color = Color.White, shape = CircleShape)
                .padding(horizontal = 5.0.wp(), vertical = 1.0.wp()),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Center
        ) {
            IconButton(
                modifier = Modifier
                    .size(4.5.wp())
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
            Text(
                modifier = Modifier.weight(1f),
                textAlign = TextAlign.Center,
                text = textDay,
                style = MaterialTheme.typography.headlineSmall.copy(fontSize = 18.sp),
                fontWeight = FontWeight.Bold,
                color = Color.Black
            )
            IconButton(
                modifier = Modifier
                    .size(4.5.wp())
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
        Spacer(modifier = Modifier.padding(3.0.wp()))
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .wrapContentHeight()
                .shadow(3.dp, shape = MaterialTheme.shapes.extraLarge)
                .background(color = Color.White, shape = MaterialTheme.shapes.small)
                .padding(5.0.wp()),
            verticalArrangement = Arrangement.Top,
            horizontalAlignment = Alignment.Start
        ) {
            Row(
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.Start,
            ) {
                Icon(
                    modifier = Modifier
                        .size(8.0.wp())
                        .background(color = MaterialTheme.color.Jade, shape = CircleShape)
                        .padding(1.5.wp()),
                    painter = painterResource(id = R.drawable.radio_1),
                    contentDescription = "",
                    tint = Color.White
                )
                Spacer(modifier = Modifier.padding(3.0.wp()))
                Text(
                    "Summary",
                    style = MaterialTheme.typography.headlineSmall,
                    fontWeight = FontWeight.Bold,
                    color = Color.Black,
                    fontSize = 16.sp
                )
            }
            Spacer(modifier = Modifier.padding(3.0.wp()))
            Text(
                text = "Total blocked: " +  totalBlock +"\n" +
                        "Bad websites: " + badWebsite  +"\n" +
                        "Bad apps: " +   badApp,
                style = MaterialTheme.typography.headlineSmall,
                color = Color.Black,
                fontWeight = FontWeight.Normal,
                fontSize = 16.sp
            )
        }
        Spacer(modifier = Modifier.padding(3.0.wp()))
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .wrapContentHeight()
                .shadow(4.dp, shape = MaterialTheme.shapes.extraLarge)
                .background(color = Color.White, shape = MaterialTheme.shapes.small)
                .padding(5.0.wp()),
            verticalArrangement = Arrangement.Top,
            horizontalAlignment = Alignment.Start
        ) {
            Row(
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.Start,
            ) {
                Icon(
                    modifier = Modifier
                        .size(8.0.wp())
                        .background(
                            color = MaterialTheme.color.LightningYellow,
                            shape = CircleShape
                        )
                        .padding(1.5.wp()),
                    painter = painterResource(id = R.drawable.globe_1),
                    contentDescription = "",
                    tint = Color.White
                )
                Spacer(modifier = Modifier.padding(3.0.wp()))
                Text(
                    "Bad Websites",
                    style = MaterialTheme.typography.headlineSmall,
                    fontWeight = FontWeight.Bold,
                    color = Color.Black,
                    fontSize = 16.sp
                )
            }
            Spacer(modifier = Modifier.padding(3.0.wp()))
            for (element in listBadWebsite){
                Text(
                    text = element.time + " " + element.nameApp,
                    style = MaterialTheme.typography.headlineSmall.copy(),
                    color = MaterialTheme.color.Jade,
                    fontWeight = FontWeight.Normal,
                    fontSize = 16.sp,
                    textDecoration = TextDecoration.Underline
                )
            }
            Spacer(modifier = Modifier.padding(3.0.wp()))
            Row(
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.Center,
                modifier = Modifier
                    .height(8.0.wp())
                    .fillMaxWidth()
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
            Spacer(modifier = Modifier.padding(5.0.wp()))

            Row(
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.Start,
            ) {
                Icon(
                    modifier = Modifier
                        .size(8.0.wp())
                        .background(
                            color = MaterialTheme.color.LightningYellow,
                            shape = CircleShape
                        )
                        .padding(1.5.wp()),
                    painter = painterResource(id = R.drawable.grid_1),
                    contentDescription = "",
                    tint = Color.White
                )
                Spacer(modifier = Modifier.padding(3.0.wp()))
                Text(
                    "Bad apps",
                    style = MaterialTheme.typography.headlineSmall,
                    fontWeight = FontWeight.Bold,
                    color = Color.Black,
                    fontSize = 16.sp
                )
            }
            Spacer(modifier = Modifier.padding(3.0.wp()))
            for (element in listBadWebsite){
                Row {
                    Text(
                        modifier = Modifier.weight(1f),
                        text = element.nameApp,
                        style = MaterialTheme.typography.headlineSmall,
                        color = Color.Black,
                        fontWeight = FontWeight.Normal,
                        fontSize = 16.sp
                    )
                    Text(
                        modifier = Modifier.weight(1f),
                        text = element.time,
                        style = MaterialTheme.typography.headlineSmall,
                        color = Color.Black,
                        fontWeight = FontWeight.Normal,
                        fontSize = 16.sp,
                        textAlign = TextAlign.End
                    )
                }
            }
            Spacer(modifier = Modifier.padding(3.0.wp()))
            Row(
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.Center,
                modifier = Modifier
                    .height(8.0.wp())
                    .fillMaxWidth()
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
        Spacer(modifier = Modifier.padding(12.0.wp()))
    }
}