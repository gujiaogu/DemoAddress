package com.uestc.address.widget;

import com.uestc.address.bean.Address;

public interface OnAddressSelectedListener {
    void onAddressSelected(Address province, Address city, Address county, Address street);
}
