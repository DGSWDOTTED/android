package dgsw.kr.dotted.home.view

import RecommendCompanyAdapter
import android.Manifest
import android.content.Context
import android.content.pm.PackageManager
import android.location.Location
import android.location.LocationManager
import android.util.Log
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import androidx.fragment.app.activityViewModels
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import dgsw.kr.dotted.R
import dgsw.kr.dotted.adapter.CompanyAdapter
import dgsw.kr.dotted.base.BaseFragment
import dgsw.kr.dotted.databinding.FragmentHomeBinding
import dgsw.kr.dotted.detail.vm.SharedViewModel
import dgsw.kr.dotted.home.vm.homeViewModel
import dgsw.kr.dotted.local.DB.CompanyDatabase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class HomeFragment : BaseFragment<FragmentHomeBinding, homeViewModel>(R.layout.fragment_home) {

    override val viewModel: homeViewModel by viewModels()
    private val sharedViewModel : SharedViewModel by activityViewModels()

    lateinit var database : CompanyDatabase

    override fun start() {
//
//        val locationManager = context?.getSystemService(Context.LOCATION_SERVICE) as LocationManager
//        var lastLocation : Location? = null
//
//
//        val array = arrayOf(Manifest.permission.ACCESS_FINE_LOCATION)
//
//        val gpsCheck = ContextCompat.checkSelfPermission(requireContext(), Manifest.permission.ACCESS_COARSE_LOCATION)
//
//        if(gpsCheck == PackageManager.PERMISSION_DENIED){
//
//            Log.d("도티드","들어왔냐?!!")
//
//
//            ActivityCompat.requestPermissions(requireActivity(), array , 0);
//
//            lastLocation = locationManager.getLastKnownLocation(LocationManager.GPS_PROVIDER)
//
//        }else{
//
//            Log.d("도티드","들어왔는가아!!")
//
//
//            lastLocation = locationManager.getLastKnownLocation(LocationManager.GPS_PROVIDER)
//        }


        database = CompanyDatabase.getInstance(requireContext().applicationContext)!!

        val companyAdapter = CompanyAdapter {
            sharedViewModel.id = it.id
            findNavController().navigate(R.id.action_homeFragment_to_detailFragment)
        }
        val recommendCompanyAdapter = RecommendCompanyAdapter {
            sharedViewModel.id = it.id
            findNavController().navigate(R.id.action_homeFragment_to_detailFragment)
        }

        lifecycleScope.launch(Dispatchers.IO) {
            viewModel.recommendedMapCompanyList = database.companyDao().getCompanySortedByXY(128.41446498864, 35.662090445596)
            viewModel.mapCompanyList = database.companyDao().getAllCompany()
            launch(Dispatchers.Main) {
                recommendCompanyAdapter.submitList(viewModel.recommendedMapCompanyList)
                companyAdapter.submitList(viewModel.mapCompanyList)
            }
        }

//        if(lastLocation != null){
//
//            Log.d("도티드","들어와따!")
//
//            lifecycleScope.launch(Dispatchers.IO) {
//                viewModel.recommendedMapCompanyList = database.companyDao().getCompanySortedByXY(lastLocation.longitude,lastLocation.latitude)
//
//                launch(Dispatchers.Main) {
//                    recommendCompanyAdapter.submitList(viewModel.recommendedMapCompanyList)
//                }
//            }
//        }


        binding.searchEdtxt.setOnClickListener{
            findNavController().navigate(R.id.action_homeFragment_to_searchFragment)
        }

        binding.rvCompany.adapter = companyAdapter
        binding.rvCompany.layoutManager =
            LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)

        binding.rvRecommandCompany.adapter = recommendCompanyAdapter
        binding.rvRecommandCompany.layoutManager =
            LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)

    }
}