package com.entezeer.kyrgyzprogrammer

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import com.entezeer.core.extensions.replaceFragment
import com.entezeer.kyrgyzprogrammer.databinding.ActivityMainBinding
import com.entezeer.kyrgyzprogrammer.ui.fragments.home.FavoriteFragment
import com.entezeer.kyrgyzprogrammer.ui.fragments.home.HomeFragment
import com.entezeer.kyrgyzprogrammer.ui.fragments.home.SettingsFragment
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private lateinit var mBinding: ActivityMainBinding
    private lateinit var mToolbar: Toolbar


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mBinding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(mBinding.root)
        replaceFragment(HomeFragment(), R.id.data_content)
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
                R.id.nav_home -> replaceFragment(HomeFragment(), R.id.data_content)
                R.id.nav_favorite -> replaceFragment(FavoriteFragment(), R.id.data_content)
                R.id.nav_settings -> replaceFragment(SettingsFragment(), R.id.data_content)
            }
            true
        }
    }
}