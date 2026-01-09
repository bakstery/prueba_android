package com.example.androidtest3

import android.net.Uri
import android.os.Bundle
import android.util.Log
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.lifecycle.lifecycleScope
import com.bumptech.glide.Glide
import com.example.androidtest3.databinding.ActivityMainBinding
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import androidx.core.net.toUri

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private val vModel: MainViewModel by viewModels()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        /*lifecycleScope.launch {
            vModel.getCharacter.collect {
                if (it!=null){
                    val list = it.let { results -> results.results }

                    Glide.with(this@MainActivity).load(list!![0]!!.image!!).into(binding.imageCharacter)
                }

                Log.println(Log.INFO,"http","Result"+ it?.let { results -> results.results?.size ?: 0 })
            }
        }*/

        //vModel.detonatorCharacter()
    }
}