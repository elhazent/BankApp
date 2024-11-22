package com.example.bankapp

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.MonetizationOn
import androidx.compose.material.icons.rounded.StarHalf
import androidx.compose.material.icons.rounded.Wallet
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.bankapp.data.Finance
import com.example.bankapp.ui.theme.BlueStart
import com.example.bankapp.ui.theme.GreenStart
import com.example.bankapp.ui.theme.OrangeStart
import com.example.bankapp.ui.theme.PurpleStart

val finance = listOf(
    Finance(
        icon = Icons.Rounded.StarHalf,
        name = "My\nBussiness",
        background = OrangeStart
    ),
    Finance(
        icon = Icons.Rounded.Wallet,
        name = "My\nWallet",
        background = BlueStart
    ),
    Finance(
        icon = Icons.Rounded.StarHalf,
        name = "Finance\nAnalytics",
        background = PurpleStart
    ),
    Finance(
        icon = Icons.Rounded.MonetizationOn,
        name = "My\nTransactions",
        background = GreenStart
    )
)

@Preview
@Composable
fun FinanceSection() {
    Column {
        Text(
            text = "Finance",
            fontSize = 24.sp,
            color = MaterialTheme.colorScheme.onBackground,
            fontWeight = FontWeight.Bold,
            modifier = Modifier.padding(16.dp)
        )
        LazyRow {
            items(finance.size) { index ->
                FinanceItem(index)
            }
        }
    }
}

@Composable
fun FinanceItem(index: Int) {
    val data = finance[index]
    var lastPaddingEnd = 0.dp
    if (index == finance.size - 1) {
        lastPaddingEnd = 16.dp
    }

    Box(modifier = Modifier.padding(start = 16.dp, end = lastPaddingEnd)){
        Column(
            modifier = Modifier
                .clip(RoundedCornerShape(25.dp))
                .background(MaterialTheme.colorScheme.secondaryContainer)
                .size(120.dp)
                .clickable { }
                .padding(13.dp),
            verticalArrangement = Arrangement.SpaceBetween
        ) {
            Box(
                modifier = Modifier
                    .clip(RoundedCornerShape(16.dp))
                    .background(data.background)
                    .padding(6.dp)
            ) {
                Icon(
                    imageVector = data.icon,
                    contentDescription = data.name,
                    tint = Color.White
                )

            }
            Text(
                text = data.name,
                color = MaterialTheme.colorScheme.onSecondaryContainer,
                fontWeight = FontWeight.SemiBold,
                fontSize = 15.sp
            )
        }
    }


}