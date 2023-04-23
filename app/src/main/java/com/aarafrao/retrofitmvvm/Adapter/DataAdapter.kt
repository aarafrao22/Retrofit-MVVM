package com.aarafrao.retrofitmvvm.Adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.aarafrao.retrofitmvvm.Model.Data
import com.aarafrao.retrofitmvvm.databinding.ItemDataBinding

class DataAdapter() : RecyclerView.Adapter<DataViewHolder>() {
    private var dataList: List<Data>? = null

    fun updateList(dataList: List<Data>?){
        this.dataList = dataList
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DataViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = ItemDataBinding.inflate(inflater, parent, false)
        return DataViewHolder(binding)
    }

    override fun onBindViewHolder(holder: DataViewHolder, position: Int) {
        holder.bind(dataList!![position])
    }

    override fun getItemCount(): Int {
        return dataList?.size ?: 0
    }
}

class DataViewHolder(private val binding: ItemDataBinding) : RecyclerView.ViewHolder(binding.root) {

    fun bind(data: Data) {
        binding.apply {
            // Bind the data to the views
            nameTextView.text = data.employee_name
            ageTextView.text = "Age: "+data.employee_age.toString()
            salaryTextView.text = "Salary: "+data.employee_salary.toString()

        }
    }
}
