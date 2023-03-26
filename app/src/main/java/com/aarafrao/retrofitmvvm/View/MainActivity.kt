package com.aarafrao.retrofitmvvm.View

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.aarafrao.retrofitmvvm.ViewModel.EmployeeVM
import com.aarafrao.retrofitmvvm.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var viewBinding: ActivityMainBinding
    private lateinit var viewModel: EmployeeVM

    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        viewBinding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(viewBinding.root)


        viewModel = ViewModelProvider(this)[EmployeeVM::class.java]
        viewModel.loadEMP()


        viewModel.emp.observe(this, Observer {
            viewBinding.txtHello.text = it.data.toString()
        })


    }
}