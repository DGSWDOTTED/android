package dgsw.kr.dotted.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import dgsw.kr.dotted.R
import dgsw.kr.dotted.base.BaseListAdapter
import dgsw.kr.dotted.databinding.ItemMapCompanyBinding
import dgsw.kr.dotted.map.data.CompanyData

class MapCompanyAdpater : BaseListAdapter<CompanyData,ItemMapCompanyBinding>(R.layout.item_map_company){

    override fun action(data: CompanyData, binding: ItemMapCompanyBinding) {
        binding.addressTxt.text = data.address
        binding.infoTxt.text = data.employ
        binding.nameTxt.text = data.com_name

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BaseViewHolder {
        return BaseViewHolder(ItemMapCompanyBinding.inflate(LayoutInflater.from(parent.context),parent,false))
    }


}