package com.abhi41.composeuipractice.screen.profile_screen

import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.defaultMinSize
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.KeyboardArrowDown
import androidx.compose.material3.Icon
import androidx.compose.material3.Tab
import androidx.compose.material3.TabRow
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.util.fastForEachIndexed
import com.abhi41.composeuipractice.R
import com.abhi41.composeuipractice.screen.common.RoundImage
import com.abhi41.composeuipractice.model.StoryHighlight

@Composable
fun ProfileScreen() {

    var selectedTabIndex by remember {
        mutableStateOf(0)
    }

    Column(
        modifier = Modifier.fillMaxSize()
    ) {
        TopAppBar(
            "Abhijeet Mule",
            modifier = Modifier.padding(10.dp).statusBarsPadding()
        )
        Spacer(modifier = Modifier.height(4.dp))
        ProfileSection()
        ButtonSection(modifier = Modifier.fillMaxWidth())
        Spacer(modifier = Modifier.height(25.dp))
        StoryHighlightSection(
            highlights = listOf(
                StoryHighlight(
                    image = painterResource(id = R.drawable.youtube),
                    text = "YouTube"
                ),
                StoryHighlight(
                    image = painterResource(id = R.drawable.qa),
                    text = "Q&A"
                ),
                StoryHighlight(
                    image = painterResource(id = R.drawable.discord),
                    text = "Discord"
                ),
                StoryHighlight(
                    image = painterResource(id = R.drawable.telegram),
                    text = "Telegram"
                ),
            ),
            modifier = Modifier
                .fillMaxWidth()
                .padding(20.dp)
        )

        PostTabView(
            listOfTabs = listOf(
                StoryHighlight(
                    image = painterResource(id = R.drawable.ic_grid),
                    text = "Posts"
                ),
                StoryHighlight(
                    image = painterResource(id = R.drawable.ic_reels),
                    text = "Reels"
                ),
                StoryHighlight(
                    image = painterResource(id = R.drawable.ic_igtv),
                    text = "IGTV"
                ),
                StoryHighlight(
                    image = painterResource(id = R.drawable.profile),
                    text = "Profile"
                )
            ),
            modifier = Modifier.fillMaxWidth(),
            { it ->
                selectedTabIndex = it
            }
        )
        when (selectedTabIndex) {
            0 -> PostSection(
                posts = listOf(
                    painterResource(id = R.drawable.kmm),
                    painterResource(id = R.drawable.intermediate_dev),
                    painterResource(id = R.drawable.master_logical_thinking),
                    painterResource(id = R.drawable.bad_habits),
                    painterResource(id = R.drawable.multiple_languages),
                    painterResource(id = R.drawable.learn_coding_fast)
                ),
                modifier = Modifier.fillMaxWidth()
            )


        }
    }
}

@Composable
fun TopAppBar(
    name: String,
    modifier: Modifier = Modifier
) {
    Row(
        modifier = modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceAround,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Icon(
            imageVector = Icons.Default.ArrowBack,
            contentDescription = "",
            modifier = Modifier.size(24.dp)
        )
        Text(
            text = name,
            overflow = TextOverflow.Ellipsis,
            fontWeight = FontWeight.Bold,
            fontSize = 20.sp
        )
        Icon(
            painter = painterResource(id = R.drawable.ic_bell),
            contentDescription = "IGBell",
            tint = Color.Black,
            modifier = Modifier.size(24.dp)
        )

        Icon(
            painter = painterResource(id = R.drawable.ic_dotmenu),
            contentDescription = "IGBell",
            tint = Color.Black,
            modifier = Modifier.size(20.dp)
        )
    }
}

@Composable
fun ProfileSection() {
    Column(
        modifier = Modifier.fillMaxWidth()
    ) {
        Row(
            modifier = Modifier
                .padding(20.dp)
                .fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically
        ) {
            RoundImage(
                image = painterResource(id = R.drawable.philipp),
                modifier = Modifier.size(100.dp)
            )
            Spacer(modifier = Modifier.width(16.dp))
            StateSection()
        }
        ProfileDescription(
            displayName = "Programming Mentor",
            description = "10 years of coding experiance\n" + "Want me to make your app? Send me an email!\n" + "Subscribe to my YouTube channel!",
            url = "https://youtube.com/c/PhilippLackner",
            followedBy = listOf("codinginflow", "miakhalifa"),
            otherCount = 17,
        )

    }
}

@Composable
fun StateSection(modifier: Modifier = Modifier) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceAround,
        modifier = modifier.fillMaxWidth()
    ) {
        ProfileState("1.2M", "Posts")
        ProfileState("456", "Followers")
        ProfileState("789", "Following")
    }
}

@Composable
fun ProfileState(
    numberText: String,
    text: String,
    modifier: Modifier = Modifier
) {
    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = modifier
    ) {
        Text(text = numberText, fontWeight = FontWeight.Bold, fontSize = 20.sp)
        Spacer(modifier = Modifier.height(4.dp))
        Text(text = text)
    }
}

@Composable
fun ProfileDescription(
    modifier: Modifier = Modifier,
    displayName: String,
    description: String,
    url: String,
    followedBy: List<String>,
    otherCount: Int
) {
    val letterSpacing = 0.5.sp
    val lineHeight = 20.sp
    Column(
        modifier = modifier
            .fillMaxWidth()
            .padding(20.dp),
        verticalArrangement = Arrangement.Center
    ) {
        Text(
            text = displayName,
            fontWeight = FontWeight.Bold,
            letterSpacing = letterSpacing,
            lineHeight = lineHeight
        )
        Text(
            text = description,
            letterSpacing = letterSpacing,
            lineHeight = lineHeight
        )
        Text(
            text = url,
            color = Color(0xFF3D3D91),
            letterSpacing = letterSpacing,
            lineHeight = lineHeight
        )
        if (followedBy.isNotEmpty()) {
            Text(
                text = buildAnnotatedString {
                    val boaldStyle = SpanStyle(
                        color = Color.Black,
                        fontWeight = FontWeight.Bold
                    )
                    pushStyle(boaldStyle)
                    append("Followed by ")

                    followedBy.forEachIndexed { index, name ->
                        pushStyle(boaldStyle)
                        append(name)
                        pop() ////it means we remove bold style from stack cause donn't want to show comma in bold
                        if (index < followedBy.size - 1) {
                            append(", ")
                        }
                    }

                    if (otherCount > 2) {
                        append(" and ")
                        pushStyle(boaldStyle)
                        append("$otherCount others")
                    }
                },
                letterSpacing = letterSpacing,
                lineHeight = lineHeight
            )
        }

    }
}

@Composable
fun ButtonSection(modifier: Modifier = Modifier) {
    Row(
        modifier = modifier,
        horizontalArrangement = Arrangement.SpaceEvenly
    ) {
        val minWidth = 95.dp
        val height = 30.dp
        ActionButton(
            text = "Following",
            modifier = Modifier
                .defaultMinSize(minWidth)
                .height(height),
            icon = Icons.Default.KeyboardArrowDown
        )
        ActionButton(
            text = "Message", modifier = Modifier
                .defaultMinSize(minWidth)
                .height(height)
        )
        ActionButton(
            text = "Email", modifier = Modifier
                .defaultMinSize(minWidth)
                .height(height)
        )
        ActionButton(
            icon = Icons.Default.KeyboardArrowDown,
            modifier = Modifier.height(height)
        )

    }
}

@Composable
fun ActionButton(
    text: String = "",
    modifier: Modifier = Modifier,
    icon: ImageVector? = null,
) {
    Row(
        modifier = modifier
            .border(
                width = 1.dp,
                color = Color.LightGray,
                shape = RoundedCornerShape(5.dp)
            )
            .padding(6.dp),

        horizontalArrangement = Arrangement.Center,
        verticalAlignment = Alignment.CenterVertically
    ) {
        if (icon != null) {
            Icon(
                imageVector = icon,
                contentDescription = "",
                tint = Color.Black,
            )
        }
        if (text.isNotEmpty()) {
            Spacer(modifier = Modifier.width(5.dp))
            Text(text = text, fontWeight = FontWeight.Bold, fontSize = 14.sp)
        }

    }
}

@Composable
fun StoryHighlightSection(
    modifier: Modifier = Modifier,
    highlights: List<StoryHighlight>
) {
    LazyRow(modifier = modifier) {
        items(highlights.size) {
            StoryHighlightItem(highlights[it])
        }
    }
}

@Composable
fun StoryHighlightItem(storyHighlight: StoryHighlight) {
    Column(
        modifier = Modifier.padding(end = 15.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        RoundImage(
            image = storyHighlight.image,
            modifier = Modifier.size(70.dp)
        )
        Text(
            text = storyHighlight.text,
            overflow = TextOverflow.Ellipsis,
            textAlign = TextAlign.Center
        )
    }
}

@Composable
fun PostTabView(
    listOfTabs: List<StoryHighlight>,
    modifier: Modifier = Modifier,
    onTabSelected: (Int) -> Unit
) {
    var selectedTabIndex by remember {
        mutableStateOf(0)
    }
    val inactiveColor = Color(0xFF777777)

    TabRow(
        selectedTabIndex = selectedTabIndex,
        containerColor = Color.Transparent,
        contentColor = Color.Black,
        modifier = modifier
    ) {
        listOfTabs.fastForEachIndexed { index, item ->
            val isSelected: Boolean = selectedTabIndex == index

            Tab(
                selected = isSelected,
                selectedContentColor = Color.Black,
                unselectedContentColor = inactiveColor,
                onClick = {
                    selectedTabIndex = index
                    onTabSelected(index)
                }
            ) {
                Icon(
                    modifier = Modifier
                        .padding(10.dp)
                        .size(20.dp),
                    painter = item.image,
                    contentDescription = item.text,
                    tint = if (selectedTabIndex == index) Color.Black else inactiveColor
                )
            }
        }
    }

}

@Composable
fun PostSection(
    posts: List<Painter>,
    modifier: Modifier = Modifier
) {
    LazyVerticalGrid(
        columns = GridCells.Fixed(3),
        modifier = modifier,
    ) {
        items(posts.size) {
            Image(
                painter = posts[it],
                contentDescription = null,
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .aspectRatio(1f)
                    .border(
                        width = 1.dp,
                        color = Color.White
                    )
            )
        }
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun ProfileScreenPreview() {
    ProfileScreen()
}