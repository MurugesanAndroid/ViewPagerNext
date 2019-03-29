package mis.tvscs.com.viewpagequestion;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import java.util.ArrayList;
import java.util.List;

public class PagerAdapters extends FragmentStatePagerAdapter {

    private List<String> tabTitles = new ArrayList<String>();

    ArrayList<Challan> arrayList = new ArrayList<>();

    private NextPage nextPage;

    public PagerAdapters(FragmentManager childFragmentManager, ArrayList<Challan> arrayList, NextPage nextPage) {
        super(childFragmentManager);
        this.arrayList = arrayList;
        this.nextPage = nextPage;

    }

    @Override
    public Fragment getItem(int position) {
        if(arrayList!=null) {
            if(arrayList.size()>position)
                return (FragmentView.newInstance(position, arrayList.get(position), nextPage));
                else
                return (FragmentView.newInstance(position,null, nextPage));
        }
        else
            return (FragmentView.newInstance(position,null, nextPage));
    }

    @Override
    public int getCount() {

        return arrayList.size();
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return tabTitles.get(position).toString();

    }

}
