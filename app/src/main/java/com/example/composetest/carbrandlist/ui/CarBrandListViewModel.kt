package com.example.composetest.carbrandlist.ui

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.composetest.carbrandlist.data.CarBrand
import com.example.composetest.carbrandlist.data.carBrandLists
import com.example.composetest.utils.fromJsonArray

class CarBrandListViewModel : ViewModel() {
    val carListState: LiveData<List<CarBrand>> = MutableLiveData(carBrandLists.fromJsonArray())
}