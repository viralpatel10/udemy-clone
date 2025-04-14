package com.app.udemy.ui.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.ProgressBar
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.app.udemy.R
import com.app.udemy.model.OngoingCourseItem

class OngoingCourseAdapter(private val courses: List<OngoingCourseItem>) :
    RecyclerView.Adapter<OngoingCourseAdapter.CourseViewHolder>(){


    class CourseViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val image: ImageView = itemView.findViewById(R.id.image_course_ongoing)
        val category: TextView = itemView.findViewById(R.id.txtCourseName)
        val title: TextView = itemView.findViewById(R.id.txtCourseTitle)
        val duration: TextView = itemView.findViewById(R.id.txtCourseDuration)
        val progressBar: ProgressBar = itemView.findViewById(R.id.courseProgressBar)
        val progressText: TextView = itemView.findViewById(R.id.txtProgressCourse)
        val progressTotalText: TextView = itemView.findViewById(R.id.txtTotalCourse)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CourseViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_mycourse_ongoing, parent, false)
        return CourseViewHolder(view)
    }

    override fun onBindViewHolder(holder: CourseViewHolder, position: Int) {
        val course = courses[position]
        holder.image.setImageResource(course.imageRes)
        holder.category.text = course.category
        holder.title.text = course.title
        holder.duration.text = course.duration

        val progressPercent = (course.completed.toFloat() / course.total * 100).toInt()
        holder.progressBar.progress = progressPercent
        holder.progressText.text = "${course.completed}/${course.total}"
        holder.progressTotalText.text = "${course.total}"
    }

    override fun getItemCount(): Int = courses.size
}