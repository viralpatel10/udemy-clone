package com.app.udemy.ui.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.app.udemy.R
import com.app.udemy.model.CompletedCourse

class CompletedCourseAdapter(private val courses: List<CompletedCourse>) :

    RecyclerView.Adapter<CompletedCourseAdapter.CourseViewHolder>(){

    inner class CourseViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val image: ImageView = view.findViewById(R.id.image_course_completed)
        val category: TextView = view.findViewById(R.id.txtCourseName)
        val title: TextView = view.findViewById(R.id.txtCourseTitle)
        val duration: TextView = view.findViewById(R.id.txtCourseDuration)
        val icon: ImageView = view.findViewById(R.id.imageCompleted)
        val completed: TextView = view.findViewById(R.id.txtCompleted)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CourseViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_mycourse_completed, parent, false)
        return CourseViewHolder(view)
    }

    override fun onBindViewHolder(holder: CourseViewHolder, position: Int) {
        val course = courses[position]
        holder.image.setImageResource(course.imageRes)
        holder.category.text = course.category
        holder.title.text = course.title
        holder.duration.text = course.duration
    }

    override fun getItemCount(): Int = courses.size
}