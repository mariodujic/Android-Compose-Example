package com.example.composetest.carbrandlist.ui

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.platform.setContent
import androidx.lifecycle.ViewModelProvider
import com.example.composetest.ui.ComposeTestTheme

class CarBrandListActivity : AppCompatActivity() {

    private lateinit var carBrandListViewModel: CarBrandListViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        instantiateViewModel()
        setCarBrandListContent()
    }

    private fun instantiateViewModel() {
        carBrandListViewModel = ViewModelProvider(this).get(CarBrandListViewModel::class.java)
    }

    private fun ComponentActivity.setCarBrandListContent() {
        setContent {
            val carListState by carBrandListViewModel.carListState.observeAsState(emptyList())

            ComposeTestTheme {
                Surface(color = MaterialTheme.colors.background) {
                    CarBrandListContent(carListState)
                }
            }
        }
    }
}