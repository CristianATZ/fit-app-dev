package com.devtorres.core_data

import android.util.Log
import com.devtorres.core_domain.BreadcrumbsManager
import com.devtorres.core_model.dto.BreadcrumbItem
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class BreadcrumbsManagerImp @Inject constructor(

) : BreadcrumbsManager {
    private val _history = MutableStateFlow<Set<BreadcrumbItem>>(emptySet())
    override fun getHistory(): StateFlow<Set<BreadcrumbItem>> = _history


    override fun addItem(item: BreadcrumbItem) {
        if(_history.value.lastOrNull()?.id != item.id) {
            _history.value += item
            Log.d("Breadcrumbs", "${_history.value}")
        }
    }

    override fun popUpTo(itemId: String) {
        // Se elimina el ultimo mientras no sea el mismo itemId o sea null
        while (_history.value.lastOrNull()?.id != itemId) {
            _history.value -= _history.value.last()
        }
    }

    override fun pop() {
        if(_history.value.isNotEmpty()) {
            _history.value -= _history.value.last()
        }
    }

    override fun clear() {
        _history.value = emptySet()
    }
}