package br.com.mateus.coinbank.view.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProviders
import br.com.mateus.coinbank.R
import br.com.mateus.coinbank.viewmodel.StatusViewModel
import kotlinx.android.synthetic.main.about_fragment.*
import kotlinx.android.synthetic.main.status_fragment.*

class StatusFragment : Fragment() {

    companion object {
        fun newInstance() = StatusFragment()
    }

    private lateinit var viewModel: StatusViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.status_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProviders.of(this).get(StatusViewModel::class.java)

        tb_status.setOnClickListener { activity?.onBackPressed() }
        button_back_status.setOnClickListener { activity?.onBackPressed() }
        button_accept_status.setOnClickListener {
            Toast.makeText(context, "O valor será liberado em ate 48h", Toast.LENGTH_SHORT).show()
            activity?.onBackPressed() }

        /*Aqui recebe o valor do fragment que está passando, posso alterar o titulo e esconder itens*/
        val title = arguments?.getString("key_status") ?: "NAO VEIO"
        val valorTotal = arguments?.getDouble("key_valorTotal") ?: "NAO VEIO"
        val valor = arguments?.getDouble("key_valor") ?: "NAO VEIO"
        val dataInicio = arguments?.getString("key_data") ?: "NAO VEIO"

        if (title == "REPROVADO") {
            tv_status_status.text = title
            iv_status.setImageResource(R.drawable.iv_sad)
            button_accept_status.visibility = View.GONE
            tv_date_first.visibility = View.GONE
            tv_value_status.visibility = View.GONE
            tv_value_interest.visibility = View.GONE


        } else if (title == "APROVADO") {
            tv_status_status.text = title
            tv_message_status.setText(R.string.message_status_accept)
            tv_date_first.text = "Data da primeira parcela:\n $dataInicio"
            tv_value_status.text = "Valor solicitado:\n $valor"
            tv_value_interest.text = "Valor total a pagar (juros de 2,0% a.m):\nR$$valorTotal"

        }

    }
}