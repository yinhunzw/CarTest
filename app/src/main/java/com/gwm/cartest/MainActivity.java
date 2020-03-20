package com.gwm.cartest;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;
import android.widget.CompoundButton;
import android.widget.RadioButton;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    ViewPager vp;
    RadioButton first;
    RadioButton second;
    TabLayout tl;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        first.setChecked(true);
        ArrayList<Fragment> list = new ArrayList<>();
        ArrayList<String> titles = new ArrayList<>();
        AFragment one = new AFragment();
        Two two = new Two();

        list.add(one);
        list.add(two);
        titles.add("选项卡1");
        titles.add("选项卡2");
        vp.setAdapter(new MyAdapter(getSupportFragmentManager(), list, titles));
        tl.setupWithViewPager(vp);

        first.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    vp.setCurrentItem(0);
                }
            }
        });

        second.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    vp.setCurrentItem(1);
                }
            }
        });

        vp.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int i, float v, int i1) {
            }

            @Override
            public void onPageSelected(int i) {
                switch (i) {
                    case 0:
                        first.setChecked(true);
                        break;
                    case 1:
                        second = findViewById(R.id.second);
                        second.setChecked(true);
                        break;
                }
            }

            @Override
            public void onPageScrollStateChanged(int i) {

            }
        });

    }
}

}
