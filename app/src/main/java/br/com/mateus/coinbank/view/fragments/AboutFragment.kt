package br.com.mateus.coinbank.view.fragments

import androidx.lifecycle.ViewModelProviders
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import br.com.mateus.coinbank.R
import br.com.mateus.coinbank.viewmodel.AboutViewModel
import kotlinx.android.synthetic.main.about_fragment.*

class AboutFragment : Fragment() {

    companion object {
        fun newInstance() = AboutFragment()
    }

    private lateinit var viewModel: AboutViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.about_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProviders.of(this).get(AboutViewModel::class.java)

        tb_about.setOnClickListener { activity?.onBackPressed() }

        /*Aqui recebo o valor do fragment que está passando, posso alterar o titulo e esconder itens*/
        val title = arguments?.getString("key_about") ?: "NAO VEIO"
        if (title == "SOBRE"){
            tb_about.title = title

        }else if ( title == "POLÍTICAS DE PRIVACIDADE"){
            tb_about.title = title

        }else if(title == "TERMOS DE USO"){
            tb_about.title = title
        }

    }

}