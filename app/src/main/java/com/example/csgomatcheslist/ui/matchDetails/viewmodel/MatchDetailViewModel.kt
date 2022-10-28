package com.example.csgomatcheslist.ui.matchDetails.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.csgomatcheslist.data.remote.model.MatchResponse
import dagger.hilt.android.lifecycle.HiltViewModel
import java.text.SimpleDateFormat
import java.util.*
import javax.inject.Inject

@HiltViewModel
class MatchDetailViewModel @Inject constructor(): ViewModel() {
    private val _date : MutableLiveData<String> = MutableLiveData()
    val date: LiveData<String> = _date

    private val pattern = "yyyy-MM-dd'T'HH:mm:ssX"
    private val patternToShow = "MM/dd HH:mm"
    private val simpleDateFormat = SimpleDateFormat(pattern, Locale.getDefault())


    fun formatDate(matchResponse: MatchResponse) {
        if (matchResponse.begin_at != null) {
            val date: Date? = simpleDateFormat.parse(matchResponse.begin_at)
            if (date != null)
                _date.value = SimpleDateFormat(patternToShow, Locale.getDefault()).format(date)
        }
    }
}