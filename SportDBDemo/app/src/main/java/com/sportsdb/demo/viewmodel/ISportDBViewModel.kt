package com.sportsdb.demo.viewmodel

import androidx.lifecycle.LiveData
import com.sportsdb.demo.model.GamesResult
import com.sportsdb.demo.model.LeagueResult
import com.sportsdb.demo.model.SportResult

interface ISportDBViewModel {
    fun getAllSports(): LiveData<SportResult>
    fun getAllLeagues(): LiveData<LeagueResult>
    fun getLeaguesOfGame(sportName: String): LiveData<GamesResult>
}