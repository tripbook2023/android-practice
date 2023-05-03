package com.example.toyproject1.presentation.base

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.LayoutRes
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.fragment.app.Fragment
import com.example.toyproject1.presentation.ItemViewModel

abstract class BaseFragment<B: ViewDataBinding, V: ItemViewModel>(
    @LayoutRes private val layoutResId: Int
): Fragment() {

    private var _binding: B? = null
    val binding get() = _binding!!
    abstract val itemViewModel:V

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = DataBindingUtil.inflate(inflater, layoutResId, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // 프래그먼트 공통으로 적용되는 데이터 바인딩 변수 연결
        binding.lifecycleOwner = viewLifecycleOwner
        // initView
    }

//    abstract fun initView()
    // abstract : override 강제
    // open: 상속 가능

    override fun onDestroyView() {
        _binding = null
        super.onDestroyView()
    }
}