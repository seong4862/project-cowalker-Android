package com.jemcom.cowalker.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
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
        mLayoutManager = new GridLayoutManager(getActivity(), 2);
        mRecyclerView.scrollToPosition(0);

        listAdapter = new ListAdapter(listData);
        mRecyclerView.setLayoutManager(mLayoutManager);
        mRecyclerView.setAdapter(listAdapter);

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

        listData.add(new ListData("없이 산다","사이드 프로젝트","축제","서울",R.drawable.default_img));
        listData.add(new ListData("KU석KU석 프로젝트","공모전","컨텐츠","서울",R.drawable.default_img));
        listData.add(new ListData("에너지 블록체인","창업","블록체인","충청도",R.drawable.default_img));
        listData.add(new ListData("디자인플젝","공모전","디자인","경상도",R.drawable.default_img));
        listData.add(new ListData("아이디어","축제","컨텐츠","제주",R.drawable.default_img));
        listData.add(new ListData("안드 스터디","스터디","기타","전라도",R.drawable.default_img));
        listData.add(new ListData("IoT 스터디","스터디","IoT","강원",R.drawable.default_img));
        listData.add(new ListData("스타트업 모집","창업","기타","인천",R.drawable.default_img));
        listData.add(new ListData("빅데이터 공부","스터디","인공지능 AI","경기",R.drawable.default_img));
        listData.add(new ListData("기타","기타","기타","서울",R.drawable.default_img));
        listAdapter = new ListAdapter(listData);

    }

}