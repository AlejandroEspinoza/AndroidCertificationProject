package training.itexico.com.androidcertificationproject.ViewHolders

import android.support.v7.widget.RecyclerView
import training.itexico.com.androidcertificationproject.databinding.ItemViewAppleBinding

class ViewHolderApple(val binding : ItemViewAppleBinding) : RecyclerView.ViewHolder(binding.root){

    fun bind(value : String){

        binding.label = value
    }
}