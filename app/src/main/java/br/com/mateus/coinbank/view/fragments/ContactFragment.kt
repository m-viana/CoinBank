package br.com.mateus.coinbank.view.fragments

import androidx.lifecycle.ViewModelProviders
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import br.com.mateus.coinbank.R
import br.com.mateus.coinbank.viewmodel.ContactViewModel
import kotlinx.android.synthetic.main.contact_fragment.*

class ContactFragment : Fragment() {

    companion object {
        fun newInstance() = ContactFragment()
    }

    private lateinit var viewModel: ContactViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.contact_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProviders.of(this).get(ContactViewModel::class.java)

        tb_contact.setOnClickListener { activity?.onBackPressed() }
        button_send_contact.setOnClickListener {
            Toast.makeText(context, "Obrigado, retornaremos em breve!", Toast.LENGTH_SHORT).show()
            activity?.onBackPressed()
        }
    }

}