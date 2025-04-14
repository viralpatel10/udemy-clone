package com.app.udemy.ui.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.app.udemy.R
import com.app.udemy.model.ItemMyCourses

class MyCoursesAdapter(private val items : List<ItemMyCourses>):
    RecyclerView.Adapter<RecyclerView.ViewHolder>(){

    companion object {
        private const val VIEW_TYPE_SECTION = 0
        private const val VIEW_TYPE_LESSON = 1
    }

    override fun getItemViewType(position: Int): Int {
        return when (items[position]) {
            is ItemMyCourses.SectionHeader -> VIEW_TYPE_SECTION
            is ItemMyCourses.LessonItem -> VIEW_TYPE_LESSON
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return when (viewType) {
            VIEW_TYPE_SECTION -> {
                val view = LayoutInflater.from(parent.context)
                    .inflate(R.layout.item_mycourse_section_header, parent, false)
                SectionViewHolder(view)
            }
            else -> {
                val view = LayoutInflater.from(parent.context)
                    .inflate(R.layout.item_mycourse_lesson, parent, false)
                LessonViewHolder(view)
            }
        }
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        when (val item = items[position]) {
            is ItemMyCourses.SectionHeader -> (holder as SectionViewHolder).bind(item)
            is ItemMyCourses.LessonItem -> (holder as LessonViewHolder).bind(item)
        }
    }

    override fun getItemCount() = items.size

    class SectionViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val txtSection = itemView.findViewById<TextView>(R.id.txtSection)
        private val txtIntroduction = itemView.findViewById<TextView>(R.id.txtIntroduction)
        private val txtTotalDuration = itemView.findViewById<TextView>(R.id.txtTotalDuration)
        fun bind(item: ItemMyCourses.SectionHeader) {
            txtSection.text = item.txtSection
            txtIntroduction.text = item.txtIntroduction
            txtTotalDuration.text = item.txtTotalDuration
        }
    }

    class LessonViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val txtVideoCount = itemView.findViewById<TextView>(R.id.txtVideoCount)
        private val txtVideoTitle = itemView.findViewById<TextView>(R.id.txtVideoTitle)
        private val txtVideoDuration = itemView.findViewById<TextView>(R.id.txtVideoDuration)
        fun bind(item: ItemMyCourses.LessonItem) {
            txtVideoCount.text = item.txtVideoCount
            txtVideoTitle.text = item.txtVideoTitle
            txtVideoDuration.text = item.txtVideoDuration
        }
    }
}