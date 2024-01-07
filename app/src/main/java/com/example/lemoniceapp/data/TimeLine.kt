package com.example.lemoniceapp.data

import com.example.lemoniceapp.R

enum class TimeLine(
    val key: String,
    val title: String,
    val time: String,
    val bgImageResId: Int
) {
    Opening("opening", "Opening", "13:00〜13:10", R.drawable.opening_header),
    ExtensionLab("extension_lab", "ExtensionLab", "13:20〜13:50", R.drawable.extensionlab_team_header),
    Hackathon("hackathon", "ハッカソン発表会", "14:00〜14:40", R.drawable.hackathon_header),
    ApplicationSection("application_section", "アプリ部活動報告", "14:50〜15:20", R.drawable.itpm_application_section_header),
    Infrastructure("infrastructure", "０から１へインフラの世界", "15:30〜16:00", R.drawable.hirata_header),
    Development("development", "3Dメジャー機能実装で難しかったところ", "16:10〜16:40", R.drawable.sakamoto_header),
    Closing("closing", "Closing", "16:50〜17:00", -1)
}

fun getTimeLineByKey(key: String) = TimeLine.values().first { it.key == key }
