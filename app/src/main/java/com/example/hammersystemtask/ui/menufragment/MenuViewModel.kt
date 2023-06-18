package com.example.hammersystemtask.ui.menufragment

import androidx.lifecycle.viewModelScope
import com.example.hammersystemtask.common.mvvm.BaseViewModel
import com.example.hammersystemtask.domain.usecases.meals.GetMealsByTypeUseCase
import com.example.hammersystemtask.ui.utils.UIUtils.collectIn
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.flatMapConcat
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.launch
import javax.inject.Inject



class MenuViewModel @Inject constructor(
    private val getMealsByTypeUseCase: GetMealsByTypeUseCase
): BaseViewModel() {
    val category = MutableSharedFlow<String>(1)

    val items = category.flatMapConcat { getMealsByTypeUseCase(it) }.shareWhileSubscribed()

    fun setCategory(c: String){
        viewModelScope.launch {
            category.emit(c)
        }
    }
//    init {
//        category.flatMapConcat { getMealsByTypeUseCase("") }.collectIn(viewModelScope){
//            println("all: $it")
//        }
//    }
}