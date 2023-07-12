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

        binding.searchView.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(query: String): Boolean {
                // 검색어 제출 이벤트 처리
                return true

            }

            override fun onQueryTextChange(newText: String): Boolean {
                // 검색어 변경 이벤트 처리


                // 필터링된 결과를 사용하여 추천 검색어 목록을 업데이트하는 로직 구현
                val recommendationList = filteredList.take(5) // 상위 5개의 추천 검색어만 사용하도록 제한
                updateRecommendationList(recommendationList)

                return true
            }
        })

        return binding.root
    }
    private fun updateRecommendationList(recommendations: List<String>) {
        // 추천 검색어 목록을 업데이트하는 로직 구현
        // 예를 들어, RecyclerView나 ListView 등의 UI 컴포넌트를 사용하여 추천 검색어를 표시

        // RecyclerView를 사용하는 경우
        
    }



}