package com.sportsdb.demo.model

import com.google.gson.annotations.SerializedName

/**
 * Created by Hardik on 10-01-2021.
 * this is model class for api data objects
 */

data class SportResult(
    @SerializedName("sports")
    val sports: List<Sport>
)

data class Sport(
    @SerializedName("idSport")
    val idSport: String,
    @SerializedName("strFormat")
    val strFormat: String,
    @SerializedName("strSport")
    val strSport: String,
    @SerializedName("strSportDescription")
    val strSportDescription: String,
    @SerializedName("strSportThumb")
    val strSportThumb: String,
    @SerializedName("strSportThumbGreen")
    val strSportThumbGreen: String
)

data class LeagueResult(
    @SerializedName("leagues")
    val leagues: List<League>
)

data class League(
    @SerializedName("idLeague")
    val idLeague: String,
    @SerializedName("strLeague")
    val strLeague: String,
    @SerializedName("strLeagueAlternate")
    val strLeagueAlternate: String,
    @SerializedName("strSport")
    val strSport: String
)

data class CountryResult(
    @SerializedName("countries")
    val countries: List<Country>
)

data class Country(
    @SerializedName("name_en")
    val name_en: String
)