package com.example.weatherapp.api

import com.example.weatherapp.Model.Weather
import retrofit2.Response
import retrofit2.http.GET

interface ApiService {

    @GET("weather/Luanda")
    suspend fun getWeather(): Response<Weather>
}