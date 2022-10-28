package com.example.csgomatcheslist.ui.matchlist.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.View.GONE
import android.view.View.VISIBLE
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.csgomatcheslist.data.remote.model.MatchResponse
import com.example.csgomatcheslist.databinding.FragmentMatchListBinding
import com.example.csgomatcheslist.ui.matchlist.viewmodel.MatchListViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MatchListFragment : Fragment(), MatchItemClickListener {

    private var _binding: FragmentMatchListBinding? = null
    private val mainViewModel by viewModels<MatchListViewModel>()
    private var adapter: MatchListAdapter? = null

    private val binding get() = _binding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        _binding = FragmentMatchListBinding.inflate(inflater, container, false)
        return binding?.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding?.loading?.visibility = VISIBLE
        mainViewModel.fetchMatchList()
        mainViewModel.response.observe(viewLifecycleOwner) {

            adapter = MatchListAdapter(it, this)
            binding?.rvMatchList?.adapter = adapter
            binding?.rvMatchList?.layoutManager = LinearLayoutManager(context, RecyclerView.VERTICAL, false)
            binding?.loading?.visibility = GONE

        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    override fun onClick(match: MatchResponse) {

        val action = MatchListFragmentDirections.actionMatchListFragmentToMatchDetailFragment(match)
        findNavController().navigate(action)

    }
}