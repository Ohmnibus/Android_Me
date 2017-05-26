package com.example.android.android_me.ui;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridView;

import com.example.android.android_me.R;
import com.example.android.android_me.data.AndroidImageAssets;

/**
 * Created by m.spalletti on 26/05/2017.
 */

public class MasterListFragment extends Fragment {

	public MasterListFragment() {}

	@Nullable
	@Override
	public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
		View rootview = inflater.inflate(R.layout.fragment_master_list, container, false);

		GridView gridView = (GridView)rootview;

		MasterListAdapter masterListAdapter = new MasterListAdapter(getActivity(), AndroidImageAssets.getAll());

		gridView.setAdapter(masterListAdapter);

		return rootview;
	}

	// Create a new MasterListAdapter and set it on the GridView
	// The MasterListAdapter code is provided; it creates the ImageViews that are contained in the GridView
	// The adapter takes as parameters (Context context, List<Integer> imageIds)
}
