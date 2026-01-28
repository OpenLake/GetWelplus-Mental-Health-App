package com.example.getwell.screens

import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.graphics.StrokeCap
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import kotlin.math.max
import kotlin.math.min

@Composable
fun CircularProgressBar(
    modifier: Modifier = Modifier,
    pssScore: Int = 0,
    dssScore: Int = 0,
    title: String = "STRESS",
    totalProgress: Float = 0.9f,
    fullProgress1: Float = 0.20f,
    fullProgress2: Float = 0.40f,
    fullProgress3: Float = 0.25f,
    fullProgress4: Float = 0.15f,
    animationDuration: Int = 1500,
    gapAngle: Float = 4f,
    radius: Dp = 60.dp,
    strokeWidth: Float = 45f,
    fontSize: TextUnit = 28.sp,
    animationDelay: Int = 500,
    color: Color = Color(31, 31, 37),
    barColors: List<Color> = listOf(
        Color(194, 148, 237),
        Color(74, 151, 172),
        Color(80, 124, 200),
        Color(11, 78, 160)
    )
) {
    var isAnimate by remember { mutableStateOf(false) }
    val animatedTotalProgress by animateFloatAsState(
        targetValue = if (isAnimate) totalProgress else 0f,
        animationSpec = tween(durationMillis = animationDuration, delayMillis = animationDelay),
        label = ""
    )

    val progress1 = min(animatedTotalProgress, fullProgress1)
    val progress2 = if (animatedTotalProgress > fullProgress1) {
        min(animatedTotalProgress - fullProgress1, fullProgress2)
    } else 0f
    val progress3 = if (animatedTotalProgress > fullProgress1 + fullProgress2) {
        min(animatedTotalProgress - fullProgress1 - fullProgress2, fullProgress3)
    } else 0f
    val progress4 = if (animatedTotalProgress > fullProgress1 + fullProgress2 + fullProgress3) {
        min(animatedTotalProgress - fullProgress1 - fullProgress2 - fullProgress3, fullProgress4)
    } else 0f

    LaunchedEffect(Unit) {
        isAnimate = true
    }

    Box(
        contentAlignment = Alignment.Center,
        modifier = modifier.size(radius * 2f)
    ) {
        Canvas(modifier = Modifier.size(radius * 2f)) {
            drawArc(
                color = barColors[0],
                startAngle = -90f,
                sweepAngle = max(0f, progress1 * 360 - gapAngle),
                useCenter = false,
                style = Stroke(strokeWidth, cap = StrokeCap.Butt)
            )
            drawArc(
                color = color,
                startAngle = -90f + progress1 * 360 - gapAngle,
                sweepAngle = gapAngle,
                useCenter = false,
                style = Stroke(strokeWidth, cap = StrokeCap.Butt)
            )
            drawArc(
                color = barColors[1],
                startAngle = -90f + progress1 * 360,
                sweepAngle = max(0f, progress2 * 360 - gapAngle),
                useCenter = false,
                style = Stroke(strokeWidth, cap = StrokeCap.Butt)
            )
            drawArc(
                color = color,
                startAngle = -90f + (progress1 + progress2) * 360 - gapAngle,
                sweepAngle = gapAngle,
                useCenter = false,
                style = Stroke(strokeWidth, cap = StrokeCap.Butt)
            )
            drawArc(
                color = barColors[2],
                startAngle = -90f + (progress1 + progress2) * 360,
                sweepAngle = max(0f, progress3 * 360 - gapAngle),
                useCenter = false,
                style = Stroke(strokeWidth, cap = StrokeCap.Butt)
            )
            drawArc(
                color = color,
                startAngle = -90f + (progress1 + progress2 + progress3) * 360 - gapAngle,
                sweepAngle = gapAngle,
                useCenter = false,
                style = Stroke(strokeWidth, cap = StrokeCap.Butt)
            )
            drawArc(
                color = barColors[3],
                startAngle = -90f + (progress1 + progress2 + progress3) * 360,
                sweepAngle = max(0f, progress4 * 360 - gapAngle),
                useCenter = false,
                style = Stroke(strokeWidth, cap = StrokeCap.Butt)
            )
        }

        Column(
            modifier = Modifier.padding(top = 2.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Text(
                text = title,
                fontWeight = FontWeight.SemiBold,
                fontFamily = customFont,
                fontSize = 14.sp,
                color = Color.White
            )
            Row(
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = "${String.format("%.2f", animatedTotalProgress * 100)}%",
                    fontWeight = FontWeight.Bold,
                    fontFamily = customFont,
                    fontSize = 18.sp,
                    color = Color(0xFF00FFB2)
                )
            }
        }
    }
}
