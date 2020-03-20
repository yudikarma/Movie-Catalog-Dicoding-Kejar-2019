package com.yudikarma.moviecatalogsubmision2.feature.ui.match.dashboard.search.team

import androidx.recyclerview.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.AsyncListDiffer
import androidx.recyclerview.widget.DiffUtil
import com.yudikarma.moviecatalogsubmision2.R
import com.yudikarma.moviecatalogsubmision2.data.network.model.Team

class SearchTeamRvAdapter(private val interaction: Interaction? = null) :
    RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    val DIFF_CALLBACK = object : DiffUtil.ItemCallback<Team>() {

        override fun areItemsTheSame(oldItem: Team, newItem: Team): Boolean {
            TODO("not implemented")
        }

        override fun areContentsTheSame(oldItem: Team, newItem: Team): Boolean {
            TODO("not implemented")
        }

    }
    private val differ = AsyncListDiffer(this, DIFF_CALLBACK)


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {

        return SearchTeamViewHolders(
            LayoutInflater.from(parent.context).inflate(
                R.layout.item_list_team,
                parent,
                false
            ),
            interaction
        )
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        when (holder) {
            is SearchTeamViewHolders -> {
                holder.bind(differ.currentList.get(position))
            }
        }
    }

    override fun getItemCount(): Int {
        return differ.currentList.size
    }

    fun submitList(list: List<Team>) {
        differ.submitList(list)
    }

    class SearchTeamViewHolders
    constructor(
        itemView: View,
        private val interaction: Interaction?
    ) : RecyclerView.ViewHolder(itemView) {

        fun bind(item: Team) = with(itemView) {
            itemView.setOnClickListener {
                interaction?.onItemSelected(adapterPosition, item)
            }


        }
    }

    interface Interaction {
        fun onItemSelected(position: Int, item: Team)
    }
}
