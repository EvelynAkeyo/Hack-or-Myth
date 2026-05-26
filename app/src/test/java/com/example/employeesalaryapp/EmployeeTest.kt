package com.example.employeesalaryapp

import org.junit.Test
import org.junit.Assert.*

class EmployeeTest {

    @Test
    fun calculateNetSalary_lowBracket_isCorrect() {
        // 5% tax for 10,000 or less
        val employee = Employee("Test", 10000.0)
        // 10,000 - (10,000 * 0.05) = 9,500
        assertEquals(9500.0, employee.calculateNetSalary(), 0.01)
    }

    @Test
    fun calculateNetSalary_midBracket_isCorrect() {
        // 7% tax for 10,001 to 30,000
        val employee = Employee("Test", 20000.0)
        // 20,000 - (20,000 * 0.07) = 18,600
        assertEquals(18600.0, employee.calculateNetSalary(), 0.01)
    }

    @Test
    fun calculateNetSalary_highBracket_isCorrect() {
        // 10% tax for above 30,000
        val employee = Employee("Test", 40000.0)
        // 40,000 - (40,000 * 0.10) = 36,000
        assertEquals(36000.0, employee.calculateNetSalary(), 0.01)
    }
}
