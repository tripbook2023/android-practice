package com.example.toyproject1.presentation.views

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.navArgs
import com.example.toyproject1.R
import com.example.toyproject1.databinding.FragmentDetailBinding
import com.example.toyproject1.presentation.ItemViewModel
import com.example.toyproject1.presentation.base.BaseFragment
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class DetailFragment : BaseFragment<FragmentDetailBinding, ItemViewModel>(R.layout.fragment_detail) {

    override val itemViewModel:ItemViewModel by viewModels()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val args: DetailFragmentArgs by navArgs()
        binding.item = args.item
    }
}