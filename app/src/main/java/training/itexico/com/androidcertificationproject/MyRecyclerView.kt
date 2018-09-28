package training.itexico.com.androidcertificationproject

import android.arch.lifecycle.ViewModelProviders
import android.databinding.DataBindingUtil
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import training.itexico.com.androidcertificationproject.Models.RecyclerModel
import training.itexico.com.androidcertificationproject.databinding.ActivityMyrecyclerviewBinding

class MyRecyclerView : AppCompatActivity() {

    private  val recyclerModel : RecyclerModel by lazy {

        ViewModelProviders.of(this).get(RecyclerModel::class.java)
    }

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)

        val binding : ActivityMyrecyclerviewBinding = DataBindingUtil.setContentView(this, R.layout.activity_myrecyclerview)
        binding.model = recyclerModel
        binding.setLifecycleOwner(this)
    }
}