package com.yudikarma.moviecatalogsubmision2.feature.ui.liga.ui

import android.view.Gravity
import android.view.ViewGroup
import android.widget.LinearLayout
import com.yudikarma.moviecatalogsubmision2.R
import org.jetbrains.anko.*

class ListLigaUI : AnkoComponent<ViewGroup>{

    override fun createView(ui: AnkoContext<ViewGroup>)= with(ui) {

        linearLayout {
            orientation = LinearLayout.HORIZONTAL
            lparams(matchParent, wrapContent)
            padding = dip(8)

            imageView {
                id = R.id.image
                imageResource = R.drawable.english_premier_league
            }.lparams {
                width = dip(32)
                height = dip(32)
            }

            textView{
                id = R.id.text
                textSize = sp(8).toFloat()
                text = R.string.name.toString()
            }.lparams(matchParent, wrapContent) {
                margin = dip(4)
                gravity = Gravity.CENTER_VERTICAL
            }
        }
    }

}