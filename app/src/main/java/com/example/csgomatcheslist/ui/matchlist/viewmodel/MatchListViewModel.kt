package com.example.csgomatcheslist.ui.matchlist.viewmodel

import android.os.Build
import androidx.lifecycle.*
import com.example.csgomatcheslist.data.remote.api.SafeResponse
import com.example.csgomatcheslist.data.remote.api.safeRequest
import com.example.csgomatcheslist.data.remote.model.MatchResponse
import com.example.csgomatcheslist.data.repository.GetMatchListRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import java.text.ParseException
import java.text.SimpleDateFormat
import java.time.LocalDate
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter
import java.util.*
import javax.inject.Inject

@HiltViewModel
class MatchListViewModel @Inject constructor(
    private val repository: GetMatchListRepository,

) : ViewModel(){

    private val _response : MutableLiveData<List<MatchResponse>> = MutableLiveData()
    val response: LiveData<List<MatchResponse>> = _response

    private val pattern = "yyyy-MM-dd'T'HH:mm:ssX"
    private val simpleDateFormat = SimpleDateFormat(pattern, Locale.getDefault())

    fun fetchMatchList() = viewModelScope.launch {


        when(val requestApi = safeRequest {
            repository.getMatchList()
        }) {
            is SafeResponse.Success ->{

                val result = requestApi.value.sortedByDescending {
                    simpleDateFormat.parse(it.begin_at)

                }
                result.map {
                    checkIfIsOnline(it)
                }
                _response.value = result

            }
            is SafeResponse.GenericError ->{}
            is SafeResponse.NetworkError ->{}
        }
    }

    private fun checkIfIsOnline(matchResponse: MatchResponse){
        val today = Calendar.getInstance()

        if(matchResponse.begin_at != null){
            val date : Date? = simpleDateFormat.parse(matchResponse.begin_at)
            if (date != null && date.before(today.time))
                    matchResponse.isOnline = true
        }
    }

}