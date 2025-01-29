package com.example.bmi.presentation.home

import com.example.bmi.domain.BMI

data class BMIState(
    val height: Float = 0f, // Default height
    val age: Int = 19, // Default age
    val weight: Int = 60, // Default weight
    val bmiResult: BMI? = null, // BMI calculation result
)
