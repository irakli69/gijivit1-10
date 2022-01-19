package com.example.gijivit1_5.fragments

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.navigation.Navigation
import com.example.gijivit1_5.R
import com.example.gijivit1_5.SignedInActivity
import com.google.firebase.auth.FirebaseAuth


class LoginFragment : Fragment(R.layout.fragment_login) {

    private lateinit var editTextEmailLogin : EditText
    private lateinit var editTextPasswordLogin : EditText
    private lateinit var buttonLoginAuth : Button
    private lateinit var textViewForgotPassword : TextView
    private lateinit var buttonSignUpLogin : Button



    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        if (FirebaseAuth.getInstance().currentUser != null){
            goToProfile()
        }

        init()

        registerListeners(view)

    }

    private fun goToProfile() {
        startActivity(Intent(activity, SignedInActivity::class.java))
    }

    private fun init() {
        editTextEmailLogin = requireView().findViewById(R.id.editTextEmailLogin)
        editTextPasswordLogin = requireView().findViewById(R.id.editTextPasswordLogin)
        buttonLoginAuth = requireView().findViewById(R.id.buttonLoginAuth)
        textViewForgotPassword = requireView().findViewById(R.id.textViewForgotPassword)
        buttonSignUpLogin = requireView().findViewById(R.id.buttonSignUpLogin)
    }

    private fun registerListeners(view: View) {
        val controller = Navigation.findNavController(view)
        buttonLoginAuth.setOnClickListener {
            val email = editTextEmailLogin.text.toString()
            val password = editTextPasswordLogin.text.toString()
            if(email.isEmpty()){
                editTextEmailLogin.error = "Empty!"
                return@setOnClickListener
            }else if (password.isEmpty()){
                editTextPasswordLogin.error = "Empty!"
                return@setOnClickListener
            }
            FirebaseAuth.getInstance().signInWithEmailAndPassword(email, password)
                .addOnCompleteListener{task ->
                    if(task.isSuccessful){
                        startActivity(Intent(activity, SignedInActivity::class.java))
                    }
                    else {
                        Toast.makeText(requireContext(), "There was an Error!", Toast.LENGTH_SHORT).show()
                    }
                }
        }
        textViewForgotPassword.setOnClickListener{
            val action = LoginFragmentDirections.actionLoginFragmentToResetPasswordFragment()
            controller.navigate(action)
        }

        buttonSignUpLogin.setOnClickListener {
            val action = LoginFragmentDirections.actionLoginFragmentToRegistrationFragment()
            controller.navigate(action)
        }


    }



}