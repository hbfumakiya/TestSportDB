package com.sportsdb.demo.adapter

import android.graphics.Rect
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.sportsdb.demo.R
import com.sportsdb.demo.model.Game
import kotlinx.android.synthetic.main.view_item_game.view.*

/**
 * Created by Hardik on 10-01-2021.
 * this is data adapter for the app
 */

class SportRecyclerViewAdapter(var data: ArrayList<Game>) :
    RecyclerView.Adapter<SportRecyclerViewAdapter.MyViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = MyViewHolder(
        LayoutInflater.from(parent.context).inflate(R.layout.view_item_game, parent, false)
    )

    override fun getItemCount() = data.size

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.bind(data[position])
    }

    fun updateData(updatedData: ArrayList<Game>) {
        this.data = updatedData
        notifyDataSetChanged()
    }

    inner class MyViewHolder(view: View) : RecyclerView.ViewHolder(view) {

        fun bind(sportLeagueGame: Game) {
            itemView.leagueName.text = if (!sportLeagueGame.strLeagueAlternate.isNullOrEmpty()) {
                "${sportLeagueGame.strLeague} (${sportLeagueGame.strLeagueAlternate})"
            } else {
                sportLeagueGame.strLeague
            }
            itemView.leagueCountry.text = sportLeagueGame.strCountry
            itemView.leagueWebsite.text = sportLeagueGame.strWebsite
            itemView.leagueDescription.text = sportLeagueGame.strDescriptionEN

            Glide.with(itemView.context)
                .load(sportLeagueGame.strBadge)
                .placeholder(R.drawable.ic_launcher_background)
                .into(itemView.leagueImageView)
        }
    }
}

class MarginItemDecoration(private val spaceHeight: Int) : RecyclerView.ItemDecoration() {
    override fun getItemOffsets(
        outRect: Rect, view: View,
        parent: RecyclerView, state: RecyclerView.State
    ) {
        with(outRect) {
            if (parent.getChildAdapterPosition(view) == 0) {
                top = spaceHeight
            }
            left = spaceHeight
            right = spaceHeight
            bottom = spaceHeight
        }
    }
}