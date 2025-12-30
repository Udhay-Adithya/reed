package com.udhay.reed.util

import androidx.compose.material3.SnackbarDuration
import androidx.compose.material3.SnackbarHostState
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch

object SnackbarController {

    private var snackbarHostState: SnackbarHostState? = null

    fun init(hostState: SnackbarHostState) {
        snackbarHostState = hostState
    }

    fun show(
        scope: CoroutineScope,
        message: String,
        actionLabel: String? = null,
        duration: SnackbarDuration = SnackbarDuration.Short,
        onAction: (() -> Unit)? = null
    ) {
        val hostState = snackbarHostState ?: return

        scope.launch {
            val result = hostState.showSnackbar(
                message = message,
                actionLabel = actionLabel,
                duration = duration,
                withDismissAction = true

            )

            if (result == androidx.compose.material3.SnackbarResult.ActionPerformed) {
                onAction?.invoke()
            }
        }
    }
}
