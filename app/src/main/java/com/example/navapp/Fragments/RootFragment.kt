package com.example.navapp.Fragments

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.compose.ui.graphics.Color
import androidx.core.content.ContextCompat.getColor
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.navapp.Fragments.BoxFragment.Companion.ARG_COLOR
import com.example.navapp.Fragments.BoxFragment.Companion.EXTRA_RANDOM_NUMBER
import com.example.navapp.R
import com.example.navapp.databinding.FragmentRootBinding

class RootFragment : Fragment(R.layout.fragment_root) {

    private lateinit var binding: FragmentRootBinding

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentRootBinding.bind(view)
        binding.greenBox.setOnClickListener {
            openBox(getColor(requireContext(),R.color.green) , "Green")
        }
        binding.yellowBox.setOnClickListener {
            openBox(getColor(requireContext(),R.color.yellow), "Yellow")

        }

        val liveData =
            findNavController().currentBackStackEntry?.savedStateHandle
                ?.getLiveData<Int>(EXTRA_RANDOM_NUMBER)
        liveData?.observe(viewLifecycleOwner) {
            if (it != null){
                Toast.makeText(
                    requireContext(),
                    "Generate number $it",
                    Toast.LENGTH_SHORT
                ).show()
                liveData.value = null
            }
        }

//        parentFragmentManager.setFragmentResultListener(BoxFragment.REQUEST_CODE, viewLifecycleOwner){ _, data ->
//            val number = data.getInt(BoxFragment.EXTRA_RANDOM_NUMBER)
//            Toast.makeText(requireContext(), "Generate number $number", Toast.LENGTH_SHORT).show()
//        }
    }

//    private fun openBox(color: Int, colorName: String) {
//        findNavController().navigate(
//            R.id.action_rootFragment_to_boxFragment,
//            bundleOf(ARG_COLOR to color , BoxFragment.ARG_COLOR_NAME to colorName)
//        )
//    }

    private fun openBox(color: Int, colorName: String) {
        val direction = RootFragmentDirections.actionRootFragmentToBoxFragment(colorName, color)

        findNavController().navigate(direction)
    }
}