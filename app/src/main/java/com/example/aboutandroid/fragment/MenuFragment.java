package com.example.aboutandroid.fragment;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.aboutandroid.R;
import com.example.aboutandroid.databinding.FragmentMenuBinding;
import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;
import java.util.List;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.ViewPager;


public class MenuFragment extends Fragment {


    private FragmentMenuBinding binding;
    private List<Fragment> fragments;
    private MenuAdapter menuAdapter;
    private TabLayout tabLayout;
    private ViewPager viewPager;

    private class MenuAdapter extends FragmentPagerAdapter {
        public MenuAdapter(@NonNull FragmentManager fm) {
            super(fm);
        }

        @NonNull
        @Override
        public Fragment getItem(int position) {
            return fragments.get(position);
        }

        @Override
        public int getCount() {
            return fragments.size();
        }

        @Nullable
        @Override
        public CharSequence getPageTitle(int position) {
            return getResources().getStringArray(R.array.menus)[position];
        }
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        fragments = new ArrayList<>();
        fragments.add(new ItemFragment1());
        fragments.add(new ItemFragment2());
        fragments.add(new ItemFragment3());
        menuAdapter = new MenuAdapter(getChildFragmentManager());
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_menu, container, false);
        initView(view);
        return view;
    }

    public void initView(View view) {
        tabLayout = view.findViewById(R.id.tabLayoutItemMenu);
        viewPager = view.findViewById(R.id.vpItem);
        viewPager.setAdapter(menuAdapter);
        tabLayout.setupWithViewPager(viewPager, false);
    }

    @Override
    public void setUserVisibleHint(boolean isVisibleToUser) {
        super.setUserVisibleHint(isVisibleToUser);
        if (isVisibleToUser) {
            Log.e("-------------", "MenuFragment");
        }
    }
}
