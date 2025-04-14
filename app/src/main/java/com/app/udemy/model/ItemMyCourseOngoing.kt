package com.app.udemy.model

sealed class ItemMyCourseOngoing {

    data class SectionHeader(val txtSection: String, val txtIntroduction : String ,val txtTotalDuration: String) : ItemMyCourseOngoing()
    data class LessonItem(val txtVideoCount: String, val txtVideoTitle: String, val btnPlay : Int ,val txtVideoDuration: String) : ItemMyCourseOngoing()
}