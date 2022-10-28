package com.example.csgomatcheslist.ui.matchDetails.view

import androidx.appcompat.widget.AppCompatImageView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.csgomatcheslist.data.remote.model.OpponentResponse
import com.example.csgomatcheslist.databinding.ItemPlayerDetailBinding

class MatchDetailViewHolder(
    private val itemPlayerDetailBinding: ItemPlayerDetailBinding
) : RecyclerView.ViewHolder(itemPlayerDetailBinding.root){

    fun bind(opponentInfoResponse: OpponentResponse) {
        itemPlayerDetailBinding.tvFirstName.text = opponentInfoResponse.opponent?.name
        itemPlayerDetailBinding.tvSecondName.text = opponentInfoResponse.opponent?.name
        loadImage(opponentInfoResponse.opponent?.image_url, itemPlayerDetailBinding.ivFirstPlayer)
        loadImage(opponentInfoResponse.opponent?.image_url, itemPlayerDetailBinding.ivSecondPlayer)

    }

    private fun loadImage(url:String?, imageView: AppCompatImageView){
        Glide.with(itemPlayerDetailBinding.root)
            .load(url)
            .into(imageView)

    }
}