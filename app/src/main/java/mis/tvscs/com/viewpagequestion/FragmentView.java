package mis.tvscs.com.viewpagequestion;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

public class FragmentView extends Fragment implements View.OnClickListener {

    private Context mContext;
    public NextPage nextPage;
    int mPosition;
    //  Challan challan;
    Button right_arrow_backpage, right_arrow_nextpage;
    TextView textView;
    Challan challan;


    public static Fragment newInstance(int position, Challan challan, NextPage nextPage) {
        FragmentView fragment = new FragmentView();
        Bundle args = new Bundle();
        args.putInt("Count", position);
        args.putSerializable("challan", challan);
        fragment.nextPage = nextPage;
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mContext = getContext();

        if (getArguments() != null) {
            if (getArguments().containsKey("challan")) {

                challan = (Challan) getArguments().getSerializable("challan");
            }

            if (getArguments().containsKey("Count"))
                mPosition = getArguments().getInt("Count");

        }


    }


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_view, container, false);

        right_arrow_backpage = view.findViewById(R.id.right_arrow_backpage);
        right_arrow_backpage.setOnClickListener(this);

        right_arrow_nextpage = view.findViewById(R.id.right_arrow_nextpage);
        right_arrow_nextpage.setOnClickListener(this);
        textView = view.findViewById(R.id.textView);


        textView.setText(challan.getTextValue());

        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
    }


    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.right_arrow_nextpage:

                nextPage.tapAddPosition(mPosition + 1);

                break;
            case R.id.right_arrow_backpage:

                nextPage.tapAddPosition(mPosition - 1);

                break;
        }
    }

}
