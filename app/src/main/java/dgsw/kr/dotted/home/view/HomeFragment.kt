package dgsw.kr.dotted.home.view

import RecommendCompanyAdapter
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import dgsw.kr.dotted.R
import dgsw.kr.dotted.adapter.CompanyAdapter
import dgsw.kr.dotted.base.BaseFragment
import dgsw.kr.dotted.databinding.FragmentHomeBinding
import dgsw.kr.dotted.home.vm.homeViewModel

class HomeFragment : BaseFragment<FragmentHomeBinding, homeViewModel>(R.layout.fragment_home) {

    override val viewModel: homeViewModel by viewModels()
    override fun start() {


        val companyAdapter = CompanyAdapter {
            val action = HomeFragmentDirections.actionHomeFragmentToDetailFragment(viewModel.mapCompanyList[it.idx])
            findNavController().navigate(action)
        }
        val recommendCompanyAdapter = RecommendCompanyAdapter {
            val action = HomeFragmentDirections.actionHomeFragmentToDetailFragment(viewModel.mapCompanyList[it.idx])
            findNavController().navigate(action)
        }
        binding.rvCompany.adapter = companyAdapter
        binding.rvCompany.layoutManager = LinearLayoutManager(context, LinearLayoutManager.VERTICAL,false)
        binding.rvRecommandCompany.adapter = recommendCompanyAdapter
        binding.rvRecommandCompany.layoutManager = LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL,false)
        recommendCompanyAdapter.submitList(viewModel.mapCompanyList)
        companyAdapter.submitList(viewModel.mapCompanyList)
    }

}