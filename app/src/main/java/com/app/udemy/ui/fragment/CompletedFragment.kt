package com.app.udemy.ui.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.app.udemy.R
import com.app.udemy.databinding.FragmentCompletedBinding
import com.app.udemy.model.CompletedCourse
import com.app.udemy.ui.adapter.CompletedCourseAdapter
import com.app.udemy.ui.base.BaseFragment


class CompletedFragment : BaseFragment<FragmentCompletedBinding>() {
    override val bindingInflater: (LayoutInflater, ViewGroup?, Boolean) -> FragmentCompletedBinding
        get() = FragmentCompletedBinding::inflate


    private lateinit var adapter: CompletedCourseAdapter
    override fun setup() {

        binding.rvMyCompletedCourse.layoutManager = LinearLayoutManager(requireContext())

        val courses = listOf(
            CompletedCourse(R.drawable.image_my_course, "Graphic Design", "Advertisement Design", "2 Hrs 36 mins"),
            CompletedCourse(R.drawable.image_my_course, "Graphic Design", "Advertisement Design", "2 Hrs 36 mins")
        )

        adapter = CompletedCourseAdapter(courses)
        binding.rvMyCompletedCourse.adapter = adapter
    }

}