package com.wacode.yuki.annictforapp.fragment

import android.os.Bundle
import android.support.annotation.ColorRes
import android.support.annotation.Nullable
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import butterknife.bindView
import com.wacode.yuki.annictforapp.AnnictForAppApplication
import com.wacode.yuki.annictforapp.R
import com.wacode.yuki.annictforapp.contract.WorksContract
import com.wacode.yuki.annictforapp.rest.entity.WorksEntity
import com.wacode.yuki.annictforapp.view.RankingRecyclerView
import com.wacode.yuki.annictforapp.viewmodel.WorksViewModel

/**
 * Created by yuki on 2016/09/28.
 */
class SearchFragment : Fragment(),WorksContract.WorksView {
    private lateinit var viewModel:WorksViewModel
    private val recycler_this_season by bindView<RankingRecyclerView>(R.id.fragment_search_recycler_this_season)
    override fun showWorks(entity: WorksEntity) {
        recycler_this_season.setArrayList(entity.works)
    }

    override fun showError() {
    }


    override fun onCreate(@Nullable savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel = WorksViewModel((context.applicationContext as AnnictForAppApplication).getWorksApiService(),context)
        viewModel.setViews(this)
    }

    override fun onCreateView(inflater: LayoutInflater, @Nullable container: ViewGroup?, @Nullable savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.fragment_search, null)
        val linearLayout = view.findViewById(R.id.fragment_search_linear_layout) as LinearLayout
        linearLayout.setBackgroundResource(arguments.getInt(BACKGROUND_COLOR))
        viewModel.getWorks()
        return view
    }

    companion object {
        private val BACKGROUND_COLOR = "background_color"
        fun newInstance(@ColorRes IdRes: Int): SearchFragment {
            val frag = SearchFragment()
            val b = Bundle()
            b.putInt(BACKGROUND_COLOR, IdRes)
            frag.arguments = b
            return frag
        }
    }

}