package training.itexico.com.androidcertificationproject.Models

import android.app.Application
import android.arch.lifecycle.AndroidViewModel
import training.itexico.com.androidcertificationproject.Adapters.RecyclerViewAdapter

class RecyclerModel(application: Application) : AndroidViewModel(application){

    var adapter : RecyclerViewAdapter? = null

    init {

        adapter = RecyclerViewAdapter()
        val newList : ArrayList<String> = ArrayList()
        newList.add("Alex")
        newList.add("Juan Pablo")
        newList.add("Gio")
        newList.add("iTexico")
        adapter?.update(newList.toList())
    }
}