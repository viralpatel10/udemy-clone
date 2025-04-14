package com.app.udemy.ui.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.app.udemy.R
import com.app.udemy.model.ItemMyCourseEmpty

class MyCourseEmptyAdapter (private val items : List<ItemMyCourseEmpty>):
    RecyclerView.Adapter<MyCourseEmptyAdapter.CategoryViewHolder>(){

    inner class CategoryViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val txtCourseTitleName: TextView = itemView.findViewById(R.id.txtCourseTitleName)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CategoryViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_mycourse_empty, parent, false)
        return CategoryViewHolder(view)
    }

    override fun onBindViewHolder(holder: CategoryViewHolder, position: Int) {
        val item = items[position]
        holder.txtCourseTitleName.text = item.name
    }

    override fun getItemCount(): Int = items.size
}