package com.example.redcric

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box

import androidx.compose.foundation.layout.Column

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Notifications
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun ItemScreen(matchItem: MatchItem) {
      Card (
          modifier = Modifier
              .fillMaxWidth()
              ,
          colors = CardDefaults.cardColors(
              containerColor = Color.White,
              contentColor = Color.Black
          )
      ){
        Column(modifier = Modifier
            .fillMaxWidth()
            .padding(2.dp)) {
               Row(
                   modifier = Modifier.fillMaxWidth(),
                   horizontalArrangement = Arrangement.SpaceBetween
               ) {
                   Text(text = matchItem.tournament, color=Color(131, 130, 130, 255))
                   if(matchItem.lineUpOut){
                       Text(text = "Lineups Out"
                           ,color = Color(191, 19, 4, 255)
                       )
                   }
                   else{
                       IconButton(onClick = { /* Handle click */ }, modifier = Modifier.height(20.dp)) {
                           Icon(Icons.Default.Notifications, contentDescription = "Item 2")
                       }
                   }

               }
               Spacer(modifier = Modifier.height(6.dp))
               Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween
               ) {
                Text(text = matchItem.team1 )
                Text(text = matchItem.team2)
               }

            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(60.dp),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Image(painter = painterResource(id = matchItem.team1Flag),
                    contentDescription = ""
                    , modifier = Modifier
                        .width(50.dp)
                        .height(50.dp)    )
                Text(text = (matchItem.team1).substring(0,3).uppercase(), fontSize = 18.sp, fontWeight = FontWeight.SemiBold)
                Spacer(modifier = Modifier.weight(1f))
                Text(text = matchItem.time, color = Color(191, 19, 4, 255))
                Spacer(modifier = Modifier.weight(1f))
                Text(text = (matchItem.team2).substring(0,3).uppercase(), fontSize = 18.sp, fontWeight = FontWeight.SemiBold)
                Image(painter = painterResource(id = matchItem.team2Flag),
                    contentDescription = ""
                    , modifier = Modifier
                        .width(50.dp)
                        .height(50.dp)    )
            }

            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .background(Color(245, 245, 245, 255))
                    .height(23.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Box(
                    modifier = Modifier
                        .height(20.dp)
                        .width(45.dp)
                        .clip(CircleShape)
                        .background(Color(95, 140, 28, 255)),
                    contentAlignment = Alignment.Center
                ) {
                    Text(
                        text = "MEGA",
                        color = Color.White,
                        style = TextStyle(fontSize = 12.sp)
                    )
                }
                Text(text = " ${matchItem.prize}", color = Color(95, 140, 28, 255))
            }






        }
      }

}

@Preview(showBackground = true)
@Composable
fun previewItemScreen(){
    ItemScreen(MatchItem("T20 World Cup",false,"England",R.drawable.eng,"India",R.drawable.ind,"25m 30s","25 Crores"))
}