package com.example.tasktwojc

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowLeft
import androidx.compose.material.icons.filled.LocationOn
import androidx.compose.material.icons.filled.MoreVert
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Divider
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.rememberVectorPainter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.tasktwojc.ui.theme.GreenShade1
import com.example.tasktwojc.ui.theme.Purple80
import com.example.tasktwojc.ui.theme.TaskTwoJCTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            TaskTwoJCTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(), color = MaterialTheme.colorScheme.background
                ) {
                    Greeting("Mark Worms")
                }
            }
        }
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Column(
        modifier = modifier
            .fillMaxSize()
            .background(Color.LightGray),
        verticalArrangement = Arrangement.Top
    ) {
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(430.dp),
        ) {
            Box(
                modifier = modifier
                    .fillMaxWidth()
                    .height(280.dp)
                    .clip(RoundedCornerShape(bottomStart = 40.dp, bottomEnd = 40.dp))
                    .background(GreenShade1)
                    .padding(start = 5.dp, end = 5.dp, top = 30.dp)
            ) {
                Icon(
                    modifier = Modifier
                        .size(30.dp)
                        .align(Alignment.TopStart),
                    painter = rememberVectorPainter(image = Icons.Filled.KeyboardArrowLeft),
                    contentDescription = "",
                    tint = Color.White
                )
                Text(
                    text = stringResource(id = R.string.profile),
                    modifier = modifier.align(Alignment.TopCenter),
                    style = MaterialTheme.typography.titleLarge.copy(Color.White)
                )
                Icon(
                    modifier = Modifier
                        .size(30.dp)
                        .align(Alignment.TopEnd),
                    painter = rememberVectorPainter(image = Icons.Filled.MoreVert),
                    contentDescription = "",
                    tint = Color.White
                )
            }
            Card(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(270.dp)
                    .align(Alignment.BottomStart)
                    .padding(20.dp),
                colors = CardDefaults.cardColors(Color.White),
                shape = RoundedCornerShape(5.dp),
                elevation = CardDefaults.cardElevation(5.dp),
            ) {
                Column(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(top = 75.dp),
                    verticalArrangement = Arrangement.Top,
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {

                    Text(
                        text = name,
                        modifier = Modifier,
                        style = MaterialTheme.typography.titleLarge.copy(Color.Black)
                    )
                    Row(Modifier.padding(top = 3.dp)) {
                        Icon(
                            modifier = Modifier.size(20.dp),
                            painter = rememberVectorPainter(image = Icons.Filled.LocationOn),
                            contentDescription = ""
                        )
                        Text(
                            text = stringResource(id = R.string.place_name),
                            modifier = Modifier,
                            style = MaterialTheme.typography.bodyMedium.copy(Color.Black)
                        )
                    }
                    Text(text = stringResource(id = R.string.follow),
                        style = MaterialTheme.typography.titleLarge.copy(Color.White),
                        modifier = Modifier
                            .padding(15.dp)
                            .background(GreenShade1, shape = RoundedCornerShape(30.dp))
                            .padding(start = 35.dp, end = 35.dp, top = 12.dp, bottom = 12.dp)
                            .clickable {})
                }

            }
            Image(
                painter = painterResource(id = R.drawable.ic_profile_pic),
                contentDescription = null,
                modifier = Modifier
                    .padding(bottom = 55.dp)
                    .height(120.dp)
                    .clip(CircleShape)
                    .align(Alignment.Center)
            )
        }

        val scrollState = rememberScrollState()
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .verticalScroll(scrollState),
            verticalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            Statistics()
            FriendsList()
            PhotosList()
        }
    }
}

@Composable
fun Statistics() {
    Card(
        modifier = Modifier
            .padding(start = 20.dp, end = 20.dp)
            .fillMaxWidth()
            .height(120.dp),
        colors = CardDefaults.cardColors(Color.White),
        shape = RoundedCornerShape(5.dp),
        elevation = CardDefaults.cardElevation(5.dp)
    ) {
        val statsNumList = listOf("456", "23.5K", "3.6M")
        val statsCatList = listOf("Following", "Followers", "Like")
        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.spacedBy(8.dp),
            modifier = Modifier
                .fillMaxSize()
                .padding(start = 25.dp, end = 25.dp)
        ) {
            NumberAndText(
                number = statsNumList[0], category = statsCatList[0]
            )
            Divider(
                color = Purple80,
                modifier = Modifier
                    .padding(start = 18.dp, end = 18.dp)
                    .height(60.dp)
                    .width(2.dp)
            )
            NumberAndText(
                number = statsNumList[1], category = statsCatList[1]
            )
            Divider(
                color = Purple80,
                modifier = Modifier
                    .padding(start = 18.dp, end = 18.dp)
                    .height(60.dp)
                    .width(2.dp)
            )
            NumberAndText(
                number = statsNumList[2], category = statsCatList[2]
            )
        }
    }
}

@Composable
fun FriendsList() {
    Card(
        modifier = Modifier
            .padding(start = 20.dp, end = 20.dp)
            .fillMaxWidth()
            .height(200.dp),
        colors = CardDefaults.cardColors(Color.White),
        shape = RoundedCornerShape(5.dp),
        elevation = CardDefaults.cardElevation(5.dp)
    ) {
        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(top = 25.dp, start = 15.dp, end = 15.dp)
        ) {
            Text(
                modifier = Modifier.align(Alignment.TopStart),
                text = stringResource(id = R.string.friends),
                style = MaterialTheme.typography.titleLarge.copy(Color.Black)

            )
            Text(
                modifier = Modifier.align(Alignment.TopEnd),
                text = stringResource(id = R.string.see_all),
                style = MaterialTheme.typography.bodyMedium.copy(Color.Gray)
            )
            Row(
                Modifier.align(Alignment.Center),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.spacedBy(12.dp)
            ) {
                repeat(5) {
                    Column(
                        horizontalAlignment = Alignment.CenterHorizontally,
                        verticalArrangement = Arrangement.spacedBy(7.dp)
                    ) {
                        Image(
                            painter = painterResource(id = R.drawable.ic_profile_pic),
                            contentDescription = null,
                            modifier = Modifier
                                .height(50.dp)
                                .clip(CircleShape)
                        )
                        Text(
                            text = stringResource(id = R.string.friend_name),
                            style = MaterialTheme.typography.bodyMedium.copy(Color.Black)
                        )
                    }
                }
            }
        }
    }
}

@Composable
fun PhotosList() {
    Card(
        modifier = Modifier
            .padding(start = 20.dp, end = 20.dp, bottom = 30.dp)
            .fillMaxWidth()
            .height(300.dp),
        colors = CardDefaults.cardColors(Color.White),
        shape = RoundedCornerShape(5.dp),
        elevation = CardDefaults.cardElevation(5.dp)
    ) {
        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(top = 25.dp, start = 15.dp, end = 15.dp)
        ) {
            Text(
                modifier = Modifier.align(Alignment.TopStart),
                text = stringResource(id = R.string.photos),
                style = MaterialTheme.typography.titleLarge.copy(Color.Black)
            )
            Row(
                Modifier.align(Alignment.CenterStart),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.spacedBy(8.dp)
            ) {
                repeat(2) {
                    Image(
                        painter = painterResource(id = R.drawable.ic_dummy_photo),
                        contentDescription = null,
                        modifier = Modifier.size(200.dp)
                    )
                }
            }

        }
    }
}

@Composable
fun NumberAndText(number: String, category: String) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(10.dp)
    ) {
        Text(
            text = number, style = MaterialTheme.typography.titleLarge.copy(Color.Black)
        )
        Text(
            text = category, style = MaterialTheme.typography.bodyMedium.copy(Color.Gray)
        )
    }
}


@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    TaskTwoJCTheme {
        Greeting(name = "Mark Worms")
    }
}