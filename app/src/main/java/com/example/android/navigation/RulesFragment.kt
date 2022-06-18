package com.example.android.navigation

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import com.example.android.navigation.databinding.FragmentRulesBinding

class RulesFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val binding = DataBindingUtil.inflate<FragmentRulesBinding>(
            inflater,
            R.layout.fragment_rules, container, false
        )
        binding.rulesPlayButton.setOnClickListener { view: View ->
            view.findNavController().navigate(R.id.action_rulesFragment_to_gameFragment)
        }
        return binding.root
    }
}
