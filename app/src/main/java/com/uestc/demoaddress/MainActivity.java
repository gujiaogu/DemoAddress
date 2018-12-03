package com.uestc.demoaddress;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.uestc.address.bean.Address;
import com.uestc.address.widget.AddressSelector;
import com.uestc.address.widget.BottomDialog;
import com.uestc.address.widget.OnAddressSelectedListener;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void showDialog(View view) {
        BottomDialog dialog = new BottomDialog(this);
        dialog.setOnAddressSelectedListener(new OnAddressSelectedListener() {
            @Override
            public void onAddressSelected(Address province, Address city, Address county, Address street) {
                Log.d("======", "dfsasdf");
            }
        });
        dialog.setSelectorAreaPositionListener(new AddressSelector.onSelectorAreaPositionListener() {
            @Override
            public void selectorAreaPosition(int provincePosition, int cityPosition, int countyPosition, int streetPosition) {
                Log.d("======", "dfsasdf");
            }
        });
        dialog.show();
    }
}
