package com.example.hammersystemtask.ui.displayfragment

import androidx.lifecycle.viewModelScope
import com.example.hammersystemtask.common.mvvm.BaseViewModel
import com.example.hammersystemtask.domain.usecases.meals.AddMealsUseCase
import kotlinx.coroutines.launch
import javax.inject.Inject

class DisplayViewModel @Inject constructor(
    addMealsUseCase: AddMealsUseCase
): BaseViewModel() {
    val tabs = listOf("Starter", "Seafood", "Pasta")

    init {
        viewModelScope.launch {
            addMealsUseCase.invoke(tabs)
        }
    }
}