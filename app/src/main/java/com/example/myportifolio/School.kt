package com.example.myportifolio

import androidx.annotation.StringRes

data class School(
    @StringRes val educatiType:Int,
    @StringRes  val course: Int,
    @StringRes  val schoolName:Int,
    @StringRes  val  duration:Int,
)

data class More(
    @StringRes val description: Int,
    @StringRes val mySkill: Int,
)
