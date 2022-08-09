package com.gabriel.gotrpg.viewPager

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.gabriel.gotrpg.databinding.FragmentViewPagerBinding
import com.gabriel.gotrpg.viewPager.screens.AttackFragment
import com.gabriel.gotrpg.viewPager.screens.DefenseFragment
import com.gabriel.gotrpg.viewPager.screens.TableFragment
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator

class ViewPagerFragment : Fragment() {

    private lateinit var binding: FragmentViewPagerBinding


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        binding = FragmentViewPagerBinding.inflate(layoutInflater)

        val fragmentList = arrayListOf(AttackFragment(), DefenseFragment(), TableFragment())


        val adapter = ViewPagerAdapter(requireActivity().supportFragmentManager, lifecycle,fragmentList)

        binding.viewPager.adapter = adapter

        TabLayoutMediator(binding.tabLayout,binding.viewPager){tab,position->
            when(position){
                0 -> tab.text = "Dano"
                1 -> tab.text = "Defesa"
                2 -> tab.text = "Tabelas"
            }

        }.attach()

        return binding.root
    }

}