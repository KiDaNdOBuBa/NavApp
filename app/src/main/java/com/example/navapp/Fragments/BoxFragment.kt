package com.example.navapp.Fragments

import android.os.Bundle
import android.view.View
import androidx.compose.ui.graphics.Color
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.example.navapp.R
import com.example.navapp.databinding.FragmentBoxBinding
import kotlin.random.Random


class BoxFragment : Fragment(R.layout.fragment_box) {

    private lateinit var binding: FragmentBoxBinding
    private val args: BoxFragmentArgs by navArgs()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentBoxBinding.bind(view)

        val color = args.color
        binding.root.setBackgroundColor(color)

        binding.goBack.setOnClickListener {
            findNavController().popBackStack()
        }
        binding.openSecret.setOnClickListener {
            findNavController().navigate(BoxFragmentDirections.actionBoxFragmentToSecretFragment())
        }

        binding.generateNum.setOnClickListener {
            val number = Random.nextInt(100)
//            parentFragmentManager.setFragmentResult(
//                REQUEST_CODE,
//                bundleOf(EXTRA_RANDOM_NUMBER to number)
//            )
            findNavController().previousBackStackEntry?.savedStateHandle?.set(
                EXTRA_RANDOM_NUMBER,
                number
            )
            findNavController().popBackStack()
        }
    }

    companion object {
        const val ARG_COLOR = "color"
        const val ARG_COLOR_NAME = "colorName"
        const val REQUEST_CODE = "RANDOM_NUMBER_REQUEST_CODE"
        const val EXTRA_RANDOM_NUMBER = "EXTRA_RANDOM_NUMBER"
    }
}