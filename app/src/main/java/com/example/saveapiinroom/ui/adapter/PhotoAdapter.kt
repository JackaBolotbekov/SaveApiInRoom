package com.example.saveapiinroom.ui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.bumptech.glide.Glide
import com.example.saveapiinroom.data.model.Photo
import com.example.saveapiinroom.databinding.ItemPhotoBinding

class PhotoAdapter : ListAdapter<Photo, PhotoAdapter.PhotoViewHolder>(diffUtil) {
    inner class PhotoViewHolder(private val binding: ItemPhotoBinding) : ViewHolder(binding.root) {
        fun onBind(item: Photo) {
            Glide.with(binding.imageIcon.context)
                .load(item.url + ".png")
                .into(binding.imageIcon)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PhotoViewHolder {
        return PhotoViewHolder(
            ItemPhotoBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: PhotoViewHolder, position: Int) {
        getItem(position)?.let {
            holder.onBind(it)
        }
    }

    companion object {
        val diffUtil = object : DiffUtil.ItemCallback<Photo>() {
            override fun areItemsTheSame(oldItem: Photo, newItem: Photo): Boolean {
                return oldItem.id == newItem.id
            }
            override fun areContentsTheSame(oldItem: Photo, newItem: Photo): Boolean {
                return oldItem == newItem
            }
        }
    }
}