package com.yudikarma.moviecatalogsubmision2.ui.detail


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.navArgs

import com.yudikarma.moviecatalogsubmision2.R
import com.yudikarma.moviecatalogsubmision2.model.Movie
import kotlinx.android.synthetic.main.fragment_detail_movie.view.*

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 *
 */
class DetailMovieFragment : Fragment() {

    lateinit var movie:Movie
    lateinit var mView: View

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        mView = inflater.inflate(R.layout.fragment_detail_movie, container, false)

        val safeVarargs :DetailMovieFragmentArgs by navArgs()
        movie = safeVarargs.movie

        setupViewDetail(movie)

        return mView
    }

    private fun setupViewDetail(movie: Movie) {
        mView?.imageView.setImageResource(this.resources.getIdentifier("drawable/"+movie.poster,null,context?.packageName))
        mView?.textView.text = ""+movie.name
        mView?.textView2.text = ""+movie.rilis
        mView?.description.text = ""+movie.description
        mView?.ratingBar.rating = movie.rating.toFloat()
    }


}
