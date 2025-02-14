package com.example.radar_view.common

import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import com.example.radar_view.model.TriangleColors
import com.example.radar_view.model.TriangleProperties

object CustomTriangleProperties {

    @Composable
    fun triangleColors(
        primaryColor: Color = Color.Red,
        secondaryColor: Color = Color.Transparent
    ) : TriangleColors = TriangleColors(
        primaryColor = primaryColor,
        secondaryColor = secondaryColor
    )

    @Composable
    fun triangleProperties(
        alpha: Float = 0.35f,
        sweepAngle: Float = 10f,
        angleOffset: Double = 5.0
    ) : TriangleProperties = TriangleProperties(
        alpha = alpha,
        sweepAngle = sweepAngle,
        angleOffset = angleOffset
    )
}