package com.example.bmi.presentation.home.compoments

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Slider
import androidx.compose.material3.SliderDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.bmi.presentation.BMIViewModel

@Composable
fun HeightUi(
    modifier: Modifier = Modifier,
    viewModel: BMIViewModel = viewModel()
) {
    val height by viewModel.state.collectAsState()

    Card(
        modifier = modifier
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(8.dp),
            verticalArrangement = Arrangement.SpaceAround,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(text = "Height (CM)")
            Text(
                text = height.height.toInt().toString(),
                style = MaterialTheme.typography.displayLarge,
                fontWeight = FontWeight.Bold,
            )
            Slider(
                valueRange = 50f..300f,
                steps = 250,
                value = height.height,
                onValueChange = { newHeight ->
                    viewModel.updateHeight(newHeight)
                },
                colors = SliderDefaults.colors(
                    activeTickColor = MaterialTheme.colorScheme.primary,
                ),
                modifier = Modifier
                    .padding(horizontal = 16.dp)
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun HeightUiPrev() {
    HeightUi(
        modifier = Modifier
            .height(200.dp)
            .fillMaxWidth()
    )
}