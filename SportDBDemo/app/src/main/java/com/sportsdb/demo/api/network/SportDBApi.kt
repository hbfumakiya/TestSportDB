package com.sportsdb.demo.api.network

import com.sportsdb.demo.api.ApiConstant.LIST_ALL_COUNTRIES
import com.sportsdb.demo.api.ApiConstant.LIST_ALL_LEAGUES
import com.sportsdb.demo.api.ApiConstant.LIST_ALL_SPORTS
import com.sportsdb.demo.api.ApiConstant.PARAM_SPORT_NAME
import com.sportsdb.demo.api.ApiConstant.SHOW_GAMES_LEAGUES
import com.sportsdb.demo.model.CountryResult
import com.sportsdb.demo.model.GamesResult
import com.sportsdb.demo.model.LeagueResult
import com.sportsdb.demo.model.SportResult
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface SportDBApi {

    // List of all Sports
    @GET(LIST_ALL_SPORTS)
    fun getAllSports(): Call<SportResult>

    // List of all Leagues
    @GET(LIST_ALL_LEAGUES)
    fun getAllLeagues(): Call<LeagueResult>

    // List of all Countries
    @GET(LIST_ALL_COUNTRIES)
    fun getAllCountries(): Call<CountryResult>

    // List of Games by Sport name
    @GET(SHOW_GAMES_LEAGUES)
    fun getLeaguesOfGame(@Query(PARAM_SPORT_NAME) sportName:String?): Call<GamesResult>

}