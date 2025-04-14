package com.app.udemy.ui.activity

import android.os.Bundle
import android.view.LayoutInflater
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import com.app.udemy.R
import com.app.udemy.databinding.ActivityMyCourseOngoingBinding
import com.app.udemy.model.ItemMyCourseOngoing
import com.app.udemy.model.ItemMyCourses
import com.app.udemy.ui.adapter.MyCourseOngoingAdapter
import com.app.udemy.ui.base.BaseActivity

class MyCourseOngoingActivity : BaseActivity<ActivityMyCourseOngoingBinding>() {
    override val bindingInflater: (LayoutInflater) -> ActivityMyCourseOngoingBinding
        get() = ActivityMyCourseOngoingBinding::inflate

    private lateinit var adapter: MyCourseOngoingAdapter

    private var list = listOf(

        ItemMyCourseOngoing.SectionHeader("Section 01 - ", "Introduction", "25 Mins"),
        ItemMyCourseOngoing.LessonItem("01", "Why Using 3D Blender", R.drawable.ic_play,"15 Mins"),
        ItemMyCourseOngoing.LessonItem("02", "3D Blender Installation",R.drawable.ic_play  ,"10 Mins"),
        ItemMyCourseOngoing.SectionHeader("Section 02 -"," Graphic Design", "125 Mins"),
        ItemMyCourseOngoing.LessonItem("03", "Take a Look Blender Interface", R.drawable.ic_lock ,"20 Mins"),
        ItemMyCourseOngoing.LessonItem("04", "The Basic of 3D Modelling", R.drawable.ic_lock ,"25 Mins"),
        ItemMyCourseOngoing.LessonItem("05", "Shading and Lighting", R.drawable.ic_lock ,"36 Mins"),
        ItemMyCourseOngoing.LessonItem("06", "Using Graphic Plugins", R.drawable.ic_lock ,"10 Mins")
    )

    override fun setup() {

        binding.rvMyOngoingCourse.layoutManager = LinearLayoutManager(this)
        adapter = MyCourseOngoingAdapter(list)
        binding.rvMyOngoingCourse.adapter = adapter

    }

}