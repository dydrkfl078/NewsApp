package com.example.newsapp

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.newsapp.databinding.FragmentNewsDetailPageBinding
import com.example.newsapp.databinding.FragmentNewsListViewBinding

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"


/**
 * A simple [Fragment] subclass.
 * Use the [NewsListView.newInstance] factory method to
 * create an instance of this fragment.
 */
class NewsListView : Fragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null
    private lateinit var binding : FragmentNewsListViewBinding

    val newsList = mutableListOf<NewsData>()

    init {
        newsList.apply {
            add(
                NewsData(
                    "조선일보",
                    R.drawable.cho_sun_logo,
                    "퇴직 다음날 음주운전 사고 낸 교장... 피해자 2명은 옛 제자",
                    R.drawable.sample_01,
                    "한 고등학교 교장이 정년퇴임 다음 날 음주운전 교통사고를 내면서 중상을 입은 피해자",
                    "A기자",
                    "2023.09.02"
                )
            )
            add(
                NewsData(
                    "세계일보",
                    R.drawable.sa_gae_logo,
                    "서이초 교사 추모 위해 모인 전북교사들 우리는 살고 싶다",
                    R.drawable.sample_02,
                    "서이초 교사 추모 위해 모인 전북교사들 우리는 살고 싶다",
                    "B기자",
                    "2023.09.02"
                )
            )
            add(
                NewsData(
                    "한겨례",
                    R.drawable.han_gyu_rae_logo,
                    "뒷정리, 교통정리까지... 질서정연했던 광주 교사 집회",
                    R.drawable.sample_03,
                    "뒷정리, 교통정리까지... 질서정연했던 광주 교사 집회",
                    "TS기자",
                    "2023.09.02"
                )
            )
            add(
                NewsData(
                    "한국일보",
                    R.drawable.kuk_min_logo,
                    "늦은 밤 귀갓길, 안심귀가 스카우트를 아시나요?",
                    R.drawable.sample_04,
                    "늦은 밤 귀갓길, 안심귀가 스카우트를 아시나요?",
                    "GH기자",
                    "2023.09.01"
                )
            )
            add(
                NewsData(
                    "중앙일보",
                    R.drawable.joong_ang_logo,
                    "잦은 네일아트로 손발톱이 얇아졌다면??.. 조갑연화증 주의",
                    R.drawable.sample_05,
                    "잦은 네일아트로 손발톱이 얇아졌다면??.. 조갑연화증 주의",
                    "BH기자",
                    "2023.09.05"
                )
            )
            add(
                NewsData(
                    "조선일보",
                    R.drawable.cho_sun_logo,
                    "세입자 신용 분량자 만든 전세사기 50대 구속",
                    R.drawable.sample_06,
                    "세입자 신용 분량자 만든 전세사기 50대 구속",
                    "G기자",
                    "2023.09.03"
                )
            )
            add(
                NewsData(
                    "조선일보",
                    R.drawable.cho_sun_logo,
                    "경북 칠곡 종합병원 서 흉기 난동으로 환자 1명 사망",
                    R.drawable.sample_07,
                    "경북 칠곡 종합병원 서 흉기 난동으로 환자 1명 사망",
                    "A기자",
                    "2023.09.02"
                )
            )
            add(
                NewsData(
                    "머니투데이",
                    R.drawable.moneytoday_logo,
                    "부임 3일만에... 중학교 교장 출신 제주도교육청 과장 숨진 채 발견",
                    R.drawable.sample_01,
                    "부임 3일만에... 중학교 교장 출신 제주도교육청 과장 숨진 채 발견",
                    "A기자",
                    "2023.09.02"
                )
            )
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentNewsListViewBinding.inflate(inflater,container,false)

        val adapter = MyAdapter(newsList)
        binding.recyclerviewNewsList.adapter = adapter
        binding.recyclerviewNewsList.layoutManager=LinearLayoutManager(requireContext())
        binding.recyclerviewNewsList.addItemDecoration(DividerItemDecoration(requireContext(),LinearLayout.VERTICAL))

        // RecyclerView Item 클릭 시 NewsDetail 로 이동.
        adapter.itemClick = object : MyAdapter.ItemClick{
            override fun onClick(view: View, position: Int) {
                val detailFragment = NewsDetail()
                val bundle = Bundle()
                bundle.putParcelable("newsDetail",newsList[position])

                detailFragment.arguments = bundle
                parentFragmentManager.beginTransaction()
                    .replace(R.id.main_frame_layout,detailFragment)
                    .addToBackStack(null)
                    .commit()
                }
        }
        // 데이터 넘기기
        // Inflate the layout for this fragment
        return binding.root
    }




    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment NewsListView.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            NewsListView().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}