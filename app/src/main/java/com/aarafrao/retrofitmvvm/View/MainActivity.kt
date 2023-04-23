package com.aarafrao.retrofitmvvm.View

import android.annotation.SuppressLint
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.aarafrao.retrofitmvvm.Adapter.DataAdapter
import com.aarafrao.retrofitmvvm.ViewModel.EmployeeVM
import com.aarafrao.retrofitmvvm.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var viewBinding: ActivityMainBinding
    private lateinit var viewModel: EmployeeVM
    private lateinit var dataAdapter: DataAdapter

    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        viewBinding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(viewBinding.root)

        viewModel = ViewModelProvider(this)[EmployeeVM::class.java]
        viewModel.loadEMP()


        dataAdapter = DataAdapter()
        viewBinding.mainRV.apply {
            adapter = dataAdapter
            layoutManager = LinearLayoutManager(applicationContext)
        }

        viewModel.emp.observe(this) {

            if (it != null) {
                dataAdapter.updateList(it.data)
                dataAdapter.notifyDataSetChanged()
            } else Toast.makeText(applicationContext, "Error", Toast.LENGTH_SHORT).show()

        }


    }
}