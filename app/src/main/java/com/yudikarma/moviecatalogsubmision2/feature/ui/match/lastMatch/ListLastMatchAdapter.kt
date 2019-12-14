package com.yudikarma.moviecatalogsubmision2.feature.ui.match.lastMatch

import androidx.recyclerview.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.AsyncListDiffer
import androidx.recyclerview.widget.DiffUtil
import com.yudikarma.moviecatalogsubmision2.R
import com.yudikarma.moviecatalogsubmision2.data.network.model.EventsItem
import com.yudikarma.moviecatalogsubmision2.utils.loadImage
import kotlinx.android.synthetic.main.item_list_match.view.*

class ListLastMatchAdapter(private val interaction: Interaction? = null) :
    RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    val DIFF_CALLBACK = object : DiffUtil.ItemCallback<EventsItem>() {

        override fun areItemsTheSame(oldItem: EventsItem, newItem: EventsItem): Boolean {
            return oldItem == newItem
        }

        override fun areContentsTheSame(oldItem: EventsItem, newItem: EventsItem): Boolean {
            return oldItem.idEvent == newItem.idEvent
        }

    }
    private val differ = AsyncListDiffer(this, DIFF_CALLBACK)


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {

        return ListLastMatchViewHolder(
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
            is ListLastMatchViewHolder -> {
                holder.bind(differ.currentList.get(position))
            }
        }
    }

    override fun getItemCount(): Int {
        return differ.currentList.size
    }

    fun submitList(list: List<EventsItem>) {
        differ.submitList(list)
    }

    class ListLastMatchViewHolder
    constructor(
        itemView: View,
        private val interaction: Interaction?
    ) : RecyclerView.ViewHolder(itemView) {

        fun bind(item: EventsItem) = with(itemView) {
            itemView.setOnClickListener {
                interaction?.onItemSelected(adapterPosition, item)
            }
            //itemView.logo_team_2.loadImage(item.strThumb+"/preview")
            val eventName = if (item.strEvent == null) "-" else "${item.strEvent}"
            itemView.name_match.text = eventName
            val eventDate = if (item.strDate == null) "-" else "${item.strDate}"
            itemView.rilis_match.text = eventDate
            val homeTeam = if (item.strHomeTeam == null) "-" else "${item.strHomeTeam}"
            itemView.name_team_1.text = homeTeam
            val awayTeam = if (item.strAwayTeam == null) "-" else "${item.strAwayTeam}"
            itemView.name_team_2.text = awayTeam
            val homeScore = if (item.intHomeScore == null) "-" else "\"${item.intHomeScore}\""
            itemView.score_team_1.text = homeScore
            val awayScore = if (item.intAwayScore == null) "-" else "${item.intAwayScore}"
            itemView.score_team_2.text = awayScore
        }
    }

    interface Interaction {
        fun onItemSelected(position: Int, item: EventsItem)
    }
}