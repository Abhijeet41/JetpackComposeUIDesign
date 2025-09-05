package com.abhi41.composeuipractice.screen.RealEastateScreen.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.abhi41.composeuipractice.R

@Composable
fun HeaderSection(modifier: Modifier = Modifier) {
    Row(
        modifier = Modifier
            .padding(
                horizontal = 16.dp,
                vertical = 24.dp
            )
            .fillMaxWidth()
            .statusBarsPadding(),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Image(
            modifier = Modifier
                .size(45.dp)
                .clip(CircleShape),
            painter = painterResource(id = R.drawable.profile),
            contentDescription = null,
        )

        Column(
            modifier = Modifier
                .padding(start = 8.dp)
                .weight(1f),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text("Welcome", color = colorResource(R.color.gray), fontSize = 14.sp)
            Text(
                "Sara Anderson",
                color = colorResource(R.color.black),
                fontSize = 20.sp,
                fontWeight = FontWeight.Bold
            )
            Image(
                painter = painterResource(id = R.drawable.bell_icon),
                contentDescription = null,
                modifier = Modifier.size(48.dp)
            )
        }
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
private fun HeaderSectionPreview() {
    HeaderSection()
}