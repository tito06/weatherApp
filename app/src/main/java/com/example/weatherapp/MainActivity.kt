package com.example.weatherapp

import android.os.Bundle
import android.util.Size
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RadialGradientShader
import androidx.compose.ui.graphics.Shader
import androidx.compose.ui.graphics.ShaderBrush
import androidx.compose.ui.platform.LocalLifecycleOwner
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import com.example.weatherapp.ViewModel.WeatherViewModel
import com.example.weatherapp.ui.theme.WeatherAppTheme
import dagger.hilt.android.AndroidEntryPoint





@AndroidEntryPoint
class MainActivity : ComponentActivity() {


    private  val viewModel:WeatherViewModel by viewModels()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            WeatherAppTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = Color.White
                ) {

                    Column(modifier = Modifier.fillMaxSize()) {

                            Text(
                                text = "WEATHER APP",
                                modifier = Modifier.fillMaxWidth(),
                                textAlign = TextAlign.Center,
                                fontSize = 30.sp
                            )

                            cenntreAlign(viewModel)


                    }

                }
            }
        }
    }
}

@Composable
fun cenntreAlign(viewModel: WeatherViewModel){
    Box(modifier = Modifier.fillMaxSize(),
    contentAlignment = Alignment.Center){
        Greeting(viewModel = viewModel)
    }
}


@Composable
fun Greeting(viewModel:WeatherViewModel) {
    var data = ""
    var temp = ""
    viewModel.weatherData.observe(LocalLifecycleOwner.current, {

         data = it.description
         temp = it.temperature

    })


    Column {


        Text(
            text = "today's temp -> $temp",
            fontSize = 35.sp
        )


        Text(
            text = "description -> $data",
        )
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    WeatherAppTheme {
    }
}