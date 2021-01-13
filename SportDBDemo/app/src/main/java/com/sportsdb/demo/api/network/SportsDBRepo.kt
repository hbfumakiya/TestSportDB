package com.sportsdb.demo.api.network

import android.util.Log
import androidx.lifecycle.MutableLiveData
import com.sportsdb.demo.api.ApiConstant.BASE_URL
import com.sportsdb.demo.api.ApiConstant.HTTP_CONNECT_TIMEOUT
import com.sportsdb.demo.api.ApiConstant.HTTP_READ_TIMEOUT
import com.sportsdb.demo.model.GamesResult
import com.sportsdb.demo.model.LeagueResult
import com.sportsdb.demo.model.SportResult
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

/**
 * Created by Hardik on 11-01-2021.
 * this is sportdb repository structure for api calls
 */

object SportsDBRepo : ISportsDBRepo {

    private val retroClient: SportDBApi by lazy {
        val mLoggingInterceptor = HttpLoggingInterceptor()
        mLoggingInterceptor.level = HttpLoggingInterceptor.Level.BODY

        val mClient = OkHttpClient.Builder()
            .connectTimeout(HTTP_CONNECT_TIMEOUT, TimeUnit.SECONDS)
            .readTimeout(HTTP_READ_TIMEOUT, TimeUnit.SECONDS)
            .build()

        val mRetrofit = Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .client(mClient)
            .build()

        mRetrofit.create(SportDBApi::class.java)
    }

    override fun getAllSports(): MutableLiveData<SportResult> {
        val result = MutableLiveData<SportResult>()
        retroClient.getAllSports().enqueue(object : Callback<SportResult> {
            override fun onFailure(call: Call<SportResult>, t: Throwable) {
                Log.v("onFailure : ", t.toString())
            }

            override fun onResponse(call: Call<SportResult>, response: Response<SportResult>) {
                Log.v("onResponse : ", response.body().toString())
                result.value = response.body()
            }

        })

        return result
    }

    override fun getAllLeagues(): MutableLiveData<LeagueResult> {
        val result = MutableLiveData<LeagueResult>()
        retroClient.getAllLeagues().enqueue(object : Callback<LeagueResult> {
            override fun onFailure(call: Call<LeagueResult>, t: Throwable) {
                Log.v("onFailure : ", t.toString())
            }

            override fun onResponse(call: Call<LeagueResult>, response: Response<LeagueResult>) {
                Log.v("onResponse : ", response.body().toString())
                result.value = response.body()
            }

        })
        return result
    }

    override fun getLeaguesOfGame(sportName: String): MutableLiveData<GamesResult> {
        val result = MutableLiveData<GamesResult>()
        retroClient.getLeaguesOfGame(sportName).enqueue(object : Callback<GamesResult> {
            override fun onFailure(call: Call<GamesResult>, t: Throwable) {
                Log.v("onFailure : ", t.toString())
            }

            override fun onResponse(call: Call<GamesResult>, response: Response<GamesResult>) {
                Log.v("onResponse : ", response.body().toString())
                result.value = response.body()
            }
        })
        return result
    }
}

interface ISportsDBRepo {
    fun getAllSports(): MutableLiveData<SportResult>
    fun getAllLeagues(): MutableLiveData<LeagueResult>
    fun getLeaguesOfGame(sportName: String): MutableLiveData<GamesResult>
}