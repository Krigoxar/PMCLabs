package com.example.myapplication

import android.os.Bundle
import android.content.Intent
import android.util.Patterns
import android.view.View
import android.widget.Toast
import java.util.regex.Pattern
import com.example.myapplication.databinding.LoginPageBinding
import com.google.firebase.auth.FirebaseAuth
import androidx.activity.ComponentActivity

class LoginActivity : ComponentActivity() {
    lateinit var binding: LoginPageBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = LoginPageBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.loginButton.setOnClickListener{
            val email = binding.email.text.toString()
            val password = binding.password.text.toString()

            if (!Pattern.matches(Patterns.EMAIL_ADDRESS.pattern(), email)){
                binding.email.setError("Invalid email!")
                return@setOnClickListener
            }

            if(password.length<6){
                binding.password.setError("Password should be more than 6 symbols!")
                return@setOnClickListener
            }

            loginWithFirebase(email, password)
        }

        binding.gotoSignupBtn.setOnClickListener {
            startActivity(Intent(this,SingUpActivity::class.java))
        }
    }

    fun setInProgress(inProgress:Boolean){
        if(inProgress){
            binding.loginButton.visibility = View.GONE
            binding.progressBar.visibility = View.VISIBLE
        }
        else{
            binding.loginButton.visibility = View.VISIBLE
            binding.progressBar.visibility = View.GONE
        }
    }

    override fun onResume() {
        super.onResume()
        FirebaseAuth.getInstance().currentUser?.apply {
            startActivity(Intent(this@LoginActivity,MainActivity::class.java))
            finish()
        }
    }

    fun loginWithFirebase(email:String, password:String){
        setInProgress(true)
        FirebaseAuth.getInstance().signInWithEmailAndPassword(email,password)
            .addOnSuccessListener {
                setInProgress(false)
                startActivity(Intent(this@LoginActivity, MainActivity::class.java))
                finish()
            }.addOnFailureListener{
                setInProgress(false)
                Toast.makeText(applicationContext,"Login account failed!", Toast.LENGTH_SHORT).show()
            }
    }
}