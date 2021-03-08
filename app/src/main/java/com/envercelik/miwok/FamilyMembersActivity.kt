package com.envercelik.miwok

import android.media.MediaPlayer
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

import com.envercelik.miwok.databinding.ListViewWordBinding

class FamilyMembersActivity : AppCompatActivity() {

    private  var mediaPlayer:MediaPlayer? =null

    private lateinit var binding: ListViewWordBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ListViewWordBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val listOfFamilyMembers = getListOfFamilyMembers()

        binding.listViewWord.adapter = WordAdapter(this,listOfFamilyMembers,R.color.category_family)




        binding.listViewWord.setOnItemClickListener { adapterView, view, i, l ->

            mediaPlayer?.release()

            mediaPlayer = MediaPlayer.create(this@FamilyMembersActivity,listOfFamilyMembers[i].pronunciationId)
            mediaPlayer!!.start()

            mediaPlayer!!.setOnCompletionListener {
                mediaPlayer!!.release()
            }
        }


    }


    private fun getListOfFamilyMembers():ArrayList<Word> {

        val listOfFamilyMembers = ArrayList<Word>()

        listOfFamilyMembers.add(Word("father","әpә",R.drawable.family_father,R.raw.family_father))
        listOfFamilyMembers.add(Word("mother","әṭa",R.drawable.family_mother,R.raw.family_mother))
        listOfFamilyMembers.add(Word("son","angsi",R.drawable.family_son,R.raw.family_son))
        listOfFamilyMembers.add(Word("daughter","tune",R.drawable.family_daughter,R.raw.family_daughter))
        listOfFamilyMembers.add(Word("older brother","taachi",R.drawable.family_older_brother,R.raw.family_older_brother))
        listOfFamilyMembers.add(Word("younger brother","chalitti",R.drawable.family_younger_brother,R.raw.family_younger_brother))
        listOfFamilyMembers.add(Word("older sister","teṭe",R.drawable.family_older_sister,R.raw.family_older_sister))
        listOfFamilyMembers.add(Word("younger sister","kolliti",R.drawable.family_younger_sister,R.raw.family_younger_sister))
        listOfFamilyMembers.add(Word("grandmother","ama",R.drawable.family_grandmother,R.raw.family_grandmother))
        listOfFamilyMembers.add(Word("grandfather","paapa",R.drawable.family_grandfather,R.raw.family_grandfather))

        return listOfFamilyMembers

    }


    override fun onStop() {
        super.onStop()
        mediaPlayer?.release()
    }

}