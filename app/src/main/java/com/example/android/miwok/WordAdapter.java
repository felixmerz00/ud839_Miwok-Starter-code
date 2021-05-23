package com.example.android.miwok;

import android.app.Activity;
import android.graphics.Color;
import android.media.MediaPlayer;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.content.ContextCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class WordAdapter extends ArrayAdapter<Word> {

    //Resource ID for the background color for the textViews
    private int mColorResourceId;

    public WordAdapter(Activity context, ArrayList<Word> w, int c) {
        super(context, 0, w);
        mColorResourceId = c;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        View listItemView = convertView;
        if(listItemView == null){
            listItemView = LayoutInflater.from(getContext()).inflate(R.layout.list_item, parent, false);
        }

        //get a word object from our ArrayList words
        Word currentWord = getItem(position);

        //creates a text view and defines the text for the Miwok Translation
        TextView miwokTextView = (TextView) listItemView.findViewById(R.id.miwok_text_view);
        miwokTextView.setText(currentWord.getMiwokTranslation());

        //creates a text view and defines the text for the default Translation
        TextView defaultTextView = (TextView) listItemView.findViewById(R.id.default_text_view);
        defaultTextView.setText(currentWord.getDefaultTranslation());

        // Find the ImageView in the list_item.xml layout with the ID image.
        ImageView imageView = (ImageView) listItemView.findViewById(R.id.image);

        // Check if an image is provided for this word or not
        if (currentWord.hasImage()) {
            // If an image is available, display the provided image based on the resource ID
            imageView.setImageResource(currentWord.getImageResourceId());
        // Make sure the view is visible
        imageView.setVisibility(View.VISIBLE);
    } else {
        // Otherwise hide the ImageView (set visibility to GONE)
        imageView.setVisibility(View.GONE);
    }

    //Set the theme color for the list item
    //find the parent of the two textViews
    View textContainer = listItemView.findViewById(R.id.text_container);
    //Find the color that the resource ID maps to
    int color = ContextCompat.getColor(getContext(), mColorResourceId);
    //Set the background color of the text container View
        textContainer.setBackgroundColor(color);

        return listItemView;
    }
}