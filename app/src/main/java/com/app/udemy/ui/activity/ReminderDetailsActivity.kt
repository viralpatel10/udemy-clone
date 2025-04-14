package com.app.udemy.ui.activity

import android.os.Bundle
import android.view.LayoutInflater
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.app.udemy.R
import com.app.udemy.databinding.ActivityReminderDetailsBinding
import com.app.udemy.ui.base.BaseActivity

class ReminderDetailsActivity : BaseActivity<ActivityReminderDetailsBinding>() {
    override val bindingInflater: (LayoutInflater) -> ActivityReminderDetailsBinding
        get() = ActivityReminderDetailsBinding::inflate

    override fun setup() {
        TODO("Not yet implemented")
    }

}