package com.yudikarma.moviecatalogsubmision2.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.RatingBar
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.yudikarma.moviecatalogsubmision2.R
import com.yudikarma.moviecatalogsubmision2.model.Movie

class ListTvShowAdapter(var context: Context, private val datas:MutableList<Movie>, val listener:OnItemClickListener):
    RecyclerView.Adapter<ListTvShowAdapter.ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.item_list_movie,parent,false)
        return ViewHolder(view)
    }


    override fun getItemCount(): Int = datas.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = datas[position]
        holder.bind(item)
        holder.itemView.setOnClickListener { listener.onItemDetailClick(it,position,item) }
    }

    inner class ViewHolder internal constructor(itemView: View) : RecyclerView.ViewHolder(itemView) {

        internal var posterMovie: ImageView
        internal var nameMovie: TextView
        internal var rilisMovie: TextView
        internal var sinopsisMovie: TextView
        internal var ratingMovie: RatingBar

        init {
            posterMovie = itemView.findViewById(R.id.poster_movie)
            nameMovie = itemView.findViewById(R.id.name_movie)
            rilisMovie = itemView.findViewById(R.id.rilis_movie)
            sinopsisMovie = itemView.findViewById(R.id.artist_movie)
            ratingMovie = itemView.findViewById(R.id.rating_movie)


        }

        fun bind(item: Movie) {
            nameMovie.text = "${item.name}"
            posterMovie.setImageResource(context.resources.getIdentifier("drawable/"+item.poster,null,context.packageName))
            rilisMovie.text = "${item.rilis}"
            sinopsisMovie.text = "${item.description}"
            ratingMovie.rating = "${item.rating}".toFloat()
        }
    }

    interface OnItemClickListener {
        fun onItemDetailClick(v: View, position: Int, data:Movie)
    }
}