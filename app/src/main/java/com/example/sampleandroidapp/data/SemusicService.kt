package com.example.sampleandroidapp.data

import retrofit2.http.GET

interface SemusicService {

    @GET("SEMWebServices/webresources/SEMWS/getPlaylists&stationname=ruslan_hp")
    suspend fun getPlaylists() : String
}