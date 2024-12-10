package ru.hoster.aaa0512111

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class AchivkaAdapter(val taskArray: ArrayList<Achivka>) : RecyclerView.Adapter<AchivkaAdapter.AchivkaHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AchivkaHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val view = layoutInflater.inflate(R.layout.taskcard,parent,false)

        return AchivkaHolder(view)
    }

    override fun onBindViewHolder(holder: AchivkaHolder, position: Int) {
        val kitty = taskArray[position]
        holder.nameTV?.text = kitty.name

    }

    override fun getItemCount(): Int {
        return taskArray.size
    }


    inner class AchivkaHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
        var nameTV: TextView? = null

        init {
            nameTV = itemView.findViewById(R.id.Name)
        }
    }
}