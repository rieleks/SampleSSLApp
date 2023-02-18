package com.example.sampleandroidapp.data

import com.google.gson.GsonBuilder
import retrofit2.Retrofit
import retrofit2.converter.scalars.ScalarsConverterFactory
import java.net.URL

class SemusicDataSource {

    suspend fun testSSL() {
        val url = URL("https://stage.semusic.net:8181")
        val urlConnection = url.openConnection()
        val inputStream = urlConnection.getInputStream()
        inputStream.copyTo(System.out)
    }

    suspend fun getPlaylists() : String {
        return getService().getPlaylists()
    }

    private fun getService() : SemusicService {

        val gson = GsonBuilder().setLenient().create()

        val retrofit = Retrofit.Builder()
            .baseUrl("http://stage.semusic.net:8080")
//            .addConverterFactory(GsonConverterFactory.create())
//            .addConverterFactory(SimpleXmlConverterFactory.create())
            .addConverterFactory(ScalarsConverterFactory.create())
            .build()

        return retrofit.create(SemusicService::class.java)
    }

    private fun getMediumService() : MediumService{
        val retrofit = Retrofit.Builder()
            .baseUrl("https://medium.com")
            .addConverterFactory(ScalarsConverterFactory.create())
            .build()

        return retrofit.create(MediumService::class.java)
    }

}