package com.sportsdb.demo.view

import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.DefaultItemAnimator
import androidx.recyclerview.widget.LinearLayoutManager
import com.sportsdb.demo.R
import com.sportsdb.demo.adapter.MarginItemDecoration
import com.sportsdb.demo.adapter.SportRecyclerViewAdapter
import com.sportsdb.demo.api.Resource.Status.*
import com.sportsdb.demo.model.League
import com.sportsdb.demo.viewmodel.SportsDBViewModel
import kotlinx.android.synthetic.main.activity_main.*

/**
 * Created by Hardik on 10-01-2021.
 * this is launcher activity for app
 */

class MainActivity : AppCompatActivity(), AdapterView.OnItemSelectedListener {

    private lateinit var sportsDBViewModel: SportsDBViewModel
    private var adapter: SportRecyclerViewAdapter? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        sportsDBViewModel = ViewModelProvider(this).get(SportsDBViewModel::class.java)

    }

    override fun onResume() {
        super.onResume()
        initData()
    }

    private fun initData() {
        sportsDBViewModel.getAllSports().observe(this, Observer { sportResult ->

            when (sportResult.status) {
                SUCCESS -> {
                    val sportsSet = arrayListOf<String>()
                    sportResult.data?.let { result ->
                        result.sports?.let { sports ->
                            sports.forEach {
                                sportsSet.add(it.strSport)
                            }
                        }
                        spinnerView.adapter = ArrayAdapter<String>(
                            this,
                            R.layout.support_simple_spinner_dropdown_item,
                            sportsSet
                        )
                        spinnerView.onItemSelectedListener = this
                    }
                }
                ERROR -> {
                    Toast.makeText(this, "Invalid data", Toast.LENGTH_SHORT).show()
                }
                LOADING -> {
                    // fetching data
                }
            }


        })
    }

    private fun loadSportLeagues(selectedSport: String) {
        sportsDBViewModel.getLeaguesOfGame(selectedSport)
            .observe(this@MainActivity, Observer { result ->
                when (result.status) {
                    SUCCESS -> {
                        result.data?.let { gamesResult ->
                            loadRecyclerData(gamesResult.games)
                        }
                    }
                    ERROR -> {
                        Toast.makeText(this, "Invalid data", Toast.LENGTH_SHORT).show()
                    }
                    LOADING -> {
                        // fetching data
                    }
                }
            })
    }

    private fun loadRecyclerData(games: List<League>) {
        val gameList = arrayListOf<League>()
        games.forEach { game ->
            gameList.add(game)
        }
        if (adapter == null) {
            adapter = SportRecyclerViewAdapter(gameList)
            sportRecyclerView.layoutManager = LinearLayoutManager(this)
            sportRecyclerView.itemAnimator = DefaultItemAnimator()
            sportRecyclerView.setHasFixedSize(true)
            sportRecyclerView.adapter = adapter
            sportRecyclerView.addItemDecoration(
                MarginItemDecoration(
                    resources.getDimension(R.dimen.padding_margin_5dp).toInt()
                )
            )

        } else {
            adapter?.updateData(gameList)
        }
    }

    override fun onNothingSelected(parent: AdapterView<*>?) {

    }

    override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
        val selectedSport = parent?.getItemAtPosition(position).toString()
        loadSportLeagues(selectedSport)
    }
}
