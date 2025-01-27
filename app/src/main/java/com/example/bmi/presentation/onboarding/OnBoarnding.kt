package com.example.bmi.presentation.onboarding

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.ShapeDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.bmi.R
import com.example.bmi.ui.theme.Blue
import com.example.bmi.ui.theme.OnboardingButton
import com.example.bmi.ui.theme.OnboardingOnButton
import com.example.bmi.ui.theme.SecondaryTitle

@Composable
fun OnBoardingScreen(
    onClick: () -> Unit, modifier: Modifier = Modifier
) {
    Box(
        modifier = Modifier
            .background(Blue)
            .fillMaxSize()
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(24.dp),
            verticalArrangement = Arrangement.SpaceBetween,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Spacer(
                modifier = Modifier.height(16.dp)
            )
            Image(
                contentDescription = "LOGO", painter = painterResource(id = R.drawable.mybmi)
            )
            Image(
                contentDescription = "illustration",
                painter = painterResource(id = R.drawable.undraw)
            )
            Column {
                Text(
                    "Get Started with\n" + "Tracking Your Health!",
                    textAlign = TextAlign.Center,
                    style = MaterialTheme.typography.headlineSmall,
                    fontWeight = FontWeight.Bold,
                    color = Color.White,
                    modifier = modifier.fillMaxWidth()
                )
                Text(
                    "Calculate your BMI and stay on top of\n" + "your wellness journey, effortlessly.",
                    textAlign = TextAlign.Center,
                    color = SecondaryTitle,
                    style = MaterialTheme.typography.bodyLarge,
                    modifier = modifier.fillMaxWidth()
                )
            }
            Button(
                onClick = { onClick() },
                shape = ShapeDefaults.Medium,
                modifier = Modifier
                    .fillMaxWidth()
                    .height(56.dp),
                colors = ButtonDefaults.buttonColors(
                    containerColor = OnboardingButton, contentColor = OnboardingOnButton
                )
            ) {
                Text("Get Started")
            }
            Spacer(modifier = Modifier.height(1.dp))
        }
    }
}


@Preview(showSystemUi = true)
@Composable
private fun OnBoardingScreenPrev() {
    OnBoardingScreen({})
}