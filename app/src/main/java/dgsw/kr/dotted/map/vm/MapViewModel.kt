package dgsw.kr.dotted.map.vm

import androidx.lifecycle.viewModelScope
import com.naver.maps.geometry.LatLng
import com.naver.maps.map.CameraPosition
import com.naver.maps.map.MapView
import com.naver.maps.map.NaverMap
import com.naver.maps.map.util.FusedLocationSource
import dgsw.kr.dotted.adapter.MapCompanyAdpater
import dgsw.kr.dotted.base.BaseViewModel
import dgsw.kr.dotted.local.DB.CompanyEntity
import dgsw.kr.dotted.map.data.MapCompanyData
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch


class MapViewModel :BaseViewModel() {


    init {
    }

    lateinit var locationSource: FusedLocationSource
    lateinit var naverMap: NaverMap

    var cameraPosition = CameraPosition(
        LatLng(37.5666102, 126.9783881), // 대상 지점
        16.0, // 줌 레벨
        90.0, // 기울임 각도
        0.0 // 베어링 각도
    )

    val mapCompanyAdapter : MapCompanyAdpater by lazy { MapCompanyAdpater() }



}