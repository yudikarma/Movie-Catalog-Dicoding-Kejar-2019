package com.yudikarma.moviecatalogsubmision2.feature.ui.match.favoriteMatch

import androidx.recyclerview.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.AsyncListDiffer
import androidx.recyclerview.widget.DiffUtil

class FavoriteMatchRvAdapter(private val interaction: Interaction? = null) :
    RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    val DIFF_CALLBACK = object : DiffUtil.ItemCallback<Favorite>() {

        override fun areItemsTheSame(oldItem: Favorite, newItem: Favorite): Boolean {
            TODO("not implemented")
        }

        override fun areContentsTheSame(oldItem: Favorite, newItem: Favorite): Boolean {
            TODO("not implemented")
        }

    }
    private val differ = AsyncListDiffer(this, DIFF_CALLBACK)


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {

        return FavoriteMatchViewHolders(
            LayoutInflater.from(parent.context).inflate(
                R.layout.,
                parent,
                false
            ),
            interaction
        )
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        when (holder) {
            is FavoriteMatchViewHolders -> {
                holder.bind(differ.currentList.get(position))
            }
        }
    }

    override fun getItemCount(): Int {
        return differ.currentList.size
    }

    fun submitList(list: List<Favorite>) {
        differ.submitList(list)
    }

    class FavoriteMatchViewHolders
    constructor(
        itemView: View,
        private val interaction: Interaction?
    ) : RecyclerView.ViewHolder(itemView) {

        fun bind(item: Favorite) = with(itemView) {
            itemView.setOnClickListener {
                interaction?.onItemSelected(adapterPosition, item)
            }

            TODO("bind view with data")
        }
    }

    interface Interaction {
        fun onItemSelected(position: Int, item: Favorite)
    }
}