package com.example.android.miwok;

import android.app.Activity;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.content.ContextCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class WordAdapter extends ArrayAdapter<Word> {
    int colorResourceId;
    public WordAdapter(Activity context, ArrayList<Word> Words,int backGroundColor){
        // Here, we initialize the ArrayAdapter's internal storage for the context and the list.
        // the second argument is used when the ArrayAdapter is populating a single TextView.
        // Because this is a custom adapter for two TextViews and an ImageView, the adapter is not
        // going to use this second argument, so it can be any value. Here, we used 0.
        super(context,0,Words);
        colorResourceId=backGroundColor;
    }
    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        //here convertView is view given by listItem, parent is listView itself and postion is the objects index
        View listItemView = convertView;
        //check if there is no data in the convertView given by listview if not inflate the list_item.xml
        if(listItemView==null){
                listItemView = LayoutInflater.from(getContext()).inflate(R.layout.list_item,parent,false);
        }
        Word CurrentWord = getItem(position);
        TextView MiwokView = (TextView) listItemView.findViewById(R.id.miwokTv);
        TextView EngView = (TextView) listItemView.findViewById(R.id.englishTv);
        ImageView imageView = (ImageView) listItemView.findViewById(R.id.image);
        if(CurrentWord.getImageResourceId()==-1){
            imageView.setVisibility(View.GONE);
        }
        else {
            imageView.setImageResource(CurrentWord.getImageResourceId());
        }
        View textContainer= listItemView.findViewById(R.id.textContainer);
        int color = ContextCompat.getColor(getContext(),colorResourceId);
        textContainer.setBackgroundColor(color);
        MiwokView.setText( CurrentWord.getMiwokTranslation());
        EngView.setText(CurrentWord.getDefaultTranslation());
        return listItemView;
    }
}
