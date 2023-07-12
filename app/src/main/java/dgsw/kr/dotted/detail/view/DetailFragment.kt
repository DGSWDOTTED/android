package dgsw.kr.dotted.detail.view

import androidx.fragment.app.activityViewModels
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import dgsw.kr.dotted.R
import dgsw.kr.dotted.base.BaseFragment
import dgsw.kr.dotted.databinding.FragmentDetailBinding
import dgsw.kr.dotted.detail.vm.DetailViewModel
import dgsw.kr.dotted.detail.vm.SharedViewModel
import dgsw.kr.dotted.local.DB.CompanyDatabase
import dgsw.kr.dotted.local.DB.CompanyEntity
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch


class DetailFragment() : BaseFragment<FragmentDetailBinding,DetailViewModel>(R.layout.fragment_detail){

    override val viewModel: DetailViewModel by viewModels()
    private val sharedViewModel : SharedViewModel by activityViewModels()

    lateinit var database : CompanyDatabase

    override fun start() {

        binding.backTo.setOnClickListener{
            findNavController().popBackStack()
        }

        database = CompanyDatabase.getInstance(requireContext().applicationContext)!!

        lifecycleScope.launch(Dispatchers.IO) {

            val company = database.companyDao().getCompanyById(sharedViewModel.id)

            launch(Dispatchers.Main) {
                binding.companyAddress.text = company.address
                binding.companyMaster.text = company.charge
                binding.companyName.text = company.companyTitle
                binding.companyPay.text = company.pay
                binding.companyPayType.text = company.payType
                binding.companyRole.text = company.employ
                binding.companyScale.text = company.companyType

            }
        }


    }


}