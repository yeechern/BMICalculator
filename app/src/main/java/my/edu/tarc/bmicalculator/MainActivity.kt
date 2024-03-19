package my.edu.tarc.bmicalculator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import my.edu.tarc.bmicalculator.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.buttonCalculate.setOnClickListener{
            var weight: Float =binding.editTextNumberWeight.text.toString().toFloat()
            var height: Float =binding.editTextNumberHeight.text.toString().toFloat()

            var bmi: Float= weight / (height*height)

            if(bmi<18.5){
                binding.textViewDescribe.text="Underweight"
                binding.imageViewResult.setImageResource(R.drawable.under)
            }else if(bmi>=18.5 && bmi<25){
                binding.textViewDescribe.text="Normal"
                binding.imageViewResult.setImageResource(R.drawable.normal)
            }else if(bmi>25){
                binding.textViewDescribe.text="Overweight"
                binding.imageViewResult.setImageResource(R.drawable.over)
            }

            binding.textViewBMI.text = String.format("%.3f",bmi)
        }

        binding.buttonReset.setOnClickListener{
            binding.editTextNumberHeight.text.clear()
            binding.editTextNumberWeight.text.clear()
            binding.textViewBMI.text=""
            binding.textViewDescribe.text=""
            binding.imageViewResult.setImageResource(R.drawable.empty)

        }
    }

}