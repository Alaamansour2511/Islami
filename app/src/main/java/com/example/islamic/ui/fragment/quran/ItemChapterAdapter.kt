package com.example.islamic.ui.fragment.quran

import android.view.LayoutInflater
 import android.view.ViewGroup
 import androidx.recyclerview.widget.RecyclerView
 import com.example.islamic.databinding.ItemQuranBinding

class ItemChapterAdapter(private val chapters: List<String>):RecyclerView.Adapter<ItemChapterAdapter.ViewHolder>(){
    var  onItemClickListener:OnItemClickListener?=null

    class  ViewHolder(val binding:ItemQuranBinding) : RecyclerView.ViewHolder(binding.root)


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding=ItemQuranBinding.inflate(LayoutInflater.from(parent.context),parent, false)
return ViewHolder(binding)
    }

    override fun getItemCount(): Int=chapters.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val title=chapters[position]
        holder.binding.cahpterName.text=title
        if (onItemClickListener!=null){
            holder.itemView.setOnClickListener{
                onItemClickListener?.onItemClick(position,title)
             }
        }

      }

    fun interface OnItemClickListener{
        fun onItemClick(position: Int,title: String)
    }

}