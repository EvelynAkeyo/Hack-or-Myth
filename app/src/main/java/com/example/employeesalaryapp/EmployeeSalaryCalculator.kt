package com.example.employeesalaryapp

/**
 * Logic class responsible for calculating salary deductions.
 * Named 'EmployeeSalaryCalculator' to be distinct from 'EmployeeSalaryApp'.
 */
class EmployeeSalaryCalculator {

    /**
     * Determines the tax percentage based on the gross salary:
     * 0-10,000 -> 5%
     * 10,001-30,000 -> 7%
     * > 30,000 -> 10%
     */
    fun getTaxPercentage(grossSalary: Double): Double {
        return when {
            grossSalary <= 10000 -> 0.05
            grossSalary <= 30000 -> 0.07
            else -> 0.10
        }
    }

    fun calculateTaxAmount(grossSalary: Double): Double {
        return grossSalary * getTaxPercentage(grossSalary)
    }

    fun calculateNetSalary(grossSalary: Double): Double {
        return grossSalary - calculateTaxAmount(grossSalary)
    }
}
