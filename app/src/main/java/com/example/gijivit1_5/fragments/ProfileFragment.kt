package com.example.gijivit1_5.fragments

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.navigation.Navigation
import com.bumptech.glide.Glide
import com.example.gijivit1_5.MainActivity
import com.example.gijivit1_5.R
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener


class ProfileFragment : Fragment(R.layout.fragment_profile) {


    private lateinit var buttonSignOut : Button
    private lateinit var buttonChangePasswordLogin : Button
    private lateinit var textViewProfileName : TextView
    private lateinit var imageViewProfilePictureProfile : ImageView
    private lateinit var editTextProfileImageUrl : EditText
    private lateinit var buttonUpload : Button
    private val auth = FirebaseAuth.getInstance()
    private val data = FirebaseDatabase.getInstance().getReference("UserInfo")


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        init()

        callbackListener()

        profileListeners(view)


    }

    private fun callbackListener() {
        data.child(auth.currentUser?.uid!!).addValueEventListener(object: ValueEventListener {
            override fun onDataChange(snapshot: DataSnapshot) {
                if (!snapshot.hasChild("profilePhotoUrl")) {
                    data.child(auth.currentUser?.uid!!).child("profilePhotoUrl").setValue("https://i.imgur.com/3Ogv7C0.png")
                }
                val userInfo = snapshot.getValue(com.example.gijivit1_5.UserInfo::class.java) ?: return
                Glide.with(this@ProfileFragment).load(userInfo.profilePhotoUrl) .placeholder(R.drawable.profilepicture).into(imageViewProfilePictureProfile)
                textViewProfileName.text = userInfo.fullName
            }

            override fun onCancelled(error: DatabaseError) {
            }

        })

    }


    private fun init() {
        buttonSignOut = requireView().findViewById(R.id.buttonSignOut)
        buttonUpload = requireView().findViewById(R.id.buttonUpload)
        editTextProfileImageUrl = requireView().findViewById(R.id.editTextProfileImageUrl)
        textViewProfileName = requireView().findViewById(R.id.textViewProfileName)
        imageViewProfilePictureProfile = requireView().findViewById(R.id.imageViewProfilePictureProfile)
        buttonChangePasswordLogin = requireView().findViewById(R.id.buttonChangePasswordLogin)
    }

    private fun profileListeners(view: View) {
        val controller = Navigation.findNavController(view)
        buttonUpload.setOnClickListener {
            val imageUrl = editTextProfileImageUrl.text.toString().trim()
            if (imageUrl.isEmpty()){
                editTextProfileImageUrl.error = "Insert URL !"
                return@setOnClickListener
            }
            data.child(auth.currentUser?.uid!!).child("profilePhotoUrl").setValue(imageUrl)
        }

        buttonSignOut.setOnClickListener {
            FirebaseAuth.getInstance().signOut()
            startActivity(Intent(activity, MainActivity::class.java))
        }

        buttonChangePasswordLogin.setOnClickListener {
            val action = ProfileFragmentDirections.actionProfileFragmentToChangePasswordFragment()
            controller.navigate(action)
        }
    }
}