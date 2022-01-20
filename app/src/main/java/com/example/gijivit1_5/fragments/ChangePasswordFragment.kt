package com.example.gijivit1_5.fragments

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.navigation.Navigation
import com.example.gijivit1_5.fragments.ChangePasswordFragmentDirections
import com.example.gijivit1_5.R
import com.google.android.material.textfield.TextInputEditText
import com.google.firebase.auth.FirebaseAuth


class ChangePasswordFragment : Fragment(R.layout.fragment_change_password) {


    private lateinit var editTextNewPassword : EditText
    private lateinit var editTextRepeatNewPassword : EditText
    private lateinit var buttonChange : Button


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        init()

        resetPassword(view)
    }

    private fun init() {

        editTextNewPassword = requireView().findViewById(R.id.editTextNewPassword)
        editTextRepeatNewPassword = requireView().findViewById(R.id.editTextRepeatNewPassword)
        buttonChange = requireView().findViewById(R.id.buttonChange)
    }

    private fun resetPassword(view: View) {
        buttonChange.setOnClickListener {

            val newPassword = editTextNewPassword.text.toString()
            val repeatNewPassword = editTextRepeatNewPassword.text.toString()

            if(newPassword.length < 9){
                editTextNewPassword.error = "Password's length must be at least 9"
                return@setOnClickListener
            }
            else if(newPassword != repeatNewPassword){
                editTextRepeatNewPassword.error = "Passwords don't match"
                return@setOnClickListener
            }
            FirebaseAuth.getInstance().currentUser?.updatePassword(newPassword)
                ?.addOnCompleteListener{ task ->
                    if(task.isSuccessful){
                        Toast.makeText(requireContext(), "Password Changed Successfully", Toast.LENGTH_SHORT).show()
                        val controller = Navigation.findNavController(view)
                        val action = ChangePasswordFragmentDirections.actionChangePasswordFragmentToProfileFragment()
                        controller.navigate(action)
                    }
                }


                }
        }
}


