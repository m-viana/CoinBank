package br.com.mateus.coinbank.view.activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import br.com.mateus.coinbank.R
import kotlinx.android.synthetic.main.activity_login.*

class LoginActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        tv_forgot_password.setOnClickListener { forgetPassword() }
        cl_login.setOnClickListener { registerIntent() }
        btn_login.setOnClickListener {
            login()
            finish()
        }
    }

    fun forgetPassword(){
        val intent = Intent(this, ForgetPasswordActivity::class.java)
        startActivity(intent)
    }

    fun registerIntent(){
        val intent = Intent(this, RegisterActivity::class.java)
        startActivity(intent)
    }

    fun login(){
        val intent = Intent(this, NavHostActivity::class.java)
        startActivity(intent)
    }
}