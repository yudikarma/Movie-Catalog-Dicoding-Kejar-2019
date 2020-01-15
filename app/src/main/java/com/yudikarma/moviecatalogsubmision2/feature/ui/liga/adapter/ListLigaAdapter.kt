package com.yudikarma.moviecatalogsubmision2.feature.ui.Liga.adapter


import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso
import com.yudikarma.moviecatalogsubmision2.R
import com.yudikarma.moviecatalogsubmision2.feature.ui.Liga.model.ListLigaModel
import com.yudikarma.moviecatalogsubmision2.feature.ui.Liga.ui.ListLigaUI
import org.jetbrains.anko.AnkoContext

class ListLigaAdapter (private val items : List<ListLigaModel>, var listener: (ListLigaModel) -> Unit) :
    RecyclerView.Adapter<ListLigaAdapter.ListLigaViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListLigaViewHolder =
        ListLigaViewHolder(
            ListLigaUI().createView(
                AnkoContext.create(parent.context, parent)
            )
        )

    override fun getItemCount(): Int {
        return items.size
    }

    override fun onBindViewHolder(holder: ListLigaViewHolder, position: Int) {
        holder.bind(items[position], listener)
    }

    class ListLigaViewHolder(view: View) : RecyclerView.ViewHolder(view) {

        private var logoLiga : ImageView
        private var nameLiga : TextView

        init {
            logoLiga = view.findViewById(R.id.image)
            nameLiga = view.findViewById(R.id.text)
        }

        fun bind(item: ListLigaModel, listener: (ListLigaModel) -> Unit) {
            itemView.setOnClickListener{
                listener(item)
            }
            item.image?.let { Picasso.get().load(it).into(logoLiga) }
            nameLiga.text =item.name
        }
    }
}