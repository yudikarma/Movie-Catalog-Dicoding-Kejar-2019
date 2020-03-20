package com.yudikarma.moviecatalogsubmision2.feature.ui.liga.activity


import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.yudikarma.moviecatalogsubmision2.R
import com.yudikarma.moviecatalogsubmision2.feature.ui.liga.adapter.ListLigaAdapter
import com.yudikarma.moviecatalogsubmision2.feature.ui.liga.model.ListLigaModel
import org.jetbrains.anko.*
import org.jetbrains.anko.recyclerview.v7.recyclerView

class ListLigaActivity : AppCompatActivity() {

    @SuppressLint("Recycle")
    private fun loadData() {
        val name = resources.getStringArray(R.array.league_name)
        val image = resources.obtainTypedArray(R.array.league_image)
        val desc = resources.getStringArray(R.array.league_desc)
        val id = resources.getStringArray(R.array.id_liga)

        league.clear()

        for (i in name.indices) {
            league.add(
                ListLigaModel(
                    name[i],
                    desc[i],
                    image.getResourceId(i, 0),
                    id[i].toString()
                )
            )
        }
    }

    private var league : MutableList<ListLigaModel> = mutableListOf()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        loadData()

        relativeLayout{
            padding = dip(16)
            lparams(
                width = matchParent,
                height = wrapContent
            )
            recyclerView{
                lparams(
                    height = wrapContent,
                    width = matchParent
                )
                layoutManager = LinearLayoutManager(context,LinearLayoutManager.HORIZONTAL,false)
                adapter = ListLigaAdapter(league) {
                    //MainActivity.getStartedIntent(context,it.id?.toInt()?:4328)
                    LigaDetailActivity.getStartedIntent(context,it)
                }
            }
        }
    }


}
