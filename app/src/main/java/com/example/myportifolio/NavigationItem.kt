package com.example.myportifolio

sealed class NavigationItem(
    var route: String,
    var icon: Int,
    var title: String

){
    object Home : NavigationItem("home", R.drawable.ic_spa, "Home")
    object Education : NavigationItem("Search", R.drawable.ic_eucation, "Education")
    object Skills : NavigationItem("Favourite", R.drawable.ic_skills, "Skills")

}