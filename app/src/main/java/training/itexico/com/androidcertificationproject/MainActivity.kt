package training.itexico.com.androidcertificationproject

import android.arch.lifecycle.ViewModelProvider
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.os.PersistableBundle
import android.support.v4.view.ViewPager
import android.util.Log
import android.view.View
import training.itexico.com.androidcertificationproject.Adapters.MainAdapter
import training.itexico.com.androidcertificationproject.Fragments.BountiesFragment
import android.support.design.widget.TabLayout
import training.itexico.com.androidcertificationproject.ViewModel.MainViewModel
import android.arch.lifecycle.ViewModelProviders
import android.databinding.DataBindingUtil
import training.itexico.com.androidcertificationproject.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity() {
    
    companion object {
        val TAG = MainActivity::class.simpleName
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        Log.v(TAG, "onCreate")

        val binding : ActivityMainBinding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        val model = ViewModelProviders.of(this).get(MainViewModel::class.java)

        val pager = findViewById<ViewPager>(R.id.container)
        val tabLayout : TabLayout = findViewById(R.id.tablayout) as TabLayout
        tabLayout.setupWithViewPager(pager)

        val adapter = MainAdapter(supportFragmentManager)
        val fragment1 = BountiesFragment.newInstance()
        val fragment2 = BountiesFragment.newInstance()
        val fragment3 = BountiesFragment.newInstance()
        adapter.data = listOf(fragment1, fragment2, fragment3)

        pager.adapter = adapter

        binding.model = model
        binding.setLifecycleOwner(this)
    }

    override fun onStart() {
        super.onStart()
        Log.v(TAG,"onStart")
    }

    override fun onResume() {
        super.onResume()
        Log.v(TAG, "onResume")
    }

    override fun onPause() {
        super.onPause()
        Log.v(TAG, "onPause")
    }

    override fun onStop() {
        super.onStop()
        Log.v(TAG, "onStop")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.v(TAG, "onDestroy")
    }
}
