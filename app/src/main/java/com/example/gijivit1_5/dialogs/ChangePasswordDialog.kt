package com.example.gijivit1_5.dialogs

import android.app.Dialog
import android.content.Context
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.example.gijivit1_5.R

import com.google.firebase.auth.FirebaseAuth

class ChangePasswordDialog(context:Context): Dialog(context) {

    private lateinit var editTextEmailChangePassword : EditText
    private lateinit var buttonChangePassword : Button
    init {
        setCanceledOnTouchOutside(false)
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.changepassword_dialog)

        init()

        resetPassword()
    }


    private fun init() {
        editTextEmailChangePassword = findViewById(R.id.editTextEmailChangePassword)
        buttonChangePassword = findViewById(R.id.buttonChangePassword)
    }
    private fun resetPassword() {
        buttonChangePassword.setOnClickListener {
            val email = editTextEmailChangePassword.text.toString()
            if (email.isEmpty()){
                editTextEmailChangePassword.error = "Empty!"
                return@setOnClickListener
            }
            FirebaseAuth.getInstance().sendPasswordResetEmail(email)
                .addOnCompleteListener { task ->
                    if (task.isSuccessful) {
                        dismiss()
                    } else
                        dismiss()
                }

        }
    }
}