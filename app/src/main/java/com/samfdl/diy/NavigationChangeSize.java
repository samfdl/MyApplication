package com.samfdl.diy;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.samfdl.R;

import java.util.ArrayList;
import java.util.List;

public class NavigationChangeSize extends AppCompatActivity {
    private final double ZOOM = 0.2;
    private double zoom = ZOOM;
    private boolean isZoomed = false;
    private int fromSide = 0;

    private final int[] mImgIds = new int[]{R.drawable.ui_listview_adapterviewflipper_baiyang,
            R.drawable.ui_listview_adapterviewflipper_chunv, R.drawable.ui_listview_adapterviewflipper_jinniu};
    private List<ImageView> mImageViews = new ArrayList<ImageView>();
    private ViewPager mViewPager;
    private PagerAdapter myAdapter;

    private LinearLayout navigationView;
    private View navigationLeftView, navigationRightView, navigationCurrentView;

    private int navigationHeight, navigationLeftWidth, navigationCurrentHeight;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.diy_navigationchangesize);
        // 添加返回按钮
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        for (int imgId : mImgIds) {
            ImageView imageView = new ImageView(getApplicationContext());
            imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
            imageView.setImageResource(imgId);
            mImageViews.add(imageView);
        }
        mViewPager = (ViewPager) findViewById(R.id.home_pager);
        myAdapter = new PagerAdapter() {
            @Override
            public Object instantiateItem(ViewGroup container, int position) {
                container.addView(mImageViews.get(position));
                return mImageViews.get(position);
            }

            @Override
            public void destroyItem(ViewGroup container, int position, Object object) {
                container.removeView(mImageViews.get(position));
            }

            @Override
            public boolean isViewFromObject(View view, Object object) {
                return view == object;
            }

            @Override
            public int getCount() {
                return mImgIds.length;
            }
        };
        mViewPager.setAdapter(myAdapter);
        mViewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
                if (position == 1) {
                    isZoomed = true;
                } else {
                    isZoomed = false;
                }
                if (!isZoomed) {
                    navigationView.getLayoutParams().height = (int) (navigationHeight * (1 + positionOffset * zoom));
                    navigationLeftView.getLayoutParams().width = (int) (navigationLeftWidth * (1 + positionOffset * zoom * 17.5));
                    navigationRightView.getLayoutParams().width = (int) (navigationLeftWidth * (1 + positionOffset * zoom * 17.5));
                    navigationCurrentView.getLayoutParams().height = (int) (navigationCurrentHeight * (1 + positionOffset * zoom));
                    navigationCurrentView.getLayoutParams().width = (int) (navigationCurrentHeight * (1 + positionOffset * zoom));

                } else {
                    navigationView.getLayoutParams().height = (int) (navigationHeight * (1 + (1 - positionOffset) * zoom));
                    navigationLeftView.getLayoutParams().width = (int) (navigationLeftWidth * (1 + (1 - positionOffset) * zoom * 17.5));
                    navigationRightView.getLayoutParams().width = (int) (navigationLeftWidth * (1 + (1 - positionOffset) * zoom * 17.5));
                    navigationCurrentView.getLayoutParams().height = (int) (navigationCurrentHeight * (1 + (1 - positionOffset) * zoom));
                    navigationCurrentView.getLayoutParams().width = (int) (navigationCurrentHeight * (1 + (1 - positionOffset) * zoom));
                }
                navigationView.requestLayout();
                navigationLeftView.requestLayout();
                navigationRightView.requestLayout();
                navigationCurrentView.requestLayout();
                if (fromSide == 0 && position == 2) {
                    zoom = ZOOM;
                }
                if (fromSide == 2 && position == 0 && positionOffset == 0) {
                    zoom = ZOOM;
                }
            }

            @Override
            public void onPageSelected(int position) {
                switch (position) {
                    case 0:
                        navigationView.setBackgroundResource(R.color.game_game2048_bg_2);
                        break;
                    case 1:
                        navigationView.setBackgroundResource(R.color.diy_diytoast_transparent);
                        break;
                    case 2:
                        navigationView.setBackgroundResource(R.color.diy_diytoast_transparent);
                        break;
                }
            }

            @Override
            public void onPageScrollStateChanged(int state) {
            }
        });

        navigationView = (LinearLayout) findViewById(R.id.tab);
        navigationLeftView = findViewById(R.id.left);
        navigationRightView = findViewById(R.id.right);
        navigationCurrentView = findViewById(R.id.navigation_current);

        navigationHeight = navigationView.getLayoutParams().height;
        navigationLeftWidth = navigationLeftView.getLayoutParams().width;
        navigationCurrentHeight = navigationCurrentView.getLayoutParams().height;
    }

    public void onClickLeft(View V) {
        if (mViewPager.getCurrentItem() == 2) {
            zoom = 0;
            fromSide = 2;
        }
        mViewPager.setCurrentItem(0);
    }

    public void onClickRight(View V) {
        if (mViewPager.getCurrentItem() == 0) {
            zoom = 0;
            fromSide = 0;
        }
        mViewPager.setCurrentItem(2);
    }

    public void onClickCenter(View v) {
        mViewPager.setCurrentItem(1);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == android.R.id.home) {
            Intent intent = new Intent(this, DIYList.class);
            intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
            startActivity(intent);
        }
        return true;
    }
}