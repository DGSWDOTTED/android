package dgsw.kr.dotted.home.vm

import RecommendCompanyAdapter
import dgsw.kr.dotted.R
import dgsw.kr.dotted.adapter.CompanyAdapter
import dgsw.kr.dotted.base.BaseViewModel
import dgsw.kr.dotted.home.data.CompanyData

class homeViewModel: BaseViewModel() {
    lateinit var name: String
    lateinit var address: String
    lateinit var profileImage: String
    val verticalCompanyAdapter : CompanyAdapter by lazy { CompanyAdapter() }
    val recommendCompanyAdapter : RecommendCompanyAdapter by lazy { RecommendCompanyAdapter() }
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
    val randomNumber = (0 .. profileImgList.size).random()
    val mapCompanyList = mutableListOf<CompanyData>().apply {
        add(CompanyData("사회적협동조합 가온누리 보호작업장","충청남도 천안시 서북구 백석공단1로 10 지하1층 지원비 138호 (백석동)","기타 전자 부품·제품 조립·검사원", ))
        add(CompanyData("기업과사람들(주)","충청남도 천안시 서북구 성정1길 8 2층  (성정동)","인쇄, 목재, 가구 및 기타 제조 분야 단순 종사원"))
        add(CompanyData("(주)비.엘.아이","경기도 파주시 탄현면 방촌로 1172-42 (주)비.엘.아이","고무 사출성형기 조작원"))
        add(CompanyData("한국토지주택공사","경상남도 진주시 충의로 19 한국토지주택공사 (충무공동)","사무 보조원(공공기관)"))
        add(CompanyData("사회적협동조합 가온누리 보호작업장","충청남도 천안시 서북구 백석공단1로 10 지하1층 지원비 138호 (백석동)","기타 전자 부품·제품 조립·검사원"))
        add(CompanyData("사회적협동조합 가온누리 보호작업장","충청남도 천안시 서북구 백석공단1로 10 지하1층 지원비 138호 (백석동)","기타 전자 부품·제품 조립·검사원"))
    }
}