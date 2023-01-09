package com.example.unitconversion

import android.os.Bundle
import android.view.View
import android.view.View.GONE
import android.view.View.VISIBLE
import android.widget.AdapterView
import android.widget.ArrayAdapter
import androidx.appcompat.app.AppCompatActivity
import com.example.unitconversion.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        with(binding) {
            buttonAddQuantity.setOnClickListener {

                if (layoutAddition.visibility == GONE) {
                    textViewResult.hint = "Enter Quantity"
                    textViewResult.isEnabled = true
                    layoutAddition.visibility = VISIBLE
                    buttonConvertOrAddUnits.text = "Add Units"
                    buttonAddQuantity.text = "Hide Add Quantity"
                }
                else {
                    textViewResult.hint = "Result"
                    textViewResult.setText("")
                    textViewResult.isEnabled = false
                    layoutAddition.visibility = GONE
                    buttonConvertOrAddUnits.text = "Convert Unit"
                    buttonAddQuantity.text = "Add Quantity"
                }
            }
        }

        binding.buttonConvertOrAddUnits.setOnClickListener {
            with(binding) {

                if (layoutAddition.visibility == GONE) {
                    ConvertUnitButton().onClickOfIt(this)
                }
                else {
                    AddUnitsButton().onClickOfIt(this)
                }
            }

        }

        val parameters = arrayListOf<String>("Length", "Weight", "Volume")
        val arrayAdapterParameter =
            ArrayAdapter(applicationContext, R.layout.spinner_parameter, parameters)
        binding.spinnerParameters.adapter = arrayAdapterParameter

        binding.spinnerParameters.onItemSelectedListener =
            object : AdapterView.OnItemSelectedListener {
                override fun onItemSelected(p0: AdapterView<*>?, p1: View?, p2: Int, p3: Long) {
                    val arrayListOfUnits: ArrayList<String> = getListOfUnits(p2)
                    with(binding) {
                        textViewResult.setText("")
                        textViewAddResult.setText("")
                    }

                    val arrayAdapterConverter =
                        ArrayAdapter(
                            applicationContext,
                            R.layout.spinner_convert_fromto,
                            arrayListOfUnits
                        )

                    binding.spinnerConvertFrom.adapter = arrayAdapterConverter
                    binding.spinnerConvertTo.adapter = arrayAdapterConverter
                    binding.spinnerAddInUnit.adapter = arrayAdapterConverter

                }

                override fun onNothingSelected(p0: AdapterView<*>?) {
                    TODO("Not yet implemented")
                }

            }
    }

    companion object {
        fun getListOfUnits(p2: Int): ArrayList<String> =
            if (p2 == 0) arrayListOf<String>("CM", "Meter", "KM")
            else if (p2 == 1) arrayListOf<String>("Gram", "KG", "Tonne")
            else arrayListOf<String>("ML", "Liter", "Gallon")
    }
}