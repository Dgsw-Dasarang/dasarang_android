package co.dasa.dasarang.features.plaza.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import co.dasa.dasarang.databinding.ItemBannerBinding

class ViewPagerAdapter : RecyclerView.Adapter<ViewPagerAdapter.MyViewHolder>() {
    val item = mutableListOf<Int>()

    inner class MyViewHolder(private val binding: ItemBannerBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind() {
            binding.ivAds.setImageResource(item[position])
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val binding = ItemBannerBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return MyViewHolder(binding)
    }

    override fun getItemCount(): Int = item.size

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.bind()
    }
}
