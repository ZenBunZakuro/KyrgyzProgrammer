package com.entezeer.kyrgyzprogrammer.ui.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.view.animation.AnimationUtils
import com.entezeer.core.extensions.fadeIn
import com.entezeer.kyrgyzprogrammer.MainActivity
import com.entezeer.kyrgyzprogrammer.R
import com.entezeer.kyrgyzprogrammer.databinding.ActivityMainBinding
import com.entezeer.kyrgyzprogrammer.databinding.ActivitySplashBinding

class SplashActivity : AppCompatActivity() {

    private val SPLASH_TIME_OUT: Long = 1500
    private lateinit var mBinding: ActivitySplashBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mBinding = ActivitySplashBinding.inflate(layoutInflater)
        setContentView(mBinding.root)

        mBinding.ivSplash.startAnimation(AnimationUtils.loadAnimation(applicationContext,R.anim.fade_in))

        Handler().postDelayed(
            {
                MainActivity.start(this)
                this.fadeIn()
                finish()

            }, SPLASH_TIME_OUT
        )
    }
}