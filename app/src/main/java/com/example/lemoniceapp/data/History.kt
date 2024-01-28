package com.example.lemoniceapp.data

import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.text.font.FontWeight
import com.example.lemoniceapp.R

enum class History(
    val key: String,
    val title: String,
    val imageResId: Int,
    val description: AnnotatedString,
) {
    PeachICE(
        "peach_ice",
        "Peach ICE",
        R.mipmap.peach_ice,
        buildAnnotatedString {
            withStyle(SpanStyle(fontWeight = FontWeight.Bold)) { append("第１回 Peach ICE（2022年4月）")}
            append("\n")
            append("初の開催となったPeach（桃）ICEでは、「挑戦」をテーマにシニアの方からの発表や、案件交代に向けてメンバーが作成したポートフォリオの展示、今までにITPMで開催された勉強会の動画上映等を行いました。")
        }
    ),
    PearICE(
        "pear_ice",
        "Pear ICE",
        R.mipmap.pear_ice,
        buildAnnotatedString {
            withStyle(SpanStyle(fontWeight = FontWeight.Bold)) { append("第２回 Pear ICE（2022年11月）")}
            append("\n")
            append("第２回の開催となったPear（梨）ICEでは、「楽しむ」をテーマに、ITPMで初となるハッカソンを実施。モノ作りの楽しさを感じながらスキルアップに励んだ成果を発表しました。")
        }
    ),
    MelonICE(
        "melon_ice",
        "Melon ICE",
        R.mipmap.melon_ice,
        buildAnnotatedString {
            withStyle(SpanStyle(fontWeight = FontWeight.Bold)) { append("第３回 Melon ICE（2023年6月）")}
            append("\n")
            append("第３回となるMelon（メロン）ICEでは、「拡張」をテーマに行いました。ハッカソンでは期間中、月に１回の勉強会を開催するなど、活動の幅を広げたり、発表においても様々な拡張についてのお話がありました。")
        }
    )
}

fun getHistoryByKey(key: String) = History.values().first { it.key == key }
