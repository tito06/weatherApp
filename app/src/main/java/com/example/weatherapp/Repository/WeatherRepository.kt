package com.example.weatherapp.Repository

import com.example.weatherapp.api.ApiService
import javax.inject.Inject

class WeatherRepository
@Inject constructor(private  val apiservice: ApiService){

    suspend fun getWeather()= apiservice.getWeather()
}