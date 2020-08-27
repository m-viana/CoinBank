package br.com.mateus.coinbank.view.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import br.com.mateus.coinbank.R
import kotlinx.android.synthetic.main.activity_register.*

class RegisterActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)

        tb_register.setOnClickListener { finish() }

    }
}