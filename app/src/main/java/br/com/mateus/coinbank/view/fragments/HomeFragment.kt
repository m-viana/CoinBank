package br.com.mateus.coinbank.view.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProviders
import androidx.navigation.fragment.findNavController
import br.com.mateus.coinbank.R
import br.com.mateus.coinbank.viewmodel.HomeViewModel
import com.google.android.material.bottomsheet.BottomSheetDialog
import kotlinx.android.synthetic.main.activity_login.*
import kotlinx.android.synthetic.main.home_fragment.*

class HomeFragment : Fragment() {

    companion object {
        fun newInstance() = HomeFragment()
    }

    private lateinit var viewModel: HomeViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.home_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProviders.of(this).get(HomeViewModel::class.java)


        btn_send_proposal.setOnClickListener { validacaoField() }

        /*Subindo o bottom sheet ao clicar em sair*/
        exit_home.setOnClickListener {
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

    private fun validacaoField() {
        var statusValue = false
        var statusMonthly = false
        var statusManyParcels = false
        var statusDate = false

        if (!iet_value.text.isNullOrEmpty()){
            statusValue = true
            il_value.error = null

        }else{
            il_value.error = "Digite um valor"
            il_value.requestFocus()
        }

        if (!iet_monthly_income.text.isNullOrEmpty()){
            statusMonthly = true
            il_monthly_income.error = null

        }else{
            il_monthly_income.error = "Digite sua renda"
            il_monthly_income.requestFocus()
        }

        if (!iet_many_parcels.text.isNullOrEmpty()){
            statusManyParcels = true
            il_many_parcels.error = null

        }else{
            il_many_parcels.error = "Digite a quantidade de parcelas"
            il_many_parcels.requestFocus()
        }

        if (!iet_first_parcels.text.isNullOrEmpty()){
            statusDate = true
            il_first_parcels.error = null

        }else{
            il_first_parcels.error = "Digite quando quer começar pagar"
            il_first_parcels.requestFocus()
        }

        if (statusValue && statusMonthly && statusManyParcels && statusDate){
            validacaoProposal()
        }
    }

    private fun validacaoProposal() {

        val bundle = Bundle()
        val valor = iet_value.text.toString().toDouble()
        val renda = iet_monthly_income.text.toString().toDouble()
        val quantParcelas = iet_many_parcels.text.toString().toDouble()
        val dataInicio = iet_first_parcels.text.toString()
        val valorParcela = valor / quantParcelas
        val valorTotal = valor + (valorParcela* 0.02 * quantParcelas)

        if (valorParcela >= renda){
            bundle.putString("key_status", "REPROVADO")
            findNavController().navigate(R.id.action_nav_home_to_statusFragment, bundle)
        } else if(valorParcela < renda){
            bundle.putString("key_status", "APROVADO")
            bundle.putDouble("key_valorTotal", valorTotal)
            bundle.putDouble("key_valor", valor)
            bundle.putString("key_data", dataInicio)
            findNavController().navigate(R.id.action_nav_home_to_statusFragment, bundle)
        }
    }

}

