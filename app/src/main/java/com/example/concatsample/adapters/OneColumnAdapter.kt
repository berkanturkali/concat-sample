package com.example.concatsample.adapters

import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.example.concatsample.databinding.OneColumnItemBinding

class OneColumnAdapter : RecyclerView.Adapter<OneColumnAdapter.OneColumnViewHolder>() {

    companion object {
        const val VIEW_TYPE = 4
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): OneColumnViewHolder =
        OneColumnViewHolder(OneColumnItemBinding.inflate(LayoutInflater.from(
            parent.context),
            parent,
            false))

    override fun onBindViewHolder(holder: OneColumnViewHolder, position: Int) {}

    override fun getItemCount(): Int = 6

    inner class OneColumnViewHolder(binding: OneColumnItemBinding) :
        RecyclerView.ViewHolder(binding.root)

    override fun getItemViewType(position: Int): Int  = VIEW_TYPE
}