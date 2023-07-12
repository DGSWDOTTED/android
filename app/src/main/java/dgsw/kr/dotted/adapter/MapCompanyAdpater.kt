package dgsw.kr.dotted.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import dgsw.kr.dotted.R
import dgsw.kr.dotted.base.BaseListAdapter
import dgsw.kr.dotted.databinding.ItemMapCompanyBinding
import dgsw.kr.dotted.local.DB.CompanyEntity
import dgsw.kr.dotted.map.data.MapCompanyData

class MapCompanyAdpater : BaseListAdapter<CompanyEntity,ItemMapCompanyBinding>(R.layout.item_map_company){

    override fun action(data: CompanyEntity, binding: ItemMapCompanyBinding) {
        binding.addressTxt.text = data.address
        binding.infoTxt.text = data.jobType
        binding.nameTxt.text = data.companyTitle

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BaseViewHolder {
        return BaseViewHolder(ItemMapCompanyBinding.inflate(LayoutInflater.from(parent.context),parent,false))
    }


}