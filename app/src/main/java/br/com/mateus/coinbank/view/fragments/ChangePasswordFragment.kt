package br.com.mateus.coinbank.view.fragments

import androidx.lifecycle.ViewModelProviders
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import br.com.mateus.coinbank.R
import br.com.mateus.coinbank.viewmodel.ChangePasswordViewModel
import kotlinx.android.synthetic.main.change_password_fragment.*

class ChangePasswordFragment : Fragment() {

    companion object {
        fun newInstance() = ChangePasswordFragment()
    }

    private lateinit var viewModel: ChangePasswordViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.change_password_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProviders.of(this).get(ChangePasswordViewModel::class.java)

        tb_change_password.setNavigationOnClickListener { activity?.onBackPressed() }
        button_change_password.setOnClickListener {
            Toast.makeText(context, "Senha alterada com suceso!", Toast.LENGTH_SHORT).show()
            activity?.onBackPressed() }


    }

}