package com.entezeer.kyrgyzprogrammer

<<<<<<< HEAD
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import com.entezeer.kyrgyzprogrammer.databinding.ActivityMainBinding
import com.entezeer.kyrgyzprogrammer.ui.home.HomeFragment
import com.entezeer.kyrgyzprogrammer.ui.MessageFragment
import com.entezeer.kyrgyzprogrammer.ui.SearchFragment
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
        supportFragmentManager.beginTransaction()
            .replace(R.id.id_data_container,
                HomeFragment()
            ).commit()
        createHeader()
        createDrawer()

        val bottomify = findViewById<BottomifyNavigationView>(R.id.id_bottomify_nav)
        bottomify.setOnNavigationItemChangedListener(object : OnNavigationItemChangeListener {
            override fun onNavigationItemChanged(navigationItem: BottomifyNavigationView.NavigationItem) {
                when(navigationItem.position){
                    0 -> {
                        supportFragmentManager.beginTransaction()
                            .addToBackStack(null)
                            .replace(R.id.id_data_container,
                                HomeFragment()
                            ).commit()
                    }
                    1 -> {
                        supportFragmentManager.beginTransaction()
                            .addToBackStack(null)
                            .replace(R.id.id_data_container, MessageFragment()).commit()
                    }
                    2 -> {
                        supportFragmentManager.beginTransaction()
                            .addToBackStack(null)
                            .replace(R.id.id_data_container, SearchFragment()).commit()
                    }
                }
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
        mToolbar = mBinding.idMainToolbar
=======
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
>>>>>>> d9f3fdb... initial commit
    }
}