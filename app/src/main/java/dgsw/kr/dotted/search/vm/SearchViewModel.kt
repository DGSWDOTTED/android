package dgsw.kr.dotted.search.vm

import dgsw.kr.dotted.base.BaseViewModel
import dgsw.kr.dotted.local.DB.CompanyEntity

class SearchViewModel : BaseViewModel() {


    lateinit var companyList : List<CompanyEntity>
}