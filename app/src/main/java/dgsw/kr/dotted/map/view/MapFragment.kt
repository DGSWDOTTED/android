package dgsw.kr.dotted.map.view

import android.annotation.SuppressLint
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.naver.maps.map.LocationTrackingMode
import com.naver.maps.map.NaverMap
import com.naver.maps.map.OnMapReadyCallback
import com.naver.maps.map.util.FusedLocationSource
import dgsw.kr.dotted.R
import dgsw.kr.dotted.adapter.MapCompanyAdapter
import dgsw.kr.dotted.base.BaseFragment
import dgsw.kr.dotted.databinding.FragmentMapBinding
import dgsw.kr.dotted.map.vm.MapViewModel

class MapFragment : BaseFragment<FragmentMapBinding, MapViewModel>(R.layout.fragment_map), OnMapReadyCallback {
    override val viewModel: MapViewModel by viewModels()
    @SuppressLint("ResourceType")
    val mapCompanyAdapter = MapCompanyAdapter {
        findNavController().navigate(R.layout.fragment_detail)
    }

    override fun start() {

        viewModel.mapView = binding.mapView
        viewModel.mapView.getMapAsync(this)

        viewModel.locationSource =
            FusedLocationSource(this, LOCATION_PERMISSION_REQUEST_CODE)

        binding.companyRecyclerview.apply {

            layoutManager = LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL,false)
            adapter = mapCompanyAdapter
        }
        mapCompanyAdapter.submitList(viewModel.mapCompanyList)
    }

    override fun onMapReady(naverMap: NaverMap) {

        viewModel.naverMap = naverMap

        binding.locationBtn.setOnClickListener {
            naverMap.locationTrackingMode = LocationTrackingMode.Follow
            Log.d("DOTTED", "location button clicked")
        }

        naverMap.locationSource = viewModel.locationSource

        naverMap.buildingHeight = 0.5F
        naverMap.cameraPosition = viewModel.cameraPosition
        naverMap.lightness = -0.08F

        val uiSettings = naverMap.uiSettings
        uiSettings.isCompassEnabled = false
        uiSettings.isLocationButtonEnabled = true

        naverMap.uiSettings
    }

    override fun onRequestPermissionsResult(
        requestCode: Int,
        permissions: Array<out String>,
        grantResults: IntArray
    ) {
        return
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)
    }

    override fun onStart() {
        super.onStart()
        viewModel.mapView.onStart()
    }

    override fun onResume() {
        super.onResume()
        viewModel.mapView.onResume()
    }

    override fun onPause() {
        super.onPause()

        viewModel.mapView.onPause()
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        viewModel.mapView.onSaveInstanceState(outState)
    }

    override fun onStop() {
        super.onStop()
        viewModel.mapView.onStop()
    }

    override fun onDestroy() {
        super.onDestroy()
        viewModel.mapView.onDestroy()
    }

    override fun onLowMemory() {
        super.onLowMemory()
        viewModel.mapView.onLowMemory()
    }

    companion object {
        private const val LOCATION_PERMISSION_REQUEST_CODE = 1000

    }

}