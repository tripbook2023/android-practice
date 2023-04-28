package com.example.toyproject1.ui.views

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.toyproject1.data.ItemRepositoryImpl
import com.example.toyproject1.ui.RecyclerViewAdapter
import com.example.toyproject1.databinding.FragmentListBinding
import com.example.toyproject1.domain.usecase.GetItemUseCase
import com.example.toyproject1.ui.ItemViewModel
import com.example.toyproject1.ui.ItemViewModelFactory

class ListFragment : Fragment() {

    private var _binding: FragmentListBinding? = null
    private val binding get() = _binding!!

    private val itemViewModel: ItemViewModel by viewModels{
        ItemViewModelFactory(GetItemUseCase())
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentListBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val adapter = RecyclerViewAdapter { item ->
            val action = ListFragmentDirections.actionListFragmentToDetailFragment(item)
            findNavController().navigate(action)
        }

        binding.apply {
            viewModel = itemViewModel
            lifecycleOwner = this@ListFragment.viewLifecycleOwner
            recyclerView.adapter = adapter
            recyclerView.layoutManager = LinearLayoutManager(requireContext())
        }
    }

    override fun onDestroyView() {
        _binding = null
        super.onDestroyView()
    }
}