package training.itexico.com.androidcertificationproject.Adapters

import android.databinding.BindingAdapter
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.widget.LinearLayout
import training.itexico.com.androidcertificationproject.CustomViews.CircleImageView
import training.itexico.com.androidcertificationproject.CustomViews.FugitiveView
import training.itexico.com.androidcertificationproject.Models.Fugitive

@BindingAdapter("android:fugitive")
fun setFugitive(view:CircleImageView, fugitive:Fugitive) {
    view.fugitivo = fugitive
}

@BindingAdapter("android:fugitive")
fun setFugitive(view:FugitiveView, fugitive:Fugitive) {
    view.fugitivo = fugitive
}
@BindingAdapter("android:adapter")
fun setAdapter(view : RecyclerView, adapter : RecyclerView.Adapter<RecyclerView.ViewHolder>){

    view.adapter = adapter
}

@BindingAdapter("android:setLinearLayout")
fun setAdapter(view : RecyclerView, boolean: Boolean){

    view.layoutManager = LinearLayoutManager(view.context)
}
