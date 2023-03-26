package com.aarafrao.retrofitmvvm.Utils

import com.aarafrao.retrofitmvvm.Model.EmplyeeModel
import retrofit2.http.GET

interface ApiService {

    @GET("api/v1/employees")
    suspend fun getEmployees():EmplyeeModel
}