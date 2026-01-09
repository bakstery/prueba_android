package com.example.androidtest3.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.androidtest3.R
import com.example.androidtest3.models.Result
import com.google.android.material.imageview.ShapeableImageView

class CharacterAdapter(private val context: Context, private val listCharacters: List<Result?>?) :
    RecyclerView.Adapter<CharacterAdapter.ViewHolder>() {

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val iv_imagen: ShapeableImageView
        val tv_name: TextView
        val tv_especie: TextView
        val tv_type: TextView

        init {
            // Define click listener for the ViewHolder's View
            iv_imagen = view.findViewById(R.id.iv_image)
            tv_name = view.findViewById(R.id.tv_name)
            tv_especie = view.findViewById(R.id.tv_especie)
            tv_type = view.findViewById(R.id.tv_type)
        }
    }

    // Create new views (invoked by the layout manager)
    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): ViewHolder {
        // Create a new view, which defines the UI of the list item
        val view = LayoutInflater.from(viewGroup.context)
            .inflate(R.layout.items_list, viewGroup, false)

        return ViewHolder(view)
    }

    // Replace the contents of a view (invoked by the layout manager)
    override fun onBindViewHolder(viewHolder: ViewHolder, position: Int) {

        // Get element from your dataset at this position and replace the
        // contents of the view with that element
        viewHolder.tv_name.text = listCharacters?.get(position)?.name
        viewHolder.tv_especie.text = listCharacters?.get(position)?.species
        viewHolder.tv_type.text = listCharacters?.get(position)?.type

        Glide.with(context).load(listCharacters?.get(position)?.image).into(viewHolder.iv_imagen)
    }

    // Return the size of your dataset (invoked by the layout manager)
    override fun getItemCount() = listCharacters!!.size

}