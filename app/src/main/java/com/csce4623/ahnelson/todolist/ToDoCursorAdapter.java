package com.csce4623.ahnelson.todolist;

import android.content.Context;
import android.database.Cursor;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CursorAdapter;
import android.widget.TextView;

public class ToDoCursorAdapter extends CursorAdapter {
    public ToDoCursorAdapter(Context context, Cursor cursor) {
        super(context, cursor, 0);
    }

    // The newView method is used to inflate a new view and return it,
    // you don't bind any data to the view at this point.
    @Override
    public View newView(Context context, Cursor cursor, ViewGroup parent) {
        return LayoutInflater.from(context).inflate(R.layout.item_todo, parent, false);
    }

    // The bindView method is used to bind all data to a given view
    // such as setting the text on a TextView.
    @Override
    public void bindView(View view, Context context, Cursor cursor) {
        // Find fields to populate in inflated template
        TextView tvID = (TextView) view.findViewById(R.id.tvID);
        TextView tvTitle = (TextView) view.findViewById(R.id.tvTitle);
        TextView tvContent = (TextView) view.findViewById(R.id.tvContent);
        // Extract properties from cursor
        String id = cursor.getString(cursor.getColumnIndexOrThrow("_id"));
        String title = cursor.getString(cursor.getColumnIndexOrThrow("title"));
        String content = cursor.getString(cursor.getColumnIndexOrThrow("content"));
        // Populate fields with extracted properties
        tvID.setText(id);
        tvTitle.setText(title);
        tvContent.setText(content);
    }
}