package com.app.udemy.ui.activity

import android.graphics.Color
import android.text.Spannable
import android.text.SpannableString
import android.text.style.ForegroundColorSpan
import android.view.LayoutInflater
import com.app.udemy.databinding.ActivityCloseAccountBinding
import com.app.udemy.ui.base.BaseActivity

class CloseAccountActivity : BaseActivity<ActivityCloseAccountBinding>() {
    override val bindingInflater: (LayoutInflater) -> ActivityCloseAccountBinding
        get() = ActivityCloseAccountBinding::inflate

    override fun setup() {

        val fullText = "Warning: Lorem ipsum dolor sit amet consectetur. Sem turpis sodales mattis iaculis vulputate. Ut eget amet quis turpis aliquet nunc duis."

        val spannable = SpannableString(fullText)
        spannable.setSpan(
            ForegroundColorSpan(Color.RED),
            0, 8,
            Spannable.SPAN_EXCLUSIVE_EXCLUSIVE
        )

        binding.txtWarning.text = spannable
    }

}