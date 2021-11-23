package com.project.newsapp.ui.main

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.project.newsapp.data.Resource
import com.project.newsapp.data.jp.JapaneseRepository
import com.project.newsapp.data.jp.JapaneseResponse
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import javax.inject.Inject

@HiltViewModel
class JapaneseViewModel @Inject constructor(
    private val japaneseRepository: JapaneseRepository
) : ViewModel() {

    private val _japaneseResponse = MutableLiveData<Resource<JapaneseResponse>>()
    val japaneseResponse: LiveData<Resource<JapaneseResponse>> = _japaneseResponse

    init {
        getJapaneseResponse()
    }

    fun getJapaneseResponse() = viewModelScope.launch(Dispatchers.Main) {
        _japaneseResponse.value = Resource.loading()
        val result = withContext(Dispatchers.IO) {
            japaneseRepository.jpNews()
        }
        _japaneseResponse.value = result
    }
}