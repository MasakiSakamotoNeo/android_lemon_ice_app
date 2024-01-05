package com.example.lemoniceapp.data

import com.example.lemoniceapp.R

enum class History(
    val key: String,
    val imageResId: Int
) {
    PeachICE("Peach ICE", R.mipmap.peach_ice),
    PearICE("Pear ICE", R.mipmap.pear_ice),
    MelonICE("Melon ICE", R.mipmap.melon_ice)
}

fun getHistoryByKey(key: String) = History.values().first { it.key == key }
