package com.ilmal08.kmptemplate.views.theme

import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily.Companion.Default
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.unit.sp

private const val HEADLINE_LINE_HEIGHT = 1.2
private const val BODY_LINE_HEIGHT = 1.4
private const val LABEL_LINE_HEIGHT = 1.2
private const val UNDERLINE_LINE_HEIGHT = 1.2

data class ThemeTypography(
    val h0: TextStyle = TextStyle(
        fontFamily = Default,
        fontWeight = FontWeight.ExtraBold,
        fontSize = 32.sp,
        lineHeight = 32.sp * HEADLINE_LINE_HEIGHT
    ),
    val h1: TextStyle = TextStyle(
        fontFamily = Default,
        fontWeight = FontWeight.ExtraBold,
        fontSize = 28.sp,
        lineHeight = 28.sp * HEADLINE_LINE_HEIGHT
    ),
    val h2: TextStyle = TextStyle(
        fontFamily = Default,
        fontWeight = FontWeight.Bold,
        fontSize = 24.sp,
        lineHeight = 24.sp * HEADLINE_LINE_HEIGHT
    ),
    val h3: TextStyle = TextStyle(
        fontFamily = Default,
        fontWeight = FontWeight.Bold,
        fontSize = 18.sp,
        lineHeight = 18.sp * HEADLINE_LINE_HEIGHT
    ),
    val h4: TextStyle = TextStyle(
        fontFamily = Default,
        fontWeight = FontWeight.Bold,
        fontSize = 16.sp,
        lineHeight = 16.sp * HEADLINE_LINE_HEIGHT
    ),
    val h5: TextStyle = TextStyle(
        fontFamily = Default,
        fontWeight = FontWeight.Bold,
        fontSize = 14.sp,
        lineHeight = 14.sp * HEADLINE_LINE_HEIGHT
    ),
    val h6: TextStyle = TextStyle(
        fontFamily = Default,
        fontWeight = FontWeight.Bold,
        fontSize = 12.sp,
        lineHeight = 12.sp * HEADLINE_LINE_HEIGHT
    ),
    val body1: TextStyle = TextStyle(
        fontFamily = Default,
        fontWeight = FontWeight.Normal,
        fontSize = 16.sp,
        lineHeight = 16.sp * BODY_LINE_HEIGHT
    ),
    val bodyBold1: TextStyle = TextStyle(
        fontFamily = Default,
        fontWeight = FontWeight.SemiBold,
        fontSize = 16.sp,
        lineHeight = 16.sp * BODY_LINE_HEIGHT
    ),
    val body2: TextStyle = TextStyle(
        fontFamily = Default,
        fontWeight = FontWeight.Normal,
        fontSize = 14.sp,
        lineHeight = 14.sp * BODY_LINE_HEIGHT
    ),
    val bodyBold2: TextStyle = TextStyle(
        fontFamily = Default,
        fontWeight = FontWeight.SemiBold,
        fontSize = 14.sp,
        lineHeight = 14.sp * BODY_LINE_HEIGHT
    ),
    val body3: TextStyle = TextStyle(
        fontFamily = Default,
        fontWeight = FontWeight.Normal,
        fontSize = 12.sp,
        lineHeight = 12.sp * BODY_LINE_HEIGHT
    ),
    val bodyBold3: TextStyle = TextStyle(
        fontFamily = Default,
        fontWeight = FontWeight.SemiBold,
        fontSize = 12.sp,
        lineHeight = 12.sp * BODY_LINE_HEIGHT
    ),
    val label1: TextStyle = TextStyle(
        fontFamily = Default,
        fontWeight = FontWeight.Normal,
        fontSize = 14.sp,
        lineHeight = 14.sp * LABEL_LINE_HEIGHT
    ),
    val labelBold1: TextStyle = TextStyle(
        fontFamily = Default,
        fontWeight = FontWeight.SemiBold,
        fontSize = 14.sp,
        lineHeight = 14.sp * LABEL_LINE_HEIGHT
    ),
    val label2: TextStyle = TextStyle(
        fontFamily = Default,
        fontWeight = FontWeight.Normal,
        fontSize = 12.sp,
        lineHeight = 12.sp * LABEL_LINE_HEIGHT
    ),
    val labelBold2: TextStyle = TextStyle(
        fontFamily = Default,
        fontWeight = FontWeight.SemiBold,
        fontSize = 12.sp,
        lineHeight = 12.sp * LABEL_LINE_HEIGHT
    ),
    val label3: TextStyle = TextStyle(
        fontFamily = Default,
        fontWeight = FontWeight.Normal,
        fontSize = 10.sp,
        lineHeight = 10.sp * LABEL_LINE_HEIGHT
    ),
    val labelBold3: TextStyle = TextStyle(
        fontFamily = Default,
        fontWeight = FontWeight.SemiBold,
        fontSize = 10.sp,
        lineHeight = 10.sp * LABEL_LINE_HEIGHT
    ),
    val underline1: TextStyle = TextStyle(
        fontFamily = Default,
        fontWeight = FontWeight.Medium,
        fontSize = 16.sp,
        lineHeight = 16.sp * UNDERLINE_LINE_HEIGHT,
        textDecoration = TextDecoration.Underline
    ),
    val underlineBold1: TextStyle = TextStyle(
        fontFamily = Default,
        fontWeight = FontWeight.Bold,
        fontSize = 16.sp,
        lineHeight = 16.sp * UNDERLINE_LINE_HEIGHT,
        textDecoration = TextDecoration.Underline
    ),
    val underline2: TextStyle = TextStyle(
        fontFamily = Default,
        fontWeight = FontWeight.Medium,
        fontSize = 14.sp,
        lineHeight = 14.sp * UNDERLINE_LINE_HEIGHT,
        textDecoration = TextDecoration.Underline
    ),
    val underlineBold2: TextStyle = TextStyle(
        fontFamily = Default,
        fontWeight = FontWeight.Bold,
        fontSize = 14.sp,
        lineHeight = 14.sp * UNDERLINE_LINE_HEIGHT,
        textDecoration = TextDecoration.Underline
    ),
    val underline3: TextStyle = TextStyle(
        fontFamily = Default,
        fontWeight = FontWeight.Medium,
        fontSize = 12.sp,
        lineHeight = 12.sp * UNDERLINE_LINE_HEIGHT,
        textDecoration = TextDecoration.Underline
    ),
    val underlineBold3: TextStyle = TextStyle(
        fontFamily = Default,
        fontWeight = FontWeight.Bold,
        fontSize = 12.sp,
        lineHeight = 12.sp * UNDERLINE_LINE_HEIGHT,
        textDecoration = TextDecoration.Underline
    )
)