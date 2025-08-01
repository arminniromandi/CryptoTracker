package com.plcoding.cryptotracker.crypto.presentation.models

import androidx.annotation.DrawableRes
import com.plcoding.cryptotracker.crypto.domain.CoinModel
import com.plcoding.cryptotracker.core.presentation.util.getDrawableIdForCoin
import java.text.NumberFormat
import java.util.Locale

data class CoinUiModel(
    val id: String,
    val rank : Int,
    @DrawableRes val icon:Int,
    val name: String,
    val symbol: String,
    val marketCapUsd : DisplayableNumber,
    val priceUsd : DisplayableNumber,
    val changePercent24Hr : DisplayableNumber,
)



data class DisplayableNumber(
    val value : Double,
    val formatted : String
)

fun CoinModel.toCoinUiModel(): CoinUiModel {
    return CoinUiModel(
        id = id,
        name = name,
        symbol = symbol,
        rank = rank,
        priceUsd = priceUsd.toDispalyableNumber(),
        marketCapUsd = marketCapUsd.toDispalyableNumber(),
        changePercent24Hr = changePercent24Hr.toDispalyableNumber(),
        icon = getDrawableIdForCoin(symbol)
    )
}


fun Double.toDispalyableNumber(): DisplayableNumber{
    val formatter = NumberFormat.getNumberInstance(Locale.getDefault()).apply {
        minimumFractionDigits = 2
        maximumFractionDigits = 2
    }
    return DisplayableNumber(
        this,
        formatter.format(this)
    )
}









