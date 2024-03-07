package com.example.fragmenturl
import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.fragmenturl.databinding.CustomUrlButtonBinding

class SenderAdapter(private val context: Context, private val items: ArrayList<Urls>, private val onClick: (String) -> Unit) :
    RecyclerView.Adapter<SenderAdapter.ViewHolder>() {

    inner class ViewHolder(private val binding: CustomUrlButtonBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(item: Urls) {
            binding.btnSend.text = item.url
            binding.btnSend.setOnClickListener {
                onClick(item.url)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding =
            CustomUrlButtonBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val currentItem = items[position]
        holder.bind(currentItem)
    }

    override fun getItemCount(): Int = items.size
}
