package com.newteenho.marvel.presentation.telaPrincipal

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.SearchView
import android.widget.Toolbar
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.newteenho.marvel.R
import kotlinx.android.synthetic.main.activity_characters.*
import kotlinx.android.synthetic.main.character_item.*

class CharactersActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_characters)

        val viewModel: CharactersViewModel =
            ViewModelProviders.of(this).get(CharactersViewModel::class.java)

        viewModel.infoInitLiveData.observe(this, Observer {
            it?.let { characters ->
                with(recyclerHeroes) {
                    layoutManager =
                        LinearLayoutManager(this@CharactersActivity, RecyclerView.VERTICAL, false)
                    setHasFixedSize(true)
                    adapter = CharactersAdapter(characters)
                }
            }
        })

        viewModel.getCharacters()

        searchHeader.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(query: String): Boolean {

                viewModel.getCharactersByID(query)
                return false
            }

            override fun onQueryTextChange(newText: String): Boolean {
                if (newText != "") {
                    viewModel.getCharactersByID(newText)
                } else
                    viewModel.getCharacters()
                return false
            }
        })

        searchHeader.setOnCloseListener(object : SearchView.OnCloseListener {
            override fun onClose(): Boolean {
                viewModel.getCharacters()
                return false
            }

        })
    }
}