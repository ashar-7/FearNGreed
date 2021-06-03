package com.se7en.fearngreed.ui.index.all

import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.NavigateBefore
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.stringResource
import com.se7en.fearngreed.R
import com.se7en.fearngreed.ui.index.IndexTopAppBar

/**
 * TopAppBar for AllIndexes screen
 * @param onNavigateUp Lambda to be invoked when navigation button is clicked
 */
@Composable
fun AllIndexesTopBar(onNavigateUp: () -> Unit) {
    IndexTopAppBar(
        title = { Text(stringResource(R.string.all_indexes_top_bar_title)) },
        navigationIcon = {
            IconButton(onClick = onNavigateUp) {
                Icon(
                    Icons.Default.NavigateBefore,
                    contentDescription = stringResource(R.string.back)
                )
            }
        }
    )
}
