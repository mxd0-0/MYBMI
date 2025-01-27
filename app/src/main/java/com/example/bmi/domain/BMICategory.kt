package com.example.bmi.domain

enum class BMICategory(val range: ClosedRange<Double>, val description: String) {
    UNDERWEIGHT(0.0..18.4, "Underweight"),
    NORMAL(18.5..24.9, "Normal"),
    OVERWEIGHT(25.0..29.9, "Overweight"),
    OBESE(30.0..Double.MAX_VALUE, "Obese");

    companion object {
        fun fromBMI(bmi: Double): BMICategory {
            return entries.first { bmi in it.range }
        }
    }
}