package com.app.udemy.ui.activity

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.viewpager2.widget.ViewPager2
import com.app.udemy.R
import com.app.udemy.databinding.ActivityIntroBinding
import com.app.udemy.model.OnboardingItem
import com.app.udemy.ui.adapter.OnboardingAdapter
import com.app.udemy.ui.base.BaseActivity

class IntroActivity : BaseActivity<ActivityIntroBinding>() {
    override val bindingInflater: (LayoutInflater) -> ActivityIntroBinding
        get() = ActivityIntroBinding::inflate

    private lateinit var onboardingAdapter: OnboardingAdapter

    override fun setup() {

        val items = listOf(
            OnboardingItem("Empowering The Classy \nLearner", "Lorem ipsum dolor sit amet, consectetur adipiscing \nut labore et dolore magna aliqua.", R.drawable.image_onboarding_1),
            OnboardingItem("Clever Ideas For A Brighter \nFuture", "Lorem ipsum dolor sit amet, consectetur adipiscing \nut labore et dolore magna aliqua.", R.drawable.image_onboarding_2),
            OnboardingItem("Experience Interactive \nLearning", "Lorem ipsum dolor sit amet, consectetur adipiscing \nut labore et dolore magna aliqua.", R.drawable.image_onboarding_3)
        )

        onboardingAdapter = OnboardingAdapter(items)
        binding.viewPager.adapter = onboardingAdapter

        binding.dotsIndicator.setViewPager2(binding.viewPager)

        binding.btnNext.setOnClickListener {

            if (binding.viewPager.currentItem + 1 < items.size){

                binding.viewPager.currentItem += 1
            }else{

                startActivity(Intent(this , MyCourseCompleteActivity::class.java))
                finish()
            }
        }

        binding.viewPager.registerOnPageChangeCallback(object : ViewPager2.OnPageChangeCallback(){

            override fun onPageSelected(position: Int) {
                super.onPageSelected(position)
                binding.btnNext.text = if (position == items.lastIndex) "Get Started" else "Next"
            }
        })
    }
}