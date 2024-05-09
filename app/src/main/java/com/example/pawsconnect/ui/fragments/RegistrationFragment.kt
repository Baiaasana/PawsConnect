package com.example.pawsconnect.ui.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.pawsconnect.R
import com.example.pawsconnect.adapters.ImageAdapter
import com.example.pawsconnect.data.ImageItem
import com.example.pawsconnect.databinding.FragmentRegistrationBinding
import com.example.pawsconnect.util.ItemDecorator

class RegistrationFragment : Fragment() {

    private var _binding: FragmentRegistrationBinding? = null
    private val binding get() = _binding!!
    private lateinit var imageAdapter: ImageAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentRegistrationBinding.inflate(getLayoutInflater())
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.lifecycleOwner = this
        setUpRecycler()
        listeners()
        binding.rvImages.addItemDecoration(ItemDecorator(16, false))
    }

    private fun listeners(){
        binding.ivExit.setOnClickListener {
            findNavController().navigateUp()
        }
    }

    private fun setUpRecycler() {
        val lists = mutableListOf(
            ImageItem(0, R.drawable.cat_2),
            ImageItem(1, R.drawable.cat_2),
            ImageItem(2, R.drawable.cat_2),
            ImageItem(3, R.drawable.plus, true)
        )

        imageAdapter = ImageAdapter().apply {
            onImageClick = {
                Toast.makeText(requireContext(), "Image clicked", Toast.LENGTH_SHORT).show()
            }

            onImagePlusClick = {
                Toast.makeText(requireContext(), "Plus Image", Toast.LENGTH_SHORT).show()
            }
        }
        binding.rvImages.apply {
            layoutManager = LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)
            adapter = imageAdapter
        }
        imageAdapter.submitList(lists)
    }
}