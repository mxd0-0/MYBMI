package com.example.bmi.presentation

import androidx.lifecycle.ViewModel
import com.example.bmi.domain.BMI
import com.example.bmi.domain.BMICalculator
import com.example.bmi.presentation.home.BMIState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow

class BMIViewModel : ViewModel() {

    // State for all UI data
    private val _state = MutableStateFlow(BMIState())
    val state: StateFlow<BMIState> = _state.asStateFlow()

    private val bmiCalculator = BMICalculator()

    // Update height from the slider
    fun updateHeight(newHeight: Float) {
        _state.value = _state.value.copy(height = newHeight)
    }

    // Increase weight
    fun increaseWeight() {
        _state.value = _state.value.copy(weight = _state.value.weight + 1)
    }

    // Decrease weight
    fun decreaseWeight() {
        if (_state.value.weight > 0) {
            _state.value = _state.value.copy(weight = _state.value.weight - 1)
        }
    }

    // Update selected gender


    // Calculate BMI using weight and current height
    fun calculateBMI() {
        try {
            val weightValue = _state.value.weight.toDouble()
            val heightValue = _state.value.height.toDouble()
            val bmi = bmiCalculator.calculateBMI(weightValue, heightValue)
            _state.value = _state.value.copy(bmiResult = bmi)
        } catch (e: Exception) {
            _state.value = _state.value.copy(
                bmiResult = BMI(0.0, "Invalid input"),

            )
        }
    }
    fun dismissDialog() {
        _state.value = _state.value.copy(bmiResult = null)
    }
    fun increaseAge() {
        _state.value = _state.value.copy(age = _state.value.age + 1)
    }


    fun decreaseAge() {
        if (_state.value.age > 0) {
            _state.value = _state.value.copy(age = _state.value.age - 1)
        }
    }

}