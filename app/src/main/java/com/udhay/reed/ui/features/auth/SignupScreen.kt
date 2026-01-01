package com.udhay.reed.ui.features.auth

import androidx.compose.foundation.layout.Arrangement
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
import androidx.compose.ui.text.LinkAnnotation.Clickable
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.dp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.udhay.reed.ui.components.FullAppLogo
import com.udhay.reed.ui.components.LabeledOutlinedTextField
import com.udhay.reed.util.Loader
import com.udhay.reed.util.SnackbarController
import kotlinx.coroutines.flow.collectLatest
import org.koin.compose.viewmodel.koinViewModel

@OptIn(ExperimentalMaterial3ExpressiveApi::class)
@Composable
fun SignupScreen(
    onSignupSuccess: () -> Unit,
    onNavigateToLogin: ((link: LinkAnnotation) -> Unit),
    viewModel: AuthViewModel = koinViewModel()
) {
    val scope = rememberCoroutineScope()
    LaunchedEffect(Unit) {
        viewModel.effect.collectLatest { event ->
            when (event) {
                AuthUiEffect.NavigateToHome -> onSignupSuccess
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
    var name: String by remember { mutableStateOf("") }
    var email: String by remember { mutableStateOf("") }
    var password: String by remember { mutableStateOf("") }

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


    Scaffold( snackbarHost = { SnackbarHost(snackbarHostState) }) { paddingValues ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues)
                .padding(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Top

        ) {
            Spacer(
                modifier = Modifier.height(12.dp)
            )
            FullAppLogo()
            Spacer(
                modifier = Modifier.height(12.dp)
            )
            Text(
                text = "Ready to rock?",
                textAlign = TextAlign.Center,
                style = MaterialTheme.typography.headlineLarge,
                fontWeight = FontWeight.Bold
            )
            Spacer(
                modifier = Modifier.height(12.dp)
            )

            Text(
                text = "Sign up and unlock\nendless jams",
                style = MaterialTheme.typography.bodyLarge,
                textAlign = TextAlign.Center,
                color = MaterialTheme.colorScheme.outline

            )

            Spacer(
                modifier = Modifier.height(48.dp)
            )

            LabeledOutlinedTextField(
                label = "Name",
                value = name,
                onValueChange = { name = it },
                placeholder = "Name",
                keyboardType = KeyboardType.Email
            )


            Spacer(
                modifier = Modifier.height(18.dp)
            )

            LabeledOutlinedTextField(
                label = "Email",
                value = email,
                onValueChange = { email = it },
                placeholder = "Email",
                keyboardType = KeyboardType.Email
            )


            Spacer(
                modifier = Modifier.height(18.dp)
            )

            LabeledOutlinedTextField(
                label = "Password",
                value = password,
                onValueChange = { password = it },
                placeholder = "Password",
                isPassword = true,
                keyboardType = KeyboardType.Password
            )

            Spacer(
                modifier = Modifier.height(36.dp)
            )

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
                shape = ButtonDefaults.squareShape,
                colors = ButtonDefaults.buttonColors(
                    containerColor = MaterialTheme.colorScheme.primary,
                ),


                ) {
                if (isLoading) {
                    Loader()
                } else {
                    Text(
                        "Signup",
                        style = MaterialTheme.typography.bodyLarge,
                        textAlign = TextAlign.Start,
                        fontWeight = FontWeight.Bold
                    )
                }

            }

            Spacer(Modifier.weight(1f))

            val annotatedText = buildAnnotatedString {
                append("Already have an account? ")

                pushLink(
                    Clickable(
                        tag = "login",
                        linkInteractionListener = onNavigateToLogin
                    )
                )
                withStyle(
                    SpanStyle(
                        color = MaterialTheme.colorScheme.primary,
                        fontWeight = FontWeight.SemiBold
                    )
                ) {
                    append("Login")
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



