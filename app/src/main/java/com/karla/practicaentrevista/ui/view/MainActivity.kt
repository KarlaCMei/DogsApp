package com.karla.practicaentrevista.ui.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.SearchView
import androidx.core.view.isVisible
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.karla.practicaentrevista.ui.view.adapter.DogAdapter
import com.karla.practicaentrevista.databinding.ActivityMainBinding
import com.karla.practicaentrevista.ui.viewmodel.DogViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity(), SearchView.OnQueryTextListener,
    androidx.appcompat.widget.SearchView.OnQueryTextListener {

    private lateinit var binding: ActivityMainBinding
    private lateinit var adapter: DogAdapter
    private val dogImages = mutableListOf<String>()

    private lateinit var dogViewModel: DogViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.txtSearch.setOnQueryTextListener(this)

        dogViewModel = ViewModelProvider(this).get(DogViewModel::class.java)

        dogViewModel.dogImages.observe(this, Observer { images ->
            dogImages.clear()
            dogImages.addAll(images)
            adapter.notifyDataSetChanged()
        })

        dogViewModel.isLoading.observe(this, Observer{
            binding.progress.isVisible = it
        })

        initRecyclerView()
    }

    private fun initRecyclerView() {
        adapter= DogAdapter(dogImages)
        binding.rvDogs.layoutManager = LinearLayoutManager(this)
        binding.rvDogs.adapter = adapter
    }

    private fun searchByName (query: String){
        dogViewModel.searchDogsByBreed(query.toLowerCase())

    }

    override fun onQueryTextSubmit(query: String?): Boolean {
        if(!query.isNullOrEmpty()){
            searchByName(query.toLowerCase())
        }
        return true
    }

    override fun onQueryTextChange(newText: String?): Boolean {
        return true
    }
}