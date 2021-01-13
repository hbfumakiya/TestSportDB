package com.sportsdb.demo.viewmodel

import androidx.lifecycle.LiveData
import com.sportsdb.demo.model.Resource
import com.sportsdb.demo.model.GamesResult
import com.sportsdb.demo.model.SportResult

interface ISportDBViewModel {
    fun getAllSports(): LiveData<Resource<SportResult>>
    fun getLeaguesOfGame(sportName: String): LiveData<Resource<GamesResult>>
}