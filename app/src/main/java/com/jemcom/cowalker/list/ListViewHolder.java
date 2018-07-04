package com.jemcom.cowalker.list;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.jemcom.cowalker.R;

public class ListViewHolder extends RecyclerView.ViewHolder {

    public LinearLayout listLayout;
    public TextView itemDate, itemTitle, itemType;
    public ImageView itemBackground, itemProfile1, itemProfile2, itemProfile3;


    public ListViewHolder(final View itemView) {
        super(itemView);
        listLayout = (LinearLayout) itemView.findViewById(R.id.layout_promise_list);
        itemDate = (TextView) itemView.findViewById(R.id.item_date_tv);
        itemTitle = (TextView) itemView.findViewById(R.id.item_title_tv);
        itemType = (TextView) itemView.findViewById(R.id.item_location_tv);

        itemBackground = (ImageView) itemView.findViewById(R.id.item_background_image);
        itemProfile1 = (ImageView) itemView.findViewById(R.id.item_profile1_image);
        itemProfile2 = (ImageView) itemView.findViewById(R.id.item_profile2_image);
        itemProfile3 = (ImageView) itemView.findViewById(R.id.item_profile3_image);

    }


}