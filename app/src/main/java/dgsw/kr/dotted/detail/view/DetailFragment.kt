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
import dgsw.kr.dotted.home.view.MainActivity
import dgsw.kr.dotted.local.DB.CompanyDatabase
import dgsw.kr.dotted.local.DB.CompanyEntity
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch


class DetailFragment() : BaseFragment<FragmentDetailBinding,DetailViewModel>(R.layout.fragment_detail){

    override val viewModel: DetailViewModel by viewModels()
    private val sharedViewModel : SharedViewModel by activityViewModels()

    val profileImgList: List<Int> = listOf(
        R.drawable.img_company0,
        R.drawable.img_company1,
        R.drawable.img_company2,
        R.drawable.img_company3,
        R.drawable.img_company4,
        R.drawable.img_company5,
        R.drawable.img_company6,
        R.drawable.img_company7,
        R.drawable.img_company8,
        R.drawable.img_company9,
        R.drawable.img_company10,
        R.drawable.img_company11,
        R.drawable.img_company12,
        R.drawable.img_company13,
        R.drawable.img_company14,
        R.drawable.img_company15,
        R.drawable.img_company16,
        R.drawable.img_company17,
        R.drawable.img_company18,
        R.drawable.img_company19,
        R.drawable.img_company20,
        R.drawable.img_company21,
        R.drawable.img_company22,
        R.drawable.img_company23,
        R.drawable.img_company24,
        R.drawable.img_company25,
        R.drawable.img_company26,
        R.drawable.img_company27,
        R.drawable.img_company28,
        R.drawable.img_company29,
        R.drawable.img_company30,
    )

    lateinit var database : CompanyDatabase

    override fun start() {

        (activity as MainActivity).handleBottomNavigation(false)

        binding.backTo.setOnClickListener{
            findNavController().popBackStack()
        }

        database = CompanyDatabase.getInstance(requireContext().applicationContext)!!

        lifecycleScope.launch(Dispatchers.IO) {

            val company = database.companyDao().getCompanyById(sharedViewModel.id)

            launch(Dispatchers.Main) {
                if(company != null){

                    binding.companyAddress.text = company.address
                    binding.companyMaster.text = company.charge
                    binding.companyName.text = company.companyTitle
                    binding.companyPay.text = getConverted(company.pay.toInt())
                    binding.companyPayType.text = company.payType
                    binding.companyRole.text = company.employ
                    binding.companyScale.text = company.companyType

                    binding.companyPicture.clipToOutline = true
                    val iamgeIdx = (company.id.toInt() +123456) % profileImgList.size
                    binding.companyPicture.setImageResource(profileImgList[iamgeIdx])

                }
            }
        }

    }

    fun getConverted( pay : Int ) : String{

        if (pay > 10000) return "${pay/1000}만원"
        return "${pay}원"

    }

    override fun onDestroy() {
        super.onDestroy()
        (activity as MainActivity).handleBottomNavigation(true)
    }


}