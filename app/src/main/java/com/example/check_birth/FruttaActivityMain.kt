package com.example.check_birth

import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.lifecycle.lifecycleScope
import com.bumptech.glide.Glide
import com.example.check_birth.databinding.StandFruttaLayoutBinding
import kotlinx.coroutines.*

class FruttaActivityMain:AppCompatActivity() {
    val listaFrutta:ArrayList<Frutta> = arrayListOf()
    lateinit var mBinding: StandFruttaLayoutBinding

    @DelicateCoroutinesApi
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mBinding = StandFruttaLayoutBinding.inflate(layoutInflater)
        setContentView(mBinding.root)
        fillFrutta()

        mBinding.button.setOnClickListener {
            if(mBinding.imageView.visibility == View.VISIBLE){
                this.lifecycleScope.launch {
                    mBinding.imageView.visibility = View.GONE
                    mBinding.progress.visibility = View.VISIBLE
                    delay(2000)
                }.invokeOnCompletion { cause ->
                    val rnds = (0..4).random()
                    Glide.with(this@FruttaActivityMain).load(listaFrutta.get(rnds).imgUrl).into(mBinding.imageView)
                    mBinding.imageView.visibility = View.VISIBLE
                }
            }
        }
    }
    private fun fillFrutta(){
        val mela = Frutta("Mela","https://upload.wikimedia.org/William_Henry_Harrison_daguerreotype_edit.jpg")
        val banana = Frutta("Banana","https://upload.wikimedia.org/wikipedia/commons/thumb/4/43/Andrew_jackson_head.jpg/248px-Andrew_jackson_head.jpg")
        val pesca = Frutta("Pesca", "https://upload.wikimedia.org/wikipedia/commons/thumb/9/94/Martin_Van_Buren_edit.jpg/240px-Martin_Van_Buren_edit.jpg")
        val anguria = Frutta("Anguria","https://upload.wikimedia.org/wikipedia/commons/thumb/c/c5/William_Henry_Harrison_daguerreotype_edit.jpg/240px-William_Henry_Harrison_daguerreotype_edit.jpg")
        val ananas = Frutta("Ananas","https://upload.wikimedia.org/wikipedia/commons/thumb/1/1d/John_Tyler%2C_Jr.jpg/240px-John_Tyler%2C_Jr.jpg")
        listaFrutta.addAll(arrayListOf(mela,banana,pesca,anguria,ananas))
    }
}