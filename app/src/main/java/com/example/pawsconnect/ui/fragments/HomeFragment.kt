package com.example.pawsconnect.ui.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.bitmap.CircleCrop
import com.bumptech.glide.request.RequestOptions
import com.example.pawsconnect.R
import com.example.pawsconnect.adapters.ImageAdapter
import com.example.pawsconnect.adapters.PetsAdapter
import com.example.pawsconnect.data.Pet
import com.example.pawsconnect.databinding.FragmentHomeBinding
import com.example.pawsconnect.util.ItemDecorator


class HomeFragment : Fragment() {

    private var _binding: FragmentHomeBinding? = null
    private val binding get() = _binding!!

    private val petsAdapter by lazy { PetsAdapter() }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setUpRecycler()
        loadProfileImage()

    }

    private fun loadProfileImage() {
        Glide.with(this)
            .load(R.drawable.avatar)
            .apply(RequestOptions.bitmapTransform(CircleCrop()))
            .into(binding.image)
    }

    private fun setUpRecycler() {
        val lists = mutableListOf(
            Pet(
                id = 0,
                name = "miki",
                specie = "Metis",
                age = 9,
                location = "Chiatura",
                rating = 4.0F,
                isFavourite = true,
                attributes = listOf("dsds", "dsds", "dsds"),
                image = "https://hips.hearstapps.com/hmg-prod/images/large-cat-breed-1553197454.jpg?crop=1.00xw:0.505xh;0,0.0817xh&resize=1200:*"
            ),
            Pet(
                id = 1,
                name = "miki",
                specie = "Metis",
                age = 9,
                location = "Chiatura",
                rating = 4.0F,
                isFavourite = false,
                attributes = listOf("dsds", "dsds", "dsds"),
                image = "https://hips.hearstapps.com/hmg-prod/images/large-cat-breed-1553197454.jpg?crop=1.00xw:0.505xh;0,0.0817xh&resize=1200:*"
            ),
            Pet(
                id = 2,
                name = "miki",
                specie = "Metis",
                age = 9,
                location = "Chiatura",
                rating = 4.0F,
                isFavourite = true,
                attributes = listOf("dsds", "dsds", "dsds"),
                image = "https://hips.hearstapps.com/hmg-prod/images/large-cat-breed-1553197454.jpg?crop=1.00xw:0.505xh;0,0.0817xh&resize=1200:*"
            ),
            Pet(
                id = 3,
                name = "miki",
                specie = "Metis",
                age = 9,
                location = "Chiatura",
                rating = 4.0F,
                isFavourite = false,
                attributes = listOf("dsds", "dsds", "dsds"),
                image = "https://hips.hearstapps.com/hmg-prod/images/large-cat-breed-1553197454.jpg?crop=1.00xw:0.505xh;0,0.0817xh&resize=1200:*"
            ),
            Pet(
                id = 4,
                name = "miki",
                specie = "Metis",
                age = 9,
                location = "Chiatura",
                rating = 4.0F,
                isFavourite = true,
                attributes = listOf("dsds", "dsds", "dsds"),
                image = "https://hips.hearstapps.com/hmg-prod/images/large-cat-breed-1553197454.jpg?crop=1.00xw:0.505xh;0,0.0817xh&resize=1200:*"
            )
        )

        binding.rvPets.apply {
            layoutManager = LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)
            adapter = petsAdapter
        }
        petsAdapter.submitList(lists)
        binding.rvPets.addItemDecoration(ItemDecorator(16, vertical = true))

    }
}

