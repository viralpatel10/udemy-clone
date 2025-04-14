package com.app.udemy.ui.fragment

import android.app.Dialog
import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import android.widget.TextView
import com.app.udemy.R
import com.app.udemy.databinding.FragmentMyProfileBinding
import com.app.udemy.ui.activity.AboutActivity
import com.app.udemy.ui.activity.CloseAccountActivity
import com.app.udemy.ui.activity.PrivacyActivity
import com.app.udemy.ui.activity.ProfileActivity
import com.app.udemy.ui.activity.SettingActivity
import com.app.udemy.ui.base.BaseFragment


class MyProfileFragment : BaseFragment<FragmentMyProfileBinding>() {
    override val bindingInflater: (LayoutInflater, ViewGroup?, Boolean) -> FragmentMyProfileBinding
        get() = FragmentMyProfileBinding::inflate



    override fun setup() {

        binding.btnProfile.setOnClickListener {

            val intent = Intent(requireContext() , ProfileActivity::class.java)
            startActivity(intent)
        }

        binding.btnFaq.setOnClickListener {

        }

        binding.btnAbout.setOnClickListener {

            val intent = Intent(requireContext() , AboutActivity::class.java)
            startActivity(intent)
        }

        binding.btnLogout.setOnClickListener {

            showLogoutDialog()
        }

        binding.btnSetting.setOnClickListener {

            val intent = Intent(requireContext() , SettingActivity::class.java)
            startActivity(intent)

        }

        binding.btnShareApp.setOnClickListener {

        }

        binding.btnPrivacy.setOnClickListener {

            val intent = Intent(requireContext() , PrivacyActivity::class.java)
            startActivity(intent)
        }

        binding.btnDeleteAccount.setOnClickListener {

            val intent = Intent(requireContext() , CloseAccountActivity::class.java)
            startActivity(intent)
        }
    }

    private fun showLogoutDialog(){

        val dialog = Dialog(requireContext())
        dialog.requestWindowFeature(1)
        dialog.setContentView(R.layout.dialog_logout)

        val cancel = dialog.findViewById<View>(R.id.btnCancel) as LinearLayout
        val yes = dialog.findViewById<View>(R.id.btnYes) as LinearLayout

        yes.setOnClickListener {
            dialog.dismiss()
        }

        cancel.setOnClickListener {
            dialog.dismiss()
        }

        dialog.show()
    }
}