package com.example.hydrip;

import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

/**
 * Created by anupamchugh on 26/12/15.
 */
public class MonitorAdapter extends PagerAdapter {

    private Context mContext;
    private List<DataMonitoring> dataMonitoring;
    public TextView tvDate, tvRow1, tvRow2, tvRow3, tvRow4, tvSt, tvAh, tvAt, tvWl, tvWph, tvLi, tvArea;
    public MonitorAdapter(Context context, List<DataMonitoring> dataMonitoring) {
        this.mContext = context;
        this.dataMonitoring = dataMonitoring;
    }

    @Override
    public Object instantiateItem(ViewGroup collection, int position) {
        DataMonitoring item = dataMonitoring.get(position);
        View mView = LayoutInflater.from(mContext).inflate(R.layout.fragment_monitor, collection, false);
        tvDate = mView.findViewById(R.id.tv_date);
        tvRow1 = mView.findViewById(R.id.tv_row1);
        tvRow2 = mView.findViewById(R.id.tv_row2);
        tvRow3 = mView.findViewById(R.id.tv_row3);
        tvRow4 = mView.findViewById(R.id.tv_row4);
        tvSt = mView.findViewById(R.id.tv_st);
        tvAh = mView.findViewById(R.id.tv_ah);
        tvAt = mView.findViewById(R.id.tv_at);
        tvWl = mView.findViewById(R.id.tv_wl);
        tvWph = mView.findViewById(R.id.tv_wpH);
        tvLi = mView.findViewById(R.id.tv_li);
        tvArea = mView.findViewById(R.id.tv_area);
        tvArea.setText("Area " + item.getIdarea());
        tvDate.setText(item.getDate());
        tvRow1.setText(String.valueOf(item.getMoist1()));
        tvRow2.setText(String.valueOf(item.getMoist2()));
        tvRow3.setText(String.valueOf(item.getMoist3()));
        tvRow4.setText(String.valueOf(item.getMoist4()));
        tvSt.setText(String.valueOf(item.getSuhu()));
        tvAh.setText(String.valueOf(item.getHum()));
        tvAt.setText(String.valueOf(item.getAirtem()));
        tvWl.setText(String.valueOf(item.getLevel()));
        tvWph.setText(item.getPh());
        tvLi.setText(item.getLight());
        collection.addView(mView);
        return mView;
    }

    @Override
    public void destroyItem(ViewGroup collection, int position, Object view) {
        collection.removeView((View) view);
    }

    @Override
    public int getCount() {
        return dataMonitoring.size();
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view == object;
    }

    @Override
    public int getItemPosition(Object object) {
        return super.getItemPosition(object);
    }

}
