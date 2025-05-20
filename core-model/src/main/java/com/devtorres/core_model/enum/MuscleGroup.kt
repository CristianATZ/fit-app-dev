package com.devtorres.core_model.enum

enum class MuscleGroup(val displayName: String) {
    ALL("Todos"),
    CHEST("Pecho"),
    BACK("Espalda"),
    SHOULDERS("Hombros"),
    ARMS("Brazos"),
    LEGS("Piernas"),
    CALVES("Pantorrillas"),
    FOREARMS("Antebrazos"),
    ABS("Abdominales"),
    NECK("Cuello"),
    TRAPS("Trapecios"),
    QUADRICEPS("Cuádriceps"),
    HAMSTRINGS("Isquiotibiales"),
    GLUTES("Glúteos"),
    BICEPS("Bíceps"),
    TRICEPS("Tríceps"),
    LATS("Dorsales"),
    ABDUCTORS("Abductores"),
    ADDUCTORS("Aductores"),
    CORE("Core");

    override fun toString(): String = displayName
}
