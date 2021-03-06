package com.ljremote.android.fragments;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ListView;

import com.ljremote.android.MainActivity;
import com.ljremote.android.R;
import com.ljremote.android.adapters.BGCueCursorAdapter;
import com.ljremote.android.data.BGCueManager;

public class BGCueFragment extends AbstractDetailFragment implements OnClickListener {

	public BGCueFragment() {
		super(R.string.bgcues);
	}
	
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		View mainView = inflater.inflate(R.layout.bgcue_fragment, null, true);
		MainActivity main = (MainActivity) getActivity();
		setDataManager(main.getDataManager().getBGCueManager());
		
		
		ListView listView = (ListView) mainView.findViewById(R.id.bgcue_list);
		BGCueCursorAdapter adapter = new BGCueCursorAdapter(getDataManager());
		listView.setAdapter(adapter);
		
		((Button) mainView.findViewById(R.id.up_all)).setOnClickListener(this);
		((Button) mainView.findViewById(R.id.clear_all)).setOnClickListener(this);
		return mainView;
	}
	
	@Override
	public void onClick(View v) {
		Log.d("cue.update_all", "onClick : " + v.getId() + " ( " + R.id.up_all + " ) ");
		switch (v.getId()) {
		case R.id.up_all:
			((BGCueManager) getDataManager()).updateAllDB();
			break;
		case R.id.clear_all:
			((BGCueManager) getDataManager()).clearAll();
		default:
			break;
		}
	}
}
