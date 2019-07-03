package com.yudikarma.moviecatalogsubmision2.ui.movie


import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.Navigation
import androidx.recyclerview.widget.LinearLayoutManager

import com.yudikarma.moviecatalogsubmision2.R
import com.yudikarma.moviecatalogsubmision2.adapter.ListMovieAdapter
import com.yudikarma.moviecatalogsubmision2.model.Movie
import kotlinx.android.synthetic.main.fragment_fragment_list_movie.view.*


class FragmentListMovie : Fragment(), ListMovieAdapter.OnItemClickListener {


    lateinit var mView :View
    private lateinit var adapter : ListMovieAdapter
    private lateinit var data:MutableList<Movie>
    private lateinit var mContext:Context


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        mView = inflater.inflate(R.layout.fragment_fragment_list_movie, container, false)
        mContext = context ?: return mView

        setupRecycleView()

        return mView
    }

    private fun setupRecycleView() {
        data = arrayListOf()
        adapter = ListMovieAdapter(mContext , data, this)
        mView.recycleview_listmovie.layoutManager = LinearLayoutManager(mContext)
        mView.recycleview_listmovie.adapter = adapter

        setupDataDummy()
    }

    private fun setupDataDummy() {
        var arrayIdmovie = resources.getStringArray(R.array.id_movie)
        var arrayposterMovie = resources.getStringArray(R.array.poster_movie)
        var arrayNameMovie = resources.getStringArray(R.array.name_movie)
        var arrayRilis_movie = resources.getStringArray(R.array.rilis_movie)
        var arrayDescriptionMovie = resources.getStringArray(R.array.description_movie)
        var arrayRating = resources.getStringArray(R.array.rating_movie)


        arrayIdmovie.forEach {

            data.add(
                Movie(
                    it,
                    arrayposterMovie[it.toInt()],
                    arrayNameMovie[it.toInt()],
                    arrayRilis_movie[it.toInt()],
                    arrayDescriptionMovie[it.toInt()],
                    arrayRating[it.toInt()]
                )
            )
        }
        adapter.notifyDataSetChanged()
    }

    override fun onItemDetailClick(v: View, position: Int, data: Movie) {
        val movie = Movie(data.id,data.poster,data.name,data.rilis,data.description,data.rating)
        val action =FragmentListMovieDirections.actionFragmentListMovieToDetailMovieFragment(movie)
        Navigation.findNavController(v).navigate(action)

    }
}
