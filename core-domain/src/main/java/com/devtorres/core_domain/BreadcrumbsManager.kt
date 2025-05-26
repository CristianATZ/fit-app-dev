package com.devtorres.core_domain

import com.devtorres.core_model.ui.BreadcrumbItem
import kotlinx.coroutines.flow.StateFlow

interface BreadcrumbsManager {
    /** Añade un ítem al final, evitando duplicados consecutivos */
    fun addItem(item: BreadcrumbItem)

    /** Recorta todo el historial **por encima** de [itemId], dejándolo a tope */
    fun popUpTo(itemId: String)

    /** Elimina únicamente el último ítem del historial */
    fun pop()

    /** Obtiene el historial completo en orden de visita */
    fun getHistory(): StateFlow<Set<BreadcrumbItem>>

    /** Limpia todo el historial */
    fun clear()
}