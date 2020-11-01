package com.example.composetest.carbranddetails

import android.content.Context
import android.content.Intent
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

class CarBrandDetailsActivity : AppCompatActivity() {

    companion object {
        fun getIntent(context: Context, brand: String) {
            val intent = Intent(context, CarBrandDetailsActivity::class.java)
            intent.putExtra(BRAND_NAME_KEY, brand)
            context.startActivity(intent)
        }

        private const val BRAND_NAME_KEY = "CarBrandDetailsActivity:brandNameKey"
    }

    private lateinit var carBrandDetailsViewModel: CarBrandDetailsViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setToolbarTitle()
        instantiateViewModel()
        showCarBrandModels()
    }

    private fun instantiateViewModel() {
        carBrandDetailsViewModel = ViewModelProvider(this).get(CarBrandDetailsViewModel::class.java)
    }

    private fun ComponentActivity.showCarBrandModels() {
        setContent {
            val carBrandModels by carBrandDetailsViewModel.getCarBrandByName(getBrandName())
                .observeAsState()
            carBrandModels?.let {
                ComposeTestTheme {
                    Surface(color = MaterialTheme.colors.background) { CarBrandDetailsContent(it) }
                }
            } ?: finish()
        }
    }

    private fun setToolbarTitle() {
        supportActionBar?.title = getBrandName()
    }

    private fun getBrandName() = intent.extras?.getString(BRAND_NAME_KEY)
}