package com.quintus.labs.kidzz.fragment;


import android.os.Bundle;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

import com.quintus.labs.kidzz.R;
import com.quintus.labs.kidzz.imageslid.CirclePageIndicator;
import com.quintus.labs.kidzz.imageslid.SlideImage_Adapter;

import java.util.ArrayList;
import java.util.Timer;
import java.util.TimerTask;

/**
 * Kidzz
 * https://github.com/quintuslabs/Kidzz
 * Created on 25-feb-2019.
 * Created by : Santosh Kumar Dash:- http://santoshdash.epizy.com
 */


/**
 * A simple {@link Fragment} subclass.
 */
public class SlideFragment extends Fragment {

    private static final int[] images = new int[]{
            R.drawable.apple,
            R.drawable.ant,
            R.drawable.aeroplane,
            R.drawable.ball,
            R.drawable.balloon,
            R.drawable.bear,
            R.drawable.cat,
            R.drawable.chik,
            R.drawable.cow,
            R.drawable.dog,
            R.drawable.dolphin,
            R.drawable.donkey,
            R.drawable.elephant,
            R.drawable.egg,
            R.drawable.envelope,
            R.drawable.flower,
            R.drawable.frog,
            R.drawable.fox,
            R.drawable.goat,
            R.drawable.grasshopper,
            R.drawable.grass,
            R.drawable.horse,
            R.drawable.house,
            R.drawable.hippo,
            R.drawable.ink,
            R.drawable.injection,
            R.drawable.insect,
            R.drawable.jacket,
            R.drawable.jar,
            R.drawable.juice,
            R.drawable.kite,
            R.drawable.kettle,
            R.drawable.key,
            R.drawable.leaf,
            R.drawable.lion,
            R.drawable.lamp,
            R.drawable.mouse,
            R.drawable.moon,
            R.drawable.map,
            R.drawable.orange,
            R.drawable.octopus,
            R.drawable.owl,
            R.drawable.pencil,
            R.drawable.penguin,
            R.drawable.pineapple,
            R.drawable.queen,
            R.drawable.queue,
            R.drawable.quail,
            R.drawable.rainbow,
            R.drawable.ring,
            R.drawable.road,
            R.drawable.sun,
            R.drawable.ship,
            R.drawable.strawberry,
            R.drawable.tiger,
            R.drawable.train,
            R.drawable.turtle,
            R.drawable.umbrella,
            R.drawable.unicorn,
            R.drawable.uniform,
            R.drawable.van,
            R.drawable.vase,
            R.drawable.violin,
            R.drawable.watch,
            R.drawable.watermelon,
            R.drawable.watch,
            R.drawable.xmas,
            R.drawable.xylophone,
            R.drawable.xray,
            R.drawable.yacht,
            R.drawable.yarn,
            R.drawable.yellow,
    };
    private static ViewPager mpager;
    private static int currentPage = 0;
    private static int num_page = 0;
    CirclePageIndicator indicator;
    private ArrayList<Integer> imageArray = new ArrayList<Integer>();

    public SlideFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_slide, container, false);
        mpager = view.findViewById(R.id.view_pager);
        indicator = view.findViewById(R.id.circlePageindicator);
        init();
        return view;
    }

    private void init() {
        for (int i = 0; i < images.length; i++)
            imageArray.add(images[i]);

        mpager.setAdapter(new SlideImage_Adapter(getActivity(), imageArray));


        indicator.setViewPager(mpager);

        final float density = getResources().getDisplayMetrics().density;

        indicator.setRadius(2 * density);


        num_page = images.length;


        // Auto start of viewpager
        final Handler handler = new Handler();
        final Runnable Update = new Runnable() {
            public void run() {
                if (currentPage == num_page) {
                    currentPage = 0;
                }
                mpager.setCurrentItem(currentPage++, true);
            }
        };
        Timer swipeTimer = new Timer();
        swipeTimer.schedule(new TimerTask() {
            @Override
            public void run() {
                handler.post(Update);
            }
        }, 2000, 2000);

        // Pager listener over indicator
        indicator.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {

            @Override
            public void onPageSelected(int position) {
                currentPage = position;

            }

            @Override
            public void onPageScrolled(int pos, float arg1, int arg2) {

            }

            @Override
            public void onPageScrollStateChanged(int pos) {

            }
        });
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        //you can set the title for your toolbar here for different fragments different titles
        getActivity().setTitle("Slide Show");
    }

}
