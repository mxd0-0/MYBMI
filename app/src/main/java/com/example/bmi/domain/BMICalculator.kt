package com.example.bmi.domain

class BMICalculator {

    fun calculateBMI(weight: Double,
                     height: Double): BMI {
        if (height <= 0 || weight <= 0) throw IllegalArgumentException("Weight and height must be positive values.")
        val bmiValue = weight / ((height / 100) * (height / 100))
        val category = BMICategory.fromBMI(bmiValue)
        return BMI(bmiValue, category.description)
    }
}


