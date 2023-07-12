package dgsw.kr.dotted.search.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.SearchView
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import dgsw.kr.dotted.R
import dgsw.kr.dotted.base.BaseFragment
import dgsw.kr.dotted.databinding.FragmentSearchBinding
import dgsw.kr.dotted.search.vm.SearchViewModel

class SearchFragment : BaseFragment<FragmentSearchBinding,SearchViewModel>(R.layout.fragment_search) {
    override val viewModel: SearchViewModel by viewModels()

    override fun start() {

    }


}