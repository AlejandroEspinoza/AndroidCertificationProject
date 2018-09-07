package training.itexico.com.androidcertificationproject.ViewModel

import android.app.Application
import android.arch.lifecycle.AndroidViewModel
import android.arch.lifecycle.ViewModel
import android.util.Log
import training.itexico.com.androidcertificationproject.MainActivity
import training.itexico.com.androidcertificationproject.R

class MainViewModel() : ViewModel() {

    val title : Int = R.string.main_activity_title

    companion object {
        val TAG = MainViewModel::class.simpleName
    }

    init {
        Log.v(TAG, "MainViewModel Was created")
    }

    override fun onCleared() {
        super.onCleared()
        Log.v(TAG, "MainViewModel Was killed")
    }
}