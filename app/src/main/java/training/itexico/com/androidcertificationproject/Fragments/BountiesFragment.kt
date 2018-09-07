package training.itexico.com.androidcertificationproject.Fragments

import android.content.Context
import android.net.Uri
import android.os.Bundle
import android.support.v4.app.Fragment
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import training.itexico.com.androidcertificationproject.MainActivity

import training.itexico.com.androidcertificationproject.R

class BountiesFragment : Fragment() {

    companion object {
        val TAG = BountiesFragment::class.simpleName

        @JvmStatic
        fun newInstance() = BountiesFragment()
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        Log.v(TAG, "Fragment onAttach")
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.v(TAG, "Fragment onCreate")
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        Log.v(TAG, "Fragment onCreateView")
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_bounties, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        Log.v(TAG, "Fragment onActivityCreated")
    }

    override fun onStart() {
        super.onStart()
        Log.v(TAG, "Fragment onStart")
    }

    override fun onResume() {
        super.onResume()
        Log.v(TAG, "Fragment onResume")
    }

    override fun onPause() {
        super.onPause()
        Log.v(TAG, "Fragment onPause")
    }

    override fun onDetach() {
        super.onDetach()
        Log.v(TAG, "Fragment onDetach")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.v(TAG, "Fragment onDestroy")
    }
}
