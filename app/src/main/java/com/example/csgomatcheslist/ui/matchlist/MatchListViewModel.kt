package com.example.csgomatcheslist.ui.matchlist

import android.app.Application
import androidx.lifecycle.*
import com.example.csgomatcheslist.data.remote.api.SafeResponse
import com.example.csgomatcheslist.data.remote.api.safeRequest
import com.example.csgomatcheslist.data.remote.model.MatchResponse
import com.example.csgomatcheslist.data.repository.GetMatchListRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MatchListViewModel @Inject constructor(
    private val repository: GetMatchListRepository,

) : ViewModel(){

    private val _response : MutableLiveData<List<MatchResponse>> = MutableLiveData()
    val response: LiveData<List<MatchResponse>> = _response

    fun fetchMatchList() = viewModelScope.launch {

        when(val requestApi = safeRequest {
            repository.getMatchList()
        }) {
            is SafeResponse.Success ->{}
            is SafeResponse.GenericError ->{}
            is SafeResponse.NetworkError ->{}
        }
    }

}