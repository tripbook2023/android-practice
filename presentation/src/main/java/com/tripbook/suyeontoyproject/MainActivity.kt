package com.tripbook.suyeontoyproject

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.tripbook.suyeontoyproject.adapter.CustomAdapter
import com.tripbook.suyeontoyproject.viewModel.MainViewModel


class MainActivity : AppCompatActivity() {

    //@SuppressLint("SuspiciousIndentation")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val viewModel = ViewModelProvider(this).get(MainViewModel::class.java)
        viewModel.getAllData()

        val rv = findViewById<RecyclerView>(R.id.rv)

        viewModel.result2.observe(this) {

            val customAdapter = CustomAdapter(this, it)
            rv.adapter = customAdapter
            rv.layoutManager = LinearLayoutManager(this)
        }

    }
}