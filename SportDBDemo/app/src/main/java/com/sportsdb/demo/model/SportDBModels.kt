package com.sportsdb.demo.model

import com.google.gson.annotations.SerializedName

/**
 * Created by Hardik on 10-01-2021.
 * this is model class for api data objects
 */

data class SportResult(
    @SerializedName("sports")
    var sports: List<Sport>? = null
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

data class GamesResult(
    @SerializedName("countrys")
    val games: List<League>
)

data class League(
    @SerializedName("dateFirstEvent")
    val dateFirstEvent: String?,
    @SerializedName("idAPIfootball")
    val idAPIfootball: String?,
    @SerializedName("idCup")
    val idCup: String?,
    @SerializedName("idLeague")
    val idLeague: String?,
    @SerializedName("intFormedYear")
    val intFormedYear: String?,
    @SerializedName("strBadge")
    val strBadge: String? = null,
    @SerializedName("strCountry")
    val strCountry: String?,
    @SerializedName("strCurrentSeason")
    val strCurrentSeason: String?,
    @SerializedName("strDescriptionEN")
    val strDescriptionEN: String? = null,
    @SerializedName("strDivision")
    val strDivision: String?,
    @SerializedName("strGender")
    val strGender: String?,
    @SerializedName("strLeague")
    val strLeague: String?,
    @SerializedName("strLeagueAlternate")
    val strLeagueAlternate: String?,
    @SerializedName("strLocked")
    val strLocked: String?,
    @SerializedName("strLogo")
    var strLogo: String? = null,
    @SerializedName("strNaming")
    val strNaming: String?,
    @SerializedName("strPoster")
    val strPoster: Any?,
    @SerializedName("strSport")
    val strSport: String?,
    @SerializedName("strTrophy")
    val strTrophy: Any?,
    @SerializedName("strWebsite")
    val strWebsite: String?
)