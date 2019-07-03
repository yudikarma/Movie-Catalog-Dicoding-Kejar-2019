package com.yudikarma.moviecatalogsubmision2.ui.tvshow


import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.Navigation
import androidx.recyclerview.widget.LinearLayoutManager

import com.yudikarma.moviecatalogsubmision2.R
import com.yudikarma.moviecatalogsubmision2.adapter.ListTvShowAdapter
import com.yudikarma.moviecatalogsubmision2.model.Movie
import com.yudikarma.moviecatalogsubmision2.ui.movie.FragmentListMovieDirections
import kotlinx.android.synthetic.main.fragment_list_tv_show.view.*


class ListTvShowFragment : Fragment(),ListTvShowAdapter.OnItemClickListener {
    lateinit var mView :View
    private lateinit var adapter : ListTvShowAdapter
    private lateinit var data:MutableList<Movie>
    private lateinit var mContext: Context

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        mView = inflater.inflate(R.layout.fragment_list_tv_show, container, false)
        mContext = context ?: return mView

        setupRecycleView()

        return mView
    }

    private fun setupRecycleView() {
        data = arrayListOf()
        adapter = ListTvShowAdapter(mContext , data, this)
        mView.recycleview_listtvshow.layoutManager = LinearLayoutManager(mContext)
        mView.recycleview_listtvshow.adapter = adapter

        setupDataDummy()
    }

    private fun setupDataDummy() {
        var arrayIdmovie = resources.getStringArray(R.array.id_tvshow)
        var arrayposterMovie = resources.getStringArray(R.array.poster_tvshow)
        var arrayNameMovie = resources.getStringArray(R.array.name_tvshow)
        var arrayRilis_movie = resources.getStringArray(R.array.rilis_tvshow)
        var arrayDescriptionMovie = resources.getStringArray(R.array.description_tvshow)
        var arrayRating = resources.getStringArray(R.array.rating_tvshow)


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
        val action = ListTvShowFragmentDirections.actionActionTvshowToDetailMovieFragment(movie)
        Navigation.findNavController(v).navigate(action)

    }

}
