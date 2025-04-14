package com.app.udemy.ui.activity

import android.os.Bundle
import android.view.LayoutInflater
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.app.udemy.R
import com.app.udemy.databinding.ActivitySubscriptionBinding
import com.app.udemy.ui.base.BaseActivity

class SubscriptionActivity : BaseActivity<ActivitySubscriptionBinding>() {
    override val bindingInflater: (LayoutInflater) -> ActivitySubscriptionBinding
        get() = ActivitySubscriptionBinding::inflate

    override fun setup() {

    }

}