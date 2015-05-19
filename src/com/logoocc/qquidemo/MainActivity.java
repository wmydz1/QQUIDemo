package com.logoocc.qquidemo;

import java.util.ArrayList;
import java.util.List;


import com.logoocc.framgmentdemo.adapter.MyPageAdapter;
import com.logoocc.framgmentdemo.fr.Fourfragment;
import com.logoocc.framgmentdemo.fr.Onefragment;
import com.logoocc.framgmentdemo.fr.Threefragment;
import com.logoocc.framgmentdemo.fr.Twofragment;

import android.R.integer;
import android.app.Activity;
import android.graphics.BitmapFactory;
import android.graphics.Matrix;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v4.view.ViewPager.OnPageChangeListener;
import android.util.DisplayMetrics;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.animation.Animation;
import android.view.animation.Transformation;
import android.view.animation.TranslateAnimation;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends FragmentActivity {

	private ViewPager viewPager;
	private ImageView imageView;
	private TextView voiceAnswer, healthPedia, pDected,tab_chat;
	private List<Fragment> fragments;
	private int offset = 0;
	private int currIndex = 0;
	private int bmpW;
	private int selectedColor, unselectedColor;
	private static final int pageSize = 4;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);
		initView();
	}

	private void initView() {
		selectedColor = getResources()
				.getColor(R.color.tab_title_pressed_color);
		unselectedColor = getResources().getColor(
				R.color.tab_title_normal_color);
		InitImageView();
		InitTextView();
		InitViewPager();
	}

	private void InitViewPager() {
		viewPager = (ViewPager) findViewById(R.id.vPagers);
		fragments = new ArrayList<Fragment>();
		fragments.add(new Onefragment());
		fragments.add(new Twofragment());
		fragments.add(new Threefragment());
		fragments.add(new Fourfragment());

		viewPager.setAdapter(new MyPageAdapter(getSupportFragmentManager(),
				fragments));
		viewPager.setCurrentItem(0);
		viewPager.setOnPageChangeListener(new MyOnPageChangeListener());

	}

	private void InitTextView() {
		voiceAnswer = (TextView) findViewById(R.id.tab_1);
		healthPedia = (TextView) findViewById(R.id.tab_2);
		pDected = (TextView) findViewById(R.id.tab_3);

		tab_chat=(TextView) findViewById(R.id.tab_4);
		

		voiceAnswer.setTextColor(selectedColor);
		healthPedia.setTextColor(unselectedColor);
		pDected.setTextColor(unselectedColor);
		tab_chat.setTextColor(unselectedColor);
		
		voiceAnswer.setText("动态");
		healthPedia.setText("群组");
		pDected.setText("好友");
		tab_chat.setText("会话");

		voiceAnswer.setOnClickListener(new MyOnClickListener(0));
		healthPedia.setOnClickListener(new MyOnClickListener(1));
		pDected.setOnClickListener(new MyOnClickListener(2));
		tab_chat.setOnClickListener(new MyOnClickListener(3));

	}

	private void InitImageView() {

		 imageView=(ImageView) findViewById(R.id.cursor);
		// 获取图片宽度
		 bmpW=BitmapFactory.decodeResource(getResources(), R.drawable.tab_selected_bg).getWidth();
		
		 DisplayMetrics dm =new DisplayMetrics();
		 
		 getWindowManager().getDefaultDisplay().getMetrics(dm);
		// 获取分辨率宽度
		 int screenW=dm.widthPixels;
		// 计算偏移量--(屏幕宽度/页卡总数-图片实际宽度)/2= 偏移量
		 offset=(screenW/pageSize-bmpW)/2;
		 
		 Matrix matrix=new Matrix();
		 matrix.postTranslate(offset, 0);
		// 设置动画初始位置
		 imageView.setImageMatrix(matrix);
		 
		
		
	}

	private class MyOnClickListener implements OnClickListener {
		private int index = 0;

		public MyOnClickListener(int i) {
			index = i;
		}

		@Override
		public void onClick(View v) {
			switch (index) {
			case 0:
				voiceAnswer.setTextColor(selectedColor);
				healthPedia.setTextColor(unselectedColor);
				pDected.setTextColor(unselectedColor);
				tab_chat.setTextColor(unselectedColor);
				break;
			case 1:
				healthPedia.setTextColor(selectedColor);
				voiceAnswer.setTextColor(unselectedColor);
				pDected.setTextColor(unselectedColor);
				tab_chat.setTextColor(unselectedColor);
				break;
			case 2:
				pDected.setTextColor(selectedColor);
				voiceAnswer.setTextColor(unselectedColor);
				healthPedia.setTextColor(unselectedColor);
				tab_chat.setTextColor(unselectedColor);
				break;
			case 3:
				tab_chat.setTextColor(selectedColor);
				pDected.setTextColor(unselectedColor);
				voiceAnswer.setTextColor(unselectedColor);
				healthPedia.setTextColor(unselectedColor);
				
				break;
			}
			viewPager.setCurrentItem(index);
		}

	}
	

	private class MyOnPageChangeListener implements OnPageChangeListener {
		int one = offset * 2 + bmpW;// 页卡1 -> 页卡2 偏移量
		int two = one * 2;// 页卡1 -> 页卡3 偏移量

		@Override
		public void onPageScrollStateChanged(int arg0) {

		}

		@Override
		public void onPageScrolled(int arg0, float arg1, int arg2) {

		}

		@Override
		public void onPageSelected(int index) {
			Animation animation = new TranslateAnimation(one * currIndex, one
					* index, 0, 0);
			currIndex = index;
			animation.setFillAfter(true);
			animation.setDuration(300);
			imageView.startAnimation(animation);

			switch (index) {
			case 0:
				voiceAnswer.setTextColor(selectedColor);
				healthPedia.setTextColor(unselectedColor);
				pDected.setTextColor(unselectedColor);
				tab_chat.setTextColor(unselectedColor);
				break;
			case 1:
				healthPedia.setTextColor(selectedColor);
				voiceAnswer.setTextColor(unselectedColor);
				pDected.setTextColor(unselectedColor);
				tab_chat.setTextColor(unselectedColor);
				break;
			case 2:
				pDected.setTextColor(selectedColor);
				voiceAnswer.setTextColor(unselectedColor);
				healthPedia.setTextColor(unselectedColor);
				tab_chat.setTextColor(unselectedColor);
				break;
			case 3:
				tab_chat.setTextColor(selectedColor);
				pDected.setTextColor(unselectedColor);
				voiceAnswer.setTextColor(unselectedColor);
				healthPedia.setTextColor(unselectedColor);
				
				break;
			}
		}

	}
	
	
	
}
