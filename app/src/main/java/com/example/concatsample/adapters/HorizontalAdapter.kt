package com.example.concatsample.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.concatsample.databinding.HorizontalItemBinding

class HorizontalAdapter : RecyclerView.Adapter<HorizontalAdapter.HorizontalViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HorizontalViewHolder =
        HorizontalViewHolder(HorizontalItemBinding.inflate(LayoutInflater.from(parent.context),
            parent,
            false))

    override fun onBindViewHolder(holder: HorizontalViewHolder, position: Int) {
        holder.bind(position)
    }

    override fun getItemCount(): Int = 20

    inner class HorizontalViewHolder(private val binding: HorizontalItemBinding) :
        RecyclerView.ViewHolder(binding.root){

            fun bind(position:Int){
                binding.horizontalItemTv.text = "H ${position+1}"
            }
        }
}