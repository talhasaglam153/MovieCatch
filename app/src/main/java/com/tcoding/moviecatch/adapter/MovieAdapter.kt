package com.tcoding.moviecatch.adapter

import android.text.Layout
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.tcoding.moviecatch.R
import com.tcoding.moviecatch.models.Result

class MovieAdapter: RecyclerView.Adapter<MovieAdapter.MyCustomHolder>() {

    var liveData : List<Result>? = null

    fun setList(liveData : List<Result>) {
        this.liveData = liveData
        notifyDataSetChanged()
    }

    class MyCustomHolder(itemView: View): RecyclerView.ViewHolder(itemView){
        val txtTitle = itemView.findViewById<TextView>(R.id.title)

        fun bindData(data : Result) {
            txtTitle.text = data.title
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieAdapter.MyCustomHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.popular_movie_item, parent, false)
        return MyCustomHolder(view)
    }

    override fun onBindViewHolder(holder: MovieAdapter.MyCustomHolder, position: Int) {
        holder.bindData(liveData!!.get(position))
    }

    override fun getItemCount(): Int {
        if(liveData == null) {
            return 0
        }else {
            return liveData!!.size
        }


    }

}