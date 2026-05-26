# EmployeeSalaryApp 📊

A modern, Material Design Android application that calculates employee net salary based on specific tax brackets.

## ✨ Features
*   **Dynamic Tax Calculation**: Automatically applies tax rates based on salary:
    *   0 - 10,000: **5% Tax**
    *   10,001 - 30,000: **7% Tax**
    *   Above 30,000: **10% Tax**
*   **Currency Selection**: Support for USD ($), EUR (€), and GBP (£).
*   **Material Design 3**: Modern UI using CardViews, Outlined TextFields, and smooth Fade-in animations.
*   **Calculation History**: Tracks the last 5 calculations locally.
*   **Share Functionality**: Export your calculation history to other apps (WhatsApp, Email, etc.).
*   **Input Validation**: Real-time error handling for empty or invalid inputs.

## 🛠️ Architecture
The project follows clean coding principles by separating concerns into different classes:
*   `Employee`: Data model for holding employee information.
*   `EmployeeSalaryCalculator`: Logic class dedicated to performing all tax and salary math.
*   `MainActivity`: Controller class managing the UI state and user interactions.

## 🚀 How to Run
1. Clone this repository.
2. Open the project in **Android Studio (Hedgehog or newer)**.
3. Run the app on a **Pixel 8 Emulator (API 34)**.

## 📸 Screenshots
*(Tip: You can drag your recorded video or screenshots into this section on GitHub!)*

---
Developed as a professional Android learning project.
