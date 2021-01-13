package com.sportsdb.demo.api.network

import androidx.lifecycle.MutableLiveData
import com.sportsdb.demo.api.ApiConstant.BASE_URL
import com.sportsdb.demo.api.ApiConstant.HTTP_CONNECT_TIMEOUT
import com.sportsdb.demo.api.ApiConstant.HTTP_READ_TIMEOUT
import com.sportsdb.demo.api.Resource
import com.sportsdb.demo.model.GamesResult
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

    override fun getAllSports(): MutableLiveData<Resource<SportResult>> {
        val result = MutableLiveData<Resource<SportResult>>()
        retroClient.getAllSports().enqueue(object : Callback<SportResult> {
            override fun onFailure(call: Call<SportResult>, t: Throwable) {
                result.value = Resource.error("getAllSports call failed", t as SportResult)
            }

            override fun onResponse(call: Call<SportResult>, response: Response<SportResult>) {
                result.value = Resource.success(response.body() as SportResult)
            }

        })

        return result
    }

    override fun getLeaguesOfGame(sportName: String): MutableLiveData<Resource<GamesResult>> {
        val result = MutableLiveData<Resource<GamesResult>>()
        retroClient.getLeaguesOfGame(sportName).enqueue(object : Callback<GamesResult> {
            override fun onFailure(call: Call<GamesResult>, t: Throwable) {
                result.value = Resource.error("getLeaguesOfGame call failed", t as GamesResult)
            }

            override fun onResponse(call: Call<GamesResult>, response: Response<GamesResult>) {
                result.value = Resource.success(response.body() as GamesResult)
            }
        })
        return result
    }
}

interface ISportsDBRepo {
    fun getAllSports(): MutableLiveData<Resource<SportResult>>
    fun getLeaguesOfGame(sportName: String): MutableLiveData<Resource<GamesResult>>
}