package com.example.islamic.ui.fragment.quran

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.islamic.R


class ContentChapterAdapter(  val versesList: List<String>):RecyclerView.Adapter<ContentChapterAdapter.viewHolder>() {



    class viewHolder(itemView:View):
        RecyclerView.ViewHolder(itemView){
        val versesContent:TextView=itemView.findViewById(R.id.Contant)

     }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): viewHolder {
        val view=LayoutInflater.from(parent.context).inflate(R.layout.item_chapter_details,parent,false)
        return viewHolder(view)
     }

    override fun getItemCount(): Int=versesList.size

    @SuppressLint("SetTextI18n")
    override fun onBindViewHolder(holder: viewHolder, position: Int) {
        val content=versesList[position]
        holder.versesContent.text="$content(${position+1})"
     }
}