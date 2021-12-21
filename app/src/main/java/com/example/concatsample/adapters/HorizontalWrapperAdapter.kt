package com.example.concatsample.adapters

import android.os.Parcelable
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.concatsample.R
import com.example.concatsample.databinding.HorizontalWrapperBinding

class HorizontalWrapperAdapter(
    private val adapter: HorizontalAdapter,
) : RecyclerView.Adapter<HorizontalWrapperAdapter.HorizontalWrapperViewHolder>() {

    private var scrollStateX: Parcelable? = null

    companion object {
        const val VIEW_TYPE = 1
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HorizontalWrapperViewHolder =
        HorizontalWrapperViewHolder(HorizontalWrapperBinding.inflate(LayoutInflater.from(
            parent.context),
            parent,
            false))

    override fun onBindViewHolder(holder: HorizontalWrapperViewHolder, position: Int) {
        holder.bind(adapter)
    }

    override fun getItemCount(): Int = 1

    inner class HorizontalWrapperViewHolder(private val binding: HorizontalWrapperBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(adapter: HorizontalAdapter) {
            binding.horizontalRv.adapter = adapter
            val state = scrollStateX
            state?.let {
                binding.horizontalRv.layoutManager?.onRestoreInstanceState(it)
            } ?: binding.horizontalRv.scrollToPosition(0)

        }
    }

    override fun onViewRecycled(holder: HorizontalWrapperAdapter.HorizontalWrapperViewHolder) {
        super.onViewRecycled(holder)
        scrollStateX =
            holder.itemView.findViewById<RecyclerView>(R.id.horizontal_rv).layoutManager?.onSaveInstanceState()
    }

    override fun getItemViewType(position: Int): Int = VIEW_TYPE
}