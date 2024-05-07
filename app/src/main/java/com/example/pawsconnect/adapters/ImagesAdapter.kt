package com.example.pawsconnect.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.pawsconnect.R
import com.example.pawsconnect.databinding.ImageItemBinding

class ImageAdapter : ListAdapter<ImageItem, RecyclerView.ViewHolder>(DiffCallback) {

    var onImageClick: (() -> Unit)? = null
    var onImagePlusClick: (() -> Unit)? = null

    inner class ImageViewHolder(private var binding: ImageItemBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(item: ImageItem) {
            binding.image.setImageResource(item.image)
            binding.root.setOnClickListener {
                onImageClick?.invoke()
            }
        }
    }

    inner class ImagePlusViewHolder(private var binding: ImageItemBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(item: ImageItem) {
            binding.image.setImageResource(item.image)
            binding.image.setBackgroundResource(R.drawable.dash)
            binding.root.setOnClickListener {
                onImagePlusClick?.invoke()
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return when (viewType) {
            ITEM_VIEW_TYPE_IMAGE -> ImageViewHolder(
                ImageItemBinding.inflate(
                    LayoutInflater.from(parent.context),
                    parent,
                    false
                )
            )

            ITEM_VIEW_TYPE_IMAGE_PLUS -> ImagePlusViewHolder(
                ImageItemBinding.inflate(
                    LayoutInflater.from(parent.context),
                    parent,
                    false
                )
            )

            else -> throw ClassCastException("Unknown viewType $viewType")
        }
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        when (holder) {
            is ImageViewHolder -> {
                val item = getItem(position) as ImageItem
                holder.bind(item)
            }

            is ImagePlusViewHolder -> {
                val item = getItem(position) as ImageItem
                holder.bind(item)
            }
        }
    }

    override fun getItemViewType(position: Int): Int {
        return when ((getItem(position) as ImageItem).isPlus!!) {
            false -> ITEM_VIEW_TYPE_IMAGE
            true -> ITEM_VIEW_TYPE_IMAGE_PLUS
        }
    }

    companion object {
        private const val ITEM_VIEW_TYPE_IMAGE = 0
        private const val ITEM_VIEW_TYPE_IMAGE_PLUS = 1

        val DiffCallback = object : DiffUtil.ItemCallback<ImageItem>() {
            override fun areItemsTheSame(oldItem: ImageItem, newItem: ImageItem): Boolean {
                return oldItem == newItem
            }

            override fun areContentsTheSame(oldItem: ImageItem, newItem: ImageItem): Boolean {
                return oldItem.id == newItem.id
            }
        }
    }
}


data class ImageItem(val id: Int, val image: Int, var isPlus: Boolean? = false)

