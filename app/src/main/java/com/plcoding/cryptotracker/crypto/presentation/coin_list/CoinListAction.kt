package com.plcoding.cryptotracker.crypto.presentation.coin_list

import com.plcoding.cryptotracker.crypto.presentation.models.CoinUiModel

sealed interface CoinListAction {
    data class OnCoinClick(val coinUiModel: CoinUiModel): CoinListAction

}