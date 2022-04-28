package com.example.hydrip;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;


public class ControlFragment extends Fragment {
    private TabLayout mTabLayout;
    private ViewPager mViewPager;
    private VPAdapterMonitor mAdapter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View mView = inflater.inflate(R.layout.content_tab, container, false);
        mAdapter = new VPAdapterMonitor(getActivity().getSupportFragmentManager());
        mViewPager = mView.findViewById(R.id.vp_Tab);
        mViewPager.setAdapter(mAdapter);

//        mTabLayout = mView.findViewById(R.id.tab_layout);
//        mTabLayout.setupWithViewPager(mViewPager);

        return mView;
    }
    public class VPAdapterMonitor extends FragmentStatePagerAdapter {

        private final ArrayList<Fragment> mFragment;
        private final ArrayList<String> mTitle;

        public VPAdapterMonitor(FragmentManager fm) {
            super(fm);
            mFragment = new ArrayList<Fragment>(2);
            mFragment.add(new Control1_Fragment());
            mFragment.add(new Control2_Fragment());
            mFragment.add(new Control3_Fragment());

            mTitle = new ArrayList<String>(mFragment.size());
            mTitle.add(getString(R.string.area1));
            mTitle.add(getString(R.string.area2));
            mTitle.add(getString(R.string.area3));
        }

        @Override
        public Fragment getItem(int position) {
            return mFragment.get(position);
        }

        @Override
        public int getCount() {
            return mFragment.size();
        }

        @Override
        public CharSequence getPageTitle(int position) {
            return mTitle.get(position);
        }
    }
}
