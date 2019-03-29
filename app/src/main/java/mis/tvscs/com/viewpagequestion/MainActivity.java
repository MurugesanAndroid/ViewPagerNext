package mis.tvscs.com.viewpagequestion;

import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements NextPage {


    public PagerAdapters adapter = null;
    public CustomViewPager mViewPager = null;
    AppCompatActivity mContext;
    public NextPage nextPage;
    ArrayList<Challan> arrayList = new ArrayList<>();


    public void setNextPage(NextPage nextPage) {
        this.nextPage = nextPage;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mContext = MainActivity.this;
        setNextPage(this);

        mViewPager = findViewById(R.id.viewpager);


        for (int i = 0; i < 10; i++) {
            Challan challan = new Challan();
            challan.setTextValue("Bank" + i);
            arrayList.add(challan);
        }

        try {

            adapter = new PagerAdapters(getSupportFragmentManager(), arrayList, nextPage);
            mViewPager.setAdapter(adapter);
            mViewPager.setOffscreenPageLimit(arrayList.size());
        } catch (Exception e) {
            e.printStackTrace();
        }

    }


    @Override
    public void tapAddPosition(int position) {
        Log.d("CallBack", " onTabAddpostion position" + position);
        mViewPager.setCurrentItem(position, true);
    }
}
