package com.jemcom.cowalker.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


import com.google.gson.Gson;
import com.jemcom.cowalker.R;
import com.jemcom.cowalker.list.ListAdapter;
import com.jemcom.cowalker.list.ListData;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;

public class HomeFragment extends Fragment {
    private RecyclerView mRecyclerView;
    private ListAdapter listAdapter;
    private RecyclerView.LayoutManager mLayoutManager;
    // default이므로 서버이용시 지울꺼임
    private ArrayList<ListData> listData;
    private List<ListData> postList;

    public HomeFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        View view = inflater.inflate(R.layout.fragment_home, container, false);


        mRecyclerView = (RecyclerView) view.findViewById(R.id.recyclerview);
        //  mRecyclerView.setHasFixedSize(true);
        mLayoutManager = new LinearLayoutManager(getActivity());
        mRecyclerView.scrollToPosition(0);

        return view;
    }


    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState)
    {
        super.onActivityCreated(savedInstanceState);
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);

        initDataSet();
    }




    private void initDataSet() {
        listData = new ArrayList<>();
        listData.add(new ListData("2018년 4월 16일","공릉역","adsf",R.drawable.login_unclick,R.drawable.invite_plus_btn,R.drawable.invite_plus_btn,R.drawable.invite_plus_btn));
        listData.add(new ListData("2018년 5월 6일","2018.06.05", "석계역",R.drawable.login_unclick,R.drawable.invite_plus_btn,R.drawable.invite_plus_btn,R.drawable.invite_plus_btn));

    }

}
