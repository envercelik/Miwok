package com.envercelik.miwok

import android.content.Intent
import android.media.MediaPlayer
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.envercelik.miwok.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding:ActivityMainBinding
    //private val mediaPlayer = MediaPlayer.create(this)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setListeners()




    }



    private fun setListeners() {

        val listOfClickAbleView = listOf<View>(
            binding.textViewPhrases,
            binding.textViewFamily,
            binding.textViewColors,
            binding.textViewNumbers
        )


        for (view in listOfClickAbleView) {

            view.setOnClickListener { changeActivity(it) }
        }

    }



    private fun changeActivity(it: View) {

        var intent:Intent? = null

        when(it.id) {

            R.id.text_view_numbers -> intent = Intent(this,NumbersActivity::class.java)
            R.id.text_view_family -> intent = Intent(this,FamilyMembersActivity::class.java)
            R.id.text_view_phrases -> intent = Intent(this,PhrasesActivity::class.java)
            R.id.text_view_colors -> intent = Intent(this,ColorsActivity::class.java)

        }
        startActivity(intent)
    }
}