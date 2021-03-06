package com.ljremote.android.adapters;

import android.content.Context;
import android.database.Cursor;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.ljremote.android.R;
import com.ljremote.android.data.AbstractDataManager;
import com.ljremote.android.data.BGCueManager;
import com.ljremote.android.data.DataManager.TABLES;
import com.ljremote.json.model.BGCue;

public class BGCueCursorAdapter extends AbstractCursorAdapter {
	
	public BGCueCursorAdapter(AbstractDataManager abstractDataManager) {
		super(abstractDataManager, R.layout.static_item);
	}

	@Override
	public View newView(Context context, Cursor cursor, ViewGroup parent) {
		View convertView = LayoutInflater.from(context).inflate(
				R.layout.seq_item, null);

		bindView(convertView, context, cursor);
		return convertView;
	}

	@Override
	public void bindView(View view, Context context, Cursor cursor) {
		BGCue bgCue = ((BGCueManager) manager).getBGCueFromCursor(cursor);

		((TextView) view.findViewById(R.id.id)).setText(String.valueOf(bgCue
				.getId()));
		TextView label = (TextView) view.findViewById(R.id.label);
		label.setText(bgCue.getLabel());

	}

	@Override
	public void onTableUpdateListener(Context context, TABLES table) {
		if (table == TABLES.BGCUES) {
			reloadCursor();
		}
	}
}
