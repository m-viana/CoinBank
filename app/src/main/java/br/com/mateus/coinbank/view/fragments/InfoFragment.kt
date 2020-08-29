package br.com.mateus.coinbank.view.fragments

import androidx.lifecycle.ViewModelProviders
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.navigation.fragment.findNavController
import br.com.mateus.coinbank.R
import br.com.mateus.coinbank.viewmodel.InfoViewModel
import com.google.android.material.bottomsheet.BottomSheetDialog
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

        tv_change_password.setOnClickListener { findNavController().navigate(R.id.action_nav_info_to_changePasswordFragment) }
        tv_contact_info.setOnClickListener { findNavController().navigate(R.id.action_nav_info_to_contactFragment) }

        /*Envia um argumento que é recebido do outro lado, possui uma chave e um título, quando
        * passo um argumento tmb preciso passar o bundle junto com o navigate*/
        tv_about_info.setOnClickListener {
            val bundle = Bundle()
            bundle.putString("key_about", "SOBRE")
            findNavController().navigate(R.id.action_nav_info_to_aboutFragment, bundle) }

        tv_pp_info.setOnClickListener {
            val bundle = Bundle()
            bundle.putString("key_about", "POLÍTICAS DE PRIVACIDADE")
            findNavController().navigate(R.id.action_nav_info_to_aboutFragment, bundle) }

        tv_terms_use_info.setOnClickListener {
            val bundle = Bundle()
            bundle.putString("key_about", "TERMOS DE USO")
            findNavController().navigate(R.id.action_nav_info_to_aboutFragment, bundle) }


        /*Subindo o bottom sheet ao clicar em sair*/
        tv_exit_info.setOnClickListener {
            val dialog = BottomSheetDialog(context!!)
            val view = layoutInflater.inflate(R.layout.bottom_sheet, null)

            /*dando dismiss nos botoes sim e não do bottom sheet*/
            val closeNo = view.findViewById<Button>(R.id.btn_no)
            closeNo.setOnClickListener { dialog.dismiss() }

            val closeYes = view.findViewById<Button>(R.id.btn_yes)
            closeYes.setOnClickListener { dialog.dismiss() }
            /*--*/

            dialog.setContentView(view)
            dialog.show()
        }

    }

}