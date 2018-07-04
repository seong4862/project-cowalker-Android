package com.jemcom.cowalker.list;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.jemcom.cowalker.R;

import java.util.List;

public class ListAdapter extends RecyclerView.Adapter<ListViewHolder> {

    Context context;

    private List<ListData> arrayListOfListData;
    private OnItemClickListener mListener;


    public interface OnItemClickListener {
        void onItemClick(int position);
    }

    public void setOnItemClickListener(OnItemClickListener listener){
        mListener = listener;
    }

    public ListAdapter(List<ListData> arrayListOfListData)
    {
        this.arrayListOfListData = arrayListOfListData;

    }

    @Override
    public ListViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        context = parent.getContext();
        LayoutInflater layoutInflater = LayoutInflater.from(context);
        View listView = layoutInflater.inflate(R.layout.list_item, parent, false);
        ListViewHolder viewHolder = new ListViewHolder(listView);

        return viewHolder;
    }


    public void onBindViewHolder(ListViewHolder holder, int position) {

        int i=0;
        String RoomTitle[] = new String[50];
        RoomTitle[i] = arrayListOfListData.get(position).getTitle();
        Log.v("logtest", "방 제목 = " + RoomTitle);
        holder.itemDate.setText(arrayListOfListData.get(position).getDate());
        holder.itemTitle.setText(arrayListOfListData.get(position).getTitle());
        holder.itemType.setText(arrayListOfListData.get(position).getType());

        holder.itemBackground.setImageResource(arrayListOfListData.get(position).post_imgUrl);

        // default 이미지 적용 중
        holder.itemProfile1.setImageResource(R.drawable.invite_plus_btn);
        holder.itemProfile2.setImageResource(R.drawable.invite_plus_btn);
        holder.itemProfile3.setImageResource(R.drawable.invite_plus_btn);


    }

    @Override
    public int getItemCount() {

        return arrayListOfListData.size();
    }

}


