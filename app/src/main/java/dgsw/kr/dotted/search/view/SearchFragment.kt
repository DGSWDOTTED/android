package dgsw.kr.dotted.search.view

import android.content.Context
import android.content.Context.INPUT_METHOD_SERVICE
import android.view.View
import android.view.inputmethod.InputMethodManager
import androidx.core.content.ContextCompat.getSystemService
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.activityViewModels
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import dgsw.kr.dotted.R
import dgsw.kr.dotted.adapter.CompanyAdapter
import dgsw.kr.dotted.base.BaseFragment
import dgsw.kr.dotted.databinding.FragmentSearchBinding
import dgsw.kr.dotted.detail.vm.SharedViewModel
import dgsw.kr.dotted.home.view.MainActivity
import dgsw.kr.dotted.local.DB.CompanyDatabase
import dgsw.kr.dotted.local.DB.CompanyEntity
import dgsw.kr.dotted.search.vm.SearchViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch


class SearchFragment : BaseFragment<FragmentSearchBinding,SearchViewModel>(R.layout.fragment_search) {
    override val viewModel: SearchViewModel by viewModels()
    private val sharedViewModel : SharedViewModel by activityViewModels()


    lateinit var database : CompanyDatabase

    override fun start() {

        (activity as MainActivity).handleBottomNavigation(false)

        val companyAdapter = CompanyAdapter {
            sharedViewModel.id = it.id
            findNavController().navigate(R.id.action_searchFragment_to_detailFragment)
        }

        binding.searchEdtxt.setFocusableInTouchMode(true)
        binding.searchEdtxt.requestFocus()

        binding.backBtn.setOnClickListener {
            findNavController().popBackStack()
        }

        binding.rvCompany.adapter = companyAdapter
        binding.rvCompany.layoutManager =
            LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)

        database = CompanyDatabase.getInstance(requireContext().applicationContext)!!

        val imm = context?.getSystemService(INPUT_METHOD_SERVICE) as InputMethodManager?

        imm!!.showSoftInput(binding.searchEdtxt, 0)

        binding.keywordTxt.visibility = View.INVISIBLE
        binding.textView.visibility = View.INVISIBLE

        binding.searchBtn.setOnClickListener {
            binding.keywordTxt.text = "'${binding.searchEdtxt.text}'"
            binding.keywordTxt.visibility = View.VISIBLE
            binding.textView.visibility = View.VISIBLE

            lifecycleScope.launch(Dispatchers.IO){

                val query = "%${binding.searchEdtxt.text}%"
                viewModel.companyList = database.companyDao().searchCompany(query)

                launch(Dispatchers.Main) {
                    companyAdapter.submitList(viewModel.companyList)
                }

            }
        }
    }

    override fun onResume() {
        super.onResume()
        (activity as MainActivity).handleBottomNavigation(false)


    }

    override fun onDestroy() {
        super.onDestroy()
        (activity as MainActivity).handleBottomNavigation(true)
    }


}