package com.example.islamic.ui.activity.chapterdetailsquran

import android.graphics.Color
import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.RecyclerView
import com.example.islamic.R
import com.example.islamic.databinding.ActivityChapterdetailsBinding
import com.example.islamic.ui.fragment.quran.ContentChapterAdapter

class ChapterDetailsActivity : AppCompatActivity() {
    lateinit var binding: ActivityChapterdetailsBinding

     var chapterPosition: Int = -1
      lateinit var chapterTitle: String
       lateinit var  versesRecyclerView: RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding=ActivityChapterdetailsBinding.inflate(layoutInflater)
        setContentView(binding.root)
binding

        initParams()
        initView()
        readAssets()
    }








private fun readAssets() {

    val allFileContent=  assets.open("${chapterPosition+1}.txt")
        .bufferedReader().use { it.readText() }
    val versesList=allFileContent.split("\n")
    bindversesRecyclerViewAdapter(versesList)

}

private fun bindversesRecyclerViewAdapter(versesList: List<String>) {
    val contentChapterAdapter= ContentChapterAdapter(versesList)
    versesRecyclerView.adapter=contentChapterAdapter

}


private fun initView() {
     setSupportActionBar(binding.toolbar)

    supportActionBar?.setDisplayHomeAsUpEnabled(true)
    supportActionBar?.setDisplayShowHomeEnabled(true)
binding.toolbar.navigationIcon?.setTint(Color.BLACK)

    binding.titleSuraName.text = chapterTitle
    versesRecyclerView=findViewById(R.id.Verses_rv)
}

@Override
override fun onSupportNavigateUp(): Boolean {
    finish()
    return true
}

private fun initParams() {
    chapterPosition = intent.getIntExtra(EXTRA_POSITION, -1)
    chapterTitle = intent.getStringExtra(EXTRA_TITLE)?:""
}

companion object {
    const val EXTRA_POSITION = "position"
    const val EXTRA_TITLE = "title"
}
}
