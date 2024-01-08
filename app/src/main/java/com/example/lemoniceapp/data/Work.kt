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
        "",
        "",
        R.mipmap.ic_work_nareppo, R.mipmap.ic_work_nareppo_bg
    ),
    JunaBlog(
        "junablog",
        "Junaブログ",
        "",
        "",
        R.mipmap.ic_work_junablog, R.mipmap.ic_work_junablog_bg
    ),
    TomodachiCamera(
        "tomodachicamera",
        "ともだちカメラ",
        "",
        "中村 麻衣子",
        R.mipmap.ic_work_tomodachicamera, R.mipmap.ic_work_tomodachicamera_bg),
    PojiKaji(
        "pojikaji",
        "ポジカジ",
        "",
        "木村 ",
        R.mipmap.ic_work_pojikaji, R.mipmap.ic_work_pojikaji_bg
    )
}

fun getWorkByKey(key: String) = Work.values().first { it.key == key }
