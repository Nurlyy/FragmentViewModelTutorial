package com.example.myapplication

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.LifecycleOwner
import com.example.myapplication.databinding.FragmentBlankBinding

class BlankFragment : Fragment() {

    private val dataModel: DataModel by activityViewModels()
    private lateinit var binding: FragmentBlankBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentBlankBinding.inflate(inflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        dataModel.messageToFragment1.observe(activity as LifecycleOwner, {
            binding.message.text = it
        })

        binding.btnSendToFragment2.setOnClickListener{
            dataModel.messageToFragment2.value = "Hello from Fragment1"
        }

        binding.btnSendToActivity.setOnClickListener{
            dataModel.messageToActivity.value = "Hello activity from Fragment1 "
        }
    }

    companion object {
        @JvmStatic
        fun newInstance() = BlankFragment()
    }
}