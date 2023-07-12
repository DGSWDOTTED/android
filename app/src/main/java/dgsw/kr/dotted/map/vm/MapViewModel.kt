package dgsw.kr.dotted.map.vm

import androidx.lifecycle.viewModelScope
import com.naver.maps.geometry.LatLng
import com.naver.maps.map.CameraPosition
import com.naver.maps.map.MapView
import com.naver.maps.map.NaverMap
import com.naver.maps.map.util.FusedLocationSource
import dgsw.kr.dotted.adapter.MapCompanyAdapter
import dgsw.kr.dotted.base.BaseViewModel
<<<<<<< HEAD
import dgsw.kr.dotted.local.DB.CompanyEntity
import dgsw.kr.dotted.map.data.MapCompanyData
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

=======
import dgsw.kr.dotted.map.data.CompanyData
>>>>>>> master

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

<<<<<<< HEAD
    val mapCompanyAdapter : MapCompanyAdpater by lazy { MapCompanyAdpater() }


=======
    val mapCompanyList = mutableListOf<CompanyData>().apply {
        add(CompanyData("사회적협동조합 가온누리 보호작업장","충청남도 천안시 서북구 백석공단1로 10 지하1층 지원비 138호 (백석동)","기타 전자 부품·제품 조립·검사원"))
        add(CompanyData("기업과사람들(주)","충청남도 천안시 서북구 성정1길 8 2층  (성정동)","인쇄, 목재, 가구 및 기타 제조 분야 단순 종사원"))
        add(CompanyData("(주)비.엘.아이","경기도 파주시 탄현면 방촌로 1172-42 (주)비.엘.아이","고무 사출성형기 조작원"))
        add(CompanyData("한국토지주택공사","경상남도 진주시 충의로 19 한국토지주택공사 (충무공동)","사무 보조원(공공기관)"))
        add(CompanyData("사회적협동조합 가온누리 보호작업장","충청남도 천안시 서북구 백석공단1로 10 지하1층 지원비 138호 (백석동)","기타 전자 부품·제품 조립·검사원"))
        add(CompanyData("사회적협동조합 가온누리 보호작업장","충청남도 천안시 서북구 백석공단1로 10 지하1층 지원비 138호 (백석동)","기타 전자 부품·제품 조립·검사원"))
    }
>>>>>>> master

}