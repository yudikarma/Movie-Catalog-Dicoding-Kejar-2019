package com.yudikarma.moviecatalogsubmision2.feature.ui.liga.activity

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Gravity
import com.squareup.picasso.Picasso
import com.yudikarma.moviecatalogsubmision2.R
import com.yudikarma.moviecatalogsubmision2.feature.ui.liga.model.ListLigaModel
import com.yudikarma.moviecatalogsubmision2.feature.ui.match.MainActivity
import org.jetbrains.anko.*
import org.jetbrains.anko.sdk27.coroutines.onClick

class LigaDetailActivity : AppCompatActivity() {
    private class DescriptionUI(var item : ListLigaModel) : AnkoComponent<LigaDetailActivity> {
        override fun createView(ui: AnkoContext<LigaDetailActivity>) = with(ui) {
            scrollView {
                verticalLayout {
                    lparams(
                        width = matchParent,
                        height = wrapContent
                    )
                    gravity =Gravity.CENTER
                    padding = dip(16)

                    imageView{
                        Picasso.get().load(item.image!!).into(this)
                        id = R.id.image
                        padding = dip(16)
                    }.lparams(
                        width = matchParent,
                        height = 200
                    )

                    textView {
                        id = R.id.nameID
                        text = item.name
                        textSize = sp(12).toFloat()
                        padding = dip(16)
                    }

                    textView {
                        id = R.id.descID
                        text = item.description
                        padding = dip(16)
                    }
                    button{
                        id = R.id.click_id
                        text = "See Match"
                        padding = dip(8)
                        onClick {
                            goToMatch(context)
                        }
                    }

                }
            }
        }
    }

    companion object {
        const val POSITIONLEAGUE = "position"

        var id = ""

        fun goToMatch(context:Context){
            MainActivity.getStartedIntent(context,id.toInt())
        }

        fun getStartedIntent(context: Context,data:ListLigaModel){
            context.startActivity<LigaDetailActivity>(POSITIONLEAGUE to data)
        }
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val intent =intent
        val list = intent.getParcelableExtra(POSITIONLEAGUE)  as ListLigaModel


        id = list.id.toString()

        DescriptionUI(list).setContentView(this)
    }




}
