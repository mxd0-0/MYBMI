package com.example.bmi.presentation.home


import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.safeContentPadding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.ShapeDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.PreviewLightDark
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.bmi.presentation.BMIViewModel
import com.example.bmi.presentation.home.compoments.HeightUi
import com.example.bmi.presentation.home.compoments.ResultDialog
import com.example.bmi.presentation.home.compoments.SetValue
import com.example.bmi.ui.theme.BMITheme

@Composable
fun HomeScreen(
    modifier: Modifier = Modifier, viewModel: BMIViewModel = viewModel(),
) {
    val state by viewModel.state.collectAsState()
    Scaffold { innerPadding ->
        Column(
            modifier = modifier
                .fillMaxSize()
                .padding(innerPadding),
            verticalArrangement = Arrangement.spacedBy(16.dp, Alignment.CenterVertically),
        ) {
            Row(
                horizontalArrangement = Arrangement.SpaceBetween, modifier = Modifier.fillMaxWidth()
            ) {
                SetValue(
                    name = "Weight (KG)", modifier = Modifier.size(height = 200.dp, width = 160.dp)
                )
                SetValue(
                    name = "Age", modifier = Modifier.size(height = 200.dp, width = 160.dp)
                )

            }
            HeightUi(
                modifier = Modifier.height(200.dp)
            )

            Button(
                shape = ShapeDefaults.Medium,
                onClick = {
                    viewModel.calculateBMI()
                }, modifier = Modifier
                    .fillMaxWidth()
                    .height(56.dp)
            ) {
                Text(
                    "Calculate BMI",
                    style = MaterialTheme.typography.bodyLarge,
                )
            }
            if (state.bmiResult != null) {
                ResultDialog(viewModel = viewModel)
            }
        }
    }
}

@PreviewLightDark
@Composable
private fun HomeScreenPrev() {
    BMITheme {
        HomeScreen(
            modifier = Modifier.safeContentPadding()
        )
    }
}