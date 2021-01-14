package com.sportsdb.demo

import android.content.Context
import androidx.test.platform.app.InstrumentationRegistry
import com.google.gson.Gson
import com.sportsdb.demo.model.GamesResult
import com.sportsdb.demo.model.SportResult
import com.sportsdb.demo.viewmodel.SportsDBViewModel
import org.junit.Assert
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.robolectric.RobolectricTestRunner

@RunWith(RobolectricTestRunner::class)
class SportsDBViewModelTest {

    var context: Context = InstrumentationRegistry.getInstrumentation().context

    lateinit var sportsDBViewModel: SportsDBViewModel

    @Before
    fun initViewModel() {
        sportsDBViewModel = SportsDBViewModel()
    }

    @Test
    fun isValidSportResult() {
        sportsDBViewModel.getAllSports()
        val result = context.assets.open("get_all_sport.json").bufferedReader().use {
            val text = it.readText()
            Gson().fromJson(text, SportResult::class.java)
        }
        Assert.assertEquals(sportsDBViewModel.sportResult, result)
    }

    @Test
    fun isValidLeagueResult() {
        sportsDBViewModel.getLeaguesOfGame("Soccer")
        val result = context.assets.open("soccer_league_result.json").bufferedReader().use {
            val text = it.readText()
            Gson().fromJson(text, GamesResult::class.java)
        }
        Assert.assertEquals(sportsDBViewModel.leagueResult, result)
    }
}