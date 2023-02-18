package com.example.sampleandroidapp.model

import com.example.sampleandroidapp.data.SemusicDataSource
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class SemusicRepository(private val dataSource : SemusicDataSource) {

    suspend fun getPlaylists() : String {
        return dataSource.getPlaylists()
    }

    suspend fun testSSL() {
        withContext(Dispatchers.IO) {
            dataSource.testSSL()
        }
    }
}