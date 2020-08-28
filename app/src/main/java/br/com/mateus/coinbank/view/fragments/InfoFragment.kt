package br.com.mateus.coinbank.view.fragments

import androidx.lifecycle.ViewModelProviders
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import br.com.mateus.coinbank.R
import br.com.mateus.coinbank.viewmodel.InfoViewModel
import kotlinx.android.synthetic.main.info_fragment.*

class InfoFragment : Fragment() {

    companion object {
        fun newInstance() = InfoFragment()
    }

    private lateinit var viewModel: InfoViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.info_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProviders.of(this).get(InfoViewModel::class.java)
        // TODO: Use the ViewModel

        tv_change_password.setOnClickListener { findNavController().navigate(R.id.changePasswordFragment) }
        tv_contact_info.setOnClickListener { findNavController().navigate(R.id.contactFragment) }
        tv_about_info.setOnClickListener { findNavController().navigate(R.id.aboutFragment) }
    }

}