package com.envercelik.miwok

import android.media.MediaPlayer
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.envercelik.miwok.databinding.ListViewWordBinding

class PhrasesActivity : AppCompatActivity() {

    private lateinit var binding: ListViewWordBinding
    private  var mediaPlayer: MediaPlayer? =null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ListViewWordBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val listOfPhrases = ArrayList<Word>()

        listOfPhrases.add(Word("Where are you going?","minto wuksus",R.raw.phrase_where_are_you_going))
        listOfPhrases.add(Word("What is your name?","tinnә oyaase'nә",R.raw.phrase_what_is_your_name))
        listOfPhrases.add(Word("My name is...","oyaaset...",R.raw.phrase_my_name_is))
        listOfPhrases.add(Word("How are you feeling?","michәksәs?",R.raw.phrase_how_are_you_feeling))
        listOfPhrases.add(Word("I’m feeling good.","kuchi achit",R.raw.phrase_im_feeling_good))
        listOfPhrases.add(Word("Are you coming?","әәnәs'aa?",R.raw.phrase_are_you_coming))
        listOfPhrases.add(Word("Yes, I’m coming.","hәә’ әәnәm",R.raw.phrase_yes_im_coming))
        listOfPhrases.add(Word("I’m coming.","әәnәm",R.raw.phrase_im_coming))
        listOfPhrases.add(Word("Let’s go.","yoowutis",R.raw.phrase_lets_go))
        listOfPhrases.add(Word("Come here.","әnni'nem",R.raw.phrase_come_here))

        binding.listViewWord.adapter = WordAdapter(this,listOfPhrases,R.color.category_phrases)


        binding.listViewWord.setOnItemClickListener { adapterView, view, i, l ->

            mediaPlayer?.release()


            mediaPlayer = MediaPlayer.create(this@PhrasesActivity,listOfPhrases[i].pronunciationId)
            mediaPlayer!!.start()

            mediaPlayer!!.setOnCompletionListener {
                mediaPlayer!!.release()
            }

        }


    }

    override fun onStop() {
        super.onStop()
        mediaPlayer?.release()
    }
}