package com.example.navapp.Fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.navapp.R
import com.example.navapp.databinding.FragmentSecretBinding


class SecretFragment : Fragment(R.layout.fragment_secret) {
    private lateinit var binding: FragmentSecretBinding

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentSecretBinding.bind(view)

        binding.closeSecret.setOnClickListener{
            findNavController().popBackStack()
        }

        binding.closeBox.setOnClickListener {
            findNavController().popBackStack(R.id.rootFragment, false)
        }
    }
}