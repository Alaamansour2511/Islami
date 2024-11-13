package com.example.islamic.ui.fragment.hadeth


import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
 import com.example.islamic.databinding.ItemTitleHadithBinding


class ItremHadithAdapter(val hadithList: MutableList<Hadith>):RecyclerView.Adapter<ItremHadithAdapter.ViewHolder>()
{

 class ViewHolder(val binding: ItemTitleHadithBinding):RecyclerView.ViewHolder(binding.root)

 override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {

 val binding=ItemTitleHadithBinding.inflate(LayoutInflater.from(parent.context),parent,false)
 return ViewHolder(binding)
 }

 override fun getItemCount(): Int =hadithList.size

 override fun onBindViewHolder(holder: ViewHolder, position: Int) {
  val title=hadithList[position].title
  holder.binding.hadethName.text="$title{${position+1}}"

  }

  }


