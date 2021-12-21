package com.example.concatsample.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.concatsample.databinding.PagerWrapperBinding


class PagerWrapperAdapter(
    private val adapter: PagerAdapter,
) : RecyclerView.Adapter<PagerWrapperAdapter.PagerWrapperViewHolder>() {

    companion object {
        const val VIEW_TYPE = 2
    }

    override fun getItemCount(): Int = 1

    inner class PagerWrapperViewHolder(private val binding: PagerWrapperBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(adapter: PagerAdapter) {
            binding.pager.adapter = adapter
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PagerWrapperViewHolder =
        PagerWrapperViewHolder(PagerWrapperBinding.inflate(LayoutInflater.from(parent.context),
            parent,
            false))

    override fun onBindViewHolder(holder: PagerWrapperViewHolder, position: Int) {
        holder.bind(adapter)
    }

    override fun getItemViewType(position: Int): Int = VIEW_TYPE
}