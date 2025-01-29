
package com.example.bmi

import com.example.bmi.presentation.BMIViewModel
import org.junit.Assert.assertEquals
import org.junit.Assert.assertNotNull
import org.junit.Assert.assertNull
import org.junit.Before
import org.junit.Test

class BMIViewModelTest {

    private lateinit var viewModel: BMIViewModel

    @Before
    fun setUp() {
        viewModel = BMIViewModel()
    }

    @Test
    fun bmiViewModel_Initialization_DefaultState() {
        val initialState = viewModel.state.value

        // Assert that initial height is 0
        assertEquals(0f, initialState.height)
        // Assert that initial weight is 60
        assertEquals(60, initialState.weight)
        // Assert that initial age is 19
        assertEquals(19, initialState.age)
        // Assert that initial BMI result is null
        assertNull(initialState.bmiResult)
    }

    @Test
    fun bmiViewModel_UpdateHeight_HeightUpdated() {
        val newHeight = 170f

        viewModel.updateHeight(newHeight)
        val updatedState = viewModel.state.value

        // Assert that height is updated correctly
        assertEquals(newHeight, updatedState.height)
    }

    @Test
    fun bmiViewModel_IncreaseWeight_WeightIncreased() {
        viewModel.increaseWeight()
        val updatedState = viewModel.state.value

        // Assert that weight is increased by 1 (from 60 to 61)
        assertEquals(61, updatedState.weight)
    }

    @Test
    fun bmiViewModel_DecreaseWeight_WeightDecreased() {
        // Set initial weight to 62 (60 + 2)
        viewModel.increaseWeight()
        viewModel.increaseWeight()

        viewModel.decreaseWeight()
        val updatedState = viewModel.state.value

        // Assert that weight is decreased by 1 (from 62 to 61)
        assertEquals(61, updatedState.weight)
    }

    @Test
    fun bmiViewModel_DecreaseWeight_WeightNotNegative() {
        // Set initial weight to 60 and decrease it 61 times
        repeat(61) {
            viewModel.decreaseWeight()
        }
        val updatedState = viewModel.state.value

        // Assert that weight does not go below 0
        assertEquals(0, updatedState.weight)
    }

    @Test
    fun bmiViewModel_IncreaseAge_AgeIncreased() {
        viewModel.increaseAge()
        val updatedState = viewModel.state.value

        // Assert that age is increased by 1 (from 19 to 20)
        assertEquals(20, updatedState.age)
    }

    @Test
    fun bmiViewModel_DecreaseAge_AgeDecreased() {
        // Set initial age to 21 (19 + 2)
        viewModel.increaseAge()
        viewModel.increaseAge()

        viewModel.decreaseAge()
        val updatedState = viewModel.state.value

        // Assert that age is decreased by 1 (from 21 to 20)
        assertEquals(20, updatedState.age)
    }

    @Test
    fun bmiViewModel_DecreaseAge_AgeNotNegative() {
        // Set initial age to 19 and decrease it 20 times
        repeat(20) {
            viewModel.decreaseAge()
        }
        val updatedState = viewModel.state.value

        // Assert that age does not go below 0
        assertEquals(0, updatedState.age)
    }

    @Test
    fun bmiViewModel_CalculateBMI_ValidInput_BMIResultUpdated() {
        // Set height to 170 cm and weight to 60 kg
        viewModel.updateHeight(170f)

        // Calculate BMI
        viewModel.calculateBMI()
        val updatedState = viewModel.state.value

        // Assert that BMI result is not null
        assertNotNull(updatedState.bmiResult)
        // Assert that BMI value is calculated correctly
        updatedState.bmiResult?.let { assertEquals(20.76, it.value, 0.01) } // Allowing a small delta for floating-point precision
    }

    @Test
    fun bmiViewModel_CalculateBMI_InvalidInput_BMIResultInvalid() {
        // Set invalid height (0)
        viewModel.updateHeight(0f)

        viewModel.calculateBMI()
        val updatedState = viewModel.state.value

        // Assert that BMI result is marked as invalid
        assertEquals("Invalid input", updatedState.bmiResult?.category)
    }

    @Test
    fun bmiViewModel_DismissDialog_BMIResultCleared() {
        // Set BMI result
        viewModel.updateHeight(170f)
        viewModel.calculateBMI()

        // Dismiss the dialog
        viewModel.dismissDialog()
        val updatedState = viewModel.state.value

        // Assert that BMI result is cleared
        assertNull(updatedState.bmiResult)
    }
}
