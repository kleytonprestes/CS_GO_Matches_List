package com.example.csgomatcheslist.ui.matchlist.view

import android.content.Context
import androidx.appcompat.content.res.AppCompatResources
import androidx.appcompat.widget.AppCompatImageView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.csgomatcheslist.R
import com.example.csgomatcheslist.data.remote.model.MatchResponse
import com.example.csgomatcheslist.databinding.ItemMatchBinding
import java.text.SimpleDateFormat
import java.util.*

class MatchViewHolder(
    private val itemBinding: ItemMatchBinding
    ): RecyclerView.ViewHolder(itemBinding.root) {


    private val pattern = "yyyy-MM-dd'T'HH:mm:ssX"
    private val patternToShow = "MM/dd HH:mm"
    private val simpleDateFormat = SimpleDateFormat(pattern, Locale.getDefault())

        fun bind(matchResponse: MatchResponse, context: Context) {

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

            if (matchResponse.isOnline) {
                itemBinding.matchTime.text = context.getString(R.string.now)
                itemBinding.matchTime.background = AppCompatResources.getDrawable(context,R.drawable.rounded_red_background)
            } else {
                if(matchResponse.begin_at != null){
                    val date : Date? = simpleDateFormat.parse(matchResponse.begin_at)
                    if (date!= null)
                    itemBinding.matchTime.text =
                        SimpleDateFormat(patternToShow, Locale.getDefault()).format(date)
                    itemBinding.matchTime.background = AppCompatResources.getDrawable(context,R.drawable.rounded_grey_background)


                }
            }

        }


    private fun loadImage(url:String?, imageView: AppCompatImageView){
        Glide.with(itemBinding.root)
            .load(url)
            .into(imageView)

    }


}