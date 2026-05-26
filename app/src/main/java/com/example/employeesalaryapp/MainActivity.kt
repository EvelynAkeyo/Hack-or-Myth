package com.example.employeesalaryapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.animation.AnimationUtils
import android.widget.*
import androidx.appcompat.app.AlertDialog
import com.google.android.material.card.MaterialCardView
import com.google.android.material.textfield.TextInputEditText
import com.google.android.material.textfield.TextInputLayout
import java.util.Locale

class MainActivity : AppCompatActivity() {

    private val historyList = mutableListOf<String>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // UI references
        val tilName = findViewById<TextInputLayout>(R.id.tilName)
        val tilSalary = findViewById<TextInputLayout>(R.id.tilSalary)
        val etEmployeeName = findViewById<TextInputEditText>(R.id.etEmployeeName)
        val etSalary = findViewById<TextInputEditText>(R.id.etSalary)
        val btnCalculate = findViewById<Button>(R.id.btnCalculate)
        val btnClear = findViewById<Button>(R.id.btnClear)
        val btnInfo = findViewById<ImageButton>(R.id.btnInfo)
        val btnShare = findViewById<ImageButton>(R.id.btnShare)
        val spinnerCurrency = findViewById<Spinner>(R.id.spinnerCurrency)
        val cardResult = findViewById<MaterialCardView>(R.id.cardResult)
        val tvResultDetails = findViewById<TextView>(R.id.tvResultDetails)
        val tvHistory = findViewById<TextView>(R.id.tvHistory)

        // 1. Info Button Popup
        btnInfo.setOnClickListener {
            AlertDialog.Builder(this)
                .setTitle(R.string.tax_table_title)
                .setMessage(R.string.tax_table_message)
                .setPositiveButton("OK", null)
                .show()
        }

        btnCalculate.setOnClickListener {
            val name = etEmployeeName.text.toString().trim()
            val salaryInput = etSalary.text.toString().trim()
            val selectedCurrency = spinnerCurrency.selectedItem.toString().take(1)

            tilName.error = null
            tilSalary.error = null

            if (name.isBlank()) {
                tilName.error = getString(R.string.error_name_required)
                return@setOnClickListener
            }

            if (salaryInput.isBlank()) {
                tilSalary.error = getString(R.string.error_salary_required)
                return@setOnClickListener
            }

            val salaryValue = salaryInput.toDoubleOrNull()
            if (salaryValue == null || salaryValue < 0) {
                tilSalary.error = getString(R.string.error_invalid_salary)
                return@setOnClickListener
            }

            // Calculations
            val employee = Employee(name, salaryValue)
            val calculator = EmployeeSalaryCalculator()
            
            val taxRate = calculator.getTaxPercentage(employee.grossSalary)
            val taxAmount = calculator.calculateTaxAmount(employee.grossSalary)
            val netSalary = calculator.calculateNetSalary(employee.grossSalary)

            // Result Display
            val resultText = String.format(
                Locale.getDefault(),
                "Name: %s\nGross Salary: %s%.2f\nTax Rate: %.0f%%\nTax Amount: %s%.2f\n-----------------------\nNet Salary: %s%.2f",
                employee.name, selectedCurrency, employee.grossSalary, taxRate * 100, selectedCurrency, taxAmount, selectedCurrency, netSalary
            )

            tvResultDetails.text = resultText
            
            // 3. Animation: Slide up/Fade in
            cardResult.visibility = View.VISIBLE
            val animation = AnimationUtils.loadAnimation(this, android.R.anim.fade_in)
            cardResult.startAnimation(animation)

            // Add to history
            val summary = "Name: ${employee.name}\nNet: $selectedCurrency${String.format(Locale.getDefault(), "%.2f", netSalary)}"
            historyList.add(0, summary)
            updateHistoryView(tvHistory)
        }

        // 4. Share History
        btnShare.setOnClickListener {
            if (historyList.isEmpty()) {
                Toast.makeText(this, "No history to share", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            val shareContent = historyList.joinToString("\n\n")
            val sendIntent = Intent().apply {
                action = Intent.ACTION_SEND
                putExtra(Intent.EXTRA_TEXT, shareContent)
                putExtra(Intent.EXTRA_TITLE, getString(R.string.share_history_title))
                type = "text/plain"
            }
            val shareIntent = Intent.createChooser(sendIntent, null)
            startActivity(shareIntent)
        }

        btnClear.setOnClickListener {
            etEmployeeName.text?.clear()
            etSalary.text?.clear()
            tilName.error = null
            tilSalary.error = null
            cardResult.visibility = View.GONE
            Toast.makeText(this, getString(R.string.msg_fields_cleared), Toast.LENGTH_SHORT).show()
        }
    }

    private fun updateHistoryView(tvHistory: TextView) {
        if (historyList.isEmpty()) {
            tvHistory.text = getString(R.string.text_no_history)
        } else {
            tvHistory.text = historyList.take(5).joinToString("\n\n")
        }
    }
}
