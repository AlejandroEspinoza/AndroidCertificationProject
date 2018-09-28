package training.itexico.com.androidcertificationproject.Adapters

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup
import training.itexico.com.androidcertificationproject.ViewHolders.ViewHolderApple
import training.itexico.com.androidcertificationproject.databinding.ItemViewAppleBinding


class RecyclerViewAdapter : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    var mItems : List<String> = listOf()

    fun update(newList : List<String>){

        mItems = newList
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {

        return ViewHolderApple(ItemViewAppleBinding.inflate(LayoutInflater.from(parent.context), parent, false))
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {

        (holder as ViewHolderApple).bind(mItems[position])
    }

    override fun getItemCount(): Int {

        return mItems.size
    }}
