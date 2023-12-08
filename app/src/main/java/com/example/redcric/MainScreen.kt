package com.example.redcric

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.DateRange
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.List
import androidx.compose.material.icons.filled.Notifications
import androidx.compose.material.icons.filled.Person
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SmallTopAppBar
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarColors
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.scale
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MainScreen() {
    val items = listOf("Home", "My Contest", "Account", "More")
    var selectedItemIndex by remember { mutableStateOf(0) }
    
    val contestList= listOf<MatchItem>(MatchItem("T20 World Cup",true,"England",R.drawable.eng,"India",R.drawable.ind,"25m 30s","25 Crores"),
        MatchItem("T20 World Cup",true,"England",R.drawable.eng,"India",R.drawable.ind,"25m 30s","25 Crores"),
        MatchItem("T20 World Cup",false,"England",R.drawable.eng,"India",R.drawable.ind,"25m 30s","25 Crores"),
        MatchItem("T20 World Cup",true,"England",R.drawable.eng,"India",R.drawable.ind,"25m 30s","25 Crores"),
        MatchItem("T20 World Cup",true,"England",R.drawable.eng,"India",R.drawable.ind,"25m 30s","25 Crores")
    ,MatchItem("T20 World Cup",true,"England",R.drawable.eng,"India",R.drawable.ind,"25m 30s","25 Crores"))

    Scaffold(
        topBar = {
            TopAppBar(colors = TopAppBarDefaults.smallTopAppBarColors(containerColor = Color(
                200,
                26,
                0,
                255
            )
            ),title = {
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    Image(painterResource(id = R.drawable.logo_app), contentDescription = "Logo", modifier = Modifier
                        .height(40.dp)
                        .width(186.dp))
                    Row {
                        IconButton(onClick = { /* Handle click */ }) {
                            Icon(Icons.Default.List, contentDescription = "Item 1")
                        }
                        IconButton(onClick = { /* Handle click */ }) {
                            Icon(Icons.Default.Notifications, contentDescription = "Item 2")
                        }
                    }
                }
            }
            )
        },
        bottomBar = {
            NavigationBar {
                items.forEachIndexed { index, item ->
                    NavigationBarItem(
                        icon = { Icon(
                             if(item=="Home"){
                                 Icons.Default.Home
                             }
                            else if(item=="My Contest"){
                                Icons.Default.DateRange
                             }
                             else if(item=="Account"){
                                 Icons.Default.Person
                             }
                             else {
                                 Icons.Default.List
                             }
                            , contentDescription = null) }, // Change the icon as per your requirement
                        label = { Text(item) },
                        selected = selectedItemIndex == index,
                        onClick = { selectedItemIndex = index }
                    )
                }
            }
        }
    ) { innerPadding ->

        Box {

        }
        Box(modifier = Modifier
            .background(Color(238, 238, 238, 255))
            .padding(innerPadding)) {
            LazyColumn(modifier = Modifier.padding(start = 12.dp, end = 12.dp)) {
                items(contestList){
                        ItemScreen(matchItem = it)
                    Spacer(modifier = Modifier.height(20.dp))
                }

            }
        }
    }
}




@Preview(showBackground = true)
@Composable
fun previewMainScreen() {
    MainScreen()
}