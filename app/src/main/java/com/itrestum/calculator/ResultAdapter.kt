package com.itrestum.calculator

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.view_result.view.*


class ResultAdapter : RecyclerView.Adapter<ResultAdapter.ResultViewHolder>() {
    private val results = mutableListOf<Result>()

    fun addItem(result:Result){
        results.add(result)
        notifyDataSetChanged()
    }

    fun clearAll() {
        results.clear()
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ResultViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.view_result, parent, false)
        return ResultViewHolder(view)
    }

    override fun getItemCount(): Int {
        return results.size
    }

    override fun onBindViewHolder(holder: ResultViewHolder, position: Int) {
        holder.bind(results[position])
    }

    class ResultViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        fun bind(result: Result) {
            itemView.input.text = result.input
            //itemView.output.text = result.output
        }
    }
}