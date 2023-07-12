package dgsw.kr.dotted.search.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.SearchView
import androidx.fragment.app.Fragment
import dgsw.kr.dotted.databinding.FragmentSearchBinding

class SearchFragment : Fragment() {

    private lateinit var binding: FragmentSearchBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentSearchBinding.inflate(inflater, container, false)

        return binding.root
    }
    private fun updateRecommendationList(recommendations: List<String>) {
        // 추천 검색어 목록을 업데이트하는 로직 구현
        // 예를 들어, RecyclerView나 ListView 등의 UI 컴포넌트를 사용하여 추천 검색어를 표시

        // RecyclerView를 사용하는 경우
        
    }



}