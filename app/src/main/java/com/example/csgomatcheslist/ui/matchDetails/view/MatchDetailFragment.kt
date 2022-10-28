package com.example.csgomatcheslist.ui.matchDetails.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import androidx.navigation.ui.setupWithNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.csgomatcheslist.databinding.FragmentMatchDetailBinding
import com.example.csgomatcheslist.loadImage
import com.example.csgomatcheslist.ui.matchDetails.viewmodel.MatchDetailViewModel

class MatchDetailFragment: Fragment() {


    private val mainViewModel by viewModels<MatchDetailViewModel>()
    private val args: MatchDetailFragmentArgs by navArgs()
    private var adapter : MatchDetailAdapter? = null
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
        val matchResponse = args.matchResponse
        mainViewModel.formatDate(matchResponse)

        binding?.toolbar?.setNavigationOnClickListener {
            findNavController().popBackStack()
        }

        mainViewModel.date.observe(viewLifecycleOwner){
            binding?.tvMatchTime?.text = it
        }
        val leaguePlusSerie = matchResponse.league?.name.plus(" ").plus(matchResponse.serie?.name)
        binding?.tvLeagueSerie?.text = leaguePlusSerie
        binding?.tvNameFirstTeam?.text = matchResponse.name?.split("vs")?.first()
        binding?.tvNameSecondTeam?.text = matchResponse.name?.split("vs")?.get(1) ?: ""

        if (matchResponse.opponents.isNotEmpty() && binding?.ivFirstTeam != null) {
            loadImage(requireContext(),matchResponse.opponents.first().opponent?.image_url,
                binding!!.ivFirstTeam)
        }
        if (matchResponse.opponents.size > 1 && binding?.ivSecondTeam != null){

            loadImage(requireContext(), matchResponse.opponents[1].opponent?.image_url,
                binding!!.ivSecondTeam)
        }

        adapter = MatchDetailAdapter(args.matchResponse.opponents)
        binding?.rvPlayerList?.adapter = adapter
        binding?.rvPlayerList?.layoutManager = LinearLayoutManager(context, RecyclerView.VERTICAL, false)

    }
}