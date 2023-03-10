package com.wazzii_tech.calculator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.AutoCompleteTextView
import com.wazzii_tech.calculator.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }


    override fun onStart() {
        super.onStart()

        val items = Constants.optionMenu
        val adapter = ArrayAdapter(baseContext, R.layout.list_item, items)
        (binding.selection as? AutoCompleteTextView)?.setAdapter(adapter)

    }






    fun hasValidInput(chosen:Int) =
        when(chosen){
            0 -> validDecimal()
            1 -> validBinary()
            2 -> validHex()
            else -> validOctal()
        }





    private fun validDecimal() = binding.editText.toString().isNotEmpty() &&
            binding.editText.toString().matches("^[0-9]+\$".toRegex())

    private fun validHex() = binding.editText.toString().isNotEmpty() &&
            binding.editText.toString().matches("^[0-9a-fA-F]+\$".toRegex())

    private fun validBinary() = binding.editText.toString().isNotEmpty() &&
            binding.editText.toString().matches("^[0-1]+\$".toRegex())

    private fun validOctal() = binding.editText.toString().isNotEmpty() &&
            binding.editText.toString().matches("^0[0-7]+\$".toRegex())

}