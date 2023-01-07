package com.example.unitconversion

import com.example.unitconversion.databinding.ActivityMainBinding

class ConvertUnitButton {
    fun onClickOfIt(binding: ActivityMainBinding) {

        val parametersSpinner = binding.spinnerParameters
        val convertFromSpinner = binding.spinnerConvertFrom
        val convertToSpinner = binding.spinnerConvertTo
        val quantityEditText = binding.editTextQuantity
        val resultTextView = binding.textViewResult

        val convertFromSpinnerValue = convertFromSpinner.selectedItem
        val quantity: Double = quantityEditText.text.toString().toDouble()

        convertToSpinner.let {
            with(parametersSpinner.selectedItem) {
                if (this.equals("Length"))
                    when (it.selectedItem) {
                        "CM" -> {
                            if (convertFromSpinnerValue.equals("CM"))
                                resultTextView.setText(quantity.toString())
                            else if (convertFromSpinnerValue.equals("Meter"))
                                resultTextView.setText((quantity * 100).toString())
                            else if (convertFromSpinnerValue.equals("KM"))
                                resultTextView.setText((quantity * 1000 * 100).toString())
                        }
                        "Meter" -> {
                            if (convertFromSpinnerValue.equals("CM"))
                                resultTextView.setText((quantity / 100).toString())
                            else if (convertFromSpinnerValue.equals("Meter"))
                                resultTextView.setText(quantity.toString())
                            else if (convertFromSpinnerValue.equals("KM"))
                                resultTextView.setText((quantity * 1000).toString())
                        }
                        "KM" -> {
                            if (convertFromSpinnerValue.equals("CM"))
                                resultTextView.setText((quantity / 100000).toString())
                            else if (convertFromSpinnerValue.equals("Meter"))
                                resultTextView.setText((quantity / 1000).toString())
                            else if (convertFromSpinnerValue.equals("KM"))
                                resultTextView.setText(quantity.toString())
                        }
                    }
                else if (this.equals("Weight"))
                    when (it.selectedItem) {
                        "Gram" -> {
                            if (convertFromSpinnerValue.equals("Gram"))
                                resultTextView.setText(quantity.toString())
                            else if (convertFromSpinnerValue.equals("KG"))
                                resultTextView.setText((quantity * 1000).toString())
                            else if (convertFromSpinnerValue.equals("Tonne"))
                                resultTextView.setText((quantity * 1000 * 1000).toString())
                        }
                        "KG" -> {
                            if (convertFromSpinnerValue.equals("Gram"))
                                resultTextView.setText((quantity / 1000).toString())
                            else if (convertFromSpinnerValue.equals("KG"))
                                resultTextView.setText(quantity.toString())
                            else if (convertFromSpinnerValue.equals("Tonne"))
                                resultTextView.setText((quantity * 1000).toString())
                        }
                        "Tonne" -> {
                            if (convertFromSpinnerValue.equals("Gram"))
                                resultTextView.setText((quantity / 1000000).toString())
                            else if (convertFromSpinnerValue.equals("KG"))
                                resultTextView.setText((quantity / 1000).toString())
                            else if (convertFromSpinnerValue.equals("Tonne"))
                                resultTextView.setText(quantity.toString())
                        }
                    }
                else if (this.equals("Volume"))
                    when (it.selectedItem) {
                        "ML" -> {
                            if (convertFromSpinnerValue.equals("ML"))
                                resultTextView.setText(quantity.toString())
                            else if (convertFromSpinnerValue.equals("Liter"))
                                resultTextView.setText((quantity * 1000).toString())
                            else if (convertFromSpinnerValue.equals("Gallon"))
                                resultTextView.setText((quantity * 1000 * 3.78541).toString())
                        }
                        "Liter" -> {
                            if (convertFromSpinnerValue.equals("ML"))
                                resultTextView.setText((quantity / 1000).toString())
                            else if (convertFromSpinnerValue.equals("Liter"))
                                resultTextView.setText(quantity.toString())
                            else if (convertFromSpinnerValue.equals("Gallon"))
                                resultTextView.setText((quantity * 3.78541).toString())
                        }
                        "Gallon" -> {
                            if (convertFromSpinnerValue.equals("ML"))
                                resultTextView.setText((quantity / (1000 * 3.78541)).toString())
                            else if (convertFromSpinnerValue.equals("Liter"))
                                resultTextView.setText((quantity / 3.78541).toString())
                            else if (convertFromSpinnerValue.equals("Gallon"))
                                resultTextView.setText(quantity.toString())
                        }
                    }
            }
        }
    }
}