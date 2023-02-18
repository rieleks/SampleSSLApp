package com.example.sampleandroidapp.data

import retrofit2.http.GET

interface MediumService {

    @GET
    suspend fun getRoot() : String

}