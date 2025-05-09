package com.devtorres.fit_app.ui.theme

import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.Immutable
import androidx.compose.ui.graphics.Color

@Immutable
data class ColorFamily(
    val color: Color,
    val onColor: Color,
    val colorContainer: Color,
    val onColorContainer: Color
)


// Color extendido: Rosa (siguiendo el formato de Material 3)
@Immutable
object ExtendedColors {
    val pink = ColorFamily(
        color = Pink,
        onColor = OnPink,
        colorContainer = PinkContainer,
        onColorContainer = OnPinkContainer
    )
    val green = ColorFamily(
        color = Green,
        onColor = OnGreen,
        colorContainer = GreenContainer,
        onColorContainer = OnGreenContainer
    )
}

// Esquema de colores oscuro para Material Theme 3
val FitProDarkColorScheme = darkColorScheme(
    primary = Primary,
    onPrimary = OnPrimary,
    primaryContainer = PrimaryContainer,
    onPrimaryContainer = OnPrimaryContainer,
    secondary = Secondary,
    onSecondary = OnSecondary,
    secondaryContainer = SecondaryContainer,
    onSecondaryContainer = OnSecondaryContainer,
    tertiary = Tertiary,
    onTertiary = OnTertiary,
    tertiaryContainer = TertiaryContainer,
    onTertiaryContainer = OnTertiaryContainer,
    background = DarkBackground,
    onBackground = OnDarkBackground,
    surface = DarkSurface,
    onSurface = OnDarkSurface,
    surfaceVariant = DarkSurfaceVariant,
    onSurfaceVariant = OnDarkSurfaceVariant,
    outline = DarkOutline,
    surfaceTint = SurfaceTint,

    // Colores agregados que faltaban
    error = Error,
    onError = OnError,
    errorContainer = ErrorContainer,
    onErrorContainer = OnErrorContainer,
    inverseSurface = InverseSurface,
    inverseOnSurface = InverseOnSurface,
    inversePrimary = InversePrimary,
    outlineVariant = Color(0xFF444444), // Variante de contorno más oscura
    scrim = Scrim,

    // Colores de superficie adicionales de Material 3
    surfaceBright = SurfaceBright,
    surfaceContainer = SurfaceContainer,
    surfaceContainerHigh = SurfaceContainerHigh,
    surfaceContainerHighest = SurfaceContainerHighest,
    surfaceContainerLow = SurfaceContainerLow,
    surfaceContainerLowest = SurfaceContainerLowest,
    surfaceDim = SurfaceDim
)

@Composable
fun FitappTheme(
    darkTheme: Boolean = true,
    // Dynamic color is available on Android 12+
    dynamicColor: Boolean = true,
    content: @Composable () -> Unit
) {
    val colorScheme = FitProDarkColorScheme
    val typography = FitProTypography

    MaterialTheme(
        colorScheme = colorScheme,
        typography = typography,
        content = content
    )
}

// Extensión para acceder a los colores extendidos desde cualquier lugar
object MaterialThemeExt {
    val colors: ExtendedColors
        @Composable
        get() = ExtendedColors
}

// Ejemplo de uso de los colores extendidos
/*
@Composable
fun ExampleUsage() {
    // Acceder a los colores extendidos
    val pinkColor = MaterialThemeExt.colors.Pink
    val pinkContainerColor = MaterialThemeExt.colors.PinkContainer

    // O acceder a todas las variantes
    val allPinkVariants = MaterialThemeExt.colors.getAllPinkVariants()
    val specificPink = allPinkVariants["pinkAccent"]

    // Uso en un componente
    // Surface(color = pinkColor) { ... }
}*/
