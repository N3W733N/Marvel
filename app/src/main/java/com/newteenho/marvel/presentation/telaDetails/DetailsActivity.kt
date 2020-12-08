package com.newteenho.marvel.presentation.telaDetails

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.method.ScrollingMovementMethod
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.bumptech.glide.Glide
import com.newteenho.marvel.R
import kotlinx.android.synthetic.main.activity_details.*

class DetailsActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_details)

        val detailViewModel: DetailsViewModel =
            ViewModelProviders.of(this).get(DetailsViewModel::class.java)

        val id = intent.getStringExtra("CHAR_ID")
        id?.let { detailViewModel.getCharById(it) }
        setCharacterData(detailViewModel)
    }


    private fun setCharacterData(detailViewModel: DetailsViewModel) {
        detailViewModel.heroesLiveData.observe(this, Observer {
            heroDescription.movementMethod = ScrollingMovementMethod()
            heroTitle.text = it.name
            if (it.description != "") {
                heroDescription.text = it.description
            } else {
                heroDescription.text = "No description founded"
                heroDescription.textSize = 30F
            }

            val img = "${it.thumbnail.path}/standard_amazing.${it.thumbnail.extension}"
                .split(":")
            Glide.with(this).load("https:" + img[1]).into(thumbHero)
        })
        backButton.setOnClickListener{
            motionLayout.transitionToStart()
            finishAfterTransition()
        }
    }

    companion object {
        fun getStartIntent(
            context: Context, charID: String
        ): Intent {
            return Intent(context, DetailsActivity::class.java).apply {
                putExtra(
                    "CHAR_ID",
                    charID
                )
            }
        }
    }

}
