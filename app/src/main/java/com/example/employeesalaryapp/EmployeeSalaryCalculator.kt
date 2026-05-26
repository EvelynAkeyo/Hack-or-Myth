package com.example.employeesalaryapp

/**
 * Class representing an Employee.
 * Named 'Employee' to distinguish it from the application name 'EmployeeSalaryApp'.
 */
class Employee(val name: String, val grossSalary: Double) {

    /**
     * Calculates the net salary based on the following tax rules:
     * - 0 to 10,000: 5% tax
     * - 10,001 to 30,000: 7% tax
     * - Above 30,000: 10% tax
     */
    fun calculateNetSalary(): Double {
        val taxPercentage = when {
            grossSalary <= 10000 -> 0.05
            grossSalary <= 30000 -> 0.07
            else -> 0.10
        }
        
        val taxAmount = grossSalary * taxPercentage
        return grossSalary - taxAmount
    }
}
