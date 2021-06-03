package com.se7en.fearngreed.ui.index.current

import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.stringResource
import com.se7en.fearngreed.R
import com.se7en.fearngreed.ui.index.IndexTopAppBar

/**
 * TopAppBar for CurrentIndex screen
 */
@Composable
fun CurrentIndexTopBar() {
    IndexTopAppBar(
        title = { Text(stringResource(R.string.current_index_top_bar_title)) }
    )
}
