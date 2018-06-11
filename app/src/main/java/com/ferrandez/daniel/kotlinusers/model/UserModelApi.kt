package com.ferrandez.daniel.kotlinusers.model

data class UserModelApi(val gender: String, val name : Name, val email: String, val picture: Picture)

//data class Results(val resutls: List<UserModelApi>)
data class Name(val title: String, val first: String, val last: String)
data class Picture(val large: String, val medium: String, val thumbnail: String)