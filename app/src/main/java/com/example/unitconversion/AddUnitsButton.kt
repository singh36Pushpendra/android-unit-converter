package com.example.unitconversion

import android.widget.EditText
import android.widget.Spinner
import com.example.unitconversion.databinding.ActivityMainBinding

class AddUnitsButton {
    fun onClickOfIt(binding: ActivityMainBinding) {
        with(binding) {
            val quantity1: Double = convertToAddInUnit(this, spinnerAddInUnit, spinnerConvertFrom, editTextQuantity)
            val quantity2: Double = convertToAddInUnit(this, spinnerAddInUnit, spinnerConvertTo, textViewResult)
            textViewAddResult.setText("${quantity1 + quantity2}")
        }
    }

    private fun convertToAddInUnit(binding: ActivityMainBinding, addInSpinner: Spinner, convertSpinner: Spinner, quantityEditText: EditText): Double {

        val parametersSpinner = binding.spinnerParameters

        val convertSpinnerValue = convertSpinner.selectedItem.toString()
        val quantity: Double = quantityEditText.text.toString().toDouble()

        addInSpinner.let {
            with(parametersSpinner.selectedItem.toString()) {
                if (this == "Length")
                    when (it.selectedItem) {
                        "CM" -> {
                            when (convertSpinnerValue) {
                                "CM" -> return quantity
                                "Meter" -> return (quantity * 100)
                                "KM" -> return (quantity * 1000 * 100)
                            }
                        }
                        "Meter" -> {
                            when (convertSpinnerValue) {
                                "CM" -> return (quantity / 100)
                                "Meter" -> return quantity
                                "KM" -> return (quantity * 1000)
                            }
                        }
                        "KM" -> {
                            when (convertSpinnerValue) {
                                "CM" -> return (quantity / 100000)
                                "Meter" -> return (quantity / 1000)
                                "KM" -> return quantity
                            }
                        }
                    }
                else if (this == "Weight")
                    when (it.selectedItem) {
                        "Gram" -> {
                            when (convertSpinnerValue) {
                                "Gram" -> return quantity
                                "KG" -> return (quantity * 1000)
                                "Tonne" -> return (quantity * 1000 * 1000)
                            }
                        }
                        "KG" -> {
                            when (convertSpinnerValue) {
                                "Gram" -> return (quantity / 1000)
                                "KG" -> return quantity
                                "Tonne" -> return (quantity * 1000)
                            }
                        }
                        "Tonne" -> {
                            when (convertSpinnerValue) {
                                "Gram" -> return (quantity / 1000000)
                                "KG" -> return (quantity / 1000)
                                "Tonne" -> return quantity
                            }
                        }
                    }
                else if (this == "Volume")
                    when (it.selectedItem) {
                        "ML" -> {
                            when (convertSpinnerValue) {
                                "ML" -> return quantity
                                "Liter" -> return (quantity * 1000)
                                "Gallon" -> return (quantity * 1000 * 3.78541)
                            }
                        }
                        "Liter" -> {
                            when (convertSpinnerValue) {
                                "ML" -> return (quantity / 1000)
                                "Liter" -> return quantity
                                "Gallon" -> return (quantity * 3.78541)
                            }
                        }
                        "Gallon" -> {
                            when (convertSpinnerValue) {
                                "ML" -> return (quantity / (1000 * 3.78541))
                                "Liter" -> return (quantity / 3.78541)
                                "Gallon" -> return quantity
                            }
                        }
                    }
            }
        }

        return 0.0
    }
}