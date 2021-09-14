package com.example.kirozh.myroomapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.kirozh.myroomapplication.fragments.ContactListFragment

class MainActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val currentFragment = supportFragmentManager.findFragmentById(R.id.container)
        if (currentFragment == null) {
            val fragment = ContactListFragment()
            supportFragmentManager
                .beginTransaction()
                .add(R.id.container, fragment)
                .addToBackStack(null)
                .commit()
        }
    }
}