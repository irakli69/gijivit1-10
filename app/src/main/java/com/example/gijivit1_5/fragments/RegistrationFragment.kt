package com.example.gijivit1_5.fragments

import android.os.Bundle
import android.util.Patterns
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.navigation.Navigation
import com.example.gijivit1_5.R
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.FirebaseDatabase


class RegistrationFragment : Fragment(R.layout.fragment_registration) {

    private lateinit var editTextEmailRegistration : EditText
    private lateinit var editTextPasswordRegistration : EditText
    private lateinit var editTextRepeatPasswordRegistration : EditText
    private lateinit var editTextNameRegistration : EditText
    private lateinit var editTextSurnameRegistration : EditText
    private lateinit var buttonSignUp : Button
    private lateinit var textViewSignIn : TextView
    private val auth = FirebaseAuth.getInstance()
    private val data = FirebaseDatabase.getInstance().getReference("UserInfo")

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        init()

        registerListeners(view)
    }

    private fun init() {
        editTextEmailRegistration = requireView().findViewById(R.id.editTextEmailRegistration)
        editTextNameRegistration = requireView().findViewById(R.id.editTextNameRegistration)
        editTextSurnameRegistration = requireView().findViewById(R.id.editTextSurnameRegistration)
        editTextPasswordRegistration = requireView().findViewById(R.id.editTextPasswordRegistration)
        editTextRepeatPasswordRegistration = requireView().findViewById(R.id.editTextRepeatPasswordRegistration)
        buttonSignUp = requireView().findViewById(R.id.buttonSignUp)
        textViewSignIn = requireView().findViewById(R.id.textViewSignIn)
    }

    private fun registerListeners(view: View) {
        val controller = Navigation.findNavController(view)
        buttonSignUp.setOnClickListener {
            val email = editTextEmailRegistration.text.toString().trim()
            val name = editTextNameRegistration.text.toString().trim()
            val surname = editTextSurnameRegistration.text.toString().trim()
            val fullName = "$name $surname"
            val password = editTextPasswordRegistration.text.toString().trim()
            val repeatpassword = editTextRepeatPasswordRegistration.text.toString().trim()


            if (name.isEmpty()){
                editTextNameRegistration.error = "Enter your name"
                return@setOnClickListener
            }
            else if (surname.isEmpty()){
                editTextSurnameRegistration.error = "Enter your surname"
                return@setOnClickListener
            }
            else if(!Patterns.EMAIL_ADDRESS.matcher(email).matches()){
                editTextEmailRegistration.error = "Enter a Valid Email"
                return@setOnClickListener
            }else if( password.length < 9 ){
                editTextPasswordRegistration.error = "Password's length must be at least 9"
                return@setOnClickListener
            } else if(!(password.matches(".*[a-zA-Z].*".toRegex())) || !(password.matches(".*[0-9].*".toRegex()))){
                editTextPasswordRegistration.error = "Password must contain both Symbols and Digits"
                return@setOnClickListener
            } else if(password != repeatpassword){
                editTextRepeatPasswordRegistration.error = "Passwords don't match"
                return@setOnClickListener
            }
            FirebaseAuth.getInstance().createUserWithEmailAndPassword(email, password)
                .addOnCompleteListener { task ->
                    if(task.isSuccessful){
                        Toast.makeText(requireContext(), "You have successfully registered !", Toast.LENGTH_SHORT).show()
                        data.child(auth.currentUser?.uid!!).child("fullName").setValue(fullName)


                        val action = RegistrationFragmentDirections.actionRegistrationFragmentToLoginFragment()
                        FirebaseAuth.getInstance().signOut()
                        controller.navigate(action)
                    }
                    else {
                        Toast.makeText(requireContext(), "There was an Error !", Toast.LENGTH_SHORT).show()
                    }
                }
        }
        textViewSignIn.setOnClickListener {
            val action = RegistrationFragmentDirections.actionRegistrationFragmentToLoginFragment()
            controller.navigate(action)
        }
    }
}