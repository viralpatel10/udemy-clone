package com.app.udemy.ui.activity

import android.content.Intent
import android.view.LayoutInflater
import androidx.appcompat.app.AppCompatActivity
import com.app.udemy.databinding.ActivityOtpverificationBinding
import com.app.udemy.ui.base.BaseActivity

class OTPVerificationActivity : BaseActivity<ActivityOtpverificationBinding>() {
    override val bindingInflater: (LayoutInflater) -> ActivityOtpverificationBinding
        get() = ActivityOtpverificationBinding::inflate

    override fun setup() {

        binding.btnVerify.setOnClickListener {
            val intent = Intent(this , CreateNewPasswordActivity::class.java)
            startActivity(intent)
        }
    }


}