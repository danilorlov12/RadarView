package com.example.radar_view.model

import androidx.compose.runtime.Immutable
import androidx.compose.ui.graphics.Color

@Immutable
class TriangleColors(
    val primaryColor: Color,
    val secondaryColor: Color
)

@Immutable
class TriangleProperties(
    val sweepAngle: Float,
    val alpha: Float,
    val angleOffset: Double
)