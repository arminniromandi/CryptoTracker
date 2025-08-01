package com.plcoding.cryptotracker.crypto.domain

data class CoinModel(
    val id: String,
    val rank : Int,
    val name: String,
    val symbol: String,
    val marketCapUsd : Double,
    val priceUsd : Double,
    val changePercent24Hr : Double,
    val volumeUsd24Hr : Double,
)
