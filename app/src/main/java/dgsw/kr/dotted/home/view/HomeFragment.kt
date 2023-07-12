package dgsw.kr.dotted.home.view

import RecommendCompanyAdapter
import androidx.fragment.app.activityViewModels
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import dgsw.kr.dotted.R
import dgsw.kr.dotted.adapter.CompanyAdapter
import dgsw.kr.dotted.base.BaseFragment
import dgsw.kr.dotted.databinding.FragmentHomeBinding
import dgsw.kr.dotted.detail.vm.SharedViewModel
import dgsw.kr.dotted.home.vm.homeViewModel

class HomeFragment : BaseFragment<FragmentHomeBinding, homeViewModel>(R.layout.fragment_home) {

    override val viewModel: homeViewModel by viewModels()
    private val sharedViewModel : SharedViewModel by activityViewModels()
    override fun start() {


        val companyAdapter = CompanyAdapter {
            sharedViewModel.id = it.idx.toString()
            findNavController().navigate(R.id.action_homeFragment_to_detailFragment)
        }
        val recommendCompanyAdapter = RecommendCompanyAdapter {
            sharedViewModel.id = it.idx.toString()
            findNavController().navigate(R.id.action_homeFragment_to_detailFragment)
        }
        binding.rvCompany.adapter = companyAdapter
        binding.rvCompany.layoutManager = LinearLayoutManager(context, LinearLayoutManager.VERTICAL,false)
        binding.rvRecommandCompany.adapter = recommendCompanyAdapter
        binding.rvRecommandCompany.layoutManager = LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL,false)
        recommendCompanyAdapter.submitList(viewModel.mapCompanyList)
        companyAdapter.submitList(viewModel.mapCompanyList)
    }

}