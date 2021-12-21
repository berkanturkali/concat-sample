package com.example.concatsample

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.ConcatAdapter
import androidx.recyclerview.widget.GridLayoutManager
import com.example.concatsample.adapters.*
import com.example.concatsample.databinding.ActivityMainBinding
import com.example.concatsample.utils.enforceSingleScrollDirection

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    private val oneColumnAdapter by lazy {
        OneColumnAdapter()
    }

    private val twoColumnAdapter by lazy {
        TwoColumnAdapter()
    }

    private val threeColumnAdapter by lazy {
        ThreeColumnAdapter()
    }

    private val pagerAdapter by lazy {
        PagerAdapter()
    }

    private val pagerWrapperAdapter by lazy {
        PagerWrapperAdapter(pagerAdapter)
    }

    private val horizontalAdapter by lazy {
        HorizontalAdapter()
    }

    private val horizontalWrapperAdapter by lazy {
        HorizontalWrapperAdapter(horizontalAdapter)
    }

    private val concatAdapter: ConcatAdapter by lazy {
        val config = ConcatAdapter.Config.Builder().apply {
            setIsolateViewTypes(false)
        }.build()
        ConcatAdapter(config,
            horizontalWrapperAdapter,
            pagerWrapperAdapter,
            twoColumnAdapter,
            threeColumnAdapter,
            oneColumnAdapter)
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val layoutManager = GridLayoutManager(this, 12)
        layoutManager.spanSizeLookup = object : GridLayoutManager.SpanSizeLookup() {
            override fun getSpanSize(position: Int): Int {
                return when (concatAdapter.getItemViewType(position)) {
                    HorizontalWrapperAdapter.VIEW_TYPE,
                    PagerWrapperAdapter.VIEW_TYPE,
                    OneColumnAdapter.VIEW_TYPE,
                    -> 12
                    TwoColumnAdapter.VIEW_TYPE -> 6
                    ThreeColumnAdapter.VIEW_TYPE -> 4
                    else -> {
                        12
                    }
                }
            }
        }
        binding.rv.adapter = concatAdapter
        binding.rv.layoutManager = layoutManager
        binding.rv.enforceSingleScrollDirection()
    }
}