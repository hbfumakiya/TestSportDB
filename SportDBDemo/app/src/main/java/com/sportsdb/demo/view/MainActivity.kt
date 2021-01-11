package com.sportsdb.demo.view

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import com.sportsdb.demo.R
import com.sportsdb.demo.viewmodel.SportsDBViewModel

/**
 * Created by Hardik on 10-01-2021.
 * this is launcher activity for app
 */

class MainActivity : AppCompatActivity() {

    private lateinit var sportsDBViewModel: SportsDBViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        sportsDBViewModel = ViewModelProvider(this).get(SportsDBViewModel::class.java)

    }


}