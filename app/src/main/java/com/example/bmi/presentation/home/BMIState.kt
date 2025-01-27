package com.example.bmi.presentation.home

import com.example.bmi.domain.BMI

data class BMIState(
    val height: Float = 100f, // Default height
    val age: Int = 18, // Default age
    val weight: Int = 78, // Default weight
    val bmiResult: BMI? = null, // BMI calculation result
)
