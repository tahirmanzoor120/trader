package com.tahirmanzoor.trader.fragment.product


import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.tahirmanzoor.trader.R
import com.tahirmanzoor.trader.dummy.DummyContent.DummyItem
import com.tahirmanzoor.trader.fragment.product.ProductFragment.OnListFragmentInteractionListener
import kotlinx.android.synthetic.main.fragment_product.view.*

/**
 * [RecyclerView.Adapter] that can display a [DummyItem] and makes a call to the
 * specified [OnListFragmentInteractionListener].
 */
class MyProductRecyclerViewAdapter(

    private val mValues: List<DummyItem>, // list of items

    private val mListener: OnListFragmentInteractionListener?

) : RecyclerView.Adapter<MyProductRecyclerViewAdapter.ViewHolder>() {

    inner class ViewHolder(val mView: View) : RecyclerView.ViewHolder(mView) {

        // For fragment_product.xml

        val mIdView: TextView = mView.item_number
        val mContentView: TextView = mView.content

        override fun toString(): String {
            return super.toString() + " '" + mContentView.text + "'"
        }
    }

    override fun getItemCount(): Int = mValues.size // Returns the size of list

    private val mOnClickListener: View.OnClickListener

    init {
        mOnClickListener = View.OnClickListener {
            mListener?.onListFragmentInteraction(it.tag as DummyItem)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.fragment_product, parent, false)
        return ViewHolder(view)
    }

    // Update the RecyclerView.ViewHolder contents
    // with the item at the given position


    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = mValues[position]

        holder.mIdView.text = item.id
        holder.mContentView.text = item.content

        // Sets up some private fields to be used by RecyclerView.
        with(holder.mView) {
            tag = item
            setOnClickListener(mOnClickListener)
        }
    }

}
