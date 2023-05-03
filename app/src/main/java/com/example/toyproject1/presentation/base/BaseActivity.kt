package com.example.toyproject1.presentation.base

import android.os.Bundle
import androidx.annotation.LayoutRes
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding

abstract class BaseActivity<B: ViewDataBinding, V: BaseViewModel>(
    @LayoutRes private val layoutResId: Int
):AppCompatActivity() {

    lateinit var binding: B
    abstract val TAG: String
    abstract val viewModel: V

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        // 바인딩
        binding = DataBindingUtil.setContentView(this, layoutResId)
    }
}