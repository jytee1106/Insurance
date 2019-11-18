package com.example.insurance

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*
import java.util.*

class MainActivity : AppCompatActivity(),
    AdapterView.OnItemSelectedListener {
    override fun onNothingSelected(parent: AdapterView<*>?) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
        Toast.makeText(this,"Position :"+ position,Toast.LENGTH_LONG).show()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        spinnerAge.onItemSelectedListener = this
        buttonCalculate.setOnClickListener {
            calculatePremium()
        }
    }

    private fun calculatePremium() {
        val position = spinnerAge.selectedItemPosition
        val age = spinnerAge.getChildAt(position)
        val gender = radioGroupGender.checkedRadioButtonId
        var basic_premium: Int = 0
        val symbol = Currency.getInstance(Locale.getDefault()).symbol

        basic_premium = when(position){
            0 -> 60
            1 -> 70
            2 -> 90
            3 -> 120
            else -> 150
        }


        if(gender == R.id.radioButtonMale){
            //TODO calculate premium for male
            when (position){
                0 -> basic_premium
                1 -> basic_premium += 50
                2 -> basic_premium += 100
                3 -> basic_premium += 150
                else -> basic_premium += 200
            }
        }

        if(checkBoxSmoker.isChecked){
            //TODO calculate premium for smoke
            when (position){
                0 -> basic_premium
                1 -> basic_premium += 100
                2 -> basic_premium += 150
                3 -> basic_premium += 200
                4 -> basic_premium += 250
                5 -> basic_premium += 300
            }
        }

        textViewInsurancePremium.text = String.format("%s %s %d",getString(R.string.insurance_premium),symbol,basic_premium)
    }
}
