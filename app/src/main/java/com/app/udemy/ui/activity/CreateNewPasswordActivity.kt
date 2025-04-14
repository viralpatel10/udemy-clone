package com.app.udemy.ui.activity

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.app.udemy.R
import com.app.udemy.databinding.ActivityCreateNewPasswordBinding
import com.app.udemy.ui.base.BaseActivity

class CreateNewPasswordActivity : BaseActivity<ActivityCreateNewPasswordBinding>() {
    override val bindingInflater: (LayoutInflater) -> ActivityCreateNewPasswordBinding
        get() = ActivityCreateNewPasswordBinding::inflate

    override fun setup() {

        binding.btnResetPass.setOnClickListener {

            val intent = Intent(this , PasswordChangeActivity::class.java)
            startActivity(intent)
        }
    }

}