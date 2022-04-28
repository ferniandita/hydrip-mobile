package com.example.hydrip;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.androidnetworking.AndroidNetworking;
import com.androidnetworking.common.Priority;
import com.androidnetworking.error.ANError;
import com.androidnetworking.interfaces.JSONArrayRequestListener;
import com.androidnetworking.interfaces.JSONObjectRequestListener;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class MonitorFragment extends Fragment {
    ViewPager viewPager;
//    LinearLayout linearLayout;
    List<DataMonitoring> dataMonitoring;
//    private TextView tvDate, tvRow1, tvRow2, tvRow3, tvRow4, tvSt, tvAh, tvAt, tvWl, tvWph, tvLi, tvArea;
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View mView = inflater.inflate(R.layout.content_tab, container, false);
        viewPager = mView.findViewById(R.id.vp_Tab);
        dataMonitoring = new ArrayList<>();
        AndroidNetworking.initialize(getActivity().getApplicationContext());
        getData(0);
        return mView;
    }

    private void getData(int position) {
        AndroidNetworking.get(API.MONITORING)
                .setTag(this)
                .setPriority(Priority.IMMEDIATE)
                .build()
                .getAsJSONObject(new JSONObjectRequestListener() {
                    @Override
                    public void onResponse(JSONObject response) {
                        Log.d("coba5", "" + response);
                        try {
                            JSONArray data_monitoring = response.getJSONArray("data_monitoring");
                            Log.d("coba6", "" + data_monitoring);
                            for (int i=data_monitoring.length()-1; i>=0; i--){
                                JSONObject data = data_monitoring.getJSONObject(i);
                                Log.d("coba7", "" + data);
                                dataMonitoring.add(new DataMonitoring(
                                        data.getInt("id_area"),
                                        data.getString("date"),
                                        data.getDouble("moist1"),
                                        data.getDouble("moist2"),
                                        data.getDouble("moist3"),
                                        data.getDouble("moist4"),
                                        data.getDouble("suhu"),
                                        data.getDouble("hum"),
                                        data.getDouble("airtem"),
                                        data.getDouble("level"),
                                        data.getString("ph"),
                                        data.getString("light")
                                ));
                            }
                            MonitorAdapter monitorAdapter = new MonitorAdapter(getActivity().getApplicationContext(), dataMonitoring);
                            viewPager.setAdapter(monitorAdapter);
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }

                    @Override
                    public void onError(ANError error) {
                        Log.d("coba4", "onError: " + error);
                    }
                });
    }
}
