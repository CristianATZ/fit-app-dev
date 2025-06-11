package com.devtorres.core_data

import android.util.Log
import com.devtorres.core_domain.BreadcrumbsManager
import com.devtorres.core_model.ui.BreadcrumbItem
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.SupervisorJob
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.stateIn
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class BreadcrumbsManagerImp @Inject constructor(

) : BreadcrumbsManager {
    private val _history = MutableStateFlow<Set<BreadcrumbItem>>(emptySet())
    override fun getHistory(): StateFlow<Set<BreadcrumbItem>> = _history

    override fun getLastItemId(): StateFlow<String?> =
        _history.map { it.lastOrNull()?.id }
            .stateIn(
                scope = CoroutineScope(SupervisorJob() + Dispatchers.Default),
                started = SharingStarted.Eagerly,
                initialValue = null
            )

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