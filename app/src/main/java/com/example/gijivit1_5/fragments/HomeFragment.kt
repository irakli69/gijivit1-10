package com.example.gijivit1_5.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.gijivit1_5.Day
import com.example.gijivit1_5.R
import com.example.gijivit1_5.RecyclerViewDayAdapter


class HomeFragment : Fragment(R.layout.fragment_home) {
    private lateinit var recyclerViewDayAdapter : RecyclerViewDayAdapter
    private lateinit var recyclerView : RecyclerView


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        recyclerView = view.findViewById(R.id.recyclerView)
        recyclerViewDayAdapter = RecyclerViewDayAdapter(getData())
        recyclerView.layoutManager = LinearLayoutManager(activity)
        recyclerView.adapter = recyclerViewDayAdapter

    }

    private fun getData(): List<Day>{
        val dayList = ArrayList<Day>()
        dayList.add(
            Day("Day 1", "Push Day",
                R.drawable.diamond_pushup, "Diamond Push-Ups", "2 Sets of 6 Repetitions",
                R.drawable.pike_pushup, "Pyke Push-Ups", "2 Sets of 6 Repetitions",
                R.drawable.wide_pushup, "Wide Push-Ups", "2 Sets of 6 Repetitions"
            )
        )
        dayList.add(
            Day("Day 2", "Pull Day",
                R.drawable.pullup, "Pull-Ups", "2 Sets of 4 Repetitions",
                R.drawable.curls, "Biceps Curls", "2 Sets of 12 Repetitions",
                R.drawable.plank, "Plank", "30 seconds"
            )
        )
        dayList.add(
            Day("Day 3", "Leg Day",
                R.drawable.squat, "Squats", "2 Sets of 12 Repetitions",
                R.drawable.bulgarian_squat, "Bulgarian Squats", "2 Sets of 6 Repetitions",
                R.drawable.crunches, "Crunches", "2 Sets of 8 Repetitions"
            )
        )
        dayList.add(
            Day("Day 4", "Rest Day",
                0, "", "",
                0, "", "",
                0, "", ""
            )
        )
        dayList.add(
            Day("Day 5", "Push Day",
                R.drawable.diamond_pushup, "Diamond Push-Ups", "2 Sets of 8 Repetitions",
                R.drawable.pike_pushup, "Pyke Push-Ups", "2 Sets of 8 Repetitions",
                R.drawable.wide_pushup, "Wide Push-Ups", "2 Sets of 8 Repetitions"
            )
        )
        dayList.add(
            Day("Day 6", "Pull Day",
                R.drawable.pullup, "Pull-Ups", "2 Sets of 4 Repetitions",
                R.drawable.curls, "Biceps Curls", "2 Sets of 12 Repetitions",
                R.drawable.plank, "Plank", "35 seconds"
            )
        )
        dayList.add(
            Day("Day 7", "Leg Day",
                R.drawable.squat, "Squats", "2 Sets of 15 Repetitions",
                R.drawable.bulgarian_squat, "Bulgarian Squats", "2 Sets of 8 Repetitions",
                R.drawable.crunches, "Crunches", "2 Sets of 10 Repetitions"
            )
        )
        dayList.add(
            Day("Day 8", "Rest Day",
                0, "", "",
                0, "", "",
                0, "", ""
            )
        )
        dayList.add(
            Day("Day 9", "Rest Day",
                0, "", "",
                0, "", "",
                0, "", ""
            )
        )
        dayList.add(
            Day("Day 10", "Push Day",
                R.drawable.diamond_pushup, "Diamond Push-Ups", "2 Sets of 10 Repetitions",
                R.drawable.pike_pushup, "Pyke Push-Ups", "2 Sets of 10 Repetitions",
                R.drawable.wide_pushup, "Wide Push-Ups", "2 Sets of 10 Repetitions"
            )
        )
        dayList.add(
            Day("Day 11", "Pull Day",
                R.drawable.pullup, "Pull-Ups", "2 Sets of 5 Repetitions",
                R.drawable.curls, "Biceps Curls", "2 Sets of 12 Repetitions",
                R.drawable.plank, "Plank", "40 seconds"
            )
        )
        dayList.add(
            Day("Day 12", "Leg Day",
                R.drawable.squat, "Squats", "2 Sets of 15 Repetitions",
                R.drawable.bulgarian_squat, "Bulgarian Squats", "2 Sets of 8 Repetitions",
                R.drawable.crunches, "Crunches", "2 Sets of 10 Repetitions"
            )
        )
        dayList.add(
            Day("Day 13", "Rest Day",
                0, "", "",
                0, "", "",
                0, "", ""
            )
        )
        dayList.add(
            Day("Day 14", "Push Day",
                R.drawable.diamond_pushup, "Diamond Push-Ups", "2 Sets of 10 Repetitions",
                R.drawable.pike_pushup, "Pyke Push-Ups", "2 Sets of 10 Repetitions",
                R.drawable.wide_pushup, "Wide Push-Ups", "2 Sets of 10 Repetitions"
            )
        )
        dayList.add(
            Day("Day 15", "Pull Day",
                R.drawable.pullup, "Pull-Ups", "2 Sets of 5 Repetitions",
                R.drawable.curls, "Biceps Curls", "2 Sets of 12 Repetitions",
                R.drawable.plank, "Plank", "45 seconds"
            )
        )
        dayList.add(
            Day("Day 16", "Leg Day",
                R.drawable.squat, "Squats", "2 Sets of 15 Repetitions",
                R.drawable.bulgarian_squat, "Bulgarian Squats", "2 Sets of 8 Repetitions",
                R.drawable.crunches, "Crunches", "2 Sets of 12 Repetitions"
            )
        )
        dayList.add(
            Day("Day 17", "Rest Day",
                0, "", "",
                0, "", "",
                0, "", ""
            )
        )
        dayList.add(
            Day("Day 18", "Push Day",
                R.drawable.diamond_pushup, "Diamond Push-Ups", "3 Sets of 6 Repetitions",
                R.drawable.pike_pushup, "Pyke Push-Ups", "3 Sets of 6 Repetitions",
                R.drawable.wide_pushup, "Wide Push-Ups", "3 Sets of 6 Repetitions"
            )
        )
        dayList.add(
            Day("Day 19", "Pull Day",
                R.drawable.pullup, "Pull-Ups", "2 Sets of 5 Repetitions",
                R.drawable.curls, "Biceps Curls", "3 Sets of 12 Repetitions",
                R.drawable.plank, "Plank", "50 seconds"
            )
        )
        dayList.add(
            Day("Day 20", "Leg Day",
                R.drawable.squat, "Squats", "2 Sets of 20 Repetitions",
                R.drawable.bulgarian_squat, "Bulgarian Squats", "3 Sets of 6 Repetitions",
                R.drawable.crunches, "Crunches", "3 Sets of 8 Repetitions"
            )
        )
        dayList.add(
            Day("Day 21", "Rest Day",
                0, "", "",
                0, "", "",
                0, "", ""
            )
        )
        dayList.add(
            Day("Day 22", "Rest Day",
                0, "", "",
                0, "", "",
                0, "", ""
            )
        )
        dayList.add(
            Day("Day 23", "Rest Day",
                0, "", "",
                0, "", "",
                0, "", ""
            )
        )
        dayList.add(
            Day("Day 24", "Push Day",
                R.drawable.diamond_pushup, "Diamond Push-Ups", "3 Sets of 8 Repetitions",
                R.drawable.pike_pushup, "Pyke Push-Ups", "3 Sets of 8 Repetitions",
                R.drawable.wide_pushup, "Wide Push-Ups", "3 Sets of 8 Repetitions"
            )
        )
        dayList.add(
            Day("Day 25", "Pull Day",
                R.drawable.pullup, "Pull-Ups", "3 Sets of 4 Repetitions",
                R.drawable.curls, "Biceps Curls", "3 Sets of 12 Repetitions",
                R.drawable.plank, "Plank", "55 seconds"
            )
        )
        dayList.add(
            Day("Day 26", "Leg Day",
                R.drawable.squat, "Squats", "3 Sets of 15 Repetitions",
                R.drawable.bulgarian_squat, "Bulgarian Squats", "3 Sets of 6 Repetitions",
                R.drawable.crunches, "Crunches", "3 Sets of 12 Repetitions"
            )
        )
        dayList.add(
            Day("Day 27", "Rest Day",
                0, "", "",
                0, "", "",
                0, "", ""
            )
        )
        dayList.add(
            Day("Day 28", "Push Day",
                R.drawable.diamond_pushup, "Diamond Push-Ups", "3 Sets of 8 Repetitions",
                R.drawable.pike_pushup, "Pyke Push-Ups", "3 Sets of 8 Repetitions",
                R.drawable.wide_pushup, "Wide Push-Ups", "3 Sets of 8 Repetitions"
            )
        )
        dayList.add(
            Day("Day 29", "Pull Day",
                R.drawable.pullup, "Pull-Ups", "3 Sets of 5 Repetitions",
                R.drawable.curls, "Biceps Curls", "3 Sets of 12 Repetitions",
                R.drawable.plank, "Plank", "60 seconds"
            )
        )
        dayList.add(
            Day("Day 30", "Leg Day",
                R.drawable.squat, "Squats", "3 Sets of 15 Repetitions",
                R.drawable.bulgarian_squat, "Bulgarian Squats", "3 Sets of 8 Repetitions",
                R.drawable.crunches, "Crunches", "3 Sets of 12 Repetitions"
            )
        )

        return dayList
    }
}