package com.example.myapplication

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import android.util.Patterns
import android.view.View
import android.widget.Toast
import java.util.regex.Pattern
import com.example.myapplication.databinding.SigninPageBinding
import com.google.firebase.auth.FirebaseAuth
import androidx.activity.ComponentActivity

class SingUpActivity : ComponentActivity(){
    lateinit var binding: SigninPageBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = SigninPageBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.SignupButton.setOnClickListener{
            val email = binding.email.text.toString()
            val password = binding.password.text.toString()
            val confirmPassword = binding.confirmPassword.text.toString()

            if (!Pattern.matches(Patterns.EMAIL_ADDRESS.pattern(), email)){
                binding.email.setError("Invalid email!")
                return@setOnClickListener
            }

            if(password.length<6){
                binding.password.setError("Password should be more than 6 symbols!")
                return@setOnClickListener
            }

            if(!password.equals(confirmPassword)){
                binding.confirmPassword.setError("Passwords are not matching!")
                return@setOnClickListener
            }

            createAccountWithFirebase(email, password)
        }

        binding.gotoLoginBtn.setOnClickListener {
            finish()
        }

    }

    fun createAccountWithFirebase(email:String, password:String){
        setInProgress(true)
        FirebaseAuth.getInstance().createUserWithEmailAndPassword(email,password)
            .addOnSuccessListener {
                setInProgress(false)
                Toast.makeText(applicationContext,"Create account success!",Toast.LENGTH_SHORT).show()
                finish()
            }.addOnFailureListener{
                setInProgress(false)
                Toast.makeText(applicationContext,"Create account failed!",Toast.LENGTH_SHORT).show()
            }
    }

    fun setInProgress(inProgress:Boolean){
        if(inProgress){
            binding.SignupButton.visibility = View.GONE
            binding.progressBar.visibility = View.VISIBLE
        }
        else{
            binding.SignupButton.visibility = View.VISIBLE
            binding.progressBar.visibility = View.GONE
        }
    }
}