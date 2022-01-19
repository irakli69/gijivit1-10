package com.example.gijivit1_5

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide

class RecyclerViewPostAdapter(private val list: List<Post>): RecyclerView.Adapter<RecyclerViewPostAdapter.PostViewHolder>() {


    class PostViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){

        private val textViewUserName : TextView
        private val textViewDayNumber : TextView
        private val textViewPostDescription : TextView
        private val imageViewPfp : ImageView
        private val imageViewPost : ImageView

        init {
            textViewUserName = itemView.findViewById(R.id.textViewUserName)
            textViewDayNumber = itemView.findViewById(R.id.textViewDayNumber)
            textViewPostDescription = itemView.findViewById(R.id.textViewPostDescription)
            imageViewPfp = itemView.findViewById(R.id.imageViewPfp)
            imageViewPost = itemView.findViewById(R.id.imageViewPost)
        }





        @SuppressLint("SetTextI18n")
        fun setData(post: Post) {
            textViewUserName.text = post.userName
            textViewDayNumber.text = "Day " + post.dayNumber
            textViewPostDescription.text = post.postDescription
            Glide.with(itemView).load(post.userPostPictureUrl).into(imageViewPost)
            Glide.with(itemView).load(post.userProfilePictureUrl).into(imageViewPfp)


        }


    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PostViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.item_posts, parent , false)
        return PostViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: PostViewHolder, position: Int) {
        val post = list[position]
        holder.setData(post)
    }

    override fun getItemCount() = list.size
}