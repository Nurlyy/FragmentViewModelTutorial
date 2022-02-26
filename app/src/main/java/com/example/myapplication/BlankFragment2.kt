package com.example.myapplication

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.LifecycleOwner
import com.example.myapplication.databinding.FragmentBlank2Binding

class BlankFragment2 : Fragment() {
    private val dataModel: DataModel by activityViewModels()
    private lateinit var binding: FragmentBlank2Binding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentBlank2Binding.inflate(inflater)
        return binding.root


    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {

        dataModel.messageToFragment2.observe(activity as LifecycleOwner, {
            binding.message2.text = it
        })

        binding.btnSendToActivity.setOnClickListener{
            dataModel.messageToActivity.value = "This is message from Fragment2 to Activity"
        }

        binding.btnSendToFragment1.setOnClickListener{
            dataModel.messageToFragment1.value = "This is message from Fragment2 to Fragment1"
        }
    }

    companion object {
        @JvmStatic
        fun newInstance() = BlankFragment2()
    }
}