package com.example.newsappwithcleanarchitecture.components

import androidx.activity.compose.BackHandler
import androidx.compose.foundation.layout.Column
import androidx.compose.runtime.Composable
import com.example.newsappwithcleanarchitecture.utils.SearchRange
import com.example.newsappwithcleanarchitecture.viewmodel.MainPageViewModel

@Composable
fun NewsFilter(
    vm: MainPageViewModel
) {
    BackHandler(
        vm.dateRangeOptionsOpened ||
        vm.languageOptionsOpened ||
        vm.countryOptionsOpened
    ) {
        vm.dateRangeOptionsOpened = false
        vm.languageOptionsOpened = false
        vm.countryOptionsOpened = false
    }

    Column() {
        OptionsMenuButton(text = SearchRange.displayName()[vm.filterDateRange]) {
            vm.dateRangeOptionsOpened = !vm.dateRangeOptionsOpened
        }
    }

    if (vm.dateRangeOptionsOpened) {
        OptionsMenuScreen(
            options = SearchRange.displayName(),
            currentOption = vm.filterDateRange,
            onDismiss = { vm.dateRangeOptionsOpened = false }
        ) { vm.filterDateRange = it }
    }
}