package com.example.tiptime

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.RadioGroup
import android.widget.Switch
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    private lateinit var costOfService: EditText
    private lateinit var tipOptions: RadioGroup
    private lateinit var tipAmount: TextView
    private lateinit var calculate: Button
    private lateinit var roundTip: Switch
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        costOfService = findViewById(R.id.cost_of_service)
        calculate = findViewById(R.id.calculate_button)
        roundTip = findViewById(R.id.round_up_switch)
        tipOptions = findViewById(R.id.tip_options)
        tipAmount = findViewById(R.id.tip_amount)

        var tipOption = tipOptions.checkedRadioButtonId
        if (tipOption != -1) {
            when (tipOption) {
                R.id.option_twenty_percent -> {
                    tipOption = 20
                }

                R.id.option_eighteen_percent -> {
                    tipOption = 18
                }

                R.id.option_fifteen_percent -> {
                    tipOption = 15
                }

                else -> {
                    tipOption = 0
                }
            }
        }

        tipOptions.setOnCheckedChangeListener { _, checkedId ->
            when (checkedId) {
                R.id.option_twenty_percent -> {
                    tipOption = 20
                }

                R.id.option_eighteen_percent -> {
                    tipOption = 18
                }

                R.id.option_fifteen_percent -> {
                    tipOption = 15
                }

                else -> {
                    tipOption = 0
                }
            }
        }

        calculate.setOnClickListener {
            if (costOfService.text.isNotEmpty()) {
                val costOfService = costOfService.text.toString().toDouble()
                val tipPercent = tipOption.toString().toInt()
                val totalTip = (costOfService * tipPercent) / 100
                if (roundTip.isChecked) {
                    tipAmount.text = Math.round((costOfService + totalTip)).toString()
                } else {
                    tipAmount.text = (costOfService + totalTip).toString()
                }
            } else {
                tipAmount.text = getString(R.string.tip_amount)
            }
        }
    }
}