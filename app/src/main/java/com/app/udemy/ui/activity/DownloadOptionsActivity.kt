package com.app.udemy.ui.activity

import android.graphics.Color
import android.os.Bundle
import android.view.LayoutInflater
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.app.udemy.R
import com.app.udemy.databinding.ActivityDownloadOptionsBinding
import com.app.udemy.ui.base.BaseActivity
import com.github.mikephil.charting.data.PieData
import com.github.mikephil.charting.data.PieDataSet
import com.github.mikephil.charting.data.PieEntry

class DownloadOptionsActivity : BaseActivity<ActivityDownloadOptionsBinding>() {
    override val bindingInflater: (LayoutInflater) -> ActivityDownloadOptionsBinding
        get() = ActivityDownloadOptionsBinding::inflate

    override fun setup() {

        val entries = listOf(
            PieEntry(65.3f, "Other"),
            PieEntry(10f, "Skill Energy"),
            PieEntry(25f, "Free")
        )

        val dataSet = PieDataSet(entries, "")
        dataSet.colors = listOf(
            Color.parseColor("#B388EB"), // purple
            Color.parseColor("#5BC0EB"), // blue
            Color.parseColor("#FDE74C")  // orange
        )

        dataSet.setDrawValues(false)

        val data = PieData(dataSet)
        binding.pieChart.data = data
        binding.pieChart.isDrawHoleEnabled = true
        binding.pieChart.holeRadius = 70f
        binding.pieChart.setDrawEntryLabels(false)
        binding.pieChart.description.isEnabled = false
        binding.pieChart.legend.isEnabled = false
        binding.pieChart.invalidate()
    }

}