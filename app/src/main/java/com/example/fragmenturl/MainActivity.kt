package com.example.fragmenturl

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.fragmenturl.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity(),Communicator {
    private lateinit var binding: ActivityMainBinding
    private lateinit var senderFragment: SenderFragment
    private lateinit var receiverFragment: ReceiverFragment
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        initViews()
    }

    private fun initViews() {
        receiverFragment = ReceiverFragment()
        senderFragment = SenderFragment()

        supportFragmentManager.beginTransaction().replace(R.id.receiverFrag, receiverFragment)
            .commit()

        supportFragmentManager.beginTransaction().replace(R.id.senderFrag,senderFragment).commit()
    }

    override fun sendMessage(message: String){
        receiverFragment.sendMessage(message)
    }
}