package com.yudikarma.moviecatalogsubmision2.feature.ui.match.favoriteMatch

import androidx.recyclerview.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.AsyncListDiffer
import androidx.recyclerview.widget.DiffUtil
import com.yudikarma.moviecatalogsubmision2.R
import com.yudikarma.moviecatalogsubmision2.data.Database.Favorite
import kotlinx.android.synthetic.main.item_list_match.view.*

class FavoriteMatchRvAdapter(private val interaction: Interaction? = null) :
    RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    val DIFF_CALLBACK = object : DiffUtil.ItemCallback<Favorite>() {

        override fun areItemsTheSame(oldItem: Favorite, newItem: Favorite): Boolean {
            return oldItem == newItem
        }

        override fun areContentsTheSame(oldItem: Favorite, newItem: Favorite): Boolean {
            return oldItem.id == newItem.id
        }

    }
    private val differ = AsyncListDiffer(this, DIFF_CALLBACK)


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {

        return FavoriteMatchViewHolders(
            LayoutInflater.from(parent.context).inflate(
                R.layout.item_list_match,
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
            //itemView.logo_team_2.loadImage(item.strThumb+"/preview")
            itemView.name_match.visibility = View.INVISIBLE
            val eventDate = if (item.dateEvent == null) "-" else "${item.dateEvent}"
            itemView.rilis_match.text = eventDate
            val homeTeam = if (item.homeTeam == null) "-" else "${item.homeTeam}"
            itemView.name_team_1.text = homeTeam
            val awayTeam = if (item.awayTeam == null) "-" else "${item.awayTeam}"
            itemView.name_team_2.text = awayTeam
            val homeScore = if (item.homeScore == null) "-" else "\"${item.homeScore}\""
            itemView.score_team_1.text = homeScore
            val awayScore = if (item.awayScore == null) "-" else "${item.awayScore}"
            itemView.score_team_2.text = awayScore
        }
    }

    interface Interaction {
        fun onItemSelected(position: Int, item: Favorite)
    }
}