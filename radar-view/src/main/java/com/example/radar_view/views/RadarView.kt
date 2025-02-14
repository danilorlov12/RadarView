package com.example.radar_view.views

import androidx.annotation.FloatRange
import androidx.compose.animation.core.Easing
import androidx.compose.animation.core.LinearEasing
import androidx.compose.animation.core.RepeatMode
import androidx.compose.animation.core.animateFloat
import androidx.compose.animation.core.infiniteRepeatable
import androidx.compose.animation.core.rememberInfiniteTransition
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Canvas
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import com.example.radar_view.common.CustomTriangleProperties
import com.example.radar_view.common.drawMovingTriangle
import com.example.radar_view.common.drawRadar
import com.example.radar_view.model.TriangleColors
import com.example.radar_view.model.TriangleProperties

@Composable
fun RadarView(
    modifier: Modifier = Modifier,
    @FloatRange(-90.0, 270.0) startPosition: Float = -90f,
    duration: Int = 4000,
    easing: Easing = LinearEasing,
    repeatMode: RepeatMode = RepeatMode.Restart,
    circleCount: Int = 4,
    colors: TriangleColors = CustomTriangleProperties.triangleColors(),
    properties: TriangleProperties = CustomTriangleProperties.triangleProperties(),
) {

    val angle by rememberInfiniteTransition(label = "Radar Animation").animateFloat(
        initialValue = startPosition,
        targetValue = startPosition + 360f,
        animationSpec = infiniteRepeatable(
            animation = tween(durationMillis = duration, easing = easing),
            repeatMode = repeatMode
        ),
        label = "Rotation"
    )
    Canvas(
        modifier = modifier
    ) {

        val targetSize = if (size.width > size.height) size.height else size.width

        val center = Offset(size.width / 2, size.height / 2)
        val radius = targetSize / 2

        drawRadar(
            radius = radius,
            center = center,
            color = Color.Gray,
            circleCount = circleCount
        )

        drawMovingTriangle(
            radius = radius,
            center = center,
            angle = angle,
            colors = colors,
            properties = properties
        )
    }
}