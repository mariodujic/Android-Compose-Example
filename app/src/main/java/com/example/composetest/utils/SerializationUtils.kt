package com.example.composetest.utils

import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

val gson = Gson()
inline fun <reified T> String.fromJsonArray(): T = gson.fromJson(this, object : TypeToken<T>() {}.type)