package com.manishjandu.imguram.feedFragment

import android.util.Log
import androidx.lifecycle.*
import com.manishjandu.imguram.data.ImgurRepository
import com.manishjandu.libimgur.models.Image
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class FeedViewModel : ViewModel() {
    private val repo = ImgurRepository()
    private val _feed = MutableLiveData<List<Image>>()

    val feed : LiveData<List<Image>> = _feed

    fun updateFeed(feedType: String) {
        viewModelScope.launch(Dispatchers.IO) {
            when (feedType) {
                "hot" -> _feed.postValue(repo.getHotFeed())
                "top" -> _feed.postValue(repo.getTopFeed())
                else -> Log.e("FEED", "Feed has to be either top or hot")
            }
        }
    }
}