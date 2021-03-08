package com.envercelik.miwok

import android.media.MediaPlayer
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.envercelik.miwok.databinding.ListViewWordBinding

class ColorsActivity : AppCompatActivity() {

    private  var mediaPlayer:MediaPlayer? =null

    private lateinit var binding: ListViewWordBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ListViewWordBinding.inflate(layoutInflater)
        setContentView(binding.root)


        val listOfColors = getListOfColors()




        binding.listViewWord.adapter = WordAdapter(this, listOfColors,R.color.category_colors)


        binding.listViewWord.setOnItemClickListener { adapterView, view, i, l ->

            mediaPlayer?.release()

            mediaPlayer = MediaPlayer.create(this@ColorsActivity,listOfColors[i].pronunciationId)
            mediaPlayer!!.start()

            mediaPlayer!!.setOnCompletionListener {
                mediaPlayer!!.release()
            }
        }


    }



    private fun getListOfColors():ArrayList<Word> {

        val listOfColors = arrayListOf<Word>()

        listOfColors.add(Word("red", "weṭeṭṭi",R.drawable.color_red,R.raw.color_red))
        listOfColors.add(Word("green", "chokokki",R.drawable.color_green,R.raw.color_green))
        listOfColors.add(Word("brown", "ṭakaakki",R.drawable.color_brown,R.raw.color_brown))
        listOfColors.add(Word("gray", "ṭopoppi",R.drawable.color_gray,R.raw.color_gray))
        listOfColors.add(Word("black", "kululli",R.drawable.color_black,R.raw.color_black))
        listOfColors.add(Word("white", "kelelli",R.drawable.color_white,R.raw.color_white))
        listOfColors.add(Word("dusty yellow", "ṭopiisә",R.drawable.color_dusty_yellow,R.raw.color_dusty_yellow))
        listOfColors.add(Word("mustard yellow", "chiwiiṭә",R.drawable.color_mustard_yellow,R.raw.color_mustard_yellow))

        return listOfColors
    }


    override fun onStop() {
        super.onStop()
        mediaPlayer?.release()
    }


}