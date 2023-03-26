package com.aarafrao.retrofitmvvm.Repository

import com.aarafrao.retrofitmvvm.Model.EmplyeeModel
import com.aarafrao.retrofitmvvm.Utils.RetrofitObject

class EmployeeRepo {

    private val apiService = RetrofitObject.apiService

    suspend fun getEmployee(): EmplyeeModel{
        return apiService.getEmployees()
    }
}