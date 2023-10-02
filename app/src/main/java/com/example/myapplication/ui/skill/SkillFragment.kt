package com.example.myapplication.ui.skill

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.myapplication.R

private const val t10 = "t1"
private const val t20 = "t2"

class SkillFragment : Fragment() {

    private var t1: String? = null

    private lateinit var adapter: MyAdapter
    private lateinit var recyclerView: RecyclerView
    private lateinit var skillArrayList: ArrayList<Skill>

    private lateinit var imageId: Array<Int>
    private lateinit var heading: Array<String>
    private lateinit var skill: Array<String>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            t1 = it.getString(t10)
            t1 = it.getString(t20)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_skill, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val layoutManager = LinearLayoutManager(context)
        recyclerView = view.findViewById(R.id.recyclerView)
        recyclerView.layoutManager = layoutManager
        recyclerView.setHasFixedSize(true)
        dataInitialize()
        adapter = MyAdapter(skillArrayList)
        recyclerView.adapter = adapter

        adapter.onItemClick = {
            val intent = Intent(requireContext(), SkillDetailFragment::class.java)
            intent.putExtra("skill", it)
            startActivity(intent)
        }
    }

    private fun dataInitialize() {
        skillArrayList = arrayListOf<Skill>()

        imageId = arrayOf(
            R.drawable.ic_launcher_background
        )

        heading = arrayOf(
            getString(R.string.text_cpp)
        )

        for (i in imageId.indices) {
            val skill = Skill(imageId[i], heading[i])
            skillArrayList.add(skill)
        }
    }

    companion object {
        fun inflate(inflater: LayoutInflater, container: ViewGroup?, b: Boolean): SkillFragment? {
            return TODO("Provide the return value")
        }
    }
}
