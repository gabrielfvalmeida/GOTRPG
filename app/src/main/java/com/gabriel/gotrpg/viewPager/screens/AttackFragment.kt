package com.gabriel.gotrpg.viewPager.screens

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.CompoundButton
import android.widget.Toast
import com.gabriel.gotrpg.R
import com.gabriel.gotrpg.databinding.FragmentAttackBinding

class AttackFragment : Fragment(), View.OnClickListener, CompoundButton.OnCheckedChangeListener {

    private lateinit var binding: FragmentAttackBinding


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentAttackBinding.inflate(layoutInflater)

        binding.radioButtonMelee.setOnCheckedChangeListener(this)
        binding.radioButtonRanged.setOnCheckedChangeListener(this)
        binding.buttonCalculate.setOnClickListener(this)

        binding.text1.text = "Luta"

        return binding.root
    }

    override fun onClick(v: View) {
        when (v.id) {
            R.id.buttonCalculate -> calculateDamage()
        }
    }

    override fun onCheckedChanged(buttonView: CompoundButton, isChecked: Boolean) {
        when (buttonView.id) {
            R.id.radioButtonMelee -> {
                if (isChecked) {
                    binding.text1.text = "Luta"
                }
            }
            R.id.radioButtonRanged -> {
                if (isChecked) {
                    binding.text1.text = "Precisão"
                }
            }
        }
    }

    private fun isValid(): Boolean{
        return !binding.editGraduation.text.isNullOrEmpty() && !binding.editModifier.text.isNullOrEmpty() && !binding.editSuccess.text.isNullOrEmpty()
    }

    private fun calculateDamage() {
        if(isValid()) {
            val graduation = binding.editGraduation.text.toString().toInt()
            val modifier = binding.editModifier.text.toString().toInt()
            val success = binding.editSuccess.text.toString().toInt()
            val total = (graduation + modifier) * success
            binding.textDamage.text = total.toString()
        } else Toast.makeText(context,"Informe todos os valores!",Toast.LENGTH_SHORT).show()
    }




}