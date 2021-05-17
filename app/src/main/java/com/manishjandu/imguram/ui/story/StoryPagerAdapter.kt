package com.manishjandu.imguram.ui.story

import android.annotation.SuppressLint
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import coil.Coil
import coil.load
import coil.request.ImageRequest
import com.manishjandu.imguram.R
import com.manishjandu.imguram.databinding.PageItemStoryBinding
import com.manishjandu.libimgur.models.Image
import java.util.concurrent.RecursiveAction

class StoryPagerAdapter :
    ListAdapter<Image, StoryPagerAdapter.StoryViewHolder>(diffUtilCallback()) {

    inner class StoryViewHolder(val binding: PageItemStoryBinding) :
        RecyclerView.ViewHolder(binding.root) {

    }

    class diffUtilCallback : DiffUtil.ItemCallback<Image>() {
        override fun areItemsTheSame(oldItem: Image, newItem: Image): Boolean {
            return oldItem == newItem
        }

        @SuppressLint("DiffUtilEquals")
        override fun areContentsTheSame(oldItem: Image, newItem: Image): Boolean {
            return oldItem === newItem
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): StoryViewHolder {
        val inflater = parent.context.getSystemService(LayoutInflater::class.java)
        val binding = PageItemStoryBinding.inflate(inflater, parent, false)
        return StoryViewHolder(binding)
    }

    override fun onBindViewHolder(holder: StoryViewHolder, position: Int) {
        val image = getItem(position)
        val imgUrl = if (image.isAlbum == true && image?.imagesCount != 0) {
            image.images!![0].link
        } else {
            image.link
        }
        imgUrl?.let {
            holder.binding.ivStory.load(it)
            holder.binding.tvImageUrl.text = it

        }
        cacheNext(position, holder.binding.ivStory)
    }

    private fun cacheNext(position: Int, imageView: ImageView) {
        val image = try {
            getItem(position)
        } catch (e: Exception) {
            null
        }
        val imgUrl = if (image?.isAlbum == true && image?.imagesCount != 0) {
            image?.images!![0].link
        } else {
            image?.link
        }
        imgUrl?.let {
            val request = ImageRequest.Builder(imageView.context)
                .data(imgUrl)
                .build()
            Coil.imageLoader(imageView.context).enqueue(request)
        }

    }

}