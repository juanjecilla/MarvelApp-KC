package com.keepcoding.marvelapp.ui.commons.components

import androidx.compose.foundation.layout.padding
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import com.keepcoding.marvelapp.R
import com.keepcoding.marvelapp.ui.theme.NormalPadding

@Composable
fun MarvelTopBar() {
    val context = LocalContext.current

    TopAppBar {
        Text(
            text = context.getString(R.string.app_name),
            style = MaterialTheme.typography.h6.copy(Color.White),
            modifier = Modifier.padding(horizontal = NormalPadding)
        )
    }
}
