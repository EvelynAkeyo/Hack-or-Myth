package com.example.employeesalaryapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import java.util.Locale

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val etEmployeeName = findViewById<EditText>(R.id.etEmployeeName)
        val etSalary = findViewById<EditText>(R.id.etSalary)
        val btnCalculate = findViewById<Button>(R.id.btnCalculate)
        val btnClear = findViewById<Button>(R.id.btnClear)
        val tvResult = findViewById<TextView>(R.id.tvResult)

        btnCalculate.setOnClickListener {
            val name = etEmployeeName.text.toString()
            val salaryStr = etSalary.text.toString()

            if (name.isNotEmpty() && salaryStr.isNotEmpty()) {
                val salary = salaryStr.toDoubleOrNull() ?: 0.0
                
                // Initiating the class
                val employee = Employee(name, salary)
                val netSalary = employee.calculateNetSalary()

                tvResult.text = String.format(
                    Locale.getDefault(),
                    "Employee: %s\nGross Salary: %.2f\nNet Salary: %.2f",
                    employee.name, employee.salary, netSalary
                )
            } else {
                tvResult.text = "Please enter both name and salary."
            }
        }

        btnClear.setOnClickListener {
            etEmployeeName.text.clear()
            etSalary.text.clear()
            tvResult.text = ""
        }
    }
}
