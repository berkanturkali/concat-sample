package com.example.concatsample.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.concatsample.databinding.PagerItemBinding

class PagerAdapter : RecyclerView.Adapter<PagerAdapter.PagerViewHolder>() {

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int,
    ): PagerViewHolder {
        return PagerViewHolder(PagerItemBinding.inflate(LayoutInflater.from(parent.context),
            parent,
            false))
    }

    override fun onBindViewHolder(holder: PagerViewHolder, position: Int) {
        holder.bind()
    }

    override fun getItemCount(): Int = 4

    inner class PagerViewHolder(private val binding: PagerItemBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind() {}
    }
}