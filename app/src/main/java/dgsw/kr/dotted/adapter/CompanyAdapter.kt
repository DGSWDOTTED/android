package dgsw.kr.dotted.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import dgsw.kr.dotted.R
import dgsw.kr.dotted.base.BaseListAdapter
import dgsw.kr.dotted.databinding.ItemVerticalCompanyBinding
import dgsw.kr.dotted.home.data.CompanyData
import dgsw.kr.dotted.local.DB.CompanyEntity

class CompanyAdapter(private val onClick: (CompanyEntity) -> Unit) : BaseListAdapter<CompanyEntity, ItemVerticalCompanyBinding>(
    R.layout.item_vertical_company
) {
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

    override fun action(item: CompanyEntity, binding: ItemVerticalCompanyBinding) {
        binding.tvTitle.text = item.companyTitle
        binding.tvAddress.text = item.address
        binding.ivLogo.clipToOutline = true
        val imageIdx = (item.id.toInt()+123456 )% profileImgList.size
        binding.ivLogo.setImageResource(profileImgList[imageIdx])
        binding.root.setOnClickListener { onClick(item) }
        binding.tvEmploy.text = item.jobType
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BaseViewHolder {
        return BaseViewHolder(ItemVerticalCompanyBinding.inflate(LayoutInflater.from(parent.context),parent,false))
    }
}