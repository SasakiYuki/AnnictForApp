package com.wacode.yuki.annictforapp.fragment

import android.support.v4.widget.SwipeRefreshLayout
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.widget.LinearLayout
import com.wacode.yuki.annictforapp.R
import com.wacode.yuki.annictforapp.view.BaseRecyclerAdapter
import org.androidannotations.annotations.AfterViews
import org.androidannotations.annotations.EFragment
import org.androidannotations.annotations.ViewById

/**
 * Created by yuki.n on 2017/02/13.
 */
@EFragment(R.layout.fragment_base_recycler)
abstract class BaseRecyclerFragment : BaseFragment() {
    @ViewById(R.id.recycler)
    lateinit var recyclerView: RecyclerView

    @ViewById(R.id.refresh)
    lateinit var refresh: SwipeRefreshLayout

    @ViewById(R.id.empty_layout)
    lateinit var emptyLayout: LinearLayout

    lateinit var adapter: BaseRecyclerAdapter

    private var loading = true
    private var previousTotal = 0

    @AfterViews
    open fun initViews() {
        recyclerView.layoutManager = LinearLayoutManager(context)
    }

    fun setAdapter(adapter: BaseRecyclerAdapter) {
        this.adapter = adapter
        recyclerView.adapter = adapter
    }

    override fun onResume() {
        super.onResume()
        refresh.setOnRefreshListener {
            loadData()
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        recyclerView.removeOnScrollListener(onScrollListener)
    }

    private val onScrollListener: RecyclerView.OnScrollListener = object : RecyclerView.OnScrollListener() {
        override fun onScrolled(recyclerView: RecyclerView?, dx: Int, dy: Int) {
            super.onScrolled(recyclerView, dx, dy)
        }

        override fun onScrollStateChanged(recyclerView: RecyclerView?, newState: Int) {
            super.onScrollStateChanged(recyclerView, newState)
        }
    }

    abstract fun loadData()

    open fun onScrollStateChanged(recyclerView: RecyclerView, newState: Int) {
    }

    open fun onScrolled(recyclerView: RecyclerView, dx: Int, dy: Int) {
        val visibleItemCount = recyclerView.childCount
        val totalItemCount = recyclerView.layoutManager.itemCount
        val firstVisibleItem = (recyclerView.layoutManager as LinearLayoutManager).findFirstVisibleItemPosition()
        if (loading) {
            if (totalItemCount > previousTotal) {
                loading = false
            }
            previousTotal = totalItemCount
        }
        if (!loading && totalItemCount - visibleItemCount <= firstVisibleItem + visibleItemCount) {
            onScrollToBottom(recyclerView)
            loading = true
            loadData()
        }
    }

    open fun onScrollToBottom(recyclerView: RecyclerView) {
    }
}