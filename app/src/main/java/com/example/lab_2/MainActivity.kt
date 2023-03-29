package com.example.lab_2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.appcompat.content.res.AppCompatResources
import androidx.constraintlayout.widget.ConstraintLayout
import com.example.lab_2.databinding.ActivityMainBinding
import kotlin.math.abs
import kotlin.math.sqrt

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view: ConstraintLayout = binding.root
        setContentView(view)
        binding.button.setOnClickListener{
            binding.res.setTextColor(AppCompatResources.getColorStateList(this, R.color.white))
            val a: Double = binding.A.text.toString().toDouble()
            val b: Double = binding.B.text.toString().toDouble()
            val c: Double = binding.C.text.toString().toDouble()
            val D = (b*b-4*a*c)
            if (D>0.0){
                if (a==0.0){
                    val x = -c/b
                    binding.res.text="Линейное уравнение,\nx=$x"
                }
                else{
                    val x1 = String.format("%.3f", ((-b + sqrt(D))/(2*a)))
                    val x2 = String.format("%.3f", ((-b - sqrt(D))/(2*a)))
                    binding.res.text="x1=$x1\nx2=$x2"
                }
            }
            else if (D==0.0){
                if (a==0.0 || c==0.0 && b==0.0){
                    binding.res.setTextColor(AppCompatResources.getColorStateList(this, R.color.red))
                    binding.res.text="На 0 делить нельзя"
                }
                else {
                    val x = String.format("%.3f",(-b/(2*a)))
                    binding.res.text="x1=x2=$x"
                }
            }
            else{
                binding.res.text="Корней нет"
            }
        }

    }
}