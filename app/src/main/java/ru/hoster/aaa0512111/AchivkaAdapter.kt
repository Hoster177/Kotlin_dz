package ru.hoster.myapplication

import android.graphics.Bitmap
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import ru.hoster.aaa0512111.Achivka

class AchivkaAdapter(val kittyArray: ArrayList<Achivka>) : RecyclerView.Adapter<AchivkaAdapter.KittyHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): KittyHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val view = layoutInflater.inflate(R.layout.cardkitty,parent,false)

        return KittyHolder(view)
    }

    override fun onBindViewHolder(holder: KittyHolder, position: Int) {
        val kitty = kittyArray[position]
        holder.nameTV?.text = kitty.name

    }

    override fun getItemCount(): Int {
        return kittyArray.size
    }


    inner class KittyHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
        var nameTV: TextView? = null

        init {
            nameTV = itemView.findViewById(R.id.Name)
        }
    }
}