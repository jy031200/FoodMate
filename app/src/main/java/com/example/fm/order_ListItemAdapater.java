package com.example.fm;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

public class order_ListItemAdapater extends BaseAdapter {
    ArrayList<ListItem> items = new ArrayList<ListItem>();
    Context context;

    @Override
    public int getCount() {
        return items.size();
    }

    @Override
    public Object getItem(int position) {
        return items.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View view, ViewGroup parent) {
        context = parent.getContext();
        ListItem listItem = items.get(position);

        if (view == null) {
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            view = inflater.inflate(R.layout.order_item, parent, false);
            ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
            //layoutParams.height = 100;

            view.setLayoutParams(layoutParams);
        }

        ImageView Img = view.findViewById(R.id.img);
        TextView name = view.findViewById(R.id.txtname);
        TextView order = view.findViewById(R.id.txtoder);

        Img.setImageResource(listItem.getImg());
        name.setText(listItem.getName0());
        order.setText(listItem.getOrder());

        return view;
    }

    public void addItem(ListItem item) {
        items.add(item);
    }

    public static void getListViewSize(ListView myListView) {
        ListAdapter myListAdapter = myListView.getAdapter();
        if (myListAdapter == null) {
            // do nothing return null
            return;
        }
        // set listAdapter in loop for getting final size
        int totalHeight = 0;
        int desiredWidth = View.MeasureSpec.makeMeasureSpec(myListView.getWidth(), View.MeasureSpec.AT_MOST);
// 각 item view 마다 크기가 다를 수 있음으로 각 item view 의 size 만큼 더한다.

        for (int size = 0; size < myListAdapter.getCount(); size++) {
            View listItem = myListAdapter.getView(size, null, myListView);
            listItem.measure(desiredWidth, View.MeasureSpec.UNSPECIFIED);
            totalHeight += listItem.getMeasuredHeight();
            Log.i("getheight:", String.valueOf(listItem.getMeasuredHeight())); // 210
        }

        // setting listview item in adapter
        ViewGroup.LayoutParams params = myListView.getLayoutParams();

        // divider 도 크기가 있기 때문에 따로 더해줘야 한다.
        params.height = totalHeight + (myListView.getDividerHeight() * (myListAdapter.getCount() - 1));
        myListView.setLayoutParams(params);

        // layout view 모양이 바꼇다고 알려준다. onlayout 이 호출 된다.

        myListView.requestLayout();
        // print height of adapter on log
//        Log.i("height of listItem:", String.valueOf(totalHeight)); // 840
//        Log.i("Count:", String.valueOf(myListAdapter.getCount())); // 4
//        Log.i("height:", String.valueOf(params.height)); // 846
//        Log.i("Width:", String.valueOf(desiredWidth)); // -2147483648
    }
}
