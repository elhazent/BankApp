package com.example.bankapp

import android.annotation.SuppressLint
import android.widget.Space
import androidx.compose.animation.animateContentSize
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.BoxWithConstraints
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.AttachMoney
import androidx.compose.material.icons.rounded.CurrencyYen
import androidx.compose.material.icons.rounded.Euro
import androidx.compose.material.icons.rounded.KeyboardArrowDown
import androidx.compose.material.icons.rounded.KeyboardArrowUp
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.bankapp.data.Currency
import com.example.bankapp.ui.theme.GreenStart

val currencies = listOf(
    Currency(
        name = "USD",
        buy = 23.35f,
        sell = 52.21f,
        icon = Icons.Rounded.AttachMoney
    ),
    Currency(
        name = "EUR",
        buy = 53.35f,
        sell = 12.21f,
        icon = Icons.Rounded.Euro
    ),
    Currency(
        name = "YEN",
        buy = 33.35f,
        sell = 22.21f,
        icon = Icons.Rounded.CurrencyYen
    ),
    Currency(
        name = "USD",
        buy = 23.35f,
        sell = 52.21f,
        icon = Icons.Rounded.AttachMoney
    ),
    Currency(
        name = "EUR",
        buy = 53.35f,
        sell = 12.21f,
        icon = Icons.Rounded.Euro
    ),
    Currency(
        name = "YEN",
        buy = 33.35f,
        sell = 22.21f,
        icon = Icons.Rounded.CurrencyYen
    ),
)

@Preview
@Composable
fun CurrenciesSection() {
    var isVisible by remember {
        mutableStateOf(false)
    }

    var iconState by remember {
        mutableStateOf(Icons.Rounded.KeyboardArrowUp)
    }

    Box(
        modifier = Modifier
            .fillMaxSize(),
        contentAlignment = Alignment.BottomCenter
    ) {
        Column(
            modifier = Modifier
                .clip(RoundedCornerShape(topStart = 30.dp, topEnd = 30.dp))
                .background(MaterialTheme.colorScheme.inverseOnSurface)
                .animateContentSize()
        ) {
            Row(
                modifier = Modifier
                    .padding(16.dp)
                    .animateContentSize()
                    .fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Box(
                    modifier = Modifier
                        .clip(CircleShape)
                        .background(MaterialTheme.colorScheme.secondary)
                        .clickable {
                            isVisible = !isVisible
                            if (isVisible) {
                                iconState = Icons.Rounded.KeyboardArrowUp
                            } else {
                                iconState = Icons.Rounded.KeyboardArrowDown
                            }
                        }
                ) {
                    Icon(
                        imageVector = iconState,
                        contentDescription = "Currencies",
                        modifier = Modifier.size(25.dp),
                        tint = MaterialTheme.colorScheme.onSecondary
                    )
                }
                Spacer(modifier = Modifier.width(20.dp))
                Text(
                    text = "Currenies",
                    fontSize = 20.sp,
                    color = MaterialTheme.colorScheme.onSecondaryContainer,
                    fontWeight = FontWeight.Bold
                )
            }

            Spacer(
                modifier = Modifier
                    .height(1.dp)
                    .background(MaterialTheme.colorScheme.secondaryContainer)
                    .fillMaxWidth()
            )

            if (isVisible) {
                BoxWithConstraints(
                    modifier = Modifier
                        .padding(horizontal = 16.dp)
                        .fillMaxSize()
                        .clip(RoundedCornerShape(topStart = 25.dp, topEnd = 25.dp))
                        .background(MaterialTheme.colorScheme.background)
                ) {
                    var boxWithConstraintsScope = this
                    var width = boxWithConstraintsScope.maxWidth / 3
                    Column(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(16.dp)
                    ) {
                        Spacer(modifier = Modifier.height(16.dp))
                        Row(
                            modifier = Modifier.fillMaxWidth()
                        ) {
                            Text(
                                text = "Currency",
                                modifier = Modifier.width(width),
                                fontWeight = FontWeight.SemiBold,
                                fontSize = 16.sp,
                                color = MaterialTheme.colorScheme.onBackground
                            )
                            Text(
                                text = "Buy",
                                modifier = Modifier.width(width),
                                fontWeight = FontWeight.SemiBold,
                                fontSize = 16.sp,
                                color = MaterialTheme.colorScheme.onBackground,
                                textAlign = TextAlign.End
                            )
                            Text(
                                text = "Sell",
                                modifier = Modifier.width(width),
                                fontWeight = FontWeight.SemiBold,
                                fontSize = 16.sp,
                                color = MaterialTheme.colorScheme.onBackground,
                                textAlign = TextAlign.End
                            )
                        }
                        Spacer(modifier = Modifier.height(16.dp))
                        LazyColumn {

                            items(currencies.size) { index ->
                                CurrencyItem(
                                    index = index,
                                    width = width
                                )
                            }

                        }
                    }


                }
            }

        }
    }


}

@Composable
fun CurrencyItem(index: Int, width: Dp) {
    val data = currencies[index]

    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(bottom = 16.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Row(
            modifier = Modifier.width(width),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Box(
                modifier = Modifier
                    .clip(RoundedCornerShape(8.dp))
                    .background(GreenStart)
                    .padding(4.dp)
            ) {
                Icon(
                    imageVector = data.icon,
                    contentDescription = data.name,
                    modifier = Modifier.size(18.dp),
                    tint = Color.White
                )
            }

            Text(
                modifier = Modifier
                    .padding(start = 10.dp),
                text = data.name,
                fontWeight = FontWeight.Bold,
                fontSize = 18.sp,
                color = MaterialTheme.colorScheme.onBackground,
            )
        }
        Text(
            modifier = Modifier
                .width(width)
                .padding(start = 10.dp),
            text = "$ ${data.buy}",
            fontWeight = FontWeight.Bold,
            fontSize = 16.sp,
            color = MaterialTheme.colorScheme.onBackground,
            textAlign = TextAlign.End
        )

        Text(
            modifier = Modifier
                .width(width)
                .padding(start = 10.dp),
            text = "$ ${data.sell}",
            fontWeight = FontWeight.Bold,
            fontSize = 16.sp,
            color = MaterialTheme.colorScheme.onBackground,
            textAlign = TextAlign.End
        )

    }
}