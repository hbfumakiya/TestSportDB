package com.sportsdb.demo.viewmodel

interface ISportDBViewModel {
    fun getAllSports()
    fun getLeaguesOfGame(sportName: String)
}