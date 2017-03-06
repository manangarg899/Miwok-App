package com.example.manan.miwok;


import android.app.Activity;
import android.support.annotation.ArrayRes;
import android.support.annotation.NonNull;
import android.support.v4.content.ContextCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

import static android.icu.lang.UCharacter.GraphemeClusterBreak.T;
import static android.icu.lang.UCharacter.GraphemeClusterBreak.V;
import static com.example.manan.miwok.R.id.image_view;
import static com.example.manan.miwok.R.id.text_container;

public class WordAdapter extends ArrayAdapter<Word> {
private int mcolor;


    public WordAdapter(Activity context, ArrayList<Word> Words, int color)
    {
        super(context, 0, Words);
        mcolor = color;
    }


    @NonNull
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        View list_view = convertView;

        if(list_view == null) {
            list_view = LayoutInflater.from(getContext()).inflate(
                    R.layout.list_item, parent, false);
        }

        Word currentWord = getItem(position);


        TextView englishWord = (TextView)list_view.findViewById(R.id.default_text_view);

        englishWord.setText(currentWord.getDefaultTranslation());


        TextView miwokWord = (TextView)list_view.findViewById(R.id.miwok_text_view);

        miwokWord.setText(currentWord.getMiwokTranslation());




        View text_Container = list_view.findViewById(text_container);
        int color = ContextCompat.getColor(getContext(),mcolor);
        text_Container.setBackgroundColor(color);


        ImageView imageView = (ImageView)list_view.findViewById(image_view);


        if (currentWord.hasImage())
        {
            imageView.setImageResource(currentWord.getImageResourceId());

            imageView.setVisibility(View.VISIBLE);
        }
        else {
            imageView.setVisibility(View.GONE);
        }

        return list_view;
    }


}
