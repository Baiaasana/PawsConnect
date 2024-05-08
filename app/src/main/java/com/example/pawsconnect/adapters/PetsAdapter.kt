package com.example.pawsconnect.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.pawsconnect.data.Pet
import com.example.pawsconnect.databinding.PetItemBinding
import com.example.pawsconnect.util.loadImage

class PetsAdapter : ListAdapter<Pet, PetsAdapter.PetViewHolder>(DiffCallback) {
    inner class PetViewHolder(private var binding: PetItemBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(item: Pet) = with(binding) {
            ivPet.loadImage(item.image)
            tvAge.text = item.age.toString()
            tvLocation.text = item.location
            tvSpecie.text = item.specie
            tvRating.text = item.rating.toString()
            ivFavourite.isSelected = item.isFavourite
            tvName.text = item.name

            binding.ivFavourite.setOnClickListener {
                it.isSelected = !it.isSelected
            }
            // attributes
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PetViewHolder {
        return PetViewHolder(
            PetItemBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: PetViewHolder, position: Int) {
        holder.bind(getItem(position))
    }

    companion object {

        val DiffCallback = object : DiffUtil.ItemCallback<Pet>() {
            override fun areItemsTheSame(oldItem: Pet, newItem: Pet): Boolean {
                return oldItem == newItem
            }

            override fun areContentsTheSame(oldItem: Pet, newItem: Pet): Boolean {
                return oldItem.id == newItem.id
            }
        }
    }

}