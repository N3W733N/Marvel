package com.newteenho.marvel.presentation.telaPrincipal

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.SearchView
import androidx.core.text.isDigitsOnly
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
                if (query.isDigitsOnly()) {
                    viewModel.getCharactersByID(query)
                } else viewModel.getCharactersByName(query)
                return false
            }

            override fun onQueryTextChange(newText: String): Boolean {
                if (newText != "") {
                    if (newText.isDigitsOnly()) {
                        viewModel.getCharactersByID(newText)
                    } else viewModel.getCharactersByName(newText)
                } else viewModel.getCharacters()
                return false
            }
        })

        searchHeader.setOnCloseListener {
            viewModel.getCharacters()
            false
        }
    }
}