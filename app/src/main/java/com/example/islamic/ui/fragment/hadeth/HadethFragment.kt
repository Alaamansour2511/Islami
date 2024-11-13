package com.example.islamic.ui.fragment.hadeth

     import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
     import com.example.islamic.databinding.FragmentHadethBinding


class HadethFragment : Fragment() {


    private lateinit var binding: FragmentHadethBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentHadethBinding.inflate(LayoutInflater.from(context), container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
         readHadithFile()
    }

    private fun readHadithFile() {






        val titleHadithList:MutableList<Hadith> = mutableListOf()

        val allFileContent=
            activity?.assets?.open("ahadeth.txt")
            ?.bufferedReader()
            .use { it?.readText() }

            val ahadithList =allFileContent?.split("#")
        ahadithList?.forEach { hadith->
            val hadithLines= hadith.trim().split("\n").toMutableList()
            val title= hadithLines[0]
            hadithLines.removeAt(0)
            val h= Hadith(
           title = title,
                content = ahadithList.joinToString { "\n" }
            )
            titleHadithList.add(h)
        }
        bindHadithList(titleHadithList)

    }

    private fun bindHadithList(titleHadithList: MutableList<Hadith>) {
        val adapter=ItremHadithAdapter(titleHadithList)
        binding.chapterRv.adapter=adapter

    }




    }



