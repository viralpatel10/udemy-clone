package com.app.udemy.ui.activity

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.app.udemy.R
import com.app.udemy.databinding.ActivityPasswordChangeBinding
import com.app.udemy.ui.base.BaseActivity

class PasswordChangeActivity : BaseActivity<ActivityPasswordChangeBinding>() {
    override val bindingInflater: (LayoutInflater) -> ActivityPasswordChangeBinding
        get() = ActivityPasswordChangeBinding::inflate

    override fun setup() {


        binding.btnBackToLogin.setOnClickListener {
            val intent = Intent(this , LoginActivity::class.java)
            startActivity(intent)
        }
    }
}