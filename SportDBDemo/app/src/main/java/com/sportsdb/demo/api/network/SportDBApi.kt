package com.sportsdb.demo.api.network

import com.sportsdb.demo.api.ApiConstant.LIST_ALL_SPORTS
import com.sportsdb.demo.api.ApiConstant.PARAM_SPORT_NAME
import com.sportsdb.demo.api.ApiConstant.SHOW_GAMES_LEAGUES
import com.sportsdb.demo.model.GamesResult
import com.sportsdb.demo.model.SportResult
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

/**
 * Created by Hardik on 11-01-2021.
 * this is sportdb api for the app
 */
interface SportDBApi {

    // List of all Sports
    @GET(LIST_ALL_SPORTS)
    fun getAllSports(): Call<SportResult>

    // List of Games by Sport name
    @GET(SHOW_GAMES_LEAGUES)
    fun getLeaguesOfGame(@Query(PARAM_SPORT_NAME) sportName: String?): Call<GamesResult>

}