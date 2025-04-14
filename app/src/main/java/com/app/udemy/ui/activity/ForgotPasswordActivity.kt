package com.app.udemy.ui.activity

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.app.udemy.R
import com.app.udemy.databinding.ActivityForgotPasswordBinding
import com.app.udemy.ui.base.BaseActivity

class ForgotPasswordActivity : BaseActivity<ActivityForgotPasswordBinding>() {
    override val bindingInflater: (LayoutInflater) -> ActivityForgotPasswordBinding
        get() = ActivityForgotPasswordBinding::inflate

    override fun setup() {

        binding.btnSendCode.setOnClickListener {
            val intent = Intent(this , OTPVerificationActivity::class.java)
            startActivity(intent)
        }
    }

}