package com.app.udemy.ui.activity

import android.os.Bundle
import android.view.LayoutInflater
import com.app.udemy.ui.base.BaseActivity
import com.app.udemy.databinding.ActivityMainBinding

class MainActivity : BaseActivity<ActivityMainBinding>() {
    override val bindingInflater: (LayoutInflater) -> ActivityMainBinding
        get() = ActivityMainBinding::inflate

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun setup() {

    }
}