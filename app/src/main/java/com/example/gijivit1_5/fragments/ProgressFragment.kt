package com.example.gijivit1_5.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.example.gijivit1_5.R
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.FirebaseDatabase


class ProgressFragment : Fragment(R.layout.fragment_progress) {


    private lateinit var editTextDayNumberPost : EditText
    private lateinit var editTextPictureUrlPost : EditText
    private lateinit var editTextDescriptionPost : EditText
    private lateinit var buttonPost : Button
    private val auth = FirebaseAuth.getInstance()
    private val dataPosts = FirebaseDatabase.getInstance().getReference("Posts")
    private val dataUser = FirebaseDatabase.getInstance().getReference("UserInfo")

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        init()

        createPost()
    }

    private fun createPost() {
        buttonPost.setOnClickListener {
            val postDescription = editTextDescriptionPost.text.toString()
            val dayNumber = editTextDayNumberPost.text.toString()
            val userPostPictureUrl = editTextPictureUrlPost.text.toString()

            if(dayNumber.isEmpty()){
                editTextDayNumberPost.error = "Empty!"
                return@setOnClickListener
            }else if (userPostPictureUrl.isEmpty()){
                editTextPictureUrlPost.error = "Empty!"
                return@setOnClickListener
            }else if (postDescription.isEmpty()){
                editTextDescriptionPost.error = "Empty!"
                return@setOnClickListener
            }
            dataUser.child(auth.currentUser?.uid!!).get().addOnSuccessListener {
                if (it.exists()) {
                    val profilePhotoUrl = it.child("profilePhotoUrl").value
                    val userName = it.child("fullName").value




                        val id = dataPosts.push().key
                        dataPosts.child(id.toString()).child("userName").setValue(userName)
                        dataPosts.child(id.toString()).child("dayNumber").setValue(dayNumber)
                        dataPosts.child(id.toString()).child("postDescription").setValue(postDescription)
                        dataPosts.child(id.toString()).child("userPostPictureUrl").setValue(userPostPictureUrl)
                        dataPosts.child(id.toString()).child("userProfilePictureUrl").setValue(profilePhotoUrl.toString())
                        Toast.makeText(activity, "The post has been published", Toast.LENGTH_LONG).show()

                }
            }
        }
    }

    private fun init() {
        editTextDayNumberPost = requireView().findViewById(R.id.editTextDayNumberPost)
        editTextPictureUrlPost = requireView().findViewById(R.id.editTextPictureUrlPost)
        editTextDescriptionPost = requireView().findViewById(R.id.editTextDescriptionPost)
        buttonPost = requireView().findViewById(R.id.buttonPost)
    }
}