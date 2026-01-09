package com.example.androidtest3

import com.example.androidtest3.api.ApiClientRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import javax.inject.Inject

/**
 *   Created by Erik Armando on 07/04/25
 */
class GetAllCharactersUseCase @Inject constructor(
    private val apiClientRepository: ApiClientRepository
){

    operator fun invoke() = flow {
        apiClientRepository.getAllCharacters().collect{
           emit(it)
        }
    }.flowOn(context = Dispatchers.IO)

}