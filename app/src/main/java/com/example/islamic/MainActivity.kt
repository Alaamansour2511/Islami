package com.example.islamic

import android.os.Bundle
 import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.example.islamic.databinding.ActivityMainBinding
import com.example.islamic.ui.fragment.hadeth.HadethFragment
import com.example.islamic.ui.fragment.quran.QuranFragment
import com.example.islamic.ui.fragment.radio.RadioFragment
import com.example.islamic.ui.fragment.thebha.ThebhaFragment



class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding

     override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
         binding = ActivityMainBinding.inflate(layoutInflater)
         setContentView(binding.root)

       binding.navigationBar.setOnItemSelectedListener { item->
            when (item.itemId) {
                R.id.quran -> {
                    showTab(QuranFragment())
                }
                R.id.hadeth -> {
                    showTab(HadethFragment())

                }
                R.id.tasbeh -> {
                    showTab(ThebhaFragment())

                }
                R.id.radio -> {
                    showTab(RadioFragment())
                }
            }
            return@setOnItemSelectedListener true
        }
        binding.navigationBar.selectedItemId=R.id.quran



    }
    private fun showTab(fragment: Fragment) {
        supportFragmentManager
            .beginTransaction()
            .replace(R.id.fargment_contaner,fragment)
            .commit()
    }

}