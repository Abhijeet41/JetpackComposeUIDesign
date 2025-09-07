package com.abhi41.composeuipractice.screen.RealEastateScreen.components

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.abhi41.composeuipractice.R

@Composable
fun CategoriesRow() {
    Row(modifier = Modifier.fillMaxWidth().padding(top = 16.dp)){
        CategoryItem(
            icon = R.drawable.cat_1,
            title = "",
            modifier = Modifier.weight(1f)
        )
        CategoryItem(
            icon = R.drawable.cat_2,
            title = "",
            modifier = Modifier.weight(1f)
        )
        CategoryItem(
            icon = R.drawable.cat_3,
            title = "",
            modifier = Modifier.weight(1f)
        )
        CategoryItem(
            icon = R.drawable.cat_4,
            title = "",
            modifier = Modifier.weight(1f)
        )
        CategoryItem(
            icon = R.drawable.cat_5,
            title = "",
            modifier = Modifier.weight(1f)
        )

    }
}