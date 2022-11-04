package com.example.myportifolio

object EducationRepository {

    val schools = listOf(
        School(
            educatiType= R.string.education1,
            course = R.string.course1,
            schoolName = R.string.school1,
            duration = R.string.duration1,
        ),
        School(
            educatiType= R.string.education2,
            course = R.string.course2,
            schoolName = R.string.school2,
            duration = R.string.duration2,
        ),
        School(
            educatiType= R.string.education3,
            course = R.string.course3,
            schoolName = R.string.school3,
            duration = R.string.duration3,
        ),
    )
    val mores = listOf(
       More(
           mySkill= R.string.android1,
           description = R.string.android,

        ),
        More(
            mySkill= R.string.dataanalytics,
               description = R.string.data
               ),
        More(
            mySkill= R.string.UX,
            description = R.string.ux
        ),
        More(
            mySkill= R.string.IT,
            description = R.string.ItSupport
        )
    )
}