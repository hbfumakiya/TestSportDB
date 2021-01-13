package com.sportsdb.demo.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.sportsdb.demo.api.network.SportsDBRepo
import com.sportsdb.demo.model.CountryResult
import com.sportsdb.demo.model.GamesResult
import com.sportsdb.demo.model.LeagueResult
import com.sportsdb.demo.model.SportResult

class SportsDBViewModel : ViewModel() {

    /*private var _sportData = MutableLiveData<SportResult>()
    var sportData: LiveData<SportResult> = _sportData*/

    fun getAllSports() : LiveData<SportResult>{
        return SportsDBRepo.getAllSports()
    }

    fun getAllLeagues(): LiveData<LeagueResult> {
        return SportsDBRepo.getAllLeagues()
    }

    fun getAllCountries(): LiveData<CountryResult> {
        return SportsDBRepo.getAllCountries()
    }

    fun getLeaguesOfGame(sportName: String): LiveData<GamesResult> {
        return SportsDBRepo.getLeaguesOfGame(sportName)
    }


}