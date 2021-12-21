package com.example.concatsample.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.concatsample.databinding.ThreeColumnItemBinding

class ThreeColumnAdapter : RecyclerView.Adapter<ThreeColumnAdapter.ThreeColumnViewHolder>() {

    companion object {
        const val VIEW_TYPE = 5
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ThreeColumnViewHolder =
        ThreeColumnViewHolder(ThreeColumnItemBinding.inflate(LayoutInflater.from(
            parent.context),
            parent,
            false))

    override fun onBindViewHolder(holder: ThreeColumnViewHolder, position: Int) {}

    override fun getItemCount(): Int = 6

    inner class ThreeColumnViewHolder(binding: ThreeColumnItemBinding) :
        RecyclerView.ViewHolder(binding.root)

    override fun getItemViewType(position: Int): Int = VIEW_TYPE
}