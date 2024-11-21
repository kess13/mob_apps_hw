package com.example.myapplicationlast

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.google.android.material.textfield.TextInputLayout

class RegisterWindow : AppCompatActivity() {
    private val emailEditText: EditText by lazy { findViewById(R.id.emailEditText) }
    private val passwordEditText: EditText by lazy { findViewById(R.id.passwordEditText) }
    private val phoneEditText: EditText by lazy { findViewById(R.id.phoneEditText) }
    private val emailInputLayout: TextInputLayout by lazy { findViewById(R.id.emailInputLayout) }
    private val passwordInputLayout: TextInputLayout by lazy { findViewById(R.id.passwordInputLayout2) }
    private val phoneInputLayout: TextInputLayout by lazy { findViewById(R.id.phoneInputLayout) }
    private val registerButton: Button by lazy { findViewById(R.id.loginButton) }
    private val credentialsManager = CredentialsManager()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_register_window)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val loginText: TextView = findViewById(R.id.register)
        loginText.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            intent.flags = Intent.FLAG_ACTIVITY_CLEAR_TOP or Intent.FLAG_ACTIVITY_NEW_TASK
            startActivity(intent)
            finish()
        }

        // Listener for "Register" button
        registerButton.setOnClickListener {
            val email = emailEditText.text.toString()
            val password = passwordEditText.text.toString()
            val phone = phoneEditText.text.toString()

            if (validateInput(email, password)) {
                Toast.makeText(this, "Registration successful!", Toast.LENGTH_LONG).show()

                val intent = Intent(this, MainActivity::class.java)
                intent.flags = Intent.FLAG_ACTIVITY_CLEAR_TOP or Intent.FLAG_ACTIVITY_NEW_TASK
                startActivity(intent)
                finish()
            }
        }
    }


    private fun validateInput(email: String, password: String): Boolean {
        var isValid = true

        // Validate email
        if (!credentialsManager.isValidEmail(email)) {
            emailInputLayout.error = "Invalid email format"
            isValid = false
        } else {
            emailInputLayout.error = null
        }
        if (credentialsManager.isUserAlreadyRegistered(email)) {
            emailInputLayout.error = "Email already used"
        } else {
            emailInputLayout.error = null
        }
        // Validate password
        if (!credentialsManager.isValidPassword(password)) {
            passwordInputLayout.error = "Password must be at least 8 characters"
            isValid = false
        } else {
            passwordInputLayout.error = null
        }

        return isValid
    }
}


