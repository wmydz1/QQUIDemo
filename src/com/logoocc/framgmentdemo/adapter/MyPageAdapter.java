package com.logoocc.framgmentdemo.adapter;

import java.util.List;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

public class MyPageAdapter extends FragmentPagerAdapter {
	List<Fragment> fragmentList;
	
	public MyPageAdapter(FragmentManager fm, List<Fragment> fragmentList) {
		super(fm);
		this.fragmentList = fragmentList;
	}

	@Override
	public Fragment getItem(int arg0) {
		
		return (fragmentList==null||fragmentList.size()==0)?null:fragmentList.get(arg0);
	}
	
	@Override
	public CharSequence getPageTitle(int position) {
		return null;
	}
	@Override
	public int getCount() {
		
		return fragmentList==null?0:fragmentList.size();
	}

}
