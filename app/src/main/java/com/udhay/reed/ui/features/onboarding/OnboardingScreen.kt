package com.udhay.reed.ui.features.onboarding

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ExperimentalMaterial3ExpressiveApi
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.udhay.reed.R
import com.udhay.reed.di.AppModule
import com.udhay.reed.ui.components.ErrorScreen
import com.udhay.reed.util.Loader
import kotlinx.coroutines.flow.collectLatest
import org.koin.android.ext.koin.androidContext
import org.koin.compose.KoinApplication
import org.koin.compose.viewmodel.koinViewModel
import org.koin.ksp.generated.module

@OptIn(ExperimentalMaterial3Api::class, ExperimentalMaterial3ExpressiveApi::class)
@Composable
fun OnboardingScreen(
    onNavigateToLogin: () -> Unit,
    viewModel: OnboardingViewModel = koinViewModel()
) {
    LaunchedEffect(Unit) {
        viewModel.events.collectLatest { event ->
            when (event) {
                // TODO handle events
                is OnboardingUiEvent.ShowErrorMessage -> TODO()
            }
        }
    }

    val state = viewModel.state.collectAsStateWithLifecycle()

    when (val uiState = state.value) {
        is OnboardingUiState.Loading -> {
            Loader()
        }

        is OnboardingUiState.Error -> {
            val errorMessage = (state.value as OnboardingUiState.Error).message
            ErrorScreen(
                errorMessage,
                "Retry",
                onPrimaryButtonClicked = {}
            ) { }
        }

        is OnboardingUiState.Success -> {
            Scaffold(
            ) { paddingValues ->
                Column(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(paddingValues)
                        .padding(16.dp),
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.SpaceBetween

                ) {
                    Image(
                        painter = painterResource(R.drawable.vinyl),
                        contentDescription = "Onboarding Image",
                        modifier = Modifier
                            .padding(top = 75.dp)
                            .height(275.dp)
                            .fillMaxWidth(),
                        contentScale = ContentScale.Fit

                    )

                    Column(
                        verticalArrangement = Arrangement.Top,
                        horizontalAlignment = Alignment.Start,
                    )
                    {
                        Text(
                            text = "Music Without\nBorders",
                            textAlign = TextAlign.Start,
                            style = MaterialTheme.typography.headlineLarge,
                            fontWeight = FontWeight.Bold
                        )
                        Spacer(
                            modifier = Modifier.height(12.dp)
                        )

                        Text(
                            text = "Create playlists, find new tracks and\nlisten to your favourite music anytime!",
                            style = MaterialTheme.typography.bodyLarge,
                            textAlign = TextAlign.Start,
                            fontWeight = FontWeight.Normal
                        )

                        Spacer(
                            modifier = Modifier.height(36.dp)
                        )

                        Button(
                            onClick = onNavigateToLogin,
                            modifier = Modifier
                                .fillMaxWidth()
                                .height(56.dp),
                            shape = ButtonDefaults.squareShape,
                            colors = ButtonDefaults.buttonColors(
                                containerColor = MaterialTheme.colorScheme.primary,
                            ),


                            ) {
                            Text(
                                "Get Started",
                                style = MaterialTheme.typography.bodyLarge,
                                textAlign = TextAlign.Start,
                                fontWeight = FontWeight.Bold
                            )
                        }

                        Spacer(
                            modifier = Modifier.height(40.dp)
                        )
                    }


                }


            }
        }
    }
}

@Preview
@Composable
fun OnboardingScreenPreview() {
    // Previews don't run your Application class, so GlobalContext isn't started.
    // Provide a local Koin scope just for the preview.
    val context = LocalContext.current
    KoinApplication(application = {
        // Use the Koin KSP-generated module for AppModule (includes NetworkModule + ComponentScan).
        modules(AppModule().module)
        // Some definitions (e.g., repositories) may need an Android Context.
        androidContext(context)
    }) {
        OnboardingScreen(
            onNavigateToLogin = {}
        )
    }
}
