package com.example.androidtest3.ui

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.androidtest3.MainViewModel
import com.example.androidtest3.adapters.CharacterAdapter
import com.example.androidtest3.databinding.FramgmentCharactersBinding
import com.example.androidtest3.models.Result
import com.example.androidtest3.viewmodels.CharactersViewModel
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch

@AndroidEntryPoint
class CharactersFragment : Fragment() {
    private lateinit var binding: FramgmentCharactersBinding
    private val viewmodel by viewModels< CharactersViewModel>()
    //private lateinit var listCharacters : ArrayList<Result>

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = FramgmentCharactersBinding.inflate(inflater,container, false)
        binding = view
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        //initUI()
        getCharacters()


    }



    private fun getCharacters() {
        lifecycleScope.launch {
            viewmodel.getCharacter.collect {
                if (it!=null) {
                    val list = it.let { results -> results.results }

                    val customAdapter = CharacterAdapter(requireContext(),list)
                    binding.rvCharacters.layoutManager = LinearLayoutManager(requireContext())
                    binding.rvCharacters.adapter =customAdapter
                    //binding.rvCharacters.adapter?.notifyDataSetChanged()
                }

                Log.println(Log.INFO,"http","Result"+ it?.let { results -> results.results?.size ?: 0 })

            }
        }

        viewmodel.detonatorCharacter()
    }

}