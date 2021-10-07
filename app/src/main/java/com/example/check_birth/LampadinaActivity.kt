package com.example.check_birth

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.example.check_birth.databinding.LampadinaActivityBinding

class LampadinaActivity: AppCompatActivity() {
    lateinit var mBinding : LampadinaActivityBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mBinding = LampadinaActivityBinding.inflate(layoutInflater)
        setContentView(mBinding.root)
        mBinding.interruttore.setOnCheckedChangeListener { _, isChecked ->

            if(isChecked){
                mBinding.lampaSpenta.setColorFilter(resources.getColor(R.color.yellow))

            }else{
                mBinding.lampaSpenta.setColorFilter(null)
            }

        }
    }
}