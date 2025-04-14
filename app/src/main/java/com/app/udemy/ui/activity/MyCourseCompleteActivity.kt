package com.app.udemy.ui.activity

import android.view.LayoutInflater
import androidx.recyclerview.widget.LinearLayoutManager
import com.app.udemy.databinding.ActivityMyCourseCompleteBinding
import com.app.udemy.model.ItemMyCourses
import com.app.udemy.ui.adapter.MyCoursesAdapter
import com.app.udemy.ui.base.BaseActivity

class MyCourseCompleteActivity : BaseActivity<ActivityMyCourseCompleteBinding>() {
    override val bindingInflater: (LayoutInflater) -> ActivityMyCourseCompleteBinding
        get() = ActivityMyCourseCompleteBinding::inflate

    private lateinit var adapter: MyCoursesAdapter

    private var list = listOf(

        ItemMyCourses.SectionHeader("Section 01 - ", "Introduction", "25 Mins"),
        ItemMyCourses.LessonItem("01", "Why Using 3D Blender", "15 Mins"),
        ItemMyCourses.LessonItem("02", "3D Blender Installation", "10 Mins"),
        ItemMyCourses.SectionHeader("Section 02 -"," Graphic Design", "125 Mins"),
        ItemMyCourses.LessonItem("03", "Take a Look Blender Interface", "20 Mins"),
        ItemMyCourses.LessonItem("04", "The Basic of 3D Modelling", "25 Mins"),
        ItemMyCourses.LessonItem("05", "Shading and Lighting", "36 Mins"),
        ItemMyCourses.LessonItem("06", "Using Graphic Plugins", "10 Mins")
    )
    override fun setup() {

        binding.rvMyCompletedCourse.layoutManager = LinearLayoutManager(this)
        adapter = MyCoursesAdapter(list)
        binding.rvMyCompletedCourse.adapter = adapter
    }

}