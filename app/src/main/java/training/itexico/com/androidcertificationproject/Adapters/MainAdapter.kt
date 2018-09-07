package training.itexico.com.androidcertificationproject.Adapters

import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentStatePagerAdapter
import training.itexico.com.androidcertificationproject.Fragments.BountiesFragment

class MainAdapter(val fm:FragmentManager) : FragmentStatePagerAdapter(fm) {

    lateinit var data : List<BountiesFragment>

    override fun getCount(): Int {
        return data.size
    }

    override fun getItem(position: Int): Fragment {
        return data[position]
    }

    override fun getPageTitle(position: Int): CharSequence? {
        return when(position) {
            1 -> "Section1"
            2 -> "Section2"
            else -> "Section3"
        }
    }
}