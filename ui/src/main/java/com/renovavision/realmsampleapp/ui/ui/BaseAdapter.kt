package com.renovavision.realmsampleapp.ui.ui

import android.annotation.SuppressLint
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.AsyncListDiffer
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.renovavision.realmsampleapp.ui.Dispatch

abstract class BaseAdapter<T : Any, VH : BaseViewHolder<T>>(
    private val eventHandler: Dispatch = {}
) :
    RecyclerView.Adapter<VH>() {

    private val differ = AsyncListDiffer(this,
        ValueTypeDiffUtilItemCallback<T> { oldItem, newItem ->
            areItemsTheSame(oldItem, newItem)
        })

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
        buildViewHolder(parent, viewType).apply { this.onCreateViewHolder(eventHandler) }

    override fun onBindViewHolder(holder: VH, position: Int) {
        holder.onBindViewHolder(differ.currentList[position])
    }

    fun updateItems(newItems: List<T>) {
        differ.submitList(newItems)
    }

    override fun getItemCount(): Int = differ.currentList.size

    abstract fun areItemsTheSame(oldItem: T, newItem: T): Boolean

    abstract fun buildViewHolder(parent: ViewGroup, viewType: Int): VH
}

private class ValueTypeDiffUtilItemCallback<T>(
    private val itemComparator: ((oldItem: T, newItem: T) -> Boolean)
) :
    DiffUtil.ItemCallback<T>() {

    override fun areItemsTheSame(oldItem: T, newItem: T): Boolean =
        itemComparator(oldItem, newItem)

    @SuppressLint("DiffUtilEquals")
    override fun areContentsTheSame(oldItem: T, newItem: T): Boolean =
        oldItem.hashCode() == newItem.hashCode()
}

abstract class BaseViewHolder<T : Any>(view: View) : RecyclerView.ViewHolder(view) {

    protected lateinit var dispatch: Dispatch
    protected lateinit var item: T

    open fun onCreate(eventHandler: Dispatch) {}

    open fun onBind(item: T) {}

    internal fun onCreateViewHolder(eventHandler: Dispatch) {
        this.dispatch = eventHandler
        onCreate(eventHandler)
    }

    internal fun onBindViewHolder(item: T) {
        this.item = item
        onBind(item)
    }
}