package com.waracle.mytestapplication.view.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.appcompat.app.AlertDialog
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.AsyncListDiffer
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.waracle.mytestapplication.R
import com.waracle.mytestapplication.databinding.ItemCakeBinding
import com.waracle.mytestapplication.model.Cake

class CakesAdapter : RecyclerView.Adapter<CakesAdapter.CakeViewHolder>() {

    inner class CakeViewHolder(
        private val binding: ItemCakeBinding,
    ) : RecyclerView.ViewHolder(binding.root) {
        fun bind(cake: Cake) {
            binding.cake = cake
            if (cake.image != null && !cake.image.equals("", true)) {
                Glide.with(itemView.context).load(cake.image)
                    .placeholder(R.drawable.ic_cake).circleCrop()
                    .into(binding.cakeImage)
            }
            binding.root.setOnClickListener {
                AlertDialog.Builder(itemView.context)
                    .setTitle("Clicked on item")
                    .setMessage("The cake you clicked has description: ${cake.desc}")
                    .setPositiveButton(
                        "OK", null
                    ).show()
            }

        }
    }


    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): CakeViewHolder {
        return CakeViewHolder(
            DataBindingUtil.inflate(
                LayoutInflater.from(parent.context),
                R.layout.item_cake,
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: CakeViewHolder, position: Int) {
        val item = differ.currentList[position]

        holder.bind(item)

    }

    override fun getItemCount(): Int {
        return differ.currentList.size
    }

    private val diffCallback = object : DiffUtil.ItemCallback<Cake>() {
        override fun areItemsTheSame(oldItem: Cake, newItem: Cake): Boolean {
            return oldItem.title == newItem.title
        }

        override fun areContentsTheSame(oldItem: Cake, newItem: Cake): Boolean {
            return oldItem.hashCode() == newItem.hashCode()
        }
    }

    private val differ = AsyncListDiffer(this, diffCallback)

    fun submitList(list: List<Cake>) = differ.submitList(list)

}
