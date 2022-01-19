package com.example.gijivit1_5

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import org.w3c.dom.Text

class RecyclerViewDayAdapter(private val list: List<Day>): RecyclerView.Adapter<RecyclerViewDayAdapter.DayViewHolder>() {

    class DayViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){

        private val textViewTitle : TextView
        private val textViewDayType : TextView
        private val imageViewFirst : pl.droidsonroids.gif.GifImageView
        private val textViewFirstTitle : TextView
        private val textViewFirstDescription : TextView
        private val imageViewSecond : pl.droidsonroids.gif.GifImageView
        private val textViewSecondTitle : TextView
        private val textViewSecondDescription : TextView
        private val imageViewThird : pl.droidsonroids.gif.GifImageView
        private val textViewThirdTitle : TextView
        private val textViewThirdDescription : TextView
        init {
            textViewTitle = itemView.findViewById(R.id.textViewTitle)
            textViewDayType = itemView.findViewById(R.id.textViewDayType)

            imageViewFirst = itemView.findViewById(R.id.imageViewFirst)
            textViewFirstTitle = itemView.findViewById(R.id.textViewFirstTitle)
            textViewFirstDescription = itemView.findViewById(R.id.textViewFirstDescription)

            textViewSecondTitle = itemView.findViewById(R.id.textViewSecondTitle)
            textViewSecondDescription = itemView.findViewById(R.id.textViewSecondDescription)
            imageViewSecond = itemView.findViewById(R.id.imageViewSecond)

            textViewThirdDescription = itemView.findViewById(R.id.textViewThirdDescription)
            textViewThirdTitle = itemView.findViewById(R.id.textViewThirdTitle)
            imageViewThird = itemView.findViewById(R.id.imageViewThird)




        }

        fun setData(day : Day){
            textViewTitle.text = day.title
            textViewDayType.text = day.dayType

            imageViewFirst.setImageResource(day.firstImageUrl)


            textViewFirstTitle.text = day.firstTitle
            textViewFirstDescription.text = day.firstDescription

            imageViewSecond.setImageResource(day.secondImageUrl)
            textViewSecondTitle.text = day.secondTitle
            textViewSecondDescription.text = day.secondDescription


            imageViewThird.setImageResource(day.thirdImageUrl)
            textViewThirdTitle.text = day.thirdTitle
            textViewThirdDescription.text = day.thirdDescription




        }


    }




    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DayViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.item_days, parent, false)
        return DayViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: DayViewHolder, position: Int) {
        val day = list[position]
        holder.setData(day)
    }

    override fun getItemCount() = list.size

}