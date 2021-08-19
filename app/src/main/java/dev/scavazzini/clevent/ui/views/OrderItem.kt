package dev.scavazzini.clevent.ui.views

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import dev.scavazzini.clevent.data.models.Product
import dev.scavazzini.clevent.ui.views.ui.theme.CleventTheme
import dev.scavazzini.clevent.utilities.extensions.toCurrency

@Composable
fun OrderItem(product: Product, modifier: Modifier = Modifier) {
    var quantity: Int by remember { mutableStateOf(0) }

    Row(
        verticalAlignment = Alignment.CenterVertically,
        modifier = modifier
            .padding(10.dp)
    ) {
        Column(
            modifier = Modifier.weight(1f)
        ) {
            Text(
                text = product.name,
                fontSize = 18.sp,
            )
            Text(
                text = product.price.toCurrency(),
                fontSize = 16.sp,
                fontWeight = FontWeight.Bold,
            )
        }
        Row(
            verticalAlignment = Alignment.CenterVertically
        ) {
            CircularButton(label = "-", onClick = { if (quantity > 0) quantity-- })
            Text(
                text = quantity.toString()
            )
            CircularButton(label = "+", onClick = { if (quantity < Int.MAX_VALUE) quantity++ })
        }
    }
}

@Composable
fun CircularButton(
    label: String,
    onClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    Button(
        onClick = onClick,
        modifier = modifier
            .width(48.dp)
            .height(48.dp)
            .padding(10.dp),
        contentPadding = PaddingValues(0.dp),
        shape = RoundedCornerShape(50),
    ) {
        Text(label)
    }
}

@Preview
@Composable
fun OrderItemPreview() {
    CleventTheme {
        OrderItem(Product(1, "Name", 10000))
    }
}

@Preview
@Composable
fun CircularButtonPreview() {
    CircularButton("+", {})
}
