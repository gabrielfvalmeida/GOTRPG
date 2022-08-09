package com.gabriel.gotrpg

import android.os.Bundle
import android.os.Handler
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import kotlinx.coroutines.delay
import java.util.*
import kotlin.concurrent.schedule

class SplashFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        Handler().postDelayed({findNavController().navigate(R.id.action_splashFragment_to_viewPagerFragment)},2000)
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.splash_screen, container, false)
    }

}


