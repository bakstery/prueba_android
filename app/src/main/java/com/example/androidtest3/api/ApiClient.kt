package com.example.androidtest3.api

import com.example.androidtest3.models.CharacterResponse
import retrofit2.Response
import retrofit2.http.GET

interface ApiClient {

    @GET("character")
    suspend fun getAllCharacters(): Response<CharacterResponse>
}