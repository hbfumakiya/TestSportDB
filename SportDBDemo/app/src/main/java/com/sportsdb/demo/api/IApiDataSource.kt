package com.sportsdb.demo.api

/**
 * Created by Hardik on 10-01-2021.
 * this is api data source interface for app
 */
interface ApiCallback<T> {
    fun onSuccess(data: T)
    fun onError(errorCode: Int, errorMsg: String? = "")
}