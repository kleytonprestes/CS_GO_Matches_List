package com.example.csgomatcheslist.ui.matchlist.view

import androidx.appcompat.widget.AppCompatImageView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.csgomatcheslist.data.remote.model.MatchResponse
import com.example.csgomatcheslist.databinding.ItemMatchBinding

class MatchViewHolder(
    private val itemBinding: ItemMatchBinding
    ): RecyclerView.ViewHolder(itemBinding.root) {

        fun bind(matchResponse: MatchResponse) {

            val leaguePlusSerie = matchResponse.league?.name.plus(" ").plus(matchResponse.serie?.name)

            itemBinding.tvNameFirstTeam.text = matchResponse.name?.split("vs")?.first()
            itemBinding.tvNameSecondTeam.text = matchResponse.name?.split("vs")?.get(1) ?: ""
            itemBinding.tvLeague.text = leaguePlusSerie

            if (matchResponse.opponents.isNotEmpty()) {
                loadImage(matchResponse.opponents.first().opponent?.image_url, itemBinding.ivFirstTeam)
            }
            if (matchResponse.opponents.size > 1){

                loadImage(matchResponse.opponents[1].opponent?.image_url, itemBinding.ivSecondTeam)
            }
            loadImage(matchResponse.league?.image_url, itemBinding.ivLeague)

        }


    private fun loadImage(url:String?, imageView: AppCompatImageView){
        Glide.with(itemBinding.root)
            .load(url)
            .into(imageView)

    }


}