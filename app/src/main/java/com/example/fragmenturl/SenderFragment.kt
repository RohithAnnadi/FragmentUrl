package com.example.fragmenturl

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.fragmenturl.databinding.FragmentSenderBinding

class SenderFragment : Fragment() {
    private lateinit var binding: FragmentSenderBinding
    private lateinit var communicator: Communicator
    private lateinit var adapter: SenderAdapter
    private var yourList = ArrayList<Urls>()

    override fun onAttach(context: Context) {
        super.onAttach(context)
        communicator = context as Communicator
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentSenderBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        yourList.apply {
            add(Urls("www.google.com"))
            add(Urls("www.facebook.com"))
            add(Urls("www.youtube.com"))
        }

        val recyclerView = binding.recycle
        val spanCount = 1
        recyclerView.layoutManager =
            GridLayoutManager(requireContext(), spanCount, LinearLayoutManager.VERTICAL, false)

        adapter = SenderAdapter(requireContext(), yourList) { clickedUrl ->
            communicator.sendMessage(clickedUrl)
        }
        recyclerView.adapter = adapter

        binding.btnSend.setOnClickListener {
            val inputUrl = binding.edInput.text.toString()
            if (inputUrl.isNotEmpty()) {
                yourList.add(Urls(inputUrl))
                adapter.notifyDataSetChanged()
                binding.edInput.text.clear()
            }
        }
    }
}

