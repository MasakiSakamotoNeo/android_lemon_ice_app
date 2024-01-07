package com.example.lemoniceapp.data

import com.example.lemoniceapp.R

enum class History(
    val key: String,
    val title: String,
    val imageResId: Int
) {
    PeachICE("peach_ice","Peach ICE", R.mipmap.peach_ice),
    PearICE("pear_ice", "Pear ICE", R.mipmap.pear_ice),
    MelonICE("melon_ice", "Melon ICE", R.mipmap.melon_ice)
}

fun getHistoryByKey(key: String) = History.values().first { it.key == key }
