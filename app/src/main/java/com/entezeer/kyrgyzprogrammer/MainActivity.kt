package com.entezeer.kyrgyzprogrammer

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.core.content.ContextCompat.startActivity
import com.bumptech.glide.Glide
import com.entezeer.core.extensions.isFragmentVisible
import com.entezeer.core.extensions.replaceFragment
import com.entezeer.core.utils.CacheUtils
import com.entezeer.kyrgyzprogrammer.databinding.ActivityMainBinding
import com.entezeer.kyrgyzprogrammer.ui.fragments.favorite.FavoriteFragment
import com.entezeer.kyrgyzprogrammer.ui.fragments.home.HomeFragment
import com.entezeer.kyrgyzprogrammer.ui.fragments.settings.SettingsFragment

class MainActivity : AppCompatActivity() {

    private lateinit var mBinding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mBinding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(mBinding.root)

        setupView()
    }

    private fun setupView() {
        setSupportActionBar(mBinding.mainToolbar)

        replaceFragment(HomeFragment(), R.id.data_content)

        mBinding.bottomNav.setOnNavigationItemSelectedListener {
            when (it.itemId) {
                R.id.nav_home -> replaceFragment(HomeFragment(), R.id.data_content)
                R.id.nav_favorite -> replaceFragment(FavoriteFragment(), R.id.data_content)
                R.id.nav_settings -> replaceFragment(SettingsFragment(), R.id.data_content)
            }
            true
        }
    }

    private fun setTabByFragment(selectedId: Int) {
        mBinding.bottomNav.selectedItemId = selectedId
    }

    private fun checkCurrentFragment() {
        when {
            isFragmentVisible(
                HomeFragment::class.java.canonicalName,
                R.id.data_content
            ) -> setTabByFragment(R.id.nav_home)
            isFragmentVisible(
                FavoriteFragment::class.java.canonicalName,
                R.id.data_content
            ) -> setTabByFragment(R.id.nav_favorite)
            isFragmentVisible(
                SettingsFragment::class.java.canonicalName,
                R.id.data_content
            ) -> setTabByFragment(R.id.nav_settings)
        }
    }

    override fun onBackPressed() {
        if (supportFragmentManager.backStackEntryCount > 1) {
            supportFragmentManager.popBackStackImmediate()
            checkCurrentFragment()
        } else finish()
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