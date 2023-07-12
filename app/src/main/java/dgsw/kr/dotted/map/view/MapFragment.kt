package dgsw.kr.dotted.map.view

<<<<<<< HEAD
import android.content.Context
import android.content.Context.LOCATION_SERVICE
import android.location.LocationManager
=======
import android.annotation.SuppressLint
>>>>>>> master
import android.os.Bundle
import android.util.AttributeSet
import android.util.Log
<<<<<<< HEAD
import android.view.View
import androidx.core.content.ContextCompat.getSystemService
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
=======
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
>>>>>>> master
import androidx.recyclerview.widget.LinearLayoutManager
import com.naver.maps.geometry.LatLng
import com.naver.maps.map.CameraAnimation
import com.naver.maps.map.CameraPosition
import com.naver.maps.map.CameraUpdate
import com.naver.maps.map.LocationTrackingMode
import com.naver.maps.map.MapView
import com.naver.maps.map.NaverMap
import com.naver.maps.map.OnMapReadyCallback
import com.naver.maps.map.overlay.Marker
import com.naver.maps.map.overlay.OverlayImage
import com.naver.maps.map.util.FusedLocationSource
import dgsw.kr.dotted.R
import dgsw.kr.dotted.adapter.MapCompanyAdapter
import dgsw.kr.dotted.base.BaseFragment
import dgsw.kr.dotted.databinding.FragmentMapBinding
import dgsw.kr.dotted.local.DB.CompanyDatabase
import dgsw.kr.dotted.local.DB.CompanyEntity
import dgsw.kr.dotted.map.vm.MapViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch


class MapFragment : BaseFragment<FragmentMapBinding, MapViewModel>(R.layout.fragment_map), OnMapReadyCallback {
    override val viewModel: MapViewModel by viewModels()
    @SuppressLint("ResourceType")
    val mapCompanyAdapter = MapCompanyAdapter {
        findNavController().navigate(R.layout.fragment_detail)
    }

    lateinit var mapCompanyList : List<CompanyEntity>
    var markerList = mutableListOf<Marker>()
    private lateinit var mapView: MapView

    lateinit var database : CompanyDatabase
    override fun start() {

        Log.d("도티드","MapFragment - start() called")

        database = CompanyDatabase.getInstance(requireContext().applicationContext)!!

        lifecycleScope.launch(Dispatchers.IO) {
            mapCompanyList = database.companyDao().getAllCompany()

            viewModel.mapCompanyAdapter.submitList(mapCompanyList)

        }

        binding.mapView.getMapAsync(this)

        viewModel.locationSource =
            FusedLocationSource(this, LOCATION_PERMISSION_REQUEST_CODE)

        binding.companyRecyclerview.apply {

            layoutManager = LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL,false)
            adapter = mapCompanyAdapter
        }
<<<<<<< HEAD

        Log.d("도티드","start - ${viewModel.locationSource.lastLocation}")

    }


    fun setMarkers(naverMap: NaverMap){

        for (i in mapCompanyList){

            Log.d("도티드", "${i.x.toDouble()} ${i.y.toDouble()}")
            val marker = Marker()
            marker.isIconPerspectiveEnabled = true
            marker.position = LatLng(i.y.toDouble(),i.x.toDouble())


            marker.icon = OverlayImage.fromResource(R.drawable.company_marker)
            marker.height = 180
            marker.width = 150
            marker.map = viewModel.naverMap


            marker.setOnClickListener {

                marker.height = 400
                marker.width = 335

                val cameraUpdate = CameraUpdate.scrollAndZoomTo( LatLng(i.y.toDouble(),i.x.toDouble()), 18.0 )
                    .animate(CameraAnimation.Linear,600)
                    .finishCallback {

                        val dialog = IssueDialog(requireContext())
                        dialog.showDialog()

                        dialog.setOnClicklistener(object : IssueDialog.OnDialogClickListener{

                            override fun onClicked() {

                            }

                            override fun onDismissed() {
                                Log.d("최희건", "$marker")

                                marker.height = 180
                                marker.width = 150

                            }
                        })

                    }

                viewModel.naverMap.moveCamera(cameraUpdate)

                return@setOnClickListener(true)
            }

            markerList.add(marker)
        }

=======
        mapCompanyAdapter.submitList(viewModel.mapCompanyList)
>>>>>>> master
    }

    override fun onMapReady(naverMap: NaverMap) {

        viewModel.naverMap = naverMap

        Log.d("도티드","onMapReady - ${viewModel.locationSource.lastLocation}")

        if(viewModel.locationSource.lastLocation != null ){

            Log.d("도티드","됬다아ㅏ아아아")

            viewModel.cameraPosition = CameraPosition(
                LatLng(viewModel.locationSource.lastLocation!!.latitude,
                    viewModel.locationSource.lastLocation!!.longitude), // 대상 지점
                16.0, // 줌 레벨
                90.0, // 기울임 각도
                0.0 // 베어링 각도
            )
            viewModel.naverMap.cameraPosition = viewModel.cameraPosition

        }

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

        setMarkers(naverMap)

        naverMap.uiSettings
    }

    override fun onRequestPermissionsResult(
        requestCode: Int,
        permissions: Array<out String>,
        grantResults: IntArray
    ) {

        Log.d("도티드", "onRequestPermissionsResult: ")
        return
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)
    }

    override fun onStart() {
        super.onStart()
        binding.mapView.onStart()
        Log.d("도티드","onStart - ${viewModel.locationSource.lastLocation}")

    }

    override fun onResume() {
        super.onResume()
        binding.mapView.onResume()
        Log.d("도티드","onResume - ${viewModel.locationSource.lastLocation}")

    }

    override fun onPause() {
        super.onPause()

        binding.mapView.onPause()
        Log.d("도티드","onPause - ${viewModel.locationSource.lastLocation}")

    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        binding.mapView.onSaveInstanceState(outState)

        Log.d("도티드","onSaveInstanceState - ${viewModel.locationSource.lastLocation}")

    }

    override fun onStop() {
        super.onStop()
        binding.mapView.onStop()

        Log.d("도티드","onStop - ${viewModel.locationSource.lastLocation}")

    }

    override fun onDestroy() {
        super.onDestroy()
        binding.mapView.onDestroy()

        Log.d("도티드","onDestroy - ${viewModel.locationSource.lastLocation}")

    }

    override fun onLowMemory() {
        super.onLowMemory()
        binding.mapView.onLowMemory()

        Log.d("도티드","onLowMemory - ${viewModel.locationSource.lastLocation}")

    }

    override fun onInflate(context: Context, attrs: AttributeSet, savedInstanceState: Bundle?) {
        super.onInflate(context, attrs, savedInstanceState)

        Log.d("도티드","onInflate - ${viewModel.locationSource.lastLocation}")

    }

    companion object {
        private const val LOCATION_PERMISSION_REQUEST_CODE = 1000

    }

}