package br.com.mateus.coinbank.view.activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.TextUtils
import android.widget.Toast
import br.com.mateus.coinbank.R
import kotlinx.android.synthetic.main.activity_login.*

class LoginActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        tv_forgot_password.setOnClickListener { forgetPassword() }
        cl_login.setOnClickListener { registerIntent() }
        btn_login.setOnClickListener {
            validacaoLogin()

        }
    }

    /* Função para validar o login - Algo precisa ser digitado nos dois campos para entrar*/
    private fun validacaoLogin() {

        var statusLogin = false
        var statusPassword = false

        if (!iet_login.text.isNullOrEmpty()){
            statusLogin = true
            il_login.error = null

        }else{
            il_login.error = "Digite um login"
            il_login.requestFocus()
        }

        if (!iet_password.text.isNullOrEmpty()){
            statusPassword = true
            il_password.error = null

        }else{
            il_password.error = "Digite uma senha"
            il_password.requestFocus()
        }

        if (statusLogin && statusPassword){
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