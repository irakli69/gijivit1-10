package com.example.gijivit1_5.fragments

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.navigation.Navigation
import com.example.gijivit1_5.R
import com.example.gijivit1_5.SignedInActivity
import com.google.firebase.auth.FirebaseAuth


class ResetPasswordFragment : Fragment(R.layout.fragment_reset_password) {

    private lateinit var editTextEmailResetPassword : EditText
    private lateinit var buttonResetPassword : Button


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        init()

        resetPassword(view)
    }

    private fun init() {
        editTextEmailResetPassword = requireView().findViewById(R.id.editTextEmailResetPassword)
        buttonResetPassword = requireView().findViewById(R.id.buttonResetPassword)
    }

    private fun resetPassword(view: View) {
        buttonResetPassword.setOnClickListener {
            val email = editTextEmailResetPassword.text.toString()
            if(email.isEmpty()){
                editTextEmailResetPassword.error = "Empty!"
                return@setOnClickListener
            }
            FirebaseAuth.getInstance().sendPasswordResetEmail(email)
                .addOnCompleteListener{ task ->
                    if(task.isSuccessful){
                        Toast.makeText(requireContext(), "Check Email!", Toast.LENGTH_SHORT).show()
                        val controller = Navigation.findNavController(view)
                        if (FirebaseAuth.getInstance().currentUser != null) {
                            startActivity(Intent(activity, SignedInActivity::class.java))
                        }
                        else {
                            val action = ResetPasswordFragmentDirections.actionResetPasswordFragmentToLoginFragment()
                            controller.navigate(action)
                        }
                    }
                    else {
                        Toast.makeText(requireContext(), "Error!", Toast.LENGTH_SHORT).show()
                    }

                }
        }
    }

}