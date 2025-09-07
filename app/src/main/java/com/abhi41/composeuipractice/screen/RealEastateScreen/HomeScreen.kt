package com.abhi41.composeuipractice.screen.RealEastateScreen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.abhi41.composeuipractice.R
import com.abhi41.composeuipractice.screen.RealEastateScreen.components.CategoriesRow
import com.abhi41.composeuipractice.screen.RealEastateScreen.components.HeaderSection
import com.abhi41.composeuipractice.screen.RealEastateScreen.components.SearchRow
import com.abhi41.composeuipractice.screen.sample_data.sampleProperties

@Composable
fun HomeScreen(modifier: Modifier = Modifier) {
    val items = remember { sampleProperties() }

    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
            .statusBarsPadding()
            .background(colorResource(R.color.light_gray)),
        contentPadding = PaddingValues(bottom = 100.dp)
    ) {
        item {HeaderSection()}
        item{ Spacer(Modifier.height(16.dp)) }
        item { SearchRow() }
        item{ Spacer(Modifier.height(16.dp)) }
        item { CategoriesRow() }
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
private fun HomeScreenPreview() {
    HomeScreen()
}