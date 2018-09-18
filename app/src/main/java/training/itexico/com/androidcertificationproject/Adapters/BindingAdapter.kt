package training.itexico.com.androidcertificationproject.Adapters

import android.databinding.BindingAdapter
import training.itexico.com.androidcertificationproject.CustomViews.CircleImageView
import training.itexico.com.androidcertificationproject.Models.Fugitive

@BindingAdapter("android:fugitive")
fun setFugitive(view:CircleImageView, fugitive:Fugitive) {
    view.fugitive = fugitive
}