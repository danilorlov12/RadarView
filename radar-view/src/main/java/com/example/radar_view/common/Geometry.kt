package com.example.radar_view.common

import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.drawscope.DrawScope
import com.example.radar_view.model.TriangleColors
import com.example.radar_view.model.TriangleProperties
import kotlin.math.cos
import kotlin.math.sin

private const val TRIANGLE_ANGLE_OFFSET = 5.0

internal fun DrawScope.drawMovingTriangle(
    radius: Float,
    center: Offset,
    angle: Float,
    colors: TriangleColors,
    properties: TriangleProperties
) {

    val radian = Math.toRadians(angle.toDouble())

    val rearTrianglePoint = Offset(
        x = center.x + radius * cos(radian + Math.toRadians(TRIANGLE_ANGLE_OFFSET + properties.angleOffset)).toFloat(),
        y = center.y + radius * sin(radian + Math.toRadians(TRIANGLE_ANGLE_OFFSET + properties.angleOffset)).toFloat()
    )

    val frontTrianglePoint = Offset(
        x = center.x + radius * cos(radian - Math.toRadians(TRIANGLE_ANGLE_OFFSET)).toFloat(),
        y = center.y + radius * sin(radian - Math.toRadians(TRIANGLE_ANGLE_OFFSET)).toFloat()
    )

    val gradientBrush = Brush.linearGradient(
        colors = listOf(colors.primaryColor.copy(alpha = properties.alpha), colors.secondaryColor),
        start = rearTrianglePoint,
        end = frontTrianglePoint
    )

    drawArc(
        brush = gradientBrush,
        startAngle = angle,
        sweepAngle = properties.sweepAngle,
        useCenter = true,
        topLeft = Offset(center.x - radius, center.y - radius),
        size = Size(radius * 2, radius * 2)
    )
}

internal fun DrawScope.drawRadar(
    radius: Float,
    center: Offset,
    color: Color,
    circleCount: Int,
) {
    val step = radius / circleCount

    repeat(circleCount) { i ->
        drawCircle(
            color = color,
            radius = step * (i + 1),
            center = center,
            alpha = 0.15f
        )
    }
}