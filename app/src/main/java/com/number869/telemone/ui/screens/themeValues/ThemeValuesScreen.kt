package com.number869.telemone.ui.screens.themeValues

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.asPaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.systemBars
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.text.selection.SelectionContainer
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Switch
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import com.number869.decomposite.core.common.viewModel.viewModel
import com.number869.telemone.MainViewModel
import com.number869.telemone.ThemeColorDataType

@Composable
fun ThemeValuesScreen() {
	val vm = viewModel<MainViewModel>()

	var showValues by remember { mutableStateOf(false) }
	val mappedValues = remember { derivedStateOf { vm.mappedValues } }.value
	val text = vm.stringify(
		mappedValues.toList(),
		if (showValues)
			ThemeColorDataType.ColorValues
		else
			ThemeColorDataType.ColorTokens
	)

	LazyColumn(
		Modifier
			.fillMaxSize()
			.background(MaterialTheme.colorScheme.background),
		contentPadding = PaddingValues(
			top = WindowInsets.systemBars.asPaddingValues().calculateTopPadding(),
			bottom = WindowInsets.systemBars.asPaddingValues().calculateBottomPadding()
		)
	) {
		item {
			Row(Modifier.fillMaxWidth(), Arrangement.SpaceBetween, Alignment.CenterVertically) {
				Text(text = "Show color values", style = MaterialTheme.typography.headlineSmall)
				Switch(checked = showValues, onCheckedChange = { showValues = it })
			}

		}
		item {
			SelectionContainer() {
				Text(text = text)
			}
		}
	}
}