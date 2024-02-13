package dev.scavazzini.clevent.ui.components

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.MaterialTheme
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import dev.scavazzini.clevent.ui.components.PrimaryButtonState.DISABLED
import dev.scavazzini.clevent.ui.components.PrimaryButtonState.ENABLED
import dev.scavazzini.clevent.ui.components.PrimaryButtonState.LOADING

@Composable
fun PrimaryButton(
    text: String,
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
    state: PrimaryButtonState = ENABLED,
    colors: ButtonColors = ButtonDefaults.buttonColors(),
) {
    Button(
        onClick = onClick,
        shape = RoundedCornerShape(50),
        modifier = modifier.height(48.dp),
        colors = colors,
        enabled = when (state) {
            ENABLED -> true
            else -> false
        },
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
        ) {
            if (state == LOADING) {
                CircularProgressIndicator(
                    color = MaterialTheme.colors.primary,
                    modifier = Modifier.size(20.dp)
                )
                Spacer(
                    modifier = Modifier.width(16.dp),
                )
            }
            if (text.isNotBlank()) {
                Text(
                    text = text,
                    fontSize = 14.sp,
                )
            }
        }
    }
}

enum class PrimaryButtonState {
    ENABLED,
    DISABLED,
    LOADING,
}

@Preview("Enabled")
@Composable
private fun PrimaryButtonEnabledPreview() {
    PrimaryButton(
        text = "Place order",
        onClick = { },
        state = ENABLED,
    )
}

@Preview("Disabled")
@Composable
private fun PrimaryButtonDisabledPreview() {
    PrimaryButton(
        text = "Place order",
        onClick = { },
        state = DISABLED,
    )
}

@Preview("Loading with text")
@Composable
private fun PrimaryButtonLoadingWithTextPreview() {
    PrimaryButton(
        text = "Placing order",
        onClick = { },
        state = LOADING,
    )
}

@Preview("Loading without text")
@Composable
private fun PrimaryButtonLoadingWithoutTextPreview() {
    PrimaryButton(
        text = "",
        onClick = { },
        state = LOADING,
    )
}