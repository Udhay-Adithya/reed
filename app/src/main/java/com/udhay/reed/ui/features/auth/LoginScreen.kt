package com.udhay.reed.ui.features.auth

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3ExpressiveApi
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SnackbarDuration
import androidx.compose.material3.SnackbarHost
import androidx.compose.material3.SnackbarHostState
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.LinkAnnotation
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.dp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.udhay.reed.ui.components.ErrorScreen
import com.udhay.reed.ui.components.FullAppLogo
import com.udhay.reed.ui.components.LabeledOutlinedTextField
import com.udhay.reed.util.Loader
import com.udhay.reed.util.SnackbarController
import kotlinx.coroutines.flow.collectLatest
import org.koin.compose.viewmodel.koinViewModel

@OptIn(ExperimentalMaterial3ExpressiveApi::class)
@Composable
fun LoginScreen(
    onLoginSuccess: () -> Unit,
    onNavigateToSignup: (LinkAnnotation) -> Unit,
    viewModel: AuthViewModel = koinViewModel()
) {
    val scope = rememberCoroutineScope()
    LaunchedEffect(Unit) {
        viewModel.effect.collectLatest { event ->
            when (event) {

                AuthUiEffect.NavigateToHome -> {
                    onLoginSuccess()
                }

                is AuthUiEffect.ShowErrorMessage -> {
                    SnackbarController.show(
                        scope = scope,
                        message = event.message,
                        duration = SnackbarDuration.Short
                    )
                }
            }
        }
    }

    val snackbarHostState = remember { SnackbarHostState() }

    SnackbarController.init(snackbarHostState)

    val state by viewModel.state.collectAsStateWithLifecycle()

    var email by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }

//    if (state is AuthUiState.Error) {
//        ErrorScreen(
//            errorMessage = (state as AuthUiState.Error).message,
//            primaryButton = "Retry",
//            onPrimaryButtonClicked = {
//                // viewModel.retry()
//            }
//        ) {}
//        return
//    }

    val isLoading = state is AuthUiState.Loading

    Scaffold(
        snackbarHost = { SnackbarHost(snackbarHostState) }
    ) { paddingValues ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues)
                .padding(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {

            Spacer(Modifier.height(12.dp))
            FullAppLogo()

            Spacer(Modifier.height(12.dp))
            Text(
                text = "Great to see\nyou!",
                style = MaterialTheme.typography.headlineLarge,
                fontWeight = FontWeight.Bold,
                textAlign = TextAlign.Center
            )

            Spacer(Modifier.height(12.dp))
            Text(
                text = "Log in and dive into your\nuniverse of tunes",
                style = MaterialTheme.typography.bodyLarge,
                textAlign = TextAlign.Center,
                color = MaterialTheme.colorScheme.outline
            )

            Spacer(Modifier.height(48.dp))

            LabeledOutlinedTextField(
                label = "Email",
                value = email,
                onValueChange = { email = it },
                placeholder = "Email",
                keyboardType = KeyboardType.Email,
            )

            Spacer(Modifier.height(28.dp))

            LabeledOutlinedTextField(
                label = "Password",
                value = password,
                onValueChange = { password = it },
                placeholder = "Password",
                isPassword = true,
                keyboardType = KeyboardType.Password
            )

            Spacer(Modifier.height(36.dp))

            Button(
                onClick = {
                    viewModel.onEvent(
                        AuthUiEvent.Login(
                            email = email,
                            password = password
                        )
                    )
                },
                modifier = Modifier
                    .fillMaxWidth()
                    .height(56.dp),
                enabled = !isLoading,
                shape = ButtonDefaults.squareShape
            ) {
                if (isLoading) {
                    Loader()
                } else {
                    Text(
                        "Login",
                        style = MaterialTheme.typography.bodyLarge,
                        fontWeight = FontWeight.Bold
                    )
                }
            }

            Spacer(Modifier.weight(1f))

            val annotatedText = buildAnnotatedString {
                append("Don't have an account? ")
                pushLink(
                    LinkAnnotation.Clickable(
                        tag = "register",
                        linkInteractionListener = onNavigateToSignup
                    )
                )
                withStyle(
                    SpanStyle(
                        color = MaterialTheme.colorScheme.primary,
                        fontWeight = FontWeight.SemiBold
                    )
                ) {
                    append("Register")
                }
                pop()
            }

            Text(
                text = annotatedText,
                style = MaterialTheme.typography.bodyMedium
            )
        }
    }
}

