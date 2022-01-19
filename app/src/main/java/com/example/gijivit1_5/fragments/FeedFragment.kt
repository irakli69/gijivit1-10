package com.example.gijivit1_5.fragments

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.gijivit1_5.Post
import com.example.gijivit1_5.R
import com.example.gijivit1_5.RecyclerViewPostAdapter
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener


class FeedFragment : Fragment(R.layout.fragment_feed) {

    private lateinit var recyclerViewPostAdapter: RecyclerViewPostAdapter
    private lateinit var recyclerViewPost : RecyclerView
    private val dataPosts = FirebaseDatabase.getInstance().getReference("Posts")



    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        recyclerViewPost = view.findViewById(R.id.recyclerViewPost)
        recyclerViewPost.layoutManager = LinearLayoutManager(activity)

        getData()

    }

    private fun getData(){
        dataPosts.addValueEventListener(object : ValueEventListener{
            override fun onDataChange(snapshot: DataSnapshot) {
                val list = ArrayList<Post>()
                for (data in snapshot.children){
                    list.add(data.getValue(Post::class.java) as Post)
                }
                if (list.size > 0){
                    recyclerViewPostAdapter = RecyclerViewPostAdapter(list)
                    recyclerViewPost.adapter = recyclerViewPostAdapter
                }
            }

            override fun onCancelled(error: DatabaseError) {

            }

        })


    }

}