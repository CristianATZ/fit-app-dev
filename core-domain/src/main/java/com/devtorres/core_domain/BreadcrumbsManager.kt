package com.devtorres.core_domain

import com.devtorres.core_model.ui.BreadcrumbItem
import kotlinx.coroutines.flow.StateFlow

interface BreadcrumbsManager {

    /** Obtiene el historial completo en orden de visita */
    fun getHistory(): StateFlow<Set<BreadcrumbItem>>

    /** Obtiene el ID del ultimo ítem del historial */
    fun getLastIem(): StateFlow<BreadcrumbItem?>

    /** Añade un ítem al final, evitando duplicados consecutivos */
    fun addItem(item: BreadcrumbItem)

    /** Recorta los item del historial **por encima** de [itemId], dejándolo a tope */
    fun popUpTo(itemId: String)

    /** Elimina únicamente el último ítem del historial */
    fun pop()

    /** Limpia el historial */
    fun clear()
}