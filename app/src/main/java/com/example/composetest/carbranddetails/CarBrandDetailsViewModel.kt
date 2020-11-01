package com.example.composetest.carbranddetails

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.composetest.data.CarBrand
import com.example.composetest.data.carBrandLists
import com.example.composetest.utils.fromJsonArray

class CarBrandDetailsViewModel : ViewModel() {
    fun getCarBrandByName(brand: String?) = MutableLiveData<CarBrand>(getCarBrand(brand))
    private fun getCarBrand(brand: String?) =
        carBrandLists.fromJsonArray<List<CarBrand>>().find { it.brand == brand }
}