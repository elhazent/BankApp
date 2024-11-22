package com.example.bankapp

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.*
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.*
import com.example.bankapp.data.Card
import com.example.bankapp.ui.theme.*

val cards = listOf(
    Card(
        cardType = "VISA",
        cardNumber = "1234 5678 9012 3456",
        cardName = "Bussiness",
        balance = 1000000000.0,
        color = getGradient(PurpleStart, PurpleEnd)
    ),
    Card(
        cardType = "MASTER CARD",
        cardNumber = "1234 5678 9012 3456",
        cardName = "Saving",
        balance = 100000000000.0,
        color = getGradient(BlueStart, BlueEnd)
    ),
    Card(
        cardType = "VISA",
        cardNumber = "1234 5678 9012 3456",
        cardName = "School",
        balance = 10000.0,
        color = getGradient(OrangeStart, OrangeEnd)
    ),
    Card(
        cardType = "MASTER CARD",
        cardNumber = "1234 5678 9012 3456",
        cardName = "Trips",
        balance = 100.0,
        color = getGradient(GreenStart, GreenEnd)
    )

)

fun getGradient(startColor: Color, endColor: Color): Brush {
    return Brush.horizontalGradient(colors = listOf(startColor, endColor));
}


@Preview
@Composable
fun CardSection() {
    LazyRow() {
        items(cards.size) { index ->
            CardItem(index, card = cards[index])
        }

    }

}

@Composable
fun CardItem(index: Int, card: Card) {
    var lastItemPaddingEnd = 0.dp
    if (index == cards.size - 1) {
        lastItemPaddingEnd = 16.dp
    }

    var image = painterResource(id = R.drawable.logo_visa)
    if (card.cardType == "MASTER CARD") {
        image = painterResource(id = R.drawable.logo_mastercard)
    }

    Box(modifier = Modifier.padding(start = 16.dp, end = lastItemPaddingEnd)) {
        Column(
            modifier = Modifier
                .clip(RoundedCornerShape(25.dp))
                .background(card.color)
                .width(250.dp)
                .height(160.dp)
                .clickable { }
                .padding(horizontal = 16.dp, vertical = 12.dp),
            verticalArrangement = Arrangement.SpaceBetween
        ) {
            Image(image, contentDescription = card.cardName, modifier = Modifier.width(60.dp))
            Spacer(modifier = Modifier.height(10.dp))
            Text(text = card.cardName,color = Color.White, fontWeight = FontWeight.Bold, fontSize = 17.sp)
            Text(text = "Rp. ${card.balance}",color = Color.White, fontWeight = FontWeight.Bold, fontSize = 22.sp)
            Text(text = card.cardNumber,color = Color.White, fontWeight = FontWeight.Bold, fontSize = 18.sp)

        }
    }
}