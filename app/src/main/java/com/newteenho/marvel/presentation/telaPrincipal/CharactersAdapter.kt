package com.newteenho.marvel.presentation.telaPrincipal

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.newteenho.marvel.R
import com.newteenho.marvel.data.response.InfoInit
import com.newteenho.marvel.data.response.Results
import kotlinx.android.synthetic.main.character_item.view.*

class CharactersAdapter(
     val charactersMae: InfoInit
) : RecyclerView.Adapter<CharactersAdapter.CharactersViewHolder>() {
    private val characters = charactersMae.data.results


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CharactersViewHolder {
        val itemView =
            LayoutInflater.from(parent.context).inflate(R.layout.character_item, parent, false)
        return CharactersViewHolder(itemView)
    }

    override fun getItemCount() = characters.size

    override fun onBindViewHolder(holder: CharactersViewHolder, position: Int) {
        holder.bindView(characters[position],charactersMae)
    }


    class CharactersViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        private val heroName = itemView.nameHeroTxt
        private val heroSprite = itemView.thumbHero
        private val heroId = itemView.idHeroTxt
        private val heroAttibution = itemView.attributionTxt

        fun bindView(character: Results,charactersMae: InfoInit) {
            heroName.text = character.name
            heroId.text =  "ID: ${character.id}"
            heroAttibution.text = charactersMae.attributionText

            val img =
                "${character.thumbnail.path}/standard_amazing.${character.thumbnail.extension}".split(
                    ":"
                )
            Glide.with(itemView).load("https:" + img[1]).into(heroSprite)
        }
    }

}