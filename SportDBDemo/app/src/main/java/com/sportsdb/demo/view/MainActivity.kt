package com.sportsdb.demo.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.sportsdb.demo.R

/**
 * Created by Hardik on 10-01-2021.
 * this is launcher activity for app
 */

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }
}