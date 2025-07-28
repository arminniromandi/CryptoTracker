package com.plcoding.cryptotracker.crypto.presentation.coin_list.componnet

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.text.font.FontWeight.Companion.Bold
import androidx.compose.ui.text.font.FontWeight.Companion.SemiBold
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.tooling.preview.PreviewLightDark
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.plcoding.cryptotracker.crypto.domain.CoinModel
import com.plcoding.cryptotracker.crypto.presentation.models.CoinUiModel
import com.plcoding.cryptotracker.crypto.presentation.models.toCoinUiModel
import com.plcoding.cryptotracker.ui.theme.CryptoTrackerTheme

@Composable
fun CoinListItem(
    coinUiModel: CoinUiModel,
    onClick : () -> Unit,
    modifier: Modifier = Modifier
) {
    val textColor = if (isSystemInDarkTheme()) Color.White else Color.Black

    Row(
        modifier = modifier
            .clickable { onClick }
            .padding(16.dp),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.spacedBy(16.dp)
    ) {

        Icon(
            imageVector = ImageVector.vectorResource(id = coinUiModel.icon),
            contentDescription = coinUiModel.name,
            modifier = modifier.size(85.dp),
            tint = MaterialTheme.colorScheme.primary
        )

        Column(
            modifier.weight(1f)
        ) {
            Text(
                text = coinUiModel.symbol,
                fontSize = 20.sp,
                fontWeight = Bold,
                color = textColor
            )
            Text(
                text = coinUiModel.name,
                fontSize = 14.sp,
                fontWeight = Bold,
                color = textColor
            )
        }

        Column (
            horizontalAlignment = Alignment.End
        ){
            Text(
                text = "$ ${coinUiModel.priceUsd.formatted}",
                fontSize = 16.sp,
                fontWeight = SemiBold,
                color = textColor
            )
            Spacer(Modifier.height(8.dp))
            PriceChange(
                coinUiModel.changePercent24Hr,
            )
        }


    }


}

@PreviewLightDark
@Composable
private fun CoinListIemPreview() {

    CryptoTrackerTheme {
        CoinListItem(
            coinUiModel = preViewCoin,
            onClick = {},
            modifier = Modifier.background(MaterialTheme.colorScheme.primaryContainer)
        )
    }

}

internal val preViewCoin = CoinModel(
    id = "bitcoin",
    rank = 1,
    name = "Bitcoin",
    symbol = "BTC",
    marketCapUsd = 123513563223.12,
    priceUsd = 80025.57,
    changePercent24Hr = 0.1,
    volumeUsd24Hr = 12355645848.4
).toCoinUiModel()