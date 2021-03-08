package com.envercelik.miwok

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ImageView
import android.widget.TextView
import androidx.core.content.ContextCompat

class WordAdapter(private val context:Context, private val wordList:ArrayList<Word> ,private val colorResourceID: Int ) : BaseAdapter() {


    override fun getCount(): Int {
        return wordList.size
    }

    override fun getItem(position: Int): Word {
        return wordList[position]
    }

    override fun getItemId(p0: Int): Long {
        return 0
    }

    override fun getView(position: Int, p1: View?, viewGroup: ViewGroup?): View {

        val inflater = LayoutInflater.from(context)

        val viewWordItemRow = inflater.inflate(R.layout.list_view_word_item,viewGroup,false)


        val color = ContextCompat.getColor(context,colorResourceID)

        viewGroup?.setBackgroundColor(color)


        val textViewDefaultTranslation = viewWordItemRow.findViewById<TextView>(R.id.text_view_default_translation)
        val textViewMiwokTranslation = viewWordItemRow.findViewById<TextView>(R.id.text_view_miwok_translation)
        val imageViewWord = viewWordItemRow.findViewById<ImageView>(R.id.image_view_word)

        textViewDefaultTranslation.text = wordList[position].defaultTranslation
        textViewMiwokTranslation.text = wordList[position].miwokTranslation


        if (wordList[position].hasImage()) {
            imageViewWord.setImageResource(wordList[position].imageId)
        } else {
            imageViewWord.visibility = View.GONE
        }

        return viewWordItemRow




    }

}