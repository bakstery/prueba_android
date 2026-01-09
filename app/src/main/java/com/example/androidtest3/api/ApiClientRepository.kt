package com.example.androidtest3.api

import com.example.androidtest3.models.CharacterResponse
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

/**
 *   Created by Erik Armando on 07/04/25
 */
class ApiClientRepository @Inject constructor(
    private val apiServiceClient: ApiClient
) {

    fun getAllCharacters(): Flow<CharacterResponse?> = flow {
        val response = apiServiceClient.getAllCharacters()
        try {
            if (response.isSuccessful) {
                emit(response.body())
            } else {
                emit(null)
            }
        } catch (e: Exception) {
            emit(null)
        }
    }
}