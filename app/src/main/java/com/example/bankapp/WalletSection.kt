package com.example.bankapp

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Search
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.*


@Preview
@Composable
fun WalletSection(){
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ){
        Column {
            Text(
                text= "Wallet",
                fontSize = 17.sp,
                color = MaterialTheme.colorScheme.onBackground
            )
            Spacer(modifier = Modifier.height(8.dp))
            Text(
                text= "Rp. 1.000.000.000",
                fontSize = 24.sp,
                fontWeight = FontWeight.Bold,
                color = MaterialTheme.colorScheme.onBackground
            )
        }
        Box(modifier = Modifier.clip(RoundedCornerShape(15.dp)).background(MaterialTheme.colorScheme.secondaryContainer).clickable {  }.padding(6.dp)){
            Icon(
                imageVector = Icons.Rounded.Search,
                contentDescription = "Search",
                tint = MaterialTheme.colorScheme.onSecondaryContainer,
            )
        }
    }
}