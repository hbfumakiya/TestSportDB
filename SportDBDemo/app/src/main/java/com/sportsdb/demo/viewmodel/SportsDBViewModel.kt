package com.sportsdb.demo.viewmodel

import androidx.lifecycle.LiveData
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

    override fun getAllSports(): LiveData<Resource<SportResult>> {
        return SportsDBRepo.getAllSports()
    }

    override fun getLeaguesOfGame(sportName: String): LiveData<Resource<GamesResult>> {
        return SportsDBRepo.getLeaguesOfGame(sportName)
    }

}
