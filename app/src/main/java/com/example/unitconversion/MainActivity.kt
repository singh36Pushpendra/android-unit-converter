package com.example.unitconversion

import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import androidx.appcompat.app.AppCompatActivity
import com.example.unitconversion.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        var binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.buttonConvertUnit.setOnClickListener {
            ConvertUnitButton().onClickOfIt(binding)
        }

        val parameters = arrayListOf<String>("Length", "Weight", "Volume")
        val arrayAdapterParameter =
            ArrayAdapter(applicationContext, R.layout.spinner_parameter, parameters)
        binding.spinnerParameters.adapter = arrayAdapterParameter

        val lengthUnits = arrayListOf<String>("CM", "Meter", "KM")
        val weightUnits = arrayListOf<String>("Gram", "KG", "Tonne")
        val volumeUnits = arrayListOf<String>("ML", "Liter", "Gallon")

        val arrayAdapterConverter =
            ArrayAdapter(applicationContext, R.layout.spinner_convert_fromto, lengthUnits)

        binding.spinnerConvertFrom.adapter = arrayAdapterConverter
        binding.spinnerConvertTo.adapter = arrayAdapterConverter

        binding.spinnerParameters.onItemSelectedListener =
            object : AdapterView.OnItemSelectedListener {
                override fun onItemSelected(p0: AdapterView<*>?, p1: View?, p2: Int, p3: Long) {

                    if (p2 == 0) {

                        val arrayAdapterConverter =
                            ArrayAdapter(
                                applicationContext,
                                R.layout.spinner_convert_fromto,
                                lengthUnits
                            )

                        binding.spinnerConvertFrom.adapter = arrayAdapterConverter
                        binding.spinnerConvertTo.adapter = arrayAdapterConverter
                    }
                    if (p2 == 1) {

                        val arrayAdapterConverter =
                            ArrayAdapter(
                                applicationContext,
                                R.layout.spinner_convert_fromto,
                                weightUnits
                            )

                        binding.spinnerConvertFrom.adapter = arrayAdapterConverter
                        binding.spinnerConvertTo.adapter = arrayAdapterConverter
                    }
                    if (p2 == 2) {

                        val arrayAdapterConverter =
                            ArrayAdapter(
                                applicationContext,
                                R.layout.spinner_convert_fromto,
                                volumeUnits
                            )

                        binding.spinnerConvertFrom.adapter = arrayAdapterConverter
                        binding.spinnerConvertTo.adapter = arrayAdapterConverter
                    }

                }

                override fun onNothingSelected(p0: AdapterView<*>?) {
                    TODO("Not yet implemented")
                }

            }

    }

}