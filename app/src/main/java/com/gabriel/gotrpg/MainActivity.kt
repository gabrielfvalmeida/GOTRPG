package com.gabriel.gotrpg

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.gabriel.gotrpg.viewPager.ViewPagerAdapter
import com.google.android.material.tabs.TabLayoutMediator

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)




        supportActionBar?.hide()
    }
}