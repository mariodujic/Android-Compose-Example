package com.example.composetest.carbrandlist.ui

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Text
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumnFor
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.composetest.R
import com.example.composetest.carbrandlist.data.CarBrand

@Composable
fun CarBrandListContent(readingLists: List<CarBrand>) {

    Box(alignment = Alignment.Center) {
        CarBrandList(readingLists)
    }
}

@Composable
fun CarBrandList(readingLists: List<CarBrand>) {
    LazyColumnFor(items = readingLists, modifier = Modifier.fillMaxWidth()) { carBrand ->
        CarBrandItem(carBrand)
    }
}

@Composable
fun CarBrandItem(carBrand: CarBrand) {
    Card(
        modifier = Modifier
            .height(75.dp)
            .fillMaxWidth()
            .padding(8.dp)
            .clickable(onClick = { }, indication = null),
        elevation = 8.dp,
        border = BorderStroke(1.dp, color = MaterialTheme.colors.primary),
        shape = RoundedCornerShape(16.dp),
    ) {
        Column {
            Spacer(modifier = Modifier.height(16.dp))

            Row(verticalAlignment = Alignment.CenterVertically) {
                Spacer(modifier = Modifier.width(16.dp))

                Text(
                    fontSize = 18.sp,
                    fontWeight = FontWeight.Bold,
                    color = MaterialTheme.colors.primary,
                    text = carBrand.brand
                )

                Spacer(modifier = Modifier.width(4.dp))
                Text(
                    text = carBrand.getCarBrandListSizeText(),
                    color = MaterialTheme.colors.primary
                )

                Spacer(modifier = Modifier.width(16.dp))
            }

            Spacer(modifier = Modifier.height(16.dp))
        }
    }
}

@Composable
private fun CarBrand.getCarBrandListSizeText() = stringResource(
    id = R.string.car_brand_models_count,
    this.models.size
)