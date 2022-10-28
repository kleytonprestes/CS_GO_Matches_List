package com.example.csgomatcheslist.ui.matchDetails.view

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.csgomatcheslist.data.remote.model.OpponentResponse
import com.example.csgomatcheslist.databinding.ItemPlayerDetailBinding

class MatchDetailAdapter(
    private val list: List<OpponentResponse>
): RecyclerView.Adapter<MatchDetailViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MatchDetailViewHolder {
        val itemPlayerDetailBinding = ItemPlayerDetailBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return MatchDetailViewHolder(itemPlayerDetailBinding)
    }

    override fun onBindViewHolder(holder: MatchDetailViewHolder, position: Int) {
        val opponentResponse = list[position]
        holder.bind(opponentResponse)
    }

    override fun getItemCount(): Int = list.size
}