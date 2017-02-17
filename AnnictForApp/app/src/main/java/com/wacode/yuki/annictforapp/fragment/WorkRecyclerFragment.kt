package com.wacode.yuki.annictforapp.fragment

import android.os.Bundle
import android.view.ViewGroup
import com.wacode.yuki.annictforapp.AnnictForAppApplication
import com.wacode.yuki.annictforapp.contract.AnnimeCardContract
import com.wacode.yuki.annictforapp.contract.WorksContract
import com.wacode.yuki.annictforapp.rest.entity.WorksEntity
import com.wacode.yuki.annictforapp.type.SeasonType
import com.wacode.yuki.annictforapp.view.AnnimeCardAdapter
import com.wacode.yuki.annictforapp.view.ViewHolder
import com.wacode.yuki.annictforapp.viewmodel.WorksViewModel
import org.androidannotations.annotations.EFragment
import org.androidannotations.annotations.FragmentArg

/**
 * Created by yuki.n on 2017/02/14.
 */
@EFragment
class WorkRecyclerFragment : BaseRecyclerFragment(),WorksContract.WorksView,AnnimeCardContract {
    @FragmentArg(ARG_SEASON)
    lateinit var season:String

    @FragmentArg(ARG_YEAR)
    lateinit var year:String

    private lateinit var viewModel:WorksViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel = WorksViewModel((context as AnnictForAppApplication).getWorksApiService(), context)
        viewModel.setViews(this)
        viewModel.addPage()
        setAdapter(object : AnnimeCardAdapter() {
            override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder? {
                //TODO OnCLickListener
                return super.onCreateViewHolder(parent, viewType)
            }
        })
    }

    override fun onResume() {
        super.onResume()
    }

    override fun loadData() {
    }

    override fun showWorks(entity: WorksEntity) {
        (adapter as AnnimeCardAdapter).setWorks(entity.works)
    }

    override fun showError() {
    }

    override fun setView(view: AnnimeCardContract.AnnimeCardView) {

    }
    companion object {
        fun newInstance(season:String = SeasonType.ALL, year:String = "2017"):WorkRecyclerFragment {
            val fragment = WorkRecyclerFragment()
            fragment.season = season
            fragment.year = year
            return fragment
        }
    }
}
