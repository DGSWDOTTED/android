package dgsw.kr.dotted.adapter

import dgsw.kr.dotted.R
import dgsw.kr.dotted.databinding.ItemHorizontalCompanyBinding
import dgsw.kr.dotted.home.data.Company

class RecommendCompanyAdapter : BaseListAdapter<Company, ItemHorizontalCompanyBinding>(
    R.layout.item_horizontal_company
) {
    override fun action(item: Company, binding: ItemHorizontalCompanyBinding) {
        binding.company = item

    }
}