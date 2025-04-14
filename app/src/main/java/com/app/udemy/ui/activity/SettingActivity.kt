package com.app.udemy.ui.activity

import android.content.Intent
import android.view.LayoutInflater
import com.app.udemy.databinding.ActivitySettingactivityBinding
import com.app.udemy.ui.base.BaseActivity

class SettingActivity : BaseActivity<ActivitySettingactivityBinding>() {
    override val bindingInflater: (LayoutInflater) -> ActivitySettingactivityBinding
        get() = ActivitySettingactivityBinding::inflate

    override fun setup() {

        binding.btnSecurity.setOnClickListener {
            val intent = Intent(this , AccountSecurityActivity::class.java)
            startActivity(intent)
        }

        binding.btnPayment.setOnClickListener {
            val intent = Intent(this , PaymentMethodActivity::class.java)
            startActivity(intent)
        }

        binding.btnSubs.setOnClickListener {
            val intent = Intent(this , SubscriptionActivity::class.java)
            startActivity(intent)
        }

        binding.btnDownloadOption.setOnClickListener {
            val intent = Intent(this , DownloadOptionsActivity::class.java)
            startActivity(intent)
        }

        binding.btnVideoPlayOption.setOnClickListener {
            val intent = Intent(this , VideoPlaybackOptionsActivity::class.java)
            startActivity(intent)
        }

        binding.btnLearningReminder.setOnClickListener {
            val intent = Intent(this , LearningRemindersActivity::class.java)
            startActivity(intent)
        }
    }

}