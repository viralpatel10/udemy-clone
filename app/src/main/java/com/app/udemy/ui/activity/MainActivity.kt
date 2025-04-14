package com.app.udemy.ui.activity

import android.os.Bundle
import android.view.LayoutInflater
import androidx.fragment.app.Fragment
import com.app.udemy.R
import com.app.udemy.ui.base.BaseActivity
import com.app.udemy.databinding.ActivityMainBinding
import com.app.udemy.ui.fragment.MyCourseFragment
import com.app.udemy.ui.fragment.MyProfileFragment

class MainActivity : BaseActivity<ActivityMainBinding>() {
    override val bindingInflater: (LayoutInflater) -> ActivityMainBinding
        get() = ActivityMainBinding::inflate

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun setup() {

        loadFragment(MyCourseFragment())
    }

    private fun loadFragment(fragment: Fragment){

        val transaction = supportFragmentManager.beginTransaction()
        transaction.replace(R.id.frame, fragment)
        transaction.commit()
    }
}