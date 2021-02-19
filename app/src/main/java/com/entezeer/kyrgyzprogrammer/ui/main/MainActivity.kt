package com.entezeer.kyrgyzprogrammer.ui.main

import android.content.Context
import android.content.Intent
import android.content.IntentFilter
import android.content.res.Configuration
import android.net.ConnectivityManager
import android.os.Bundle
import androidx.core.content.ContextCompat.startActivity
import com.entezeer.core.extensions.isFragmentVisible
import com.entezeer.core.extensions.replaceFragment
import com.entezeer.core.utils.CacheUtils
import com.entezeer.core.utils.LocaleUtils
import com.entezeer.core.utils.SnackbarUtils
import com.entezeer.kyrgyzprogrammer.R
import com.entezeer.kyrgyzprogrammer.constants.Constants
import com.entezeer.kyrgyzprogrammer.databinding.ActivityMainBinding
import com.entezeer.kyrgyzprogrammer.ui.favorite.FavoriteFragment
import com.entezeer.kyrgyzprogrammer.ui.home.HomeFragment
import com.entezeer.kyrgyzprogrammer.ui.lessons.LessonsFragment
import com.entezeer.kyrgyzprogrammer.ui.main.utils.ConnectivityReceiver
import com.entezeer.kyrgyzprogrammer.ui.settings.SettingsFragment
import dagger.android.support.DaggerAppCompatActivity

class MainActivity : DaggerAppCompatActivity(), ConnectivityReceiver.ConnectivityReceiverListener {

    private lateinit var mBinding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mBinding = ActivityMainBinding.inflate(layoutInflater)
        registerReceiver(
            ConnectivityReceiver(),
            IntentFilter(ConnectivityManager.CONNECTIVITY_ACTION)
        )
        setContentView(mBinding.root)
        setupView()
    }

    private fun setupView() {
        setSupportActionBar(mBinding.mainToolbar)

        checkCurrentFragment()
        if (mBinding.bottomNav.selectedItemId == R.id.nav_home) replaceFragment(HomeFragment(), R.id.data_content)

        mBinding.bottomNav.setOnNavigationItemSelectedListener {
            when (it.itemId) {
                R.id.nav_home -> replaceFragment(HomeFragment(),
                    R.id.data_content
                )
                R.id.nav_favorite -> replaceFragment(FavoriteFragment(),
                    R.id.data_content
                )
                R.id.nav_settings -> replaceFragment(SettingsFragment(),
                    R.id.data_content
                )
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
            if (supportFragmentManager.getBackStackEntryAt(supportFragmentManager.backStackEntryCount - 2).name
                == LessonsFragment::class.java.canonicalName) {
                supportFragmentManager.popBackStackImmediate()
            }
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

    override fun onResume() {
        super.onResume()
        ConnectivityReceiver.connectivityReceiverListener = this
    }

    override fun onDestroy() {
        super.onDestroy()
        CacheUtils.deleteCache(this)
//        Glide.get(applicationContext).clearDiskCache()
    }

    override fun onNetworkConnectionChanged(isConnected: Boolean) {
        if (!isConnected) {
            SnackbarUtils.showSnackBar(mBinding.parentLayout, getString(R.string.no_internet_title), mBinding.bottomNav)
        } else {
            SnackbarUtils.hideSnackBar()
        }
    }

    override fun attachBaseContext(base: Context?) {
        super.attachBaseContext(base?.let { LocaleUtils.setLocale(it) })
    }

    override fun onConfigurationChanged(newConfig: Configuration) {
        super.onConfigurationChanged(newConfig)
        LocaleUtils.setLocale(this)
    }
}