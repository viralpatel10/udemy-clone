package com.app.udemy.ui.activity

import android.os.Bundle
import android.view.LayoutInflater
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.app.udemy.R
import com.app.udemy.databinding.ActivityCheckoutBinding
import com.app.udemy.ui.base.BaseActivity

class CheckoutActivity : BaseActivity<ActivityCheckoutBinding>() {
    override val bindingInflater: (LayoutInflater) -> ActivityCheckoutBinding
        get() = ActivityCheckoutBinding::inflate

    override fun setup() {

    }

}