package com.entezeer.kyrgyzprogrammer

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.core.content.ContextCompat
import androidx.core.content.ContextCompat.startActivity
import com.bumptech.glide.Glide
import com.entezeer.core.extensions.replaceFragment
import com.entezeer.core.utils.AppUtils
import com.entezeer.core.utils.CacheUtils
import com.entezeer.kyrgyzprogrammer.databinding.ActivityMainBinding
import com.entezeer.kyrgyzprogrammer.ui.fragments.favorite.FavoriteFragment
import com.entezeer.kyrgyzprogrammer.ui.fragments.home.HomeFragment
import com.entezeer.kyrgyzprogrammer.ui.fragments.settings.SettingsFragment
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private lateinit var mBinding: ActivityMainBinding
    private lateinit var mToolbar: Toolbar

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mBinding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(mBinding.root)
        replaceFragment(HomeFragment(), R.id.data_content, false)
    }


    override fun onStart() {
        super.onStart()
        initFields()
        initFunc()
    }

    private fun initFunc() {
        setSupportActionBar(mToolbar)
        replaceFragmentOnNavigationItemSelected()
    }

    private fun initFields() {
        mToolbar = mBinding.mainToolbar
    }


    private fun replaceFragmentOnNavigationItemSelected() {
        bottom_nav.setOnNavigationItemSelectedListener {
            when (it.itemId) {
                R.id.nav_home -> replaceFragment(HomeFragment(), R.id.data_content, true)
                R.id.nav_favorite -> replaceFragment(FavoriteFragment(), R.id.data_content, true)
                R.id.nav_settings -> replaceFragment(SettingsFragment(), R.id.data_content, true)
            }
            true
        }
    }

    companion object {
        fun start(context: Context) {
            val intent = Intent(context, MainActivity::class.java)
            startActivity(context, intent, Bundle())
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        CacheUtils.deleteCache(this)
        Glide.get(applicationContext).clearDiskCache()
    }
}