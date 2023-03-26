package com.aarafrao.retrofitmvvm.ViewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.aarafrao.retrofitmvvm.Model.EmplyeeModel
import com.aarafrao.retrofitmvvm.Repository.EmployeeRepo
import kotlinx.coroutines.launch

class EmployeeVM : ViewModel() {

    private val repo = EmployeeRepo()
    private val _emp = MutableLiveData<EmplyeeModel>()


    val emp: LiveData<EmplyeeModel>
        get() = _emp


    fun loadEMP(){
        viewModelScope.launch {
            val result = repo.getEmployee()
            _emp.postValue(result)
        }
    }
}