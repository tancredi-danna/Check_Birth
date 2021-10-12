package com.example.check_birth.age

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

import com.example.check_birth.databinding.AgeActivityMainBinding
import java.util.*

class AgeActivity : AppCompatActivity() {

    lateinit var mBinding: AgeActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mBinding = AgeActivityMainBinding.inflate(layoutInflater)
        setContentView(mBinding.root)

        mBinding.materialButton.setOnClickListener {
            mBinding.textView3.text = ""
            try {
                val birthDate = mBinding.editTextDate.text.toString().toInt()
                findAge(birthDate)

            } catch (e: NumberFormatException) {

            }


        }
    }

    @SuppressLint("SetTextI18n")
    private fun findAge(birth: Int) {
        val year = Calendar.getInstance().get(Calendar.YEAR)
        val age = year - birth
        mBinding.textView3.text = " Your age is: ${age.toString()}"


    }
}