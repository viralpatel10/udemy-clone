package com.app.udemy.ui.activity

import android.os.Bundle
import android.view.LayoutInflater
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.app.udemy.R
import com.app.udemy.databinding.ActivityLearningRemindersBinding
import com.app.udemy.ui.base.BaseActivity

class LearningRemindersActivity : BaseActivity<ActivityLearningRemindersBinding>() {
    override val bindingInflater: (LayoutInflater) -> ActivityLearningRemindersBinding
        get() = ActivityLearningRemindersBinding::inflate

    override fun setup() {

    }

}