package dgsw.kr.dotted.detail.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.fragment.app.Fragment
import dgsw.kr.dotted.R
import dgsw.kr.dotted.databinding.FragmentDetailBinding


/**
 * A simple [Fragment] subclass.
 * Use the [DetailFragment.newInstance] factory method to
 * create an instance of this fragment.
 */

class DetailFragment() : Fragment() {
    // TODO: Rename and change types of parameters
    private var name: String? = null
    private var address: String? = null
    private var profileImage: Int = R.drawable.ic_company
    private var major = null
    private var pay = null
    private var companyType: String? = null
    private var employmentType = null
    private var charge = null

    private lateinit var binding: FragmentDetailBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentDetailBinding.inflate(inflater, container, false)
        binding.companyName.setText(name)
        binding.companyAddress.setText(address)
        binding.companyPicture.setBackgroundResource(profileImage)
        binding.companyPayType.setText(major)
        binding.companyPay.setText(pay)
        binding.companyScale.setText(companyType)
        binding.companyRole.setText(employmentType)
        binding.companyMaster.setText(charge)

        binding.backTo.setOnClickListener {

        }

        return binding.root


    }
}