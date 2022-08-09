package com.gabriel.gotrpg.viewPager.screens

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.gabriel.gotrpg.databinding.FragmentDefenseBinding

class DefenseFragment : Fragment(){

    private var _binding: FragmentDefenseBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentDefenseBinding.inflate(inflater,container,false)


        binding.calculate.setOnClickListener {calculateDefense()}

        return binding.root
    }

    private fun isValid(): Boolean{
        return !binding.editAgility.text.isNullOrEmpty() &&
                !binding.editAtlhetism.text.isNullOrEmpty() &&
                !binding.editBonus.text.isNullOrEmpty() &&
                !binding.editPerception.text.isNullOrEmpty() &&
                !binding.editPenalty.text.isNullOrEmpty()
    }

    private fun calculateDefense() {
        if(isValid()) {
            val agility = binding.editAgility.text.toString().toInt()
            val athletism = binding.editAtlhetism.text.toString().toInt()
            val perception = binding.editPerception.text.toString().toInt()
            val bonus = binding.editBonus.text.toString().toInt()
            val penalty = binding.editPenalty.text.toString().toInt()
            val result = (agility + athletism + perception + bonus) - penalty
            binding.textDefense.text = result.toString()
        } else Toast.makeText(context,"Informe todos os valores!", Toast.LENGTH_SHORT).show()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }




}