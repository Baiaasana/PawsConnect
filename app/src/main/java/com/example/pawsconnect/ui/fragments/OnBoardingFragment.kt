package com.example.pawsconnect.ui.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.pawsconnect.R
import com.example.pawsconnect.databinding.FragmentOnBoardingBinding

class OnBoardingFragment : Fragment() {

    private var _binding: FragmentOnBoardingBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentOnBoardingBinding.inflate(inflater, container, false)
        requireActivity().setTheme(R.style.Base_Theme_PawsConnect)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        listeners()
    }

    private fun listeners() = with(binding) {
        btnRegister.setOnClickListener { findNavController().navigate(OnBoardingFragmentDirections.actionOnBoardingFragmentToRegistrationFragment()) }
        btnSkip.setOnClickListener { findNavController().navigate(OnBoardingFragmentDirections.actionOnBoardingFragmentToMainFragment()) }
        btnAuth.setOnClickListener { findNavController().navigate(OnBoardingFragmentDirections.actionOnBoardingFragmentToAuthfragment()) }
    }

}