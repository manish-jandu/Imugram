package com.manishjandu.imguram.feedFragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import com.manishjandu.imguram.databinding.FragmentFeedBinding

class FeedFragment : Fragment() {

    private val viewModel: FeedViewModel by activityViewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val feed = arguments?.getString("feed")
        feed?.let {
            viewModel.updateFeed(it)
        }

    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding = FragmentFeedBinding.inflate(inflater, container, false)

        viewModel.feed.observe({ lifecycle }) {
            Toast.makeText(requireContext(), "Downloaded  ${it.size}", Toast.LENGTH_SHORT).show()
        }

        return binding.root
    }

}