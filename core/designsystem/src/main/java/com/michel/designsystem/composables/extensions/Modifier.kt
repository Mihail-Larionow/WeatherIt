package com.michel.designsystem.composables.extensions

import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.composed
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.platform.debugInspectorInfo
import androidx.compose.ui.semantics.Role

fun Modifier.clickableWithRipple(
    shape: Shape = RectangleShape,
    isEnabled: Boolean = true,
    role: Role? = null,
    onClick: () -> Unit,
): Modifier = this.composed(
    inspectorInfo = debugInspectorInfo {
        name = "clickableWithRipple"
        properties["shape"] = shape
        properties["isEnabled"] = isEnabled
        properties["onClick"] = onClick
        properties["role"] = role
    }
) {
    clip(shape)
        .clickable(
            interactionSource = remember { MutableInteractionSource() },
            indication = travelRipple(),
            enabled = isEnabled,
            onClick = onClick,
            role = role,
        )
}
