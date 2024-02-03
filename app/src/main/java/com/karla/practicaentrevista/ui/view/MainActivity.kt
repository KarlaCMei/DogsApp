package com.karla.practicaentrevista.ui.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.SearchView
import android.widget.Toast
import androidx.activity.viewModels
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.karla.practicaentrevista.data.network.ApiService
import com.karla.practicaentrevista.ui.DogAdapter
import com.karla.practicaentrevista.databinding.ActivityMainBinding
import com.karla.practicaentrevista.ui.viewmodel.DogViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class MainActivity : AppCompatActivity(), SearchView.OnQueryTextListener,
    androidx.appcompat.widget.SearchView.OnQueryTextListener {

    private lateinit var binding: ActivityMainBinding
    private lateinit var adapter: DogAdapter


    private val dogImages = mutableListOf<String>()

    private val dogViewModel: DogViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.txtSearch.setOnQueryTextListener(this)




            /*dogViewModel.dogModel.observe(this, Observer { currentDog ->
                currentDog.images
                currentDog.status
                //Toast.makeText(this@MainActivity,"ResultDog ${currentDog.images}, ${currentDog.status}", Toast.LENGTH_LONG).show()
                Log.d("Resultado Dog", "ResultDog ${currentDog.images}, ${currentDog.status}")
            })

        binding.button.setOnClickListener{
            dogViewModel.randomDog()
        }*/

        initRecyclerView()
    }

    private fun initRecyclerView() {
        adapter= DogAdapter(dogImages)
        binding.rvDogs.layoutManager = LinearLayoutManager(this)
        binding.rvDogs.adapter = adapter
    }

   /* private fun getRetrofit():Retrofit{
        return Retrofit.Builder().baseUrl("https://dog.ceo/api/breed/")
            .addConverterFactory(GsonConverterFactory.create()).build()
    }

    private fun searchByName (query: String){
        CoroutineScope(Dispatchers.IO).launch {
            val call = getRetrofit().create(ApiService::class.java).getDogsByBreeds("$query/images")
            val puppies = call.body()

            runOnUiThread{
                if(call.isSuccessful){
                    //Show recycler view
                    val images : List<String> = puppies?.images ?: emptyList()
                    dogImages.clear()
                    dogImages.addAll(images)
                    adapter.notifyDataSetChanged()
                }else{
                    Toast.makeText(this@MainActivity,"No se encontraron datos", Toast.LENGTH_LONG).show()
                }
            }

        }
    }*/

    override fun onQueryTextSubmit(query: String?): Boolean {
        if (query != null) {
            dogViewModel.onCreate(query)
        }

        /* if(!query.isNullOrEmpty()){
             //searchByName(query.toLowerCase())

             dogViewModel.onCreate(query)
         }*/
         return true
    }

    override fun onQueryTextChange(newText: String?): Boolean {
        return true
    }
}