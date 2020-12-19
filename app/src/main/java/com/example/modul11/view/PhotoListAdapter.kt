package com.example.modul11.view

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.modul11.R
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.item_list.view.*
import com.example.modul11.model.Photo

class PhotoListAdapter (
    var photos: ArrayList<Photo>) :
    RecyclerView.Adapter<PhotoListAdapter.ViewHolder>() {
    //fungsi untuk mengupdate recyclerview
    fun updatePhotos(newPhotos: List<Photo>) {
        photos.clear()
        photos.addAll(newPhotos)
        notifyDataSetChanged()
    }

    //untuk membuat tampilan UI
    override fun onCreateViewHolder(parent: ViewGroup, pl: Int) = ViewHolder(
        LayoutInflater.from(parent.context).inflate(R.layout.item_list, parent, false)
    )
    override fun getItemCount() = photos.size
    //memasukkan data dengan UI
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(photos[position])
    }
    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        fun bind(photos: Photo) {
            itemView.tvTitle.text = photos.title
            itemView.textView.text= photos.id.toString()
            itemView.textView2.text = photos.thumbnail
            itemView.setOnClickListener { view ->
                Toast.makeText(itemView.context,"Hello", Toast.LENGTH_LONG).show()}
            //Glide.with(itemView.context).load(photos.thumbnail).into(itemView.imageView)
            Picasso.get().load(photos.thumbnail).into(itemView.imageView)
        }
    }
}