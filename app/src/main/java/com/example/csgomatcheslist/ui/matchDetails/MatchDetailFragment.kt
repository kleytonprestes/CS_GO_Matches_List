package com.example.csgomatcheslist.ui.matchDetails

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.navArgs
import com.example.csgomatcheslist.databinding.FragmentMatchDetailBinding

class MatchDetailFragment: Fragment() {

    private val args: MatchDetailFragmentArgs by navArgs()
    private var binding: FragmentMatchDetailBinding? = null

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding = FragmentMatchDetailBinding.inflate(inflater, container, false)


        return binding?.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

//        requireActivity.actionBar(binding.toolbar)

    }
}