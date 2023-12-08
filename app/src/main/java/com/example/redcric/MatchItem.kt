package com.example.redcric

data class MatchItem(
    val tournament:String,
    val lineUpOut:Boolean=false,
    val team1:String,
    val team1Flag:Int,
    val team2:String,
    val team2Flag:Int,
    val time:String,
    val prize:String
)