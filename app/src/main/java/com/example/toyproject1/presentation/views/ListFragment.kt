package com.example.toyproject1.presentation.views

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.toyproject1.R
import com.example.toyproject1.databinding.FragmentListBinding
import com.example.toyproject1.presentation.ItemViewModel
import com.example.toyproject1.presentation.RecyclerViewAdapter
import com.example.toyproject1.presentation.base.BaseFragment
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class ListFragment : BaseFragment<FragmentListBinding, ItemViewModel>(R.layout.fragment_list) {

    // by viewModels()에 의해 Hilt 적용 안해도 자동으로 viewModel 주입
    // viewModel 클래스에 @HiltViewModel 사용
    override val itemViewModel: ItemViewModel by viewModels()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val adapter = RecyclerViewAdapter { item ->
            val action = ListFragmentDirections.actionListFragmentToDetailFragment(item)
            findNavController().navigate(action)
        }

        binding.apply {
            viewModel = itemViewModel
            recyclerView.adapter = adapter
            recyclerView.layoutManager = LinearLayoutManager(requireContext())
        }
    }
}
