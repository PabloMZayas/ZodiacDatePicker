package com.example.zodiacdatepicker

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.zodiacdatepicker.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        binding = ActivityMainBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        //binding.btnDay.setOnClickListener { showPickerDateDialog() }
        //binding.btnMonth.setOnClickListener { showPickerDateDialog() }
        //binding.btnYear.setOnClickListener { showPickerDateDialog() }

        with(binding){
            binding.btnDay.setOnClickListener { showPickerDateDialog() }
            binding.btnMonth.setOnClickListener { showPickerDateDialog() }
            binding.btnYear.setOnClickListener { showPickerDateDialog() }
        }
    }

    private fun showPickerDateDialog() {
        val picker = DatePickerFragment { day, month, year -> onDaySelected(day, month, year) }
        picker.show(supportFragmentManager, "datePicker")
    }

    fun onDaySelected(day: Int, month: Int, year: Int) {
        val monthString = changeIntToMonths(month)
        binding.btnDay.setText("$day")
        binding.btnMonth.setText("$monthString")
        binding.btnYear.setText("$year")
        val zodiacSign = showingZodiac(day, month)
        val compatible = showCompatibleSigns(zodiacSign)
        binding.tvYourSignIs.text = "Tu signo zodiacal es $zodiacSign, los signos más compatibles contigo son $compatible"
        showingZodiac(day, month)
    }

    private fun showCompatibleSigns(zodiacSign: String): String {
        return when(zodiacSign){
            "Capricornio" -> "Tauro, Virgo y Escorpio"
            "Leo" -> "Libra, Sagitario y Aries"
            "Cáncer" -> "Virgo, Escorpio y Tauro"
            "Aries" -> "Géminis, Acuario, Leo y Tauro"
            "Libra" -> "Leo y Sagitario"
            "Piscis" -> "Géminis, Sagitario y Leo"
            "Tauro" -> "Capricornio, Piscis y Virgo"
            "Virgo" -> "Cáncer, Tauro y Capricornio"
            "Géminis" -> "Acuario y Libra"
            "Acuario" -> "Cáncer y Tauro"
            "Escorpio" -> "Cáncer, Piscis y Capricornio"
            else -> "Acuario y Libra"
        }
    }

    private fun changeIntToMonths(month: Int): String{
        return when (month) {
            0 -> "ene"
            1 -> "feb"
            2 -> "mar"
            3 -> "abril"
            4 -> "may"
            5 -> "jun"
            6 -> "jul"
            7 -> "ago"
            8 -> "sept"
            9 -> "oct"
            10 -> "nov"
            else -> "dec"
        }
    }

    private fun showingZodiac(day: Int, month: Int) : String{
        //Aries (21 de marzo al 19 de abril)
        //Tauro (20 de abril al 20 de mayo)
        //Géminis (21 de mayo al 20 de junio)
        //Cáncer (21 de junio al 22 de julio)
        //Leo (23 de julio al 22 de agosto)
        //Virgo (23 de agosto al 22 de septiembre)
        //Libra (23 de septiembre al 22 de octubre)
        //Escorpio (23 de octubre al 21 de noviembre)
        //Sagitario (22 de noviembre al 21 de diciembre)
        //Capricornio (22 de diciembre al 19 de enero)
        //Acuario (20 de enero al 18 de febrero)
        //Piscis (19 de febrero al 20 de marzo)
        return when (month) {
            0 -> {
                if (day < 20)
                    "Capricornio"
                else
                    "Acuario"
            }
            1 -> {
                if (day < 19)
                    "Acuario"
                else
                    "Piscis"
            }
            2 -> {
                if (day < 21)
                    "Piscis"
                else
                    "Aries"
            }
            3 -> {
                if (day < 20)
                    "Aries"
                else
                    "Tauro"
            }
            4 -> {
                if (day < 22)
                    "Tauro"
                else
                    "Géminis"
            }
            5 -> {
                if (day < 21)
                    "Géminis"
                else
                    "Cáncer"
            }
            6 -> {
                if (day < 24)
                    "Cáncer"
                else
                    "Leo"
            }
            7 -> {
                if (day < 23)
                    "Leo"
                else
                    "Virgo"
            }
            8 -> {
                if (day < 20)
                    "Virgo"
                else
                    "Libra"
            }
            9 -> {
                if (day < 20)
                    "Libra"
                else
                    "Escorpio"
            }
            10 -> {
                if (day < 22)
                    "Escorpio"
                else
                    "Sagitario"
            }
            else -> {
                if (day < 20)
                    "Sagitario"
                else
                    "Capricornio"
            }
        }
    }
}