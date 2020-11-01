package com.example.composetest.carbrandlist

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.composetest.data.CarBrand
import com.example.composetest.data.carBrandLists
import com.example.composetest.utils.fromJsonArray

class CarBrandListViewModel : ViewModel() {
    val carListState: LiveData<List<CarBrand>> = MutableLiveData(carBrandLists.fromJsonArray())
}