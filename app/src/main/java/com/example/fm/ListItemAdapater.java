package com.example.fm;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;
import java.util.ArrayList;

public class ListItemAdapater extends BaseAdapter {
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
            view = inflater.inflate(R.layout.payment_item, parent, false);
            ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
            layoutParams.height = 230;
            view.setLayoutParams(layoutParams);
        }

        TextView nameText = view.findViewById(R.id.name);
        TextView costText = view.findViewById(R.id.cost);
        TextView minText = view.findViewById(R.id.mincost);
        TextView feeText = view.findViewById(R.id.fee);

        nameText.setText(listItem.getName());
        costText.setText(listItem.getCost());
        minText.setText(listItem.getMincost());
        feeText.setText(listItem.getFee());

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

        for (int size = 0; size < myListAdapter.getCount()-1; size++) {
            View listItem = myListAdapter.getView(size, null, myListView);
            listItem.measure(desiredWidth, View.MeasureSpec.UNSPECIFIED);
            totalHeight += listItem.getMeasuredHeight();
            Log.i("getheight:", String.valueOf(listItem.getMeasuredHeight())); // 210
        }

        // setting listview item in adapter
        ViewGroup.LayoutParams params = myListView.getLayoutParams();

        // divider 도 크기가 있기 때문에 따로 더해줘야 한다.
        params.height = totalHeight + (myListView.getDividerHeight() * (myListAdapter.getCount()));
        myListView.setLayoutParams(params);

        // layout view 모양이 바꼇다고 알려준다. onlayout 이 호출 된다.

        myListView.requestLayout();
        // print height of adapter on log
//        Log.i("height of listItem:", String.valueOf(totalHeight)); // 840
//        Log.i("Count:", String.valueOf(myListAdapter.getCount())); // 4
//        Log.i("height:", String.valueOf(params.height)); // 846
//        Log.i("Width:", String.valueOf(desiredWidth)); // -2147483648
    }

    private int profile;
    private String name;
    private String cost;
    private String mincost;
    private String fee;

    private int Img;
    private String name0;
    private String order;

    public int getProfile() { return profile; }
    public void setProfile(int profile) {this.profile = profile; }

    public String getName() { return name; }
    public void setName(String name) {this.name = name; }

    public String getCost() { return cost; }
    public void setCost(String cost) { this.cost = cost; }

    public String getMincost() { return mincost; }
    public void setMincost(String mincost) { this.mincost = mincost; }

    public String getFee() { return fee; }
    public void setFee(String fee) { this.fee = fee; }

    public String getName0() { return name0; }
    public int getImg() { return Img; }
    public String getOrder() { return order; }

    void ListItem(int profile, String name, String cost){
        this.profile = profile;
        this.name = name;
        this.cost = cost;
    }

    void ListItem(String name0, int Img, String order) {
        this.name0 = name0;
        this.Img = Img;
        this.order = order;
    }
}
