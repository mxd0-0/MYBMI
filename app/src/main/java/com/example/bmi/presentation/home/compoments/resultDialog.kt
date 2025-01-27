package com.example.bmi.presentation.home.compoments

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.ShapeDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Dialog
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.bmi.presentation.BMIViewModel
import com.example.bmi.ui.theme.Blue
import com.example.bmi.ui.theme.onPrimaryDarkHighContrast
import com.example.bmi.ui.theme.onPrimaryLightHighContrast

@Composable
fun ResultDialog(
    viewModel: BMIViewModel = viewModel(),
) {
    val state by viewModel.state.collectAsState()

    Dialog(onDismissRequest = { viewModel.dismissDialog() }) {
        Card(
            modifier = Modifier
                .fillMaxWidth()
                .height(400.dp)
                .padding(16.dp),
            shape = RoundedCornerShape(16.dp),
        ) {
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .fillMaxWidth()
                    .padding(16.dp),
                verticalArrangement = Arrangement.SpaceAround,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text(
                    text = "BMI Result",
                    textAlign = TextAlign.Center,
                    fontWeight = FontWeight.SemiBold,
                    style = MaterialTheme.typography.headlineLarge
                )
                Text(
                    text = "%.2f".format(state.bmiResult!!.value),//${state.bmiResult!!.value}
                    textAlign = TextAlign.Center,
                    color = Blue,
                    fontWeight = FontWeight.Bold,
                    style = MaterialTheme.typography.displayLarge
                )
                Text(
                    text = state.bmiResult!!.category,//state.bmiResult!!.category,
                    textAlign = TextAlign.Center,
                    style = MaterialTheme.typography.headlineMedium
                )
                Column(
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.spacedBy(8.dp)
                ) {
                    Text(
                        "Underweight: BMI less than 18.5",
                        style = MaterialTheme.typography.labelLarge
                    )
                    Text(
                        "Normal weight: BMI 18.5 to 24.9",
                        style = MaterialTheme.typography.labelLarge
                    )
                    Text(
                        "Overweight: BMI 25 to 29.9",
                        style = MaterialTheme.typography.labelLarge
                    )
                    Text(
                        "Obesity: 30 to 40",
                        style = MaterialTheme.typography.labelLarge
                    )

                    Button(
                        onClick = { viewModel.dismissDialog() },
                        shape = ShapeDefaults.Medium,
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(46.dp),
                    ) {
                        Text(
                            "Done",
                            style = MaterialTheme.typography.bodyLarge,
                            color = if (isSystemInDarkTheme()) onPrimaryDarkHighContrast else onPrimaryLightHighContrast

                        )
                    }
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun ResultDialogPrev() {
    ResultDialog()
}