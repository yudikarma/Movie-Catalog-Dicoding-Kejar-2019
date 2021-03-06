package com.yudikarma.moviecatalogsubmision2.feature.ui.favorite.favoriteMovie

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.PopupMenu
import android.widget.RatingBar
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.yudikarma.moviecatalogsubmision2.R
import com.yudikarma.moviecatalogsubmision2.data.local.model.MovieEntity

class FavoriteMovieAdapter(var context: Context, private val datas:MutableList<MovieEntity>, val listener: OnItemClickListener):
    RecyclerView.Adapter<FavoriteMovieAdapter.ViewHolder>() {

    private lateinit var popupMenu: PopupMenu

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.item_list_movie,parent,false)
        return ViewHolder(view)
    }


    override fun getItemCount(): Int = datas.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = datas[position]
        holder.bind(item)
        holder.icon_delete.setOnClickListener {
            showPopUpMenuDelete(it,item)
        }

    }

    fun showPopUpMenuDelete(view: View,movieEntity: MovieEntity) {
        popupMenu = PopupMenu(context, view)
        popupMenu.inflate(R.menu.delete_jtem)
        popupMenu.setOnMenuItemClickListener { item ->
            when(item?.itemId){
                R.id.action_delete -> listener.onItemDeleteClick(view,movieEntity)
            }
            true
        }
        popupMenu.show()
    }

    inner class ViewHolder internal constructor(itemView: View) : RecyclerView.ViewHolder(itemView) {

        internal var posterMovie: ImageView
        internal var nameMovie: TextView
        internal var rilisMovie: TextView
        internal var sinopsisMovie: TextView
        internal var ratingMovie: RatingBar
        internal var icon_delete:ImageView

        init {
            posterMovie = itemView.findViewById(R.id.poster_movie)
            nameMovie = itemView.findViewById(R.id.name_movie)
            rilisMovie = itemView.findViewById(R.id.rilis_movie)
            sinopsisMovie = itemView.findViewById(R.id.artist_movie)
            ratingMovie = itemView.findViewById(R.id.rating_movie)
            icon_delete = itemView.findViewById(R.id.icon_delete)


        }

        fun bind(item: MovieEntity) {
            nameMovie.text = "${item.title}"
            val urlImage = "https://image.tmdb.org/t/p"
            Glide.with(context).load(urlImage+"/w500"+item.poster_path).into(posterMovie)
            rilisMovie.text = "${item.release_date}"
            sinopsisMovie.text = "${item.overview}"
            val rating = item.vote_average - 5.0
            ratingMovie.rating = rating.toFloat()
            icon_delete.visibility = View.VISIBLE
        }
    }

    interface OnItemClickListener {
        fun onItemDeleteClick(v: View, movieEntity: MovieEntity)
    }
}