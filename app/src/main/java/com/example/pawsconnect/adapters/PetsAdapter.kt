package com.example.pawsconnect.adapters

import android.content.Context
import android.graphics.Typeface
import android.util.TypedValue
import android.view.Gravity
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.LinearLayout
import androidx.appcompat.widget.AppCompatTextView
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.pawsconnect.R
import com.example.pawsconnect.data.Pet
import com.example.pawsconnect.databinding.PetItemBinding
import com.example.pawsconnect.util.loadImage

class PetsAdapter : ListAdapter<Pet, PetsAdapter.PetViewHolder>(DiffCallback) {

    lateinit var context: Context

    inner class PetViewHolder(private var binding: PetItemBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(item: Pet) = with(binding) {
            ivPet.loadImage(item.image, null)
            tvAge.text = item.age.toString()
            tvLocation.text = item.location
            tvSpecie.text = item.specie
            tvRating.text = item.rating.toString()
            ivFavourite.isSelected = item.isFavourite
            tvName.text = item.name

            binding.ivFavourite.setOnClickListener {
                it.isSelected = !it.isSelected
            }

            // manually
//            attribute1.text = item.attributes[0]
//            attribute2.text = item.attributes[1]
//            attribute3.text = item.attributes[2]

            // programmatically
            item.attributes.forEach {
                val view = AppCompatTextView(this@PetsAdapter.context).apply {
                    text = it
                    height = TypedValue.applyDimension(
                        TypedValue.COMPLEX_UNIT_DIP,
                        24f,
                        context.resources.displayMetrics
                    ).toInt()
                    textSize = 10f
                    background = ContextCompat.getDrawable(context, R.drawable.attribute_bg)
                    setTextColor(ContextCompat.getColor(context, R.color.additional))
                    val paddingInPx = TypedValue.applyDimension(
                        TypedValue.COMPLEX_UNIT_DIP,
                        12f,
                        context.resources.displayMetrics
                    ).toInt()
                    setPadding(paddingInPx, 0, paddingInPx, 0) // Set padding here
                    gravity = Gravity.CENTER_VERTICAL
                    typeface = Typeface.createFromAsset(context.assets, "nunito_regular.ttf")
                }

                val params = LinearLayout.LayoutParams(
                    LinearLayout.LayoutParams.WRAP_CONTENT,
                    LinearLayout.LayoutParams.WRAP_CONTENT
                )
                val marginInPx = TypedValue.applyDimension(
                    TypedValue.COMPLEX_UNIT_DIP,
                    12f,
                    context.resources.displayMetrics
                ).toInt()
                params.marginEnd = marginInPx
                view.layoutParams = params
                llAttributes.addView(
                    view
                )
            }

        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PetViewHolder {
        context = parent.context
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