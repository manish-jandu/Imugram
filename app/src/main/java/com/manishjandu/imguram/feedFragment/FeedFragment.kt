package com.manishjandu.imguram.feedFragment

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import com.manishjandu.imguram.R

class FeedFragment : Fragment( ) {

    private lateinit var viewModel: FeedViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val feed = arguments?.getString("feed")
        val rootView = inflater.inflate(R.layout.fragment_feed,container,false)

        feed?.let {
            rootView.findViewById<TextView>(R.id.tvFeedType).text = it
        }

        return rootView
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(FeedViewModel::class.java)
        // TODO: Use the ViewModel
    }

}