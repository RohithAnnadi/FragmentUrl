package com.example.fragmenturl
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.webkit.WebViewClient
import com.example.fragmenturl.databinding.FragmentReceiverBinding


class ReceiverFragment : Fragment() {
    private lateinit var binding: FragmentReceiverBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentReceiverBinding.inflate(layoutInflater,container
            ,false)
        setupWebView()
        return binding.root

    }

    fun sendMessage(message: String){
        binding.txtMessage.text = message
        var p="https://"+message
        binding.webview.loadUrl(p)
    }

    private fun setupWebView(){
        binding.webview.apply {
            webViewClient= WebViewClient()
            settings.javaScriptEnabled = true
        }
    }

}

