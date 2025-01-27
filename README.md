# BMI Calculator

![Cover](https://github.com/user-attachments/assets/bc446c0a-25ae-41e3-b0e5-237119a7472e)

## Overview

The BMI Calculator is an Android application built using Jetpack Compose. It allows users to calculate their Body Mass Index (BMI) based on their weight and height. The app provides a user-friendly interface to input weight, height, and age, and displays the BMI result along with the corresponding category.

## Features

- **Onboarding Screen**: A welcoming screen to introduce the app to new users.
- **Home Screen**: The main screen where users can input their weight, height, and age.
- **BMI Calculation**: Calculates BMI based on the input values and displays the result.
- **Result Dialog**: Shows the BMI result in a dialog with detailed information.
- **State Management**: Uses ViewModel and StateFlow for managing UI state.

## Project Structure

The project is organized into the following packages:

- `com.example.bmi`
  - **MainActivity.kt**: The entry point of the application.
- `com.example.bmi.domain`
  - **BMICalculator.kt**: Contains the logic for calculating BMI.
  - **BMICategory.kt**: Enum class for categorizing BMI results.
- `com.example.bmi.presentation`
  - **BMIViewModel.kt**: ViewModel for managing UI state.
  - **home**
    - **HomeScreen.kt**: Composable function for the home screen.
    - **BMIState.kt**: Data class representing the state of the home screen.
    - **components**
      - **HeightUi.kt**: Composable function for height input.
      - **ResultDialog.kt**: Composable function for displaying the BMI result.
      - **SetValue.kt**: Composable function for weight and age input.
  - **onboarding**
    - **OnBoardingScreen.kt**: Composable function for the onboarding screen.
- `com.example.bmi.navigation`
  - **BmiScreens.kt**: Enum class for defining navigation routes.

## Installation

1. Clone the repository:
   ```sh
   git clone https://github.com/yourusername/bmi-calculator.git
   ```
2. Open the project in Android Studio.
3. Build and run the project on an Android device or emulator.

## Usage

1. Launch the app.
2. Follow the onboarding instructions.
3. Input your weight, height, and age on the home screen.
4. Click the "Calculate BMI" button to see your BMI result.
5. The result will be displayed in a dialog with detailed information.

## Contributing

Contributions are welcome! Please follow these steps:

1. Fork the repository.
2. Create a new branch (`git checkout -b feature-branch`).
3. Make your changes.
4. Commit your changes (`git commit -m 'Add some feature'`).
5. Push to the branch (`git push origin feature-branch`).
6. Open a pull request.

## License

This project is licensed under the MIT License. See the `LICENSE` file for more details.

## Acknowledgements

- Jetpack Compose
- Android Studio
- Kotlin

---
