package dgsw.kr.dotted.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import dgsw.kr.dotted.R
import dgsw.kr.dotted.base.BaseListAdapter
import dgsw.kr.dotted.databinding.ItemMapCompanyBinding
<<<<<<< HEAD:app/src/main/java/dgsw/kr/dotted/adapter/MapCompanyAdpater.kt
import dgsw.kr.dotted.local.DB.CompanyEntity
import dgsw.kr.dotted.map.data.MapCompanyData

class MapCompanyAdpater : BaseListAdapter<CompanyEntity,ItemMapCompanyBinding>(R.layout.item_map_company){

    override fun action(data: CompanyEntity, binding: ItemMapCompanyBinding) {
=======
import dgsw.kr.dotted.map.data.CompanyData

class MapCompanyAdapter(private val onClick: (CompanyData) -> Unit) : BaseListAdapter<CompanyData,ItemMapCompanyBinding>(R.layout.item_map_company){

    override fun action(data: CompanyData, binding: ItemMapCompanyBinding) {
>>>>>>> master:app/src/main/java/dgsw/kr/dotted/adapter/MapCompanyAdapter.kt
        binding.addressTxt.text = data.address
        binding.infoTxt.text = data.jobType
        binding.nameTxt.text = data.companyTitle

        binding.root.setOnClickListener { onClick(data) }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BaseViewHolder {
        return BaseViewHolder(ItemMapCompanyBinding.inflate(LayoutInflater.from(parent.context),parent,false))
    }


}