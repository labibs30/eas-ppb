package com.example.eas_alfamind.components.category

import DiscountItem
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import com.example.eas_alfamind.data.Category
import com.example.eas_alfamind.components.category.CategoryItem
import com.example.eas_alfamind.R.drawable
import com.example.eas_alfamind.viewModels.ProdcutVM

@Composable
fun DiscountList(navController: NavController){
    val productViewModel : ProdcutVM = viewModel()
    val products = productViewModel.getRandomProducts()

    LazyRow(
        modifier = Modifier.padding(horizontal = 0.dp),
        horizontalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        items(products.size) { index ->
            val disc = products[index]
            DiscountItem(discount = disc) {
                // Navigate to the FieldsList destination passing the sport's name as an argument
                navController.navigate("product_detail/${disc.id}")
            }
        }
    }

}
