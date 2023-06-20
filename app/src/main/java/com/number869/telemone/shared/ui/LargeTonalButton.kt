package com.number869.telemone.shared.ui

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.basicMarquee
import androidx.compose.foundation.clickable
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.text.PlatformTextStyle
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.number869.telemone.ui.theme.fullPalette

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun LargeTonalButton(onClick: () -> Unit, label: String, modifier: Modifier = Modifier) {
	val textColor = if (isSystemInDarkTheme())
		MaterialTheme.colorScheme.surface
	else
		MaterialTheme.colorScheme.onSurface

	Box(
		modifier
			.clickable { onClick() }
			.fillMaxWidth()
			.height(64.dp)
			.clip(RoundedCornerShape(12.dp))
			.background(fullPalette().primary_90)
	) {
		Text(
			label,
			color = textColor,
			style = TextStyle(
				platformStyle = PlatformTextStyle(includeFontPadding = false)
			),
			maxLines = 1,
			fontSize = 15.sp,
			// marquee text just in case
			modifier = Modifier.align(Alignment.Center).basicMarquee()
		)
	}
}