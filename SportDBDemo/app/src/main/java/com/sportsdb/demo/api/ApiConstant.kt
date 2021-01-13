package com.sportsdb.demo.api


/**
 * Created by Hardik on 10-01-2021.
 * this is api constant class for app
 */

object ApiConstant {

    // HTTP request timeouts
    const val HTTP_CONNECT_TIMEOUT = 30L
    const val HTTP_READ_TIMEOUT = 60L

    // Base URL for TheSportsDB
    const val BASE_URL = "https://www.thesportsdb.com/"

    // SportDB endpoints

    // Show all sports
    const val LIST_ALL_SPORTS = "api/v1/json/1/all_sports.php"

    // Show all leagues
    const val LIST_ALL_LEAGUES = "api/v1/json/1/all_leagues.php"

    // Show all countries
    const val LIST_ALL_COUNTRIES = "api/v1/json/1/all_countries.php"

    // Show leagues by game name
    const val SHOW_GAMES_LEAGUES = "api/v1/json/1/search_all_leagues.php?s=Soccer"


    // Parameters
    const val PARAM_SPORT_NAME = "s"

}