package com.example.businesscardapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Call
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Share
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Alignment.Companion.CenterHorizontally
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.businesscardapp.ui.theme.BusinessCardAppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            BusinessCardAppTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    BusinessCard(
                        fullName = "Jennifer Doe",
                        title = "Android Developer Extraordinaire",
                        phoneNumber = "+11 (123)444 555 666",
                        account = "@AndroidDev",
                        email = "jen.doe@android.com"
                    )
                }
            }
        }
    }
}

@Composable
fun BusinessCard(
    fullName: String,
    title: String,
    phoneNumber: String,
    account: String,
    email: String
) {
    val painter = painterResource(id = R.drawable.android_logo)
    Column(
        horizontalAlignment = CenterHorizontally,
    ) {
        Column(
            verticalArrangement = Arrangement.Center,
            modifier = Modifier
                .fillMaxWidth(1f)
                .weight(2f)
        ) {
            Image(
                painter = painter,
                contentDescription = null,
                modifier = Modifier
                    .align(CenterHorizontally)
                    .width(96.dp)
                    .height(96.dp)
            )
            Text(
                text = fullName,
                fontSize = 48.sp,
                modifier = Modifier
                    .align(CenterHorizontally)
            )
            Text(
                text = title,
                fontWeight = FontWeight.Bold,
                modifier = Modifier
                    .align(CenterHorizontally)
            )
        }
        Column(
            horizontalAlignment = CenterHorizontally,
            modifier = Modifier
                .fillMaxWidth(1f)
                .weight(1f)
        ) {
            Divider(color = Color.DarkGray, thickness = 1.dp)
            Row(
                modifier = Modifier
                    .fillMaxWidth(1f)
                    .padding(top = 4.dp, bottom = 4.dp)
            ) {
                Icon(
                    Icons.Default.Call,
                    contentDescription = null,
                    modifier = Modifier
                        .padding(start = 48.dp, end = 24.dp)
                )
                Text(phoneNumber)
            }
            Divider(color = Color.DarkGray, thickness = 1.dp)
            Row(
                modifier = Modifier
                    .fillMaxWidth(1f)
                    .padding(top = 4.dp, bottom = 4.dp)
            ) {
                Icon(
                    Icons.Default.Share,
                    contentDescription = null,
                    modifier = Modifier
                        .padding(start = 48.dp, end = 24.dp)
                )
                Text(account)
            }
            Divider(color = Color.DarkGray, thickness = 1.dp)
            Row(
                modifier = Modifier
                    .fillMaxWidth(1f)
                    .padding(top = 4.dp, bottom = 4.dp)
            ) {
                Icon(
                    Icons.Default.Email,
                    contentDescription = null,
                    modifier = Modifier
                        .padding(start = 48.dp, end = 24.dp)
                )
                Text(email)
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    BusinessCardAppTheme {
        BusinessCard(
            fullName = "Jennifer Doe",
            title = "Android Developer Extraordinaire",
            phoneNumber = "+11 (123)444 555 666",
            account = "@AndroidDev",
            email = "jen.doe@android.com"
        )
    }
}
