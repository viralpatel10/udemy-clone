package com.app.udemy.ui.activity

import android.annotation.SuppressLint
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.view.LayoutInflater
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import com.app.udemy.ui.base.BaseActivity
import com.app.udemy.databinding.ActivitySplashBinding


@SuppressLint("CustomSplashScreen") // Suppress lint warning for custom splash screen
class SplashActivity : BaseActivity<ActivitySplashBinding>() {
    override val bindingInflater: (LayoutInflater) -> ActivitySplashBinding
        get() = ActivitySplashBinding::inflate

    private val splashDurationMillis: Long = 2000

    override fun onCreate(savedInstanceState: Bundle?) {
        // Handle the splash screen transition.
        val splashScreen = installSplashScreen()
        super.onCreate(savedInstanceState)
        // Keep the splash screen visible for the specified duration.
        splashScreen.setKeepOnScreenCondition { true }
        setup()
    }

    override fun setup() {
        // Use a Runnable for better readability and to avoid creating a new Handler instance each time.
        val navigationRunnable = Runnable {
            navigateToHome()
        }

        // Use the Main Looper to post the Runnable.
        Handler(Looper.getMainLooper()).postDelayed(navigationRunnable, splashDurationMillis)
    }

    private fun navigateToHome() {
//        if (SharedPreferencesMain.getBoolean(Constants.IS_LOGGED_IN)) {
//            startActivity(Intent(this, HomeActivity::class.java))
//        } else {
//            startActivity(Intent(this, IntroActivity::class.java))
//        }
        finish()
    }


}