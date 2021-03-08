package com.envercelik.miwok

import android.media.MediaPlayer
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.envercelik.miwok.databinding.ListViewWordBinding

class NumbersActivity : AppCompatActivity() {

    private lateinit var binding: ListViewWordBinding

    private  var mediaPlayer: MediaPlayer? =null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ListViewWordBinding.inflate(layoutInflater)
        setContentView(binding.root)


        val listOfNumbers = getListOfNumbers()


        binding.listViewWord.adapter = WordAdapter(this,listOfNumbers,R.color.category_numbers)

        binding.listViewWord.setOnItemClickListener { adapterView, view, i, l ->

            mediaPlayer?.release()

            mediaPlayer = MediaPlayer.create(this@NumbersActivity,listOfNumbers[i].pronunciationId)
            mediaPlayer!!.start()

            mediaPlayer!!.setOnCompletionListener {
                mediaPlayer!!.release()
            }
        }
    }



    private fun getListOfNumbers():ArrayList<Word> {

        val listOfNumbers = arrayListOf<Word>()

        listOfNumbers.add(Word("one","lutti",R.drawable.number_one,R.raw.number_one))
        listOfNumbers.add(Word("two","otiiko",R.drawable.number_two,R.raw.number_two))
        listOfNumbers.add(Word("three","tolookosu",R.drawable.number_three,R.raw.number_three))
        listOfNumbers.add(Word("four","oyyisa",R.drawable.number_four,R.raw.number_four))
        listOfNumbers.add(Word("five","massokka",R.drawable.number_five,R.raw.number_five))
        listOfNumbers.add(Word("six","temmokka",R.drawable.number_six,R.raw.number_six))
        listOfNumbers.add(Word("seven","kenekaku",R.drawable.number_seven,R.raw.number_seven))
        listOfNumbers.add(Word("eight","kawinta",R.drawable.number_eight,R.raw.number_eight))
        listOfNumbers.add(Word("nine","wo'e",R.drawable.number_nine,R.raw.number_nine))
        listOfNumbers.add(Word("ten","na'aacha",R.drawable.number_ten,R.raw.number_ten))

        return listOfNumbers
    }

    override fun onStop() {
        super.onStop()
        mediaPlayer?.release()
    }

}