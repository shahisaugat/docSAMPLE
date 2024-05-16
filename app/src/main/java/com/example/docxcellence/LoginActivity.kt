package com.example.docxcellence

import android.content.Intent
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.docxcellence.databinding.ActivityLoginBinding

class LoginActivity : AppCompatActivity() {
    private lateinit var loginBinding: ActivityLoginBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        loginBinding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(loginBinding.root)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        loginBinding.imageView.setOnClickListener {
            val intent = Intent(this@LoginActivity, SplashActivity::class.java)
            startActivity(intent)
            finish()
        }

        loginBinding.sendOtpBtn.setOnClickListener {
            val fetchedNumber = loginBinding.numberEntryField.text.toString()
            if (fetchedNumber.trim().isNotEmpty()) {
                if (fetchedNumber.trim().length == 10) {
                    val intent = Intent(applicationContext, OTPActivity::class.java)
                    intent.putExtra("mobile-number", fetchedNumber)
                    startActivity(intent)
                }
            }
        }
    }
}