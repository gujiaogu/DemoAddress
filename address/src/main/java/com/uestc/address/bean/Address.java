package com.uestc.address.bean;

import android.os.Parcel;
import android.os.Parcelable;

public class Address implements Parcelable {

    public String id;
    public String name;
    public String pId;
    public String shortName;
    public String level;
    public String cityCode;
    public String zipCode;
    public String mergerName;
    public String lng;
    public String lat;
    public String pinyin;
    public String firstChar;
    public String shortHand;
    public String createBy;
    public String createDate;
    public String updateBy;
    public String updateDate;
    public String delFlag;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getpId() {
        return pId;
    }

    public void setpId(String pId) {
        this.pId = pId;
    }

    public String getShortName() {
        return shortName;
    }

    public void setShortName(String shortName) {
        this.shortName = shortName;
    }

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
    }

    public String getCityCode() {
        return cityCode;
    }

    public void setCityCode(String cityCode) {
        this.cityCode = cityCode;
    }

    public String getZipCode() {
        return zipCode;
    }

    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }

    public String getMergerName() {
        return mergerName;
    }

    public void setMergerName(String mergerName) {
        this.mergerName = mergerName;
    }

    public String getLng() {
        return lng;
    }

    public void setLng(String lng) {
        this.lng = lng;
    }

    public String getLat() {
        return lat;
    }

    public void setLat(String lat) {
        this.lat = lat;
    }

    public String getPinyin() {
        return pinyin;
    }

    public void setPinyin(String pinyin) {
        this.pinyin = pinyin;
    }

    public String getFirstChar() {
        return firstChar;
    }

    public void setFirstChar(String firstChar) {
        this.firstChar = firstChar;
    }

    public String getShortHand() {
        return shortHand;
    }

    public void setShortHand(String shortHand) {
        this.shortHand = shortHand;
    }

    public String getCreateBy() {
        return createBy;
    }

    public void setCreateBy(String createBy) {
        this.createBy = createBy;
    }

    public String getCreateDate() {
        return createDate;
    }

    public void setCreateDate(String createDate) {
        this.createDate = createDate;
    }

    public String getUpdateBy() {
        return updateBy;
    }

    public void setUpdateBy(String updateBy) {
        this.updateBy = updateBy;
    }

    public String getUpdateDate() {
        return updateDate;
    }

    public void setUpdateDate(String updateDate) {
        this.updateDate = updateDate;
    }

    public String getDelFlag() {
        return delFlag;
    }

    public void setDelFlag(String delFlag) {
        this.delFlag = delFlag;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.id);
        dest.writeString(this.name);
        dest.writeString(this.pId);
        dest.writeString(this.shortName);
        dest.writeString(this.level);
        dest.writeString(this.cityCode);
        dest.writeString(this.zipCode);
        dest.writeString(this.mergerName);
        dest.writeString(this.lng);
        dest.writeString(this.lat);
        dest.writeString(this.pinyin);
        dest.writeString(this.firstChar);
        dest.writeString(this.shortHand);
        dest.writeString(this.createBy);
        dest.writeString(this.createDate);
        dest.writeString(this.updateBy);
        dest.writeString(this.updateDate);
        dest.writeString(this.delFlag);
    }

    public Address() {
    }

    protected Address(Parcel in) {
        this.id = in.readString();
        this.name = in.readString();
        this.pId = in.readString();
        this.shortName = in.readString();
        this.level = in.readString();
        this.cityCode = in.readString();
        this.zipCode = in.readString();
        this.mergerName = in.readString();
        this.lng = in.readString();
        this.lat = in.readString();
        this.pinyin = in.readString();
        this.firstChar = in.readString();
        this.shortHand = in.readString();
        this.createBy = in.readString();
        this.createDate = in.readString();
        this.updateBy = in.readString();
        this.updateDate = in.readString();
        this.delFlag = in.readString();
    }

    public static final Parcelable.Creator<Address> CREATOR = new Parcelable.Creator<Address>() {
        @Override
        public Address createFromParcel(Parcel source) {
            return new Address(source);
        }

        @Override
        public Address[] newArray(int size) {
            return new Address[size];
        }
    };
}
