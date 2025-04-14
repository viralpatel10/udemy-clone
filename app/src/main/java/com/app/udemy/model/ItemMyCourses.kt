package com.app.udemy.model

sealed class ItemMyCourses{

    data class SectionHeader(val txtSection: String, val txtIntroduction : String ,val txtTotalDuration: String) : ItemMyCourses()
    data class LessonItem(val txtVideoCount: String, val txtVideoTitle: String, val txtVideoDuration: String) : ItemMyCourses()
}



