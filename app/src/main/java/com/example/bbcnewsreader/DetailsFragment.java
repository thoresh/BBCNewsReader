package com.example.bbcnewsreader;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.text.method.LinkMovementMethod;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;


public class DetailsFragment extends Fragment {


    private NewsDatabase database;
    private Button btnFavorites;
    private TextView txtTitle;
    private TextView txtDescription;
    private TextView txtDate;
    private TextView txtLink;
    private Button btnAdd;
    private Button btnBack;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_details, container, false);

        this.txtTitle = view.findViewById(R.id.lblTitle);
        this.txtDescription = view.findViewById(R.id.lblDescription);
        this.txtDate = view.findViewById(R.id.lblDate);
        this.txtLink = view.findViewById(R.id.lblURL);
        this.btnBack = view.findViewById(R.id.btnBack);
        this.btnAdd = view.findViewById(R.id.btnAdd);
        this.btnFavorites = view.findViewById(R.id.btnFavorites);


        this.database = NewsDatabase.getInstance(this.getContext());

        Bundle bundle = getArguments();
        this.txtTitle.setText(bundle.getString("title"));
        this.txtDescription.setText(bundle.getString("description"));
        this.txtDate.setText(bundle.getString("date"));
        this.txtLink.setText(bundle.getString("link"));

        this.btnAdd.setOnClickListener( new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                addFavorite(v);
            }
        });

        this.btnFavorites.setOnClickListener( new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                moveFavorite(v);
            }
        });

        this.btnBack.setOnClickListener( new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                moveBack(v);
            }
        });

        return view;
    }


    public void moveBack(View view) {
        Intent intent = new Intent(getContext(), MainActivity.class);
        startActivity(intent);
    }


    public void moveFavorite(View view) {
        Toast.makeText(this.getContext(), "Will be implemented", Toast.LENGTH_SHORT).show();
    }


    public void addFavorite(View view) {
        Toast.makeText(this.getContext(), "Will be implemented", Toast.LENGTH_SHORT).show();
    }
}