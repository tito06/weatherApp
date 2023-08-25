package com.example.weatherapp.ViewModel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.weatherapp.Model.Weather
import com.example.weatherapp.Repository.WeatherRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class WeatherViewModel
@Inject constructor(private val repository: WeatherRepository): ViewModel() {

    private val _response = MutableLiveData<Weather>()
    val weatherData:LiveData<Weather>
        get() = _response


    init {
        getWeather()
    }

    private fun getWeather() = viewModelScope.launch{
        repository.getWeather().let { response ->
            if (response.isSuccessful){
                _response.postValue(response.body())
            } else {
                Log.d("EXCEPTION", "${response.body()}")
            }
        }
    }
}