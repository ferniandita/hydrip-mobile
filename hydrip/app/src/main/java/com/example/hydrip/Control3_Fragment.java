package com.example.hydrip;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CompoundButton;
import android.widget.Switch;
import android.widget.TextView;

import com.androidnetworking.AndroidNetworking;
import com.androidnetworking.common.Priority;
import com.androidnetworking.error.ANError;
import com.androidnetworking.interfaces.JSONObjectRequestListener;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class Control3_Fragment extends Fragment {
    private Switch swAuto, swManual1, swManual2, swManual3, swManual4;
    int id_area, auto, manual1, manual2, manual3, manual4, idmanual, statusManual;
    private TextView tvArea;
//    private SwipeRefreshLayout swipeRefreshLayout;

    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View mView = inflater.inflate(R.layout.fragment_control, container, false);

        swAuto = mView.findViewById(R.id.sw_auto);
        swManual1 = mView.findViewById(R.id.sw_manual1);
        swManual2 = mView.findViewById(R.id.sw_manual2);
        swManual3 = mView.findViewById(R.id.sw_manual3);
        swManual4 = mView.findViewById(R.id.sw_manual4);
        tvArea = mView.findViewById(R.id.tv_area);
        AndroidNetworking.initialize(getActivity().getApplicationContext());
        ambilData();
        swAuto.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if (swAuto.isChecked()){
                    updateData(3, 1, 0, 0, 0, 0);
                    swManual1.setClickable(false);
                    swManual2.setClickable(false);
                    swManual3.setClickable(false);
                    swManual4.setClickable(false);
                    swManual1.setChecked(false);
                    swManual2.setChecked(false);
                    swManual3.setChecked(false);
                    swManual4.setChecked(false);
                } else {
                    updateData(3, 0, 0, 0, 0, 0);
                    swManual1.setClickable(true);
                    swManual2.setClickable(true);
                    swManual3.setClickable(true);
                    swManual4.setClickable(true);
                    swManual1.setChecked(false);
                    swManual2.setChecked(false);
                    swManual3.setChecked(false);
                    swManual4.setChecked(false);
                }
            }
        });

        swManual1.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if (swManual1.isChecked()){
                    updateData(3, 1, 1);
                } else  {
                    updateData(3, 1, 0);
                }
            }
        });

        swManual2.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if (swManual2.isChecked()){
                    updateData(3, 2, 1);
                } else  {
                    updateData(3, 2, 0);
                }
            }
        });

        swManual3.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if (swManual3.isChecked()){
                    updateData(3, 3, 1);
                } else  {
                    updateData(3, 3, 0);
                }
            }
        });

        swManual4.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if (swManual4.isChecked()){
                    updateData(3, 4, 1);
                } else  {
                    updateData(3, 4, 0);
                }
            }
        });
        return mView;
    }

    private void ambilData() {
        AndroidNetworking.get(API.CONTROL)
                .setTag(this)
                .setPriority(Priority.IMMEDIATE)
                .build()
                .getAsJSONObject(new JSONObjectRequestListener() {
                    @Override
                    public void onResponse(JSONObject response) {
                        Log.d("coba17",""+response);
                        try {
                            JSONArray data3 = response.getJSONArray("data_control");
                            Log.d("coba18",""+data3);
                            JSONObject area3 = data3.getJSONObject(2);
                            Log.d("coba19",""+area3);
                            id_area = area3.getInt("id_area");
                            auto = area3.getInt("auto");
                            manual1 = area3.getInt("manual1");
                            manual2 = area3.getInt("manual2");
                            manual3 = area3.getInt("manual3");
                            manual4 = area3.getInt("manual4");
                            tvArea.setText("Area " + String.valueOf(id_area));
                            if (auto==1){
                                swAuto.setChecked(true);
                                swManual1.setClickable(false);
                                swManual2.setClickable(false);
                                swManual3.setClickable(false);
                                swManual4.setClickable(false);
                            } else {
                                swAuto.setChecked(false);
                                swManual1.setClickable(true);
                                swManual2.setClickable(true);
                                swManual3.setClickable(true);
                                swManual4.setClickable(true);
                            }
                            if (manual1==1){
                                swManual1.setChecked(true);
                            } else {
                                swManual1.setChecked(false);
                            }
                            if (manual2==1){
                                swManual2.setChecked(true);
                            } else {
                                swManual2.setChecked(false);
                            }
                            if (manual3==1){
                                swManual3.setChecked(true);
                            } else {
                                swManual3.setChecked(false);
                            }
                            if (manual4==1){
                                swManual4.setChecked(true);
                            } else {
                                swManual4.setChecked(false);
                            }
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }

                    @Override
                    public void onError(ANError error) {
                        Log.d("coba20", "onError: " + error);
                    }
                });
    }
    private void updateData(final int id_area, final int auto, final int manual1, final int manual2, final int manual3, final int manual4){
        AndroidNetworking.post(API.UPDATE)
                .addBodyParameter("id_area", String.valueOf(id_area))
                .addBodyParameter("auto", String.valueOf(auto))
                .addBodyParameter("manual1", String.valueOf(manual1))
                .addBodyParameter("manual2", String.valueOf(manual2))
                .addBodyParameter("manual3", String.valueOf(manual3))
                .addBodyParameter("manual4", String.valueOf(manual4))
                .setTag("test5")
                .setPriority(Priority.IMMEDIATE)
                .build()
                .getAsJSONObject(new JSONObjectRequestListener() {
                    @Override
                    public void onResponse(JSONObject response) { Log.d("coba21", "onResponse: " + response); }

                    @Override
                    public void onError(ANError error) {
                        Log.d("coba22", "onError: " + error);
                    }
                });
    }

    private void updateData(final int id_area, final int idmanual, final int statusManual){
        AndroidNetworking.post(API.UPDATE)
                .addBodyParameter("id_area", String.valueOf(id_area))
                .addBodyParameter("idmanual", String.valueOf(idmanual))
                .addBodyParameter("statusManual", String.valueOf(statusManual))
                .setPriority(Priority.IMMEDIATE)
                .build()
                .getAsJSONObject(new JSONObjectRequestListener() {
                    @Override
                    public void onResponse(JSONObject response) { Log.d("coba23", "onResponse: " + response); }

                    @Override
                    public void onError(ANError error) {
                        Log.d("coba24", "onError: " + error);
                    }
                });
    }
}
