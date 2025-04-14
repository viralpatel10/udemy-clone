package com.app.udemy.ui.activity

import android.view.LayoutInflater
import com.app.udemy.databinding.ActivityVidepDownloadQualityBinding
import com.app.udemy.ui.base.BaseActivity

class VideoDownloadQualityActivity : BaseActivity<ActivityVidepDownloadQualityBinding>() {
    override val bindingInflater: (LayoutInflater) -> ActivityVidepDownloadQualityBinding
        get() = ActivityVidepDownloadQualityBinding::inflate

    override fun setup() {

    }

}