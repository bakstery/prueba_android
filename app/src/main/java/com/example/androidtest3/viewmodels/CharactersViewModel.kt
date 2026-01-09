package com.example.androidtest3.viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.androidtest3.GetAllCharactersUseCase
import com.example.androidtest3.models.CharacterResponse
import dagger.hilt.android.lifecycle.HiltViewModel
import jakarta.inject.Inject
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

@HiltViewModel
class CharactersViewModel @Inject constructor(
    private val getAllCharactersUseCase: GetAllCharactersUseCase
) : ViewModel() {

    private val _getCharacter = MutableStateFlow<CharacterResponse?>(null)
    val getCharacter: StateFlow<CharacterResponse?> get() = _getCharacter.asStateFlow()

    init {
        detonatorCharacter()
    }

    fun detonatorCharacter(){
        viewModelScope.launch {
            getAllCharactersUseCase().collect{
                _getCharacter.emit(it)
            }
        }
    }
}