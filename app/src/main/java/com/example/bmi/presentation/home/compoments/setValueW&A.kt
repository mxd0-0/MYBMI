package com.example.bmi.presentation.home.compoments

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.Card
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.bmi.R
import com.example.bmi.presentation.BMIViewModel
import com.example.bmi.ui.theme.Blue

@Composable
fun SetValue(
    name: String,
    modifier: Modifier = Modifier,
    viewModel: BMIViewModel = viewModel()
) {
    val state by viewModel.state.collectAsState()

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
            Text(
                text = name,
                style = MaterialTheme.typography.bodyLarge,
              //  color = Color(0xFF2F2E41)
            )
            Text(
                text = if (name == "Weight (KG)") state.weight.toString() else state.age.toString(),
                style = MaterialTheme.typography.displayLarge,
                fontWeight = FontWeight.Bold,
                color = Blue
            )
            Row(
                horizontalArrangement = Arrangement.SpaceBetween,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 16.dp)
            ) {

                IconButton(
                    onClick = {
                        if (name == "Weight (KG)") viewModel.decreaseWeight() else viewModel.decreaseAge()
                    },
                    modifier = Modifier
                        .size(50.dp)
                        .clip(CircleShape)
                        .background(Blue)
                ) {
                    Icon(
                        painter = painterResource(R.drawable.baseline_remove_24),
                        contentDescription = "Minus",
                        tint = Color.White,
                        modifier = Modifier.fillMaxSize(0.8f)
                    )
                }
                IconButton(
                    onClick = {
                        if (name == "Weight (KG)") viewModel.increaseWeight() else viewModel.increaseAge()
                    },
                    modifier = Modifier
                        .size(50.dp)
                        .clip(CircleShape)
                        .background(Blue)
                ) {
                    Icon(
                        imageVector = Icons.Filled.Add,
                        contentDescription = "Add",
                        tint = Color.White,
                        modifier = Modifier.fillMaxSize(0.8f)
                    )
                }
            }
        }
    }
}

@Preview
@Composable
private fun SetValuePrev() {
    SetValue(
        "age" ,
        modifier = Modifier
        .size(200.dp)

    )
}