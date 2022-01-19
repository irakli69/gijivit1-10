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
import com.google.firebase.auth.FirebaseAuth


class ChangePasswordFragment : Fragment(R.layout.fragment_change_password) {

    private lateinit var editTextEmailChangePassword : EditText
    private lateinit var buttonChangePassword : Button


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        init()

        resetPassword(view)
    }

    private fun init() {
        editTextEmailChangePassword = requireView().findViewById(R.id.editTextEmailChangePassword)
        buttonChangePassword = requireView().findViewById(R.id.buttonChangePassword)
    }

    private fun resetPassword(view: View) {
        buttonChangePassword.setOnClickListener {
            val email = editTextEmailChangePassword.text.toString()
            if(email.isEmpty()){
                editTextEmailChangePassword.error = "Empty!"
                return@setOnClickListener
            }
            FirebaseAuth.getInstance().sendPasswordResetEmail(email)
                .addOnCompleteListener{ task ->
                    if(task.isSuccessful){
                        Toast.makeText(requireContext(), "Check Email!", Toast.LENGTH_SHORT).show()
                        val controller = Navigation.findNavController(view)
                        val action = ChangePasswordFragmentDirections.actionChangePasswordFragmentToProfileFragment()
                            controller.navigate(action)
                        }
                    }


                }
        }
}


