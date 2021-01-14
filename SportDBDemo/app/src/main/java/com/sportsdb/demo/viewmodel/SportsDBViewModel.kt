package com.sportsdb.demo.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.sportsdb.demo.model.Resource
import com.sportsdb.demo.api.network.SportsDBRepo
import com.sportsdb.demo.model.GamesResult
import com.sportsdb.demo.model.SportResult

/**
 * Created by Hardik on 11-01-2021.
 * this is view-model class for MVVM architecture
 */

class SportsDBViewModel : ViewModel(), ISportDBViewModel {

    var sportResult: LiveData<Resource<SportResult>> = MutableLiveData<Resource<SportResult>>()
    var leagueResult: LiveData<Resource<GamesResult>> = MutableLiveData<Resource<GamesResult>>()


    override fun getAllSports() {
        sportResult = SportsDBRepo.getAllSports()
    }

    override fun getLeaguesOfGame(sportName: String) {
        leagueResult = SportsDBRepo.getLeaguesOfGame(sportName)
    }

}
