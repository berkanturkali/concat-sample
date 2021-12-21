package com.example.concatsample.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.concatsample.databinding.TwoColumnItemBinding

class TwoColumnAdapter : RecyclerView.Adapter<TwoColumnAdapter.TwoColumnViewHolder>() {

    companion object {
        const val VIEW_TYPE = 3
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TwoColumnViewHolder =
        TwoColumnViewHolder(TwoColumnItemBinding.inflate(LayoutInflater.from(
            parent.context),
            parent,
            false))

    override fun onBindViewHolder(holder: TwoColumnViewHolder, position: Int) {}

    override fun getItemCount(): Int = 6

    inner class TwoColumnViewHolder(binding: TwoColumnItemBinding) :
        RecyclerView.ViewHolder(binding.root)

    override fun getItemViewType(position: Int): Int = VIEW_TYPE
}