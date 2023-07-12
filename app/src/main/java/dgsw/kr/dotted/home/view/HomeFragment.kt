package dgsw.kr.dotted.home.view

import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import dgsw.kr.dotted.R
import dgsw.kr.dotted.base.BaseFragment
import dgsw.kr.dotted.databinding.FragmentHomeBinding
import dgsw.kr.dotted.home.vm.homeViewModel

class HomeFragment : BaseFragment<FragmentHomeBinding, homeViewModel>(R.layout.fragment_home) {

    override val viewModel: homeViewModel by viewModels()
    override fun start() {
        binding.rvRecommandCompany.adapter = viewModel.recommendCompanyAdapter
        binding.rvRecommandCompany.layoutManager = LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL,false)
        binding.rvCompany.adapter = viewModel.verticalCompanyAdapter
        binding.rvCompany.layoutManager = LinearLayoutManager(context, LinearLayoutManager.VERTICAL,false)
        viewModel.recommendCompanyAdapter.submitList(viewModel.mapCompanyList)
        viewModel.verticalCompanyAdapter.submitList(viewModel.mapCompanyList)
    }

}