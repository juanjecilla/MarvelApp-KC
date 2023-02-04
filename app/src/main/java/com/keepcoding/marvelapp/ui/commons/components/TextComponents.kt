package com.keepcoding.marvelapp.ui.commons.components

import androidx.compose.foundation.layout.padding
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.Dp
import com.keepcoding.marvelapp.ui.theme.HalfPadding
import com.keepcoding.marvelapp.ui.theme.NormalPadding

@Composable
fun SectionHeader(
    text: String,
    verticalPadding: Dp = HalfPadding,
    horizontalPadding: Dp = NormalPadding,
) {
    Text(
        text = text,
        style = MaterialTheme.typography.h5,
        modifier = Modifier.padding(vertical = verticalPadding, horizontal = horizontalPadding)
    )
}
