package com.example.lukas.rgb_strip_app_navigation;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.ArraySet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.Toast;

import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.List;

public class predefined_colorsFragment extends Fragment {

    Button red,blue,green;
    Button yellow, purple, cyan;
    Button orange, pink, grey;
    Button white,black;

    View myView;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        myView = inflater.inflate(R.layout.fragment_predefined_colors, container, false);

        red = myView.findViewById(R.id.btn_red);
        blue = myView.findViewById(R.id.btn_blue);
        green = myView.findViewById(R.id.btn_green);

        yellow = myView.findViewById(R.id.btn_yellow);
        purple = myView.findViewById(R.id.btn_purple);
        cyan = myView.findViewById(R.id.btn_cyan);

        orange = myView.findViewById(R.id.btn_orange);
        pink = myView.findViewById(R.id.btn_pink);
        grey = myView.findViewById(R.id.btn_grey);

        white = myView.findViewById(R.id.btn_white);
        black = myView.findViewById(R.id.btn_black);

        red.setOnClickListener(MyOnClickListener);
        blue.setOnClickListener(MyOnClickListener);
        green.setOnClickListener(MyOnClickListener);

        yellow.setOnClickListener(MyOnClickListener);
        purple.setOnClickListener(MyOnClickListener);
        cyan.setOnClickListener(MyOnClickListener);

        orange.setOnClickListener(MyOnClickListener);
        pink.setOnClickListener(MyOnClickListener);
        grey.setOnClickListener(MyOnClickListener);

        white.setOnClickListener(MyOnClickListener);
        black.setOnClickListener(MyOnClickListener);

        //get the spinner from the xml.
        Spinner dropdown = myView.findViewById(R.id.spinner2);
        List<String> list = new ArrayList<String>();
        list.add("list 1");
        list.add("list 2");
        list.add("list 3");
        ArrayAdapter<String> dataAdapter = new ArrayAdapter<String>(getActivity(), android.R.layout.simple_spinner_item, list);
        dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        dropdown.setAdapter(dataAdapter);


        return myView;
    }

    void writepreference()
    {
        SharedPreferences sharedPref = getActivity().getPreferences(Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPref.edit();
        Gson gson = new Gson();
        String json = gson.toJson("hi");
        editor.putString("42",json);
        editor.commit();
    }

    void readprference()
    {
        Context context = getActivity();
        SharedPreferences sharedPref = context.getSharedPreferences("mystring", Context.MODE_PRIVATE);

    }

    public View.OnClickListener MyOnClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {


            switch (v.getId()) {
                case R.id.btn_red:

                    new changecolor().execute("FF0000");
                    message("set color to red");

                    break;
                case R.id.btn_blue:

                    new changecolor().execute("0000FF");
                    message("set color to blue");

                    break;
                case R.id.btn_green:

                    new changecolor().execute("00FF00");
                    message("set color to green");

                    break;
                case R.id.btn_yellow:

                    new changecolor().execute("FFFF00");
                    message("set color to yellow");

                    break;
                case R.id.btn_purple:

                    new changecolor().execute("FF00FF");
                    message("set color to purple");

                    break;
                case R.id.btn_cyan:

                    new changecolor().execute("00FFFF");
                    message("set color to cyan");

                    break;
                case R.id.btn_orange:

                    new changecolor().execute("FF7F00");
                    message("set color to orange");

                    break;
                case R.id.btn_pink:

                    new changecolor().execute("FF007F");
                    message("set color to pink");

                    break;
                case R.id.btn_grey:

                    new changecolor().execute("7F7F7F");
                    message("set color to grey");

                    break;
                case R.id.btn_white:

                    new changecolor().execute("FFFFFF");
                    message("set color to white");

                    break;
                case R.id.btn_black:

                    new changecolor().execute("000000");

                    message("turned off");

                    break;
                default:
                    break;
            }
        }
    };

    public void message(String message){
        Toast.makeText(myView.getContext(),message, Toast.LENGTH_SHORT).show();
    }



}
