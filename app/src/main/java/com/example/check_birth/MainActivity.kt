package com.example.check_birth

import android.os.Binder
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import com.example.check_birth.databinding.ActivityMainBinding
import java.time.Year
import java.util.*

class MainActivity : AppCompatActivity() {

    lateinit var mBinding:ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mBinding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(mBinding.root)

        mBinding.materialButton.setOnClickListener {
            mBinding.textView3.text =""
            try{
                val birthDate = mBinding.editTextDate.text.toString().toInt()
                findAge(birthDate)

            }catch (e:NumberFormatException){

            }



        }
    }
    private fun findAge(birth:Int){
        val year = Calendar.getInstance().get(Calendar.YEAR)
        val age = year-birth
        mBinding.textView3.text = " Your age is: ${age.toString()}"


    }
}