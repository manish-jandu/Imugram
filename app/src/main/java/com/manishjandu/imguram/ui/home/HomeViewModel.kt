package com.manishjandu.imguram.ui.home

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.manishjandu.imguram.data.ImgurRepository
import com.manishjandu.libimgur.models.Tag
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class HomeViewModel:ViewModel() {
    private val repo = ImgurRepository()
    private val _tags = MutableLiveData<List<Tag>>()

    val tags:LiveData<List<Tag>> = _tags

    fun fetchTags() = viewModelScope.launch (Dispatchers.IO){
        _tags.postValue(repo.getTags())
    }
}