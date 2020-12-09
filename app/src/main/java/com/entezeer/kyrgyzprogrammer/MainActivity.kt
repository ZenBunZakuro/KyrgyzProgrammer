package com.entezeer.kyrgyzprogrammer

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import com.entezeer.kyrgyzprogrammer.databinding.ActivityMainBinding
import com.mikepenz.materialdrawer.AccountHeader
import com.mikepenz.materialdrawer.AccountHeaderBuilder
import com.mikepenz.materialdrawer.Drawer
import com.mikepenz.materialdrawer.DrawerBuilder
import com.mikepenz.materialdrawer.model.PrimaryDrawerItem
import com.mikepenz.materialdrawer.model.ProfileDrawerItem
import com.volcaniccoder.bottomify.BottomifyNavigationView
import com.volcaniccoder.bottomify.OnNavigationItemChangeListener

class MainActivity : AppCompatActivity() {

    private lateinit var mBinding: ActivityMainBinding
    private lateinit var mBottomNav: BottomifyNavigationView
    private lateinit var mToolbar: Toolbar
    private lateinit var mDrawer: Drawer
    private lateinit var mHeader: AccountHeader

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mBinding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(mBinding.root)
    }

    override fun onStart() {
        super.onStart()
        initFields()
        initFun()
    }

    private fun initFun() {
        setSupportActionBar(mToolbar)
        createHeader()
        createDrawer()

        mBottomNav = findViewById<BottomifyNavigationView>(R.id.id_bottomify_nav)
        mBottomNav.setOnNavigationItemChangedListener(object : OnNavigationItemChangeListener{
            override fun onNavigationItemChanged(navigationItem: BottomifyNavigationView.NavigationItem) {
                Toast.makeText(this@MainActivity,
                    "Selected item at index ${navigationItem.position}",
                    Toast.LENGTH_SHORT).show()
            }
        })
    }

    private fun createDrawer() {
        mDrawer = DrawerBuilder()
            .withActivity(this)
            .withToolbar(mToolbar)
            .withActionBarDrawerToggle(true)
            .withSelectedItem(-1)
            .withAccountHeader(mHeader)
            .addDrawerItems(
                PrimaryDrawerItem().withIdentifier(100)
                    .withIconTintingEnabled(true)
                    .withName("Достижения")
                    .withSelectable(false),
                PrimaryDrawerItem().withIdentifier(100)
                    .withIconTintingEnabled(true)
                    .withName("Настройки")
                    .withSelectable(false)
            ).build()

    }

    private fun createHeader() {
        mHeader = AccountHeaderBuilder()
            .withActivity(this)
            .withHeaderBackground(R.drawable.header)
            .addProfiles(
                ProfileDrawerItem().withName("Бахтияр Туратбеков")
                    .withEmail("+996704900913")
            ).build()
    }

    private fun initFields() {
        mToolbar = mBinding.mainToolbar
    }
}