package com.logoocc.framgmentdemo.fr;



import com.logoocc.qquidemo.R;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class Fourfragment extends Fragment {
	@Override
	public View onCreateView(LayoutInflater inflater,
			@Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
          
		View view =inflater.inflate(R.layout.fragment_four, null);
		return view;
	}
}
