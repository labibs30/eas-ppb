package com.example.eas_alfamind

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.drawWithContent
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.compose.ui.unit.Dp
import com.example.eas_alfamind.components.category.CategoryList
import com.example.eas_alfamind.components.category.DiscountList

@Composable
fun Dashboard(handphone: String, navController: NavController) {
    Column(
        modifier = Modifier
            .fillMaxSize()
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth(),
//                .drawBottomShadow(4.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            // Logo on the left
            Image(
                painter = painterResource(id = R.drawable.app_logo),
                contentDescription = "App Logo",
                modifier = Modifier
                    .size(48.dp)
                    .clip(CircleShape) // Clip as a circle for the logo
                    .padding(start = 16.dp)
                    .clickable { /* Handle logo click */ },
                contentScale = ContentScale.Fit
            )

            Spacer(modifier = Modifier.width(16.dp))

            Text(
                text = "Search",
                fontSize = 16.sp,
                fontWeight = FontWeight.Bold,
                color = Color.Black,
                modifier = Modifier
                    .weight(1f) // Take remaining space
                    .background(Color.White, RoundedCornerShape(4.dp))
                    .border(2.dp, Color.Red, RoundedCornerShape(4.dp))
                    .padding(horizontal = 16.dp, vertical = 12.dp)
                    .clickable { /* Handle search click */ }
                    .wrapContentSize(Alignment.CenterEnd)  // Align to the end (right)
            )
            Spacer(modifier = Modifier.width(16.dp))

        }
        Spacer(modifier = Modifier.width(16.dp))

        Text(
            text = "Welcome to Your Dashboard",
            fontWeight = FontWeight.Bold,
            fontSize = 24.sp,
            color = Color.Black,
            modifier = Modifier.padding(16.dp)
        )

        Box(  modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp)
            .background(Color.White,RoundedCornerShape(8.dp))
        ) {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(8.dp)
            ) {
                Text(
                    text = "Kategori Barang",
                    fontWeight = FontWeight.Bold,
                    fontSize = 18.sp,
                    modifier = Modifier.padding(16.dp),
                )

                // Category list
                CategoryList(navController = navController)
            }
        }

        Box(modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp)
            .background(Color.Red,RoundedCornerShape(8.dp))
        ) {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(8.dp)
            ) {
                Text(
                    text = "Barang Diskon",
                    fontWeight = FontWeight.Bold,
                    color = Color.White,
                    fontSize = 18.sp,
                    modifier = Modifier.padding(16.dp),
                )

                DiscountList(navController = navController)
            }
        }

    }
}
// Extension function to draw bottom shadow
fun Modifier.drawBottomShadow(elevation: Dp): Modifier = this.then(
    drawWithContent {
        drawContent()
        drawRect(
            color = Color.Gray.copy(alpha = 0.2f),
            topLeft = Offset(0f, size.height),
            size = Size(size.width, elevation.toPx())
        )
    }
)

