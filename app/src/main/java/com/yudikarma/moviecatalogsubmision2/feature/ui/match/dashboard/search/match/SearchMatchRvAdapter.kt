package com.yudikarma.moviecatalogsubmision2.feature.ui.match.dashboard.search.match

import androidx.recyclerview.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.AsyncListDiffer
import androidx.recyclerview.widget.DiffUtil
import com.yudikarma.moviecatalogsubmision2.R
import com.yudikarma.moviecatalogsubmision2.data.network.model.EventsItemMatchByName
import com.yudikarma.moviecatalogsubmision2.utils.loadImage
import kotlinx.android.synthetic.main.item_list_match.view.*

class SearchMatchRvAdapter(private val interaction: Interaction? = null) :
    RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    val DIFF_CALLBACK = object : DiffUtil.ItemCallback<EventsItemMatchByName>() {

        override fun areItemsTheSame(oldItem: EventsItemMatchByName, newItem: EventsItemMatchByName): Boolean {
            return oldItem == newItem
        }

        override fun areContentsTheSame(oldItem: EventsItemMatchByName, newItem: EventsItemMatchByName): Boolean {
            return oldItem.idEvent == newItem.idEvent

        }

    }
    private val differ = AsyncListDiffer(this, DIFF_CALLBACK)


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {

        return SearchMatchViewHolder(
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
            is SearchMatchViewHolder -> {
                holder.bind(differ.currentList.get(position))
            }
        }
    }

    override fun getItemCount(): Int {
        return differ.currentList.size
    }

    fun submitList(list: List<EventsItemMatchByName>?) {
        differ.submitList(list)
    }

    class SearchMatchViewHolder
    constructor(
        itemView: View,
        private val interaction: Interaction?
    ) : RecyclerView.ViewHolder(itemView) {

        fun bind(item: EventsItemMatchByName) = with(itemView) {
            itemView.setOnClickListener {

                interaction?.onItemSelected(adapterPosition, item,this)
            }

            itemView.logo_team_2.loadImage(item.strThumb+"/preview")
            itemView.name_match.text = "${item.strEvent}"
            itemView.rilis_match.text = "${item.strDate}"
            itemView.name_team_1.text = "${item.strHomeTeam}"
            itemView.name_team_2.text = "${item.strAwayTeam}"
            itemView.score_team_1.text = "${item.intHomeScore}"
            itemView.score_team_2.text = "${item.intAwayScore}"
        }
    }

    interface Interaction {
        fun onItemSelected(position: Int, item: EventsItemMatchByName,view: View)
    }
}