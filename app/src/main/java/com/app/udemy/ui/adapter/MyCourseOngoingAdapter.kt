package com.app.udemy.ui.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.app.udemy.R
import com.app.udemy.model.ItemMyCourseOngoing

class MyCourseOngoingAdapter(private val items : List<ItemMyCourseOngoing>):
    RecyclerView.Adapter<RecyclerView.ViewHolder>(){

    companion object {
        private const val VIEW_TYPE_SECTION = 0
        private const val VIEW_TYPE_LESSON = 1
    }

    override fun getItemViewType(position: Int): Int {
        return when (items[position]) {
            is ItemMyCourseOngoing.SectionHeader -> VIEW_TYPE_SECTION
            is ItemMyCourseOngoing.LessonItem -> VIEW_TYPE_LESSON
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return when (viewType) {
            VIEW_TYPE_SECTION -> {
                val view = LayoutInflater.from(parent.context)
                    .inflate(R.layout.item_mycourse_ongoing_section_header, parent, false)
                SectionViewHolder(view)
            }
            else -> {
                val view = LayoutInflater.from(parent.context)
                    .inflate(R.layout.item_mycourse_ongoing_section_header, parent, false)
                LessonViewHolder(view)
            }
        }
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        when (val item = items[position]) {
            is ItemMyCourseOngoing.SectionHeader -> (holder as SectionViewHolder).bind(item)
            is ItemMyCourseOngoing.LessonItem -> (holder as LessonViewHolder).bind(item)
        }
    }

    override fun getItemCount() = items.size

    class SectionViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val txtSection = itemView.findViewById<TextView>(R.id.txtSection)
        private val txtIntroduction = itemView.findViewById<TextView>(R.id.txtIntroduction)
        private val txtTotalDuration = itemView.findViewById<TextView>(R.id.txtTotalDuration)
        fun bind(item: ItemMyCourseOngoing.SectionHeader) {
            txtSection.text = item.txtSection
            txtIntroduction.text = item.txtIntroduction
            txtTotalDuration.text = item.txtTotalDuration
        }
    }

    class LessonViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val txtVideoCount = itemView.findViewById<TextView>(R.id.txtVideoCount)
        private val txtVideoTitle = itemView.findViewById<TextView>(R.id.txtVideoTitle)
        private val btnPlay = itemView.findViewById<ImageView>(R.id.btnPlay)
        private val txtVideoDuration = itemView.findViewById<TextView>(R.id.txtVideoDuration)
        fun bind(item: ItemMyCourseOngoing.LessonItem) {
            txtVideoCount.text = item.txtVideoCount
            txtVideoTitle.text = item.txtVideoTitle
            btnPlay.setImageResource(item.btnPlay)
            txtVideoDuration.text = item.txtVideoDuration
        }
    }
}