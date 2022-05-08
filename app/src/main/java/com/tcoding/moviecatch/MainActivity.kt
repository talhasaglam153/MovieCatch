package com.tcoding.moviecatch

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.constraintlayout.utils.widget.MockView
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.tcoding.moviecatch.adapter.MovieAdapter
import com.tcoding.moviecatch.databinding.ActivityMainBinding
import com.tcoding.moviecatch.models.Movie
import com.tcoding.moviecatch.viewmodel.HomePageViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    lateinit var binding : ActivityMainBinding
    lateinit var movieAdapter : MovieAdapter

    val viewModel by lazy {
        ViewModelProvider(this, defaultViewModelProviderFactory).get(HomePageViewModel::class.java)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        movieAdapter = MovieAdapter()
        binding.rv.adapter = movieAdapter

        viewModel.getObserverLiveData().observe(this, object: Observer<Movie>{
            override fun onChanged(t: Movie?) {
                if(t != null) {
                    movieAdapter.setList(t.results)
                }
            }

        })
        viewModel.loadPopularData("1")

    }
}