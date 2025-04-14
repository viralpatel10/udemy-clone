package com.app.udemy.ui.activity

import android.os.Bundle
import android.view.LayoutInflater
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.app.udemy.R
import com.app.udemy.databinding.ActivityPrivacyBinding
import com.app.udemy.ui.base.BaseActivity

class PrivacyActivity : BaseActivity<ActivityPrivacyBinding>() {
    override val bindingInflater: (LayoutInflater) -> ActivityPrivacyBinding
        get() = ActivityPrivacyBinding::inflate

    override fun setup() {

    }

}