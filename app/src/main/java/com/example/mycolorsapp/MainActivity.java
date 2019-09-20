package com.example.mycolorsapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.view.ContextMenu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.SeekBar;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements SeekBar.OnSeekBarChangeListener {

    private SeekBar sbrRed = null;
    private SeekBar sbrGreen = null;
    private SeekBar sbrBlue = null;
    private SeekBar sbrAlpha = null;
    private View vieColors = null;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        igualarIds();

        sbrGreen.setOnSeekBarChangeListener(this);
        sbrBlue.setOnSeekBarChangeListener(this);
        sbrRed.setOnSeekBarChangeListener(this);
        sbrAlpha .setOnSeekBarChangeListener(this);

        registerForContextMenu(vieColors);

        registerForContextMenu(vieColors);
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);
        getMenuInflater().inflate(R.menu.colors1,menu);
    }

    @Override
    public boolean onContextItemSelected(@NonNull MenuItem item) {
        //return super.onContextItemSelected(item);
        switch (item.getItemId()){
            case R.id.itemBlue:
                cambiarColorsito(0,0,255,200,"blue");
                return  true;
            case R.id.itemRed:
                cambiarColorsito(255,0,0,200,"red");
                return  true;
            case R.id.itemTransparent:
                cambiarColorsito(0,0,0,0,"transparent");
                return  true;
            case R.id.itemSemitransparent:
                cambiarColorsito(0,0,0,125,"semi transparent");
                return  true;
            case R.id.itemGreen:
                cambiarColorsito(35,150,35,200,"green");
                return  true;
            case R.id.itemBrown:
                cambiarColorsito(99,63,33,200,"brown");
                return  true;
            case R.id.itemBlack:
                cambiarColorsito(0,0,0,200,"black");
                return  true;
            case R.id.itemPink:
                cambiarColorsito(200,50,130,200,"pink");
                return  true;
            case R.id.itemPurple:
                cambiarColorsito(160,30,160,200,"purple");
                return  true;
            case R.id.itemWhite:
                cambiarColorsito(255,255,255,200, "white");
                return  true;
            case R.id.itemGray:
                cambiarColorsito(120,120,120,200,"gray");
                return  true;
                default:
                    return super.onContextItemSelected(item);
        }
    }

    @Override
    public void onProgressChanged(SeekBar seekBar, int i, boolean v) {

        int r= sbrRed.getProgress();
        int g= sbrGreen.getProgress();
        int b= sbrBlue.getProgress();
        int a = sbrAlpha.getProgress();

        int color = Color.argb(a,r,g,b);
        vieColors.setBackgroundColor(color);
}

    @Override
    public void onStartTrackingTouch(SeekBar seekBar) {

    }

    @Override
    public void onStopTrackingTouch(SeekBar seekBar) {

    }
    //eventos creados a mano
    public void cambiarColorsito(int r, int g, int b, int a, String nameColor){

        int color = Color.argb(a,r,g,b);
        igualarIds();
        vieColors.setBackgroundColor(color);
        Toast.makeText(this, "you have selected the "+nameColor+ " option",Toast.LENGTH_SHORT ).show();
        sbrRed.setProgress(r);
        sbrBlue.setProgress(b);
        sbrGreen.setProgress(g);
        sbrAlpha.setProgress(a);

    }
    public void igualarIds(){
        sbrRed= findViewById(R.id.sbrRed);
        sbrGreen= findViewById(R.id.sbrGreen);
        sbrBlue= findViewById(R.id.sbrBlue);
        sbrAlpha= findViewById(R.id.sbrAlpha);
        vieColors= findViewById(R.id.vieColors);
    }

}
