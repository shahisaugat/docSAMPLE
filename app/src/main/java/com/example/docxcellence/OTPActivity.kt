package com.example.docxcellence

import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.docxcellence.databinding.ActivityOtpactivityBinding

class OTPActivity : AppCompatActivity() {
    lateinit var otpBinding: ActivityOtpactivityBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        otpBinding = ActivityOtpactivityBinding.inflate(layoutInflater)
        setContentView(otpBinding.root)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        val editTexts = listOf(otpBinding.code1, otpBinding.code2, otpBinding.code3, otpBinding.code4, otpBinding.code5)
        val storedEnteredNumber : String? = intent.getStringExtra("mobile-number")

        for ((index, editText) in editTexts.withIndex()) {
            editText.addTextChangedListener(object : TextWatcher {
                override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {}

                override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {}

                override fun afterTextChanged(s: Editable?) {
                    if (s?.length == 1) {
                        if (index < editTexts.size - 1) {
                            editTexts[index + 1].requestFocus()
                        }
                    } else if (s?.length == 0) {
                        if (index > 0) {
                            editTexts[index - 1].requestFocus()
                        }
                    }
                }
            })
        }
    }
}