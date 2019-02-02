package com.example.lukas.rgb_strip_app_navigation;

import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.SeekBar;
import android.widget.TextView;

public class select_colorFragment extends Fragment {


    public int green =0;
    public int red=0;
    public int blue=0;


    private SeekBar greenSeek;
    private SeekBar redSeek;
    private SeekBar blueSeek;

    public TextView currentColor,hexcolor,deccolor,redpercent,redvalue,greenpercent,greenvalue,bluepercent,bluevalue;


    View myView;

    long time=101;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        myView = inflater.inflate(R.layout.fragment_select_color, container, false);

         currentColor=  myView.findViewById(R.id.currentColor);
         hexcolor=  myView.findViewById(R.id.hexcolor);
         deccolor =  myView.findViewById(R.id.deccolor);

         redpercent =  myView.findViewById(R.id.redpercent);
         redvalue =  myView.findViewById(R.id.redvalue);

         greenpercent =  myView.findViewById(R.id.greenpercent);
         greenvalue =  myView.findViewById(R.id.greenvalue);

         bluepercent =  myView.findViewById(R.id.bluepercent);
         bluevalue =  myView.findViewById(R.id.bluevalue);

        greenSeek = (SeekBar) myView.findViewById(R.id.seekBar_green);
        blueSeek = (SeekBar) myView.findViewById(R.id.seekBar_blue);
        redSeek = (SeekBar) myView.findViewById(R.id.seekBar_red);

        redvalue.setText(String.valueOf(redSeek.getProgress()));
        greenvalue.setText(String.valueOf(greenSeek.getProgress()));
        bluevalue.setText(String.valueOf(blueSeek.getProgress()));

//currentColor.setBackgroundColor(Color.rgb(0,0,0));
        hexcolor.setText("DEC: "+Integer.toHexString(red).toUpperCase()+"/"+Integer.toHexString(green).toUpperCase()+"/"+Integer.toHexString(blue).toUpperCase());
        deccolor.setText("HEX: "+String.valueOf(red)+"/"+String.valueOf(green)+"/"+String.valueOf(blue));

        redpercent.setText("0%");
        greenpercent.setText("0%");
        bluepercent.setText("0%");

        //Seekbar listeners
        greenSeek.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int value, boolean b)
            {
                if(System.currentTimeMillis() >= time+100) {
                    time = System.currentTimeMillis();

                    green = value;
                    float greenfloat = (float) value;

                    currentColor.setBackgroundColor(Color.rgb(red, green, blue));
                    greenvalue.setText(String.valueOf(green));
                    greenpercent.setText(String.valueOf(Math.round((greenfloat) / greenSeek.getMax() * 100)) + "%");

                    hexcolor.setText("HEX: " + Integer.toHexString(red).toUpperCase() + "/" + Integer.toHexString(green).toUpperCase() + "/" + Integer.toHexString(blue).toUpperCase());
                    deccolor.setText("DEC: " + String.valueOf(red) + "/" + String.valueOf(green) + "/" + String.valueOf(blue));

                    new changecolor().execute(String.format("%02X", red) + String.format("%02X", green) + String.format("%02X", blue));

                    if ((red + green + blue) <= 200) {
                        hexcolor.setTextColor(Color.WHITE);
                        deccolor.setTextColor(Color.WHITE);
                    } else {
                        hexcolor.setTextColor(Color.BLACK);
                        deccolor.setTextColor(Color.BLACK);
                    }
                }
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

        blueSeek.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int value, boolean b) {


                if(System.currentTimeMillis() >= time+100) {
                    time= System.currentTimeMillis();

                    blue = value;
                    float bluefloat = (float) value;
                    currentColor.setBackgroundColor(Color.rgb(red, green, blue));
                    bluevalue.setText(String.valueOf(blueSeek.getProgress()));
                    bluepercent.setText(String.valueOf(Math.round((bluefloat) / blueSeek.getMax() * 100)) + "%");

                    hexcolor.setText("HEX: " + Integer.toHexString(red).toUpperCase() + "/" + Integer.toHexString(green).toUpperCase() + "/" + Integer.toHexString(blue).toUpperCase());
                    deccolor.setText("DEC: " + String.valueOf(red) + "/" + String.valueOf(green) + "/" + String.valueOf(blue));
                    new changecolor().execute(String.format("%02X", red) + String.format("%02X", green) + String.format("%02X", blue));

                    if ((red + green + blue) <= 200) {
                        hexcolor.setTextColor(Color.WHITE);
                        deccolor.setTextColor(Color.WHITE);
                    } else {
                        hexcolor.setTextColor(Color.BLACK);
                        deccolor.setTextColor(Color.BLACK);
                    }
                }
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

        redSeek.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int value, boolean b) {
                if(System.currentTimeMillis() >= time+100) {
                    time = System.currentTimeMillis();

                    red = value;
                    float redfloat = (float) value;
                    currentColor.setBackgroundColor(Color.rgb(red, green, blue));
                    redpercent.setText(String.valueOf(Math.round(redfloat / redSeek.getMax() * 100)) + "%");
                    redvalue.setText(String.valueOf(red));

                    hexcolor.setText("HEX: " + Integer.toHexString(red).toUpperCase() + "/" + Integer.toHexString(green).toUpperCase() + "/" + Integer.toHexString(blue).toUpperCase());
                    deccolor.setText("DEC: " + String.valueOf(red) + "/" + String.valueOf(green) + "/" + String.valueOf(blue));
                    new changecolor().execute(String.format("%02X", red) + String.format("%02X", green) + String.format("%02X", blue));

                    if ((red + green + blue) <= 200) {
                        hexcolor.setTextColor(Color.WHITE);
                        deccolor.setTextColor(Color.WHITE);
                    } else {
                        hexcolor.setTextColor(Color.BLACK);
                        deccolor.setTextColor(Color.BLACK);
                    }
                }
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });


        return myView;
    }
}
