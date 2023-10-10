package com.dzaigames.dzaiquiz.ui.widgets

import android.content.res.Configuration.UI_MODE_NIGHT_YES
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun ActionTextButton(
    label: String,
    action: () -> Unit
) {
    Button(
        modifier = Modifier
            .width(160.dp)
            .height(40.dp),
        shape = RoundedCornerShape(4.dp),
        enabled = true,
        onClick = action
    ) {
        Text(text = label)
    }
}

@Preview(
    showBackground = true,
    uiMode = UI_MODE_NIGHT_YES,
//    showSystemUi = true
)
@Composable
fun ActionTextButtonPreview() {
    ActionTextButton(
        label = "Start",
        action = { }
    )
}