package com.example.lemoniceapp.data

import com.example.lemoniceapp.R

enum class Work(
    val key: String,
    val title: String,
    val destination: String,
    val author: String,
    val thumbnailImageResId: Int,
    val bgImageResId: Int
) {
    Nareppo(
        "nareppo",
        "ナレっぽ",
        "学習支援アプリ",
        "未入力",
        R.mipmap.ic_work_nareppo, R.mipmap.ic_work_nareppo_bg
    ),
    JunaBlog(
        "junablog",
        "Junaブログ",
        "ブログサイト制作",
        "未入力",
        R.mipmap.ic_work_junablog, R.mipmap.ic_work_junablog_bg
    ),
    TomodachiCamera(
        "tomodachicamera",
        "ともだちカメラ",
        "撮影支援アプリ",
        "未入力",
        R.mipmap.ic_work_tomodachicamera, R.mipmap.ic_work_tomodachicamera_bg),
    PojiKaji(
        "pojikaji",
        "ポジカジ",
        "家事手伝い管理アプリ",
        "未入力",
        R.mipmap.ic_work_pojikaji, R.mipmap.ic_work_pojikaji_bg
    )
}

fun getWorkByKey(key: String) = Work.values().first { it.key == key }
