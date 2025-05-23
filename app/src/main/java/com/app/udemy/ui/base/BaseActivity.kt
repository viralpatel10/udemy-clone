package com.app.udemy.ui.base

import android.content.BroadcastReceiver
import android.os.Bundle
import android.view.LayoutInflater
import androidx.appcompat.app.AppCompatActivity
import androidx.viewbinding.ViewBinding


abstract class BaseActivity<VB : ViewBinding> : AppCompatActivity() {


    private var _binding: ViewBinding? = null
    abstract val bindingInflater: (LayoutInflater) -> VB
    private var mNetworkReceiver: BroadcastReceiver? = null

    @Suppress("UNCHECKED_CAST")
    protected val binding: VB
        get() = _binding as VB

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _binding = bindingInflater.invoke(layoutInflater)
        setContentView(requireNotNull(_binding).root)
        setup()
    }

    abstract fun setup()
    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
}
