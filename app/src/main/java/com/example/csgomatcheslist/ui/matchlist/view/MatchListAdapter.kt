package com.example.csgomatcheslist.ui.matchlist.view

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.csgomatcheslist.data.remote.model.MatchResponse
import com.example.csgomatcheslist.databinding.ItemMatchBinding
import com.example.csgomatcheslist.domain.model.MatchItemClickListener

class MatchListAdapter(
    private val list: List<MatchResponse>,
    private val listener: MatchItemClickListener
): RecyclerView.Adapter<MatchViewHolder>() {

    override fun getItemCount(): Int = list.size

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MatchViewHolder {
        val itemMatchBinding = ItemMatchBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return MatchViewHolder(itemMatchBinding)
    }

    override fun onBindViewHolder(holder: MatchViewHolder, position: Int) {
        val matchResponse = list[position]
        holder.bind(matchResponse)
    }

}